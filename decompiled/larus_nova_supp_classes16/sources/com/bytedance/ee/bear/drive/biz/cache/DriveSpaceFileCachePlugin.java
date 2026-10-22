package com.bytedance.ee.bear.drive.biz.cache;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.homepage.list.a0;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.config.strategy.d;
import com.bytedance.ee.bear.drive.config.strategy.j;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming.StreamingCache;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y45.e;
import y45.q;
import y45.r;
import y45.s;
import y45.u;
import y45.v;
import y45.w;
import y45.x;
import y45.y;
import y45.z;
import y75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/cache/DriveSpaceFileCachePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFileCachePlugin extends AbsDrivePlugin {

    public static final class a<T> implements Observer {
        public final /* synthetic */ d a;
        public final /* synthetic */ DrivePluginHost b;
        public final /* synthetic */ DriveSpaceFileCachePlugin c;

        public a(d r1, DrivePluginHost r2, DriveSpaceFileCachePlugin r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void onChanged(Object r14) {
            boolean r1 = false;
            if ((r14 instanceof VFSPath) == false) goto L14;
            tt5.a.h("DriveComponent", "liveInnerSaveCache() ds=String");
            final d r9 = this.a;
            final f85.a r7 = (f85.a) this.b.c.getFileModel();
            VFSPath r16 = (VFSPath) r14;
            final a95.a r11 = this.b.b();
            if (r9 == null) goto L9;
            if (r7 == null) goto L9;
            final t r10 = t.l();
            final String r8 = r9.i(r7);
            Flowable.just(r16).observeOn(fo5.d.b()).filter(new r()).map(new s(r8, r11, r7)).flatMap(new y45.t(r7, r8, r9, r10, r11)).subscribeOn(fo5.d.b()).observeOn(fo5.d.b()).subscribe(new a0(), new u());
            return;
        L9:
            StringBuilder r17 = new StringBuilder("saveStreamingDownloadFile param error, previewFileStrategy=");
            r17.append(r9);
            r17.append(", fileModel is null=");
            if (r7 != null) goto L12;
            r1 = true;
        L12:
            r17.append(r1);
            tt5.a.d("StreamingCacheUtils", r17.toString());
            return;
        L14:
            if ((r14 instanceof byte[]) == false) goto L27;
            tt5.a.h("DriveComponent", "liveInnerSaveCache() ds=byte[]");
            DriveSpaceFileCachePlugin.access$getContext(this.c);
            d r0 = this.a;
            f85.a r12 = (f85.a) this.b.c.getFileModel();
            final byte[] r18 = (byte[]) r14;
            final a95.a r13 = this.b.b();
            if (r0 == null) goto L22;
            if (r12 == null) goto L22;
            tt5.a.h("StreamingCacheUtils", "saveProgressiveSource start!!!");
            t r2 = t.l();
            if (r0.b(((f85.a.C0229a) r12.a).c, r12, r12.f, null) == false) goto L43;
            tt5.a.h("StreamingCacheUtils", "saveProgressiveSource canCache!!!");
            String r3 = r0.i(r12);
            final DriveFilePath r4 = t.f();
            r4.cacheName(r3);
            r12.k = r4;
            Flowable.fromCallable(new q(r4, r13, r18)).flatMap(new z(r12, r3, r2, r13)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new x(), new y());
            return;
        L43:
            return;
        L22:
            StringBuilder r19 = new StringBuilder("saveProgressiveSource param error, previewFileStrategy=");
            r19.append(r0);
            r19.append(", fileModel is null=");
            if (r12 != null) goto L25;
            r1 = true;
        L25:
            r19.append(r1);
            tt5.a.d("StreamingCacheUtils", r19.toString());
            return;
        L27:
            if ((r14 instanceof b) == false) goto L38;
            tt5.a.h("DriveComponent", "liveInnerSaveCache() ds=ExcelSubCacheModel]");
            final d r20 = this.a;
            final f85.a r21 = (f85.a) this.b.c.getFileModel();
            final a95.a r110 = this.b.b();
            if (r20 == null) goto L33;
            if (r21 == null) goto L33;
            final String r22 = r20.i(r21);
            final t r111 = t.l();
            Flowable.just("").observeOn(fo5.d.b()).flatMap(new v(r21, r22, r20, r111, r110)).subscribe(new a0(), new w());
            return;
        L33:
            StringBuilder r112 = new StringBuilder("saveStandAloneCache param error, previewFileStrategy=");
            r112.append(r20);
            r112.append(", fileModel is null=");
            if (r21 != null) goto L36;
            r1 = true;
        L36:
            r112.append(r1);
            tt5.a.d("StreamingCacheUtils", r112.toString());
            return;
        L38:
            if ((r14 instanceof StreamingCache) == false) goto L48;
            tt5.a.h("DriveComponent", "liveInnerSaveCache() ds=StreamingCache]");
            DriveViewModel r5 = this.b.c;
            Intrinsics.checkNotNullParameter(r5, "<this>");
            e.a(j.b(r5), this.b.c.getIFileModel(), (StreamingCache) r14, this.b.b());
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveSpaceFileCachePlugin() {
    }

    public static final /* synthetic */ Context access$getContext(DriveSpaceFileCachePlugin r0) {
        return r0.getContext();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super.onAttachToHost(r5);
        d r0 = j.b(r5.c);
        k75.a.i(r5).liveInnerSaveCache().observe(getLifecycleOwner(), new a(r0, r5, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
