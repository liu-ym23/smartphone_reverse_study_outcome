package elb;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.upload.ImageUploadManager$batchUpload$1;
import com.ss.android.lark.image.uploader.upload.ImageUploadManager$wrapUploader$1;
import com.ss.android.lark.image.uploader.upload.e;
import com.ss.android.lark.image.uploader.upload.f;
import com.ss.android.lark.image.uploader.upload.g;
import com.ss.android.lark.image.uploader.upload.h;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import hlb.d;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f473036a = null;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageUploadTask f473037a;

        public a(ImageUploadTask r100) {
            this.f473037a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.ss.android.lark.image.uploader.entity.b r101 = (com.ss.android.lark.image.uploader.entity.b) r100;
            Intrinsics.checkNotNullParameter(r101, "uploadImage");
            if (r101.f426400n != null) goto L7;
            glb.b.f481646a.getClass();
            glb.b.d(r101);
            glb.a r102 = r101.f426400n;
            if (r102 == null) goto L7;
            r102.f481645o = true;
        L7:
            ExecutorService r103 = b.f473036a;
            return Observable.create(new c(r101, this.f473037a));
        }
    }

    /* JADX INFO: renamed from: elb.b$b, reason: collision with other inner class name */
    public static final class C5788b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f473038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageUploadTask f473039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f473040c;

        public C5788b(Ref.BooleanRef r100, ImageUploadTask r101, e r102) {
            this.f473038a = r100;
            this.f473039b = r101;
            this.f473040c = r102;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.ss.android.lark.image.uploader.entity.b r101 = (com.ss.android.lark.image.uploader.entity.b) r100;
            Intrinsics.checkNotNullParameter(r101, "uploadImage");
            if (this.f473038a.element == true) goto L11;
            dlb.a r102 = this.f473039b.f426380f;
            if (r102 == null) goto L7;
            r102.c();
        L7:
            dlb.a r103 = this.f473039b.f426380f;
            if (r103 == null) goto L10;
            r103.g();
        L10:
            this.f473038a.element = true;
        L11:
            glb.a r104 = r101.f426400n;
            if (r104 != null) goto L14;
        L20:
            int r105 = h.f426419a;
            e r106 = this.f473040c;
            Intrinsics.checkNotNullParameter(r101, "uploadImage");
            Intrinsics.checkNotNullParameter(r106, "uploader");
            return Observable.create(new ImageUploadManager$wrapUploader$1(r101, r106));
        L14:
            if (r104.f481645o == false) goto L20;
            glb.b.f481646a.getClass();
            Intrinsics.checkNotNullParameter(r101, "uploadImage");
            glb.a r107 = r101.f426400n;
            if (r107 == null) goto L20;
            if (r107.f481631a == null) goto L20;
            AppreciableKit.Companion.getInstance().spanStart(r107.f481631a, "data_load_cost");
            goto L20
        }
    }

    static {
        f473036a = CoreThreadPool.getDefault().getCachedThreadPool();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.ss.android.lark.image.uploader.upload.ImageUploadManager$batchUpload$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void a(final ImageUploadTask r110) {
        int r100 = hlb.c.f485704a;
        Intrinsics.checkNotNullParameter(r110, "imageUploadTask");
        int r101 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "Transform begin");
        dlb.a r102 = r110.f426380f;
        if (r102 == null) goto L5;
        r102.e();
    L5:
        ArrayList<d> r103 = r110.f426377c;
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "Transform list size:" + r103.size());
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r104 = r110.f426376b;
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "UploadImage list size:" + r104.size());
        Iterator<com.ss.android.lark.image.uploader.entity.b> r105 = r104.iterator();
        boolean r106 = false;
        int r107 = 0;
    L7:
        if (r105.hasNext() == false) goto L21;
        com.ss.android.lark.image.uploader.entity.b r108 = r105.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        com.ss.android.lark.image.uploader.entity.b r111 = r108;
        if (r107 != 0) goto L14;
        glb.b.f481646a.getClass();
        glb.b.d(r111);
    L14:
        Iterator<d> r112 = r103.iterator();
    L16:
        if (r112.hasNext() == false) goto L20;
        d r113 = r112.next();
        boolean r114 = r113.a(r111, r110);
        int r115 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "transform:" + r113.getName() + ", handle:" + r114 + ", image:" + r111);
        if (r114 == false) goto L16;
        String r116 = r113.b(r111, r110);
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "path after do transform:" + r116);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r111.f426387a = r116;
        goto L16
    L20:
        r107 = r109;
        goto L7
    L21:
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r117 = r110.f426376b;
        int r118 = 0;
    L23:
        if (r118 >= r117.size()) goto L25;
        com.ss.android.lark.image.uploader.entity.b r119 = (com.ss.android.lark.image.uploader.entity.b) ListProtector.get(r117, r118);
        r119.f426397k = com.ss.android.lark.image.uploader.utils.b.d(r119.f426387a, true, false);
        r118 = r118 + 1;
        goto L23
    L25:
        dlb.a r120 = r110.f426380f;
        if (r120 == null) goto L28;
        r120.f(r110.f426376b);
    L28:
        int r121 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "Transform end");
        alb.a r122 = alb.b.b(r110);
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "FileSizeValid:" + r122.a());
        if (r122.a() == true) goto L34;
        dlb.a r123 = r110.f426380f;
        if (r123 == null) goto L88;
        r123.j(r122.f4211a, r122.f4212b, r122.f4213c, r122.f4214d, r122.f4215e);
        return;
    L88:
        return;
    L34:
        alb.a r124 = alb.c.b(r110);
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "FileTypeValid:" + r124.a());
        if (r124.a() == true) goto L40;
        dlb.a r125 = r110.f426380f;
        if (r125 == null) goto L89;
        r125.j(r124.f4211a, r124.f4212b, 0, r122.f4214d, r122.f4215e);
        return;
    L89:
        return;
    L40:
        e r126 = r110.f426381g;
        if (r126 == null) goto L43;
        boolean r127 = r126.b();
    L45:
        if (r110.f426376b.size() != 1) goto L47;
        r106 = true;
    L47:
        e r128 = r110.f426381g;
        if (r127 == true) goto L56;
        if (r106 == true) goto L56;
        if (r128 == null) goto L56;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "Compress and upload serial");
        Ref.BooleanRef r129 = new Ref.BooleanRef();
        dlb.a r130 = r110.f426380f;
        if (r130 == null) goto L55;
        r130.b(r110.f426376b);
    L55:
        Observable r131 = Observable.fromIterable(r110.f426376b).subscribeOn(LarkRxSchedulers.io()).observeOn(LarkRxSchedulers.io()).concatMap(new a(r110)).concatMapDelayError(new C5788b(r129, r110, r128)).observeOn(AndroidSchedulers.mainThread());
        int r132 = h.f426419a;
        Intrinsics.checkNotNullParameter(r110, "uploadTask");
        r131.subscribe(new g(r110));
        return;
    L56:
        int r133 = blb.c.f19525a;
        Intrinsics.checkNotNullParameter(r110, "imageUploadTask");
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "Compress begin");
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r134 = r110.f426376b;
        dlb.a r135 = r110.f426380f;
        if (r135 == null) goto L59;
        r135.b(r134);
    L59:
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "UploadImage list size:" + r134.size());
        Iterator<com.ss.android.lark.image.uploader.entity.b> r136 = r134.iterator();
    L61:
        if (r136.hasNext() == false) goto L63;
        com.ss.android.lark.image.uploader.entity.b r137 = r136.next();
        glb.b.f481646a.getClass();
        glb.b.e(r137);
        long r138 = System.currentTimeMillis();
        String r139 = r137.f426387a;
        blb.c.c(r137, r110);
        r137.f426399m = blb.c.a(r139, r137.f426387a, r138);
        int r140 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.a("ImageCompressManager", "compressInfo:" + r137.f426399m);
        glb.b.f(r137);
        goto L61
    L63:
        dlb.a r141 = r110.f426380f;
        if (r141 == null) goto L66;
        r141.c();
    L66:
        int r142 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "Compress end");
        int r143 = h.f426419a;
        Intrinsics.checkNotNullParameter(r110, "uploadTask");
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "Upload begin");
        dlb.a r144 = r110.f426380f;
        if (r144 == null) goto L69;
        r144.g();
    L69:
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r145 = r110.f426376b;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "UploadImage list size:" + r145.size());
        e r146 = r110.f426381g;
        if (r146 != 0) goto L76;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "uploader is null, finish task:" + r110);
        dlb.a r147 = r110.f426380f;
        if (r147 == null) goto L74;
        r147.h();
    L74:
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "Upload end");
        return;
    L76:
        if (r146.b() == false) goto L78;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "uploader support batch mode, upload once");
        final ArrayList<com.ss.android.lark.image.uploader.entity.b> r148 = r110.f426376b;
        r146.c(r148, new ImageUploadManager$batchUpload$1(r148, r110));
        return;
    L78:
        Observable r149 = Observable.fromIterable(r145).subscribeOn(LarkRxSchedulers.io()).observeOn(LarkRxSchedulers.io()).concatMapDelayError(new f(r146));
        Intrinsics.checkNotNullParameter(r110, "uploadTask");
        r149.observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r110));
        return;
    L43:
        r127 = false;
        goto L45
    }
}
