package com.ss.android.lark.biz.im.api.chat.setting;

import android.widget.CompoundButton;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u001aJ\u000e\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u001aJ\b\u00100\u001a\u000201H\u0014J\b\u00102\u001a\u000201H\u0014J\b\u00103\u001a\u00020$H\u0014J\n\u00104\u001a\u0004\u0018\u00010\u001dH\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010*\u001a\u00020+H\u0014J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020$H\u0014J\u0010\u00107\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0004J\u0012\u00108\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u001aH\u0004J\b\u00109\u001a\u00020&H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\u001e\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0\u001fj\u0002`'X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010(\u001a6\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0\u001fj\u0002`'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/ss/android/lark/biz/im/api/chat/setting/SettingSwitchPiece;", "Lcom/ss/android/lark/biz/im/api/chat/setting/SettingBasePiece;", "<init>", "()V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "subtitleView", "getSubtitleView", "setSubtitleView", "switchBtn", "Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "getSwitchBtn", "()Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "setSwitchBtn", "(Lcom/larksuite/component/universe_design/udswitch/UDSwitch;)V", "startExtraView", "Landroid/view/View;", "getStartExtraView", "()Landroid/view/View;", "setStartExtraView", "(Landroid/view/View;)V", "titleStr", "", "subtitleStr", "onCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "emptyAction", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "Lkotlin/ParameterName;", "name", "buttonView", "", "isChecked", "", "Lcom/ss/android/lark/biz/im/api/chat/setting/OnCheckedChangeAction;", "realAction", "getView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "layoutConfig", "Landroid/view/ViewGroup$MarginLayoutParams;", "title", "subtitle", "titleRes", "", "subtitleRes", "getDefaultCheckedState", "getOnCheckedChangeListener", "updateContentViewEnable", "isEnableState", "updateCheckedState", "updateViewProperty", "updateTitleView", "Companion", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SettingSwitchPiece extends SettingBasePiece<SettingSwitchPiece> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompoundButton.OnCheckedChangeListener f410076h;

    public static final class a {
    }

    static {
    }

    public CompoundButton.OnCheckedChangeListener e() {
        return null;
    }

    public SettingSwitchPiece() {
        this.f410076h = e();
        SettingSwitchPiece$emptyAction$1 r100 = SettingSwitchPiece$emptyAction$1.INSTANCE;
        new SettingSwitchPiece$realAction$1(this);
    }
}
