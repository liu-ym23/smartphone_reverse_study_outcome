package com.bytedance.locallife.poi.perf;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.bytedance.locallife.model.poi.resp.PoiExtension;
import com.bytedance.locallife.model.poi.resp.PoiStruct;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.Gson;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements com.bytedance.locallife.poi.perf.a {

    public static final class a<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class<? extends Serializable> f263702a;

        public a(Class<? extends Serializable> r100) {
            this.f263702a = r100;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Dito r101 = Dito.f257280a;
            Gson r102 = (Gson) Dito.a().a(Gson.class);
            if (r102 != null) goto L5;
            r102 = new Gson();
        L5:
            r102.getAdapter(this.f263702a);
        }
    }

    public static final class b<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f263703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f263704b;

        public b(String r100, f r101) {
            this.f263703a = r100;
            this.f263704b = r101;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
            Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Class<T> r101 = a(this.f263703a);     // Catch: ClassNotFoundException -> L8
            Dito r102 = Dito.f257280a;     // Catch: ClassNotFoundException -> L8
            Gson r103 = (Gson) Dito.a().a(Gson.class);     // Catch: ClassNotFoundException -> L8
            if (r103 != null) goto L6;
            r103 = new Gson();     // Catch: ClassNotFoundException -> L8
        L6:
            r103.getAdapter(r101);     // Catch: ClassNotFoundException -> L8
            return;
        L8:
            e = move-exception;
            e.printStackTrace();
            this.f263704b.getClass();
        }
    }

    public f() {
    }

    @Override // com.bytedance.locallife.poi.perf.a
    public final void handle(Map<String, ? extends Object> r100) {
        Iterator r101 = CollectionsKt.listOf(new Class[]{PoiDetail.class, PoiStruct.class, PoiExtension.class}).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Observable.create(new a((Class) r101.next())).subscribeOn(Schedulers.io()).subscribe();
        goto L4
    L6:
        Object r102 = r100.get("class");
        if ((r102 instanceof List) == false) goto L9;
        List r103 = (List) r102;
    L10:
        if (r103 != null) goto L12;
        return;
    L12:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L18;
        Object r106 = r105.next();
        if ((r106 instanceof String) == false) goto L14;
        r104.add(r106);
        goto L14
    L18:
        Iterator r107 = r104.iterator();
    L20:
        if (r107.hasNext() == false) goto L22;
        Observable.create(new b((String) r107.next(), this)).subscribeOn(Schedulers.io()).subscribe();
        goto L20
    L22:
        return;
    L9:
        r103 = null;
        goto L10
    }
}
