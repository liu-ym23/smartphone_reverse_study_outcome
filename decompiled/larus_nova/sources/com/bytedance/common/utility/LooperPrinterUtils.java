package com.bytedance.common.utility;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Printer;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class LooperPrinterUtils {
    private static boolean isInit = false;
    private static int mMaxCount = 5;
    private static Printer sOriginPrinter;
    private static PrinterWrapper sPrinterWrapper;

    public interface PrinterListener {
    }

    public static class PrinterWrapper implements Printer {
        boolean haveAdd;
        boolean haveRemove;
        List<Printer> mAddPrinters;
        List<Printer> mPrinters;
        List<Printer> mRemovePrinters;

        public PrinterWrapper() {
            this.mPrinters = new ArrayList();
            this.mRemovePrinters = new ArrayList();
            this.mAddPrinters = new ArrayList();
            this.haveRemove = false;
            this.haveAdd = false;
        }

        @Override // android.util.Printer
        public void println(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return;
        L5:
            LooperPrinterUtils.access$000();
            if (r100.charAt(0) == '>') goto L8;
        L16:
            this.mPrinters.size();
            LooperPrinterUtils.access$100();
            Iterator<Printer> r101 = this.mPrinters.iterator();
        L18:
            if (r101.hasNext() == false) goto L23;
            Printer r102 = r101.next();
            if (r102 == null) goto L18;
            r102.println(r100);
            goto L18
        L23:
            if (r100.charAt(0) == '<') goto L25;
        L31:
            LooperPrinterUtils.access$000();
            return;
        L25:
            if (this.haveRemove == false) goto L31;
            Iterator<Printer> r103 = this.mRemovePrinters.iterator();
        L28:
            if (r103.hasNext() == false) goto L30;
            Printer r104 = r103.next();
            this.mPrinters.remove(r104);
            this.mAddPrinters.remove(r104);
            goto L28
        L30:
            this.mRemovePrinters.clear();
            this.haveRemove = false;
            goto L31
        L8:
            if (this.haveAdd == false) goto L16;
            Iterator<Printer> r105 = this.mAddPrinters.iterator();
        L11:
            if (r105.hasNext() == false) goto L15;
            Printer r106 = r105.next();
            if (this.mPrinters.contains(r106) == true) goto L11;
            this.mPrinters.add(r106);
            goto L11
        L15:
            this.mAddPrinters.clear();
            this.haveAdd = false;
            goto L16
        }
    }

    public static /* synthetic */ PrinterListener access$000() {
        return null;
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static Printer getCurrentPrinter() {
        Field r100 = INVOKESTATIC_com_bytedance_common_utility_LooperPrinterUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L4
        r100.setAccessible(true);     // Catch: Exception -> L4
        return (Printer) r100.get(Looper.getMainLooper());
    L4:
        return null;
    }

    public static List<Printer> getPrinters() {
        PrinterWrapper r100 = sPrinterWrapper;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mPrinters;
    }

    public static void init() {
        if (isInit == false) goto L5;
        return;
    L5:
        isInit = true;
        sPrinterWrapper = new PrinterWrapper();
        Printer r100 = getCurrentPrinter();
        sOriginPrinter = r100;
        if (r100 == null) goto L8;
        sPrinterWrapper.mPrinters.add(r100);
    L8:
        Looper.getMainLooper().setMessageLogging(sPrinterWrapper);
    }

    public static /* synthetic */ int access$100() {
        return mMaxCount;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_utility_LooperPrinterUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void addMessageLogging(Printer r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (sPrinterWrapper.mAddPrinters.contains(r100) == true) goto L8;
        sPrinterWrapper.mAddPrinters.add(r100);
        sPrinterWrapper.haveAdd = true;
        return;
    }

    public static void removeMessageLogging(Printer r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (sPrinterWrapper.mRemovePrinters.contains(r100) == true) goto L8;
        sPrinterWrapper.mRemovePrinters.add(r100);
        sPrinterWrapper.haveRemove = true;
        return;
    }
}
