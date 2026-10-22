package com.ss.android.lark.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class a1 implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f444690f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f444691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f444692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<List<c>> f444693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f444694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<c> f444695e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a1 f444696a = null;

        static {
            f444696a = new a1();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Message f444697a;

        public final Object a() {
            Message r100 = this.f444697a;
            if (r100 == null) goto L7;
            return r100.obj;
        L7:
            throw new IllegalStateException("You can't use LocalMessage instance from a non-UI thread. Extract the data from LocalMessage and don't hold a reference to it outside of handleMessage()");
        }

        public final String toString() {
            if (this.f444697a == null) goto L14;
            StringBuilder r100 = new StringBuilder("{ id=");
            Message r101 = this.f444697a;
            if (r101 == null) goto L12;
            r100.append(r101.what);
            if (a() == null) goto L9;
            r100.append(" obj=");
            r100.append(a());
        L9:
            r100.append(" }");
            return r100.toString();
        L12:
            throw new IllegalStateException("You can't use LocalMessage instance from a non-UI thread. Extract the data from LocalMessage and don't hold a reference to it outside of handleMessage()");
        L14:
            throw new IllegalStateException("You can't use LocalMessage instance from a non-UI thread. Extract the data from LocalMessage and don't hold a reference to it outside of handleMessage()");
        }

        public b() {
            this.f444697a = null;
        }
    }

    public interface c {
        void a(b r100);
    }

    static {
        f444690f = DevEnvUtil.isDebugMode(LarkContext.getApplication());
    }

    public a1() {
        this.f444691a = new Handler(Looper.getMainLooper(), this);
        this.f444692b = new b();
        this.f444693c = new SparseArray();
        this.f444694d = new ArrayList();
        this.f444695e = new ArrayList();
    }

    public final void b(b r100) {
        SparseArray<List<c>> r101 = this.f444693c;
        Message r102 = r100.f444697a;
        if (r102 == null) goto L53;
        List<c> r103 = r101.get(r102.what);
        if (r103 == null) goto L9;
        if (r103.size() == 0) goto L9;
    L15:
        StringBuilder r104 = new StringBuilder("Delivering message ID ");
        Message r105 = r100.f444697a;
        if (r105 == null) goto L51;
        r104.append(r105.what);
        r104.append(", Specific listeners: ");
        int r106 = 0;
        if (r103 != null) goto L20;
    L30:
        r104.append(0);
    L31:
        r104.append(", Universal listeners: ");
        List<c> r107 = this.f444694d;
        monitor-enter(r107);
    L47:
        th = move-exception;
        throw th;
    L34:
        if (((ArrayList) this.f444694d).size() != 0) goto L36;
        r104.append(0);     // Catch: Throwable -> L47
    L44:
        monitor-exit(r107);     // Catch: Throwable -> L47
        r104.append(r100.toString());
        Log.i("UiMessageUtils", r104.toString());
        return;
    L36:
        r104.append(((ArrayList) this.f444694d).size());     // Catch: Throwable -> L47
        r104.append(" [");     // Catch: Throwable -> L47
    L38:
        if (r106 >= ((ArrayList) this.f444694d).size()) goto L43;
        r104.append(((c) ((ArrayList) this.f444694d).get(r106)).getClass().getSimpleName());     // Catch: Throwable -> L47
        if (r106 >= (((ArrayList) this.f444694d).size() - 1)) goto L42;
        r104.append(",");     // Catch: Throwable -> L47
    L42:
        r106 = r106 + 1;     // Catch: Throwable -> L47
        goto L38
    L43:
        r104.append("], Message: ");     // Catch: Throwable -> L47
        goto L44
    L20:
        if (r103.size() == 0) goto L30;
        r104.append(r103.size());
        r104.append(" [");
        int r108 = 0;
    L24:
        if (r108 >= r103.size()) goto L29;
        r104.append(((c) ListProtector.get(r103, r108)).getClass().getSimpleName());
        if (r108 >= (r103.size() - 1)) goto L28;
        r104.append(",");
    L28:
        r108 = r108 + 1;
        goto L24
    L29:
        r104.append("]");
        goto L31
    L51:
        throw new IllegalStateException("You can't use LocalMessage instance from a non-UI thread. Extract the data from LocalMessage and don't hold a reference to it outside of handleMessage()");
    L9:
        if (((ArrayList) this.f444694d).size() != 0) goto L15;
        StringBuilder r109 = new StringBuilder("Delivering FAILED for message ID ");
        Message r110 = r100.f444697a;
        if (r110 == null) goto L14;
        r109.append(r110.what);
        r109.append(". No listeners. ");
        r109.append(r100.toString());
        Log.w("UiMessageUtils", r109.toString());
        return;
    L14:
        throw new IllegalStateException("You can't use LocalMessage instance from a non-UI thread. Extract the data from LocalMessage and don't hold a reference to it outside of handleMessage()");
    L53:
        throw new IllegalStateException("You can't use LocalMessage instance from a non-UI thread. Extract the data from LocalMessage and don't hold a reference to it outside of handleMessage()");
    }

    public final void c(int r100) {
        if (f444690f == false) goto L9;
        List<c> r101 = this.f444693c.get(r100);
        if (r101 != null) goto L7;
    L8:
        Log.w("UiMessageUtils", "Trying to remove specific listeners that are not registered. ID " + r100);
        goto L9
    L7:
        if (r101.size() == 0) goto L8;
    L9:
        SparseArray<List<c>> r102 = this.f444693c;
        monitor-enter(r102);
        this.f444693c.delete(r100);     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        b r101 = this.f444692b;
        r101.f444697a = r100;
        if (f444690f == false) goto L5;
        b(r101);
    L5:
        SparseArray<List<c>> r102 = this.f444693c;
        monitor-enter(r102);
        List<c> r103 = this.f444693c.get(r100.what);     // Catch: Throwable -> L33
        if (r103 != null) goto L10;
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L33
        List<c> r104 = this.f444694d;
        monitor-enter(r104);
    L30:
        th = move-exception;
        throw th;
    L21:
        if (((ArrayList) this.f444694d).size() <= 0) goto L27;
        List<c> r105 = this.f444695e;     // Catch: Throwable -> L30
        ArrayList r106 = (ArrayList) r105;     // Catch: Throwable -> L30
        r106.addAll(this.f444694d);     // Catch: Throwable -> L30
        Iterator r107 = ((ArrayList) this.f444695e).iterator();     // Catch: Throwable -> L30
    L24:
        if (r107.hasNext() == false) goto L26;
        ((c) r107.next()).a(this.f444692b);     // Catch: Throwable -> L30
        goto L24
    L26:
        ((ArrayList) this.f444695e).clear();     // Catch: Throwable -> L30
    L27:
        monitor-exit(r104);     // Catch: Throwable -> L30
        this.f444692b.f444697a = null;
        return true;
    L10:
        if (r103.size() != 0) goto L12;
        this.f444693c.remove(r100.what);     // Catch: Throwable -> L33
        goto L17
    L12:
        ((ArrayList) this.f444695e).addAll(r103);     // Catch: Throwable -> L33
        Iterator r108 = ((ArrayList) this.f444695e).iterator();     // Catch: Throwable -> L33
    L14:
        if (r108.hasNext() == false) goto L16;
        ((c) r108.next()).a(this.f444692b);     // Catch: Throwable -> L33
        goto L14
    L16:
        ((ArrayList) this.f444695e).clear();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    public final void a(int r100, c r101) {
        SparseArray<List<c>> r102 = this.f444693c;
        monitor-enter(r102);
        List<c> r103 = this.f444693c.get(r100);     // Catch: Throwable -> L12
        if (r103 != null) goto L8;
        r103 = new ArrayList();     // Catch: Throwable -> L12
        this.f444693c.put(r100, r103);     // Catch: Throwable -> L12
    L8:
        if (r103.contains(r101) == true) goto L10;
        r103.add(r101);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
