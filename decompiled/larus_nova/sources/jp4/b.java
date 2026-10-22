package jp4;

import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.UploadAttachmentEntity;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements jp4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jp4.a f499948a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f499949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UploadAttachmentEntity f499950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f499951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f499952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f499953e;

        public a(b r100, UploadAttachmentEntity r101, String r102, String r103, float r104) {
            this.f499949a = r100;
            this.f499950b = r101;
            this.f499951c = r102;
            this.f499952d = r103;
            this.f499953e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f499949a.f499948a.s1(this.f499950b, this.f499951c, this.f499952d, this.f499953e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: jp4.b$b, reason: collision with other inner class name */
    public static final class RunnableC6472b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f499954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UploadAttachmentEntity f499955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f499956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f499957d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f499958e;

        public RunnableC6472b(b r100, UploadAttachmentEntity r101, String r102, String r103, int r104) {
            this.f499954a = r100;
            this.f499955b = r101;
            this.f499956c = r102;
            this.f499957d = r103;
            this.f499958e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f499954a.f499948a.z2(this.f499955b, this.f499956c, this.f499957d, this.f499958e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f499959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UploadAttachmentEntity f499960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f499961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f499962d;

        public c(b r100, UploadAttachmentEntity r101, String r102, String r103) {
            this.f499959a = r100;
            this.f499960b = r101;
            this.f499961c = r102;
            this.f499962d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f499959a.f499948a.D0(this.f499960b, this.f499961c, this.f499962d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f499963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UploadAttachmentEntity f499964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f499965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f499966d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f499967e;

        public d(b r100, UploadAttachmentEntity r101, String r102, String r103, String r104) {
            this.f499963a = r100;
            this.f499964b = r101;
            this.f499965c = r102;
            this.f499966d = r103;
            this.f499967e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f499963a.f499948a.q3(this.f499964b, this.f499965c, this.f499966d, this.f499967e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(jp4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f499948a = r100;
    }

    @Override // jp4.a
    public final void D0(UploadAttachmentEntity r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "attachmentEntity");
        j.c(new c(this, r100, r101, r102));
    }

    @Override // jp4.a
    public final void q3(UploadAttachmentEntity r100, String r101, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "attachmentEntity");
        j.c(new d(this, r100, r101, r110, r111));
    }

    @Override // jp4.a
    public final void s1(UploadAttachmentEntity r100, String r101, String r110, float r111) {
        Intrinsics.checkNotNullParameter(r100, "attachmentEntity");
        j.c(new a(this, r100, r101, r110, r111));
    }

    @Override // jp4.a
    public final void z2(UploadAttachmentEntity r100, String r101, String r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "attachmentEntity");
        j.c(new RunnableC6472b(this, r100, r101, r110, r111));
    }
}
