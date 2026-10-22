package com.bytedance.ee.bear.drive.view.preview.pdf.presentationview;

import io.reactivex.Observable;
import io.reactivex.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends Observable<PdfPresentationView.a> {
    public final PdfPresentationView a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.a$a, reason: collision with other inner class name */
    public static final class C0182a extends qtc.a implements PdfPresentationView.c {
        public final PdfPresentationView b;
        public final Observer<? super PdfPresentationView.a> c;

        public final void b() {
            this.b.setFlingListener(null);
        }

        public C0182a(PdfPresentationView r1, Observer<? super PdfPresentationView.a> r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public a(PdfPresentationView r1) {
        this.a = r1;
    }

    public final void subscribeActual(Observer<? super PdfPresentationView.a> r3) {
        C0182a r0 = new C0182a(this.a, r3);
        r3.onSubscribe(r0);
        this.a.setFlingListener(r0);
    }
}
