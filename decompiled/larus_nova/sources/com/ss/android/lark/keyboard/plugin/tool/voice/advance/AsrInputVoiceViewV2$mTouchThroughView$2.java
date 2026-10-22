package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AsrInputVoiceViewV2$mTouchThroughView$2 extends Lambda implements Function0<FrameLayout> {
    final /* synthetic */ AsrInputVoiceViewV2 this$0;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsrInputVoiceViewV2 f429837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f429838b;

        public a(AsrInputVoiceViewV2 r100, FrameLayout r101) {
            this.f429837a = r100;
            this.f429838b = r101;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            Log.i("AsrInputVoiceViewV2", "On touch touch thorough view, event.action: " + r101.getAction());
            if (this.f429837a.f429835b == false) goto L5;
            return true;
        L5:
            Intrinsics.checkNotNull(r101);
            if (r100 != null) goto L10;
            AsrInputVoiceViewV2.R5(this.f429837a).a();
            Log.i("AsrInputVoiceViewV2", "cancel asr after record by click ");
            Log.i("AsrInputVoiceViewV2", "set touch through view gone");
            this.f429838b.setVisibility(8);
            return false;
        L10:
            throw null;
        }
    }

    public AsrInputVoiceViewV2$mTouchThroughView$2(AsrInputVoiceViewV2 r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FrameLayout invoke() {
        this.this$0.getClass();
        FrameLayout r100 = new FrameLayout(null);
        AsrInputVoiceViewV2 r101 = this.this$0;
        r100.setVisibility(8);
        r100.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        r100.setAlpha(0.0f);
        r100.setOnTouchListener(new a(r101, r100));
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ FrameLayout invoke() {
        return invoke();
    }
}
