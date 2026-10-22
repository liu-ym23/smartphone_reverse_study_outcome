package com.ss.android.lark.image.uploader.upload;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ImageUploadManager$wrapUploader$1<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.image.uploader.entity.b f426414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f426415b;

    public ImageUploadManager$wrapUploader$1(com.ss.android.lark.image.uploader.entity.b r100, e r101) {
        this.f426414a = r100;
        this.f426415b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.ss.android.lark.image.uploader.upload.ImageUploadManager$wrapUploader$1$1] */
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
    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(final ObservableEmitter<com.ss.android.lark.image.uploader.entity.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        int r101 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "uploadImage:" + this.f426414a);
        e r102 = this.f426415b;
        final com.ss.android.lark.image.uploader.entity.b r103 = this.f426414a;
        r102.a(r103, new AnonymousClass1(r103, r100));
    }
}
