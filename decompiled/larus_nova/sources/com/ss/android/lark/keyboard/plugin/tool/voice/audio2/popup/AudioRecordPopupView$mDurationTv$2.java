package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/appcompat/widget/AppCompatTextView;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AudioRecordPopupView$mDurationTv$2 extends Lambda implements Function0<AppCompatTextView> {
    final /* synthetic */ AudioRecordPopupView this$0;

    public AudioRecordPopupView$mDurationTv$2(AudioRecordPopupView r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppCompatTextView invoke() {
        return (AppCompatTextView) this.this$0.findViewById(R.id.audio_record_popup_view_duration_text);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AppCompatTextView invoke() {
        return invoke();
    }
}
