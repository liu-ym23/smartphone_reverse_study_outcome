package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.view.PreviewProgressView;
import com.bytedance.android.livesdk.ktvapi.model.mv.h;
import com.bytedance.android.livesdk.ktvapi.model.mv.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/MVPreViewDialog;", "Landroidx/fragment/app/DialogFragment;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MVPreViewDialog extends DialogFragment {
    public TextureView d;
    public HSImageView e;
    public Function1<? super TextView, Unit> f;
    public PreviewProgressView g;
    public Function1<? super Boolean, Unit> h;
    public long i;
    public final Function1<n, Unit> j;
    public final String k;
    public final String l;
    public final View m;
    public final h<?> n;
    public final Function0<Unit> o;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MVPreViewDialog a;

        public b(MVPreViewDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            r2.setVisibility(0);
            this.a.o.invoke();
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ MVPreViewDialog a;

        public c(MVPreViewDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ MVPreViewDialog a;
        public final /* synthetic */ View b;

        public d(MVPreViewDialog r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a.n.isPlaying() == false) goto L7;
            this.b.setVisibility(0);
            this.a.n.pause();
            Function1<? super Boolean, Unit> r3 = this.a.h;
            if (r3 == null) goto L12;
            Unit r4 = (Unit) r3.invoke(Boolean.TRUE);
            return;
        L12:
            return;
        L7:
            Function1<? super Boolean, Unit> r5 = this.a.h;
            if (r5 == null) goto L10;
            Unit r6 = (Unit) r5.invoke(Boolean.FALSE);
        L10:
            this.a.n.start();
            this.b.setVisibility(8);
        }
    }

    public static final class e implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ MVPreViewDialog a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
        }

        public e(MVPreViewDialog r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
            MVPreViewDialog r4 = this.a;
            Surface r5 = new Surface(r1);
            r4.n.setSurface(r5);
            r4.n.setDataSource(r4.l);
            r4.n.start();
        }
    }

    static {
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.n.stop();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (getDialog() == null) goto L10;
        Dialog r0 = getDialog();
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L12;
        r1.setLayout(-1, -1);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setLayout(-1, -1);
        return;
    L9:
        return;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        this.n.stop();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L7;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L7;
        r7.setLayout(-1, -1);
    L7:
        r4.setOnClickListener(new c(this));
        this.d = (TextureView) r4.findViewById(2131391285);
        this.e = r4.findViewById(2131368157);
        View r8 = r4.findViewById(2131382424);
        TextureView r0 = this.d;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("renderView");
    L10:
        r0.setOnClickListener(new d(this, r8));
        PreviewProgressView r9 = r4.findViewById(2131382945);
        r9.setProgressColor(s1.h(2131107715));
        r9.setDragProgressListener(new MVPreViewDialog$onViewCreated$$inlined$apply$lambda$1(this));
        r9.setProgress(0.0f);
        Unit r1 = Unit.INSTANCE;
        this.g = r9;
        View r10 = this.m;
        if (r10 == null) goto L19;
        if (r10 == null) goto L16;
        ViewGroup r2 = UtilityKotlinExtentionsKt.p(r10);
        if (r2 == null) goto L16;
        r2.removeView(this.m);
    L16:
        ViewGroup r3 = (ViewGroup) r4.findViewById(2131384849);
        if (r3 == null) goto L19;
        r3.addView(r10);
    L19:
        String r11 = this.k;
        if (r11 != null) goto L22;
    L30:
        TextView r12 = (TextView) r4.findViewById(2131390339);
        if (r12 != null) goto L33;
    L38:
        TextureView r13 = this.d;
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("renderView");
    L41:
        r13.setSurfaceTextureListener(new e(this));
        return;
    L33:
        if (this.m != null) goto L35;
        r12.setVisibility(0);
    L35:
        r12.setOnClickListener(new b(this));
        Function1<? super TextView, Unit> r14 = this.f;
        if (r14 == null) goto L38;
        Unit r15 = (Unit) r14.invoke(r12);
        goto L38
    L22:
        if ((!TextUtils.isEmpty(r11)) == true) goto L25;
        r11 = null;
    L25:
        if (r11 == null) goto L30;
        HSImageView r16 = this.e;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("coverImg");
    L29:
        r16.setImageURI(r11);
        goto L30
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        this.n.setLooping(true);
        this.n.l(this.j);
        this.n.k(new AnonymousClass1(this));
        return r2.inflate(2131563366, r3, false);
    }

    public MVPreViewDialog(String r2, String r3, View r4, h<?> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "videoUrl");
        Intrinsics.checkNotNullParameter(r5, "playerClient");
        Intrinsics.checkNotNullParameter(r6, "selectedListener");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        this.j = new MVPreViewDialog$previewMvInfoCb$1(this);
    }
}
