package com.ss.android.lark.image.uploader.upload;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f426416a;

    public d(boolean r100) {
        this.f426416a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.ss.android.lark.image.uploader.upload.EncryptImageUploader$uploadImage$1] */
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
    @Override // com.ss.android.lark.image.uploader.upload.e
    public final void a(com.ss.android.lark.image.uploader.entity.b r100, final ImageUploadManager$wrapUploader$1.AnonymousClass1 r101) {
        Intrinsics.checkNotNullParameter(r100, "image");
        Intrinsics.checkNotNullParameter(r101, "callback");
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.f426387a);
        ImageInfo r103 = r100.f426397k;
        if (r103 == null) goto L5;
        int r104 = r103.f426421a;
    L6:
        if (r103 == null) goto L8;
        int r105 = r103.f426422b;
    L9:
        ykb.b.f568292a.d(r102, r104, r105, this.f426416a, new EncryptImageUploader$uploadImage$1(r101));
        return;
    L8:
        r105 = 0;
        goto L9
    L5:
        r104 = 0;
        goto L6
    }
}
