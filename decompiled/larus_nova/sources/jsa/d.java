package jsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.ss.android.bytedcert.face.ui.FaceDetectDialogActivity;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f500243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f500244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FaceDetectDialogActivity f500245c;

    public d(FaceDetectDialogActivity r100) {
        this.f500245c = r100;
        this.f500243a = new AtomicBoolean(true);
        this.f500244b = new AtomicBoolean(true);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        if (this.f500244b.compareAndSet(false, false) == false) goto L6;
        return;
    L6:
        if (this.f500245c.f407445o.getVisibility() != 4) goto L9;
        this.f500245c.f407445o.setVisibility(0);
    L9:
        if (this.f500245c.f407434d.getVisibility() != 4) goto L12;
        this.f500245c.f407434d.setVisibility(0);
        this.f500245c.f407434d.setTranslationY(-370.0f);
        this.f500245c.f407434d.setTextSize(1, 20.0f);
    L12:
        if (this.f500245c.f407440j.getVisibility() != 0) goto L15;
        this.f500245c.f407440j.setVisibility(8);
    L15:
        if (this.f500245c.f407441k.getVisibility() != 0) goto L18;
        this.f500245c.f407441k.setVisibility(8);
    L18:
        if (this.f500245c.f407442l.getVisibility() != 0) goto L21;
        this.f500245c.f407442l.setVisibility(8);
    L21:
        if (this.f500245c.f407443m.getVisibility() != 0) goto L24;
        this.f500245c.f407443m.setVisibility(8);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Object r101 = this.f500245c.f407452v;
        monitor-enter(r101);
        ((ArrayList) this.f500245c.f407451u).add(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        if (this.f500243a.compareAndSet(false, false) == false) goto L10;
        return;
    L10:
        if (this.f500245c.f407434d.getVisibility() != 0) goto L18;
        this.f500245c.f407434d.setVisibility(4);
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
