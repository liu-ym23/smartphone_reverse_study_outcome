package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.foundation.widget.FlowSwitch;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003QRSB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u001a\u0010!\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00162\b\b\u0001\u0010(\u001a\u00020\nJ\u000e\u0010)\u001a\u00020\u00162\u0006\u0010%\u001a\u00020*J\u000e\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020\u00162\b\b\u0001\u0010/\u001a\u00020\nJ\u0010\u00100\u001a\u00020\u00162\b\b\u0001\u0010(\u001a\u00020\nJ\u0010\u00101\u001a\u00020\u00162\b\b\u0001\u0010(\u001a\u00020\nJ\u0016\u00102\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\n2\u0006\u00103\u001a\u00020\nJ\u0006\u00104\u001a\u00020\u0016J\u000e\u00105\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&J\b\u00106\u001a\u0004\u0018\u00010\u0018J\u0006\u00107\u001a\u00020\u0015J\u000e\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\nJ\u000e\u0010:\u001a\u00020\u00162\u0006\u00109\u001a\u00020\nJ\u000e\u0010;\u001a\u00020\u00162\u0006\u00109\u001a\u00020\nJ\u000e\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u0015J\u0018\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u00152\b\b\u0002\u0010>\u001a\u00020\u0015J\u000e\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u0015J\u0006\u0010A\u001a\u00020\u0015J\u000e\u0010B\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u0015J\u0006\u0010C\u001a\u00020\u0015J\u000e\u0010D\u001a\u00020\u00162\u0006\u00109\u001a\u00020\nJ\u0010\u0010E\u001a\u00020\u00162\b\u0010F\u001a\u0004\u0018\u00010GJ\u000e\u0010H\u001a\u00020\u00162\u0006\u00109\u001a\u00020\nJ\u0010\u0010I\u001a\u00020\u00162\b\u0010F\u001a\u0004\u0018\u00010GJ\u001c\u0010J\u001a\u00020\u00162\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014J\u000e\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u0015J\u000e\u0010M\u001a\u00020\u00162\u0006\u0010N\u001a\u00020OJ\u000e\u0010P\u001a\u0004\u0018\u00010\u0012*\u00020\u0018H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmNormalHintSwitchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mContentTv", "Landroid/widget/TextView;", "mContentDescTv", "mSwitch", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmNormalHintSwitchView$MmSwitchAdapter;", "mListener", "Lkotlin/Function1;", "", "", "mSwitchMask", "Landroid/view/View;", "mIconItemMask", "mIconDesc", "mIcon", "Landroid/widget/ImageView;", "mCheck", "mRootView", "defaultIconResId", "defaultIconTintResId", "init", "setStyle", "style", "setContent", "text", "", "setContentColor", "color", "setContentDesc", "", "setContentDescMovementMethod", "movement", "Landroid/text/method/MovementMethod;", "setContentDescHighlightTextColor", "resId", "setContentDescColor", "setIconDescColor", "setIconResource", "colorId", "setDefaultIcon", "setIconDesc", "getIcon", "isCheckIconChecked", "setIconVisibility", RemoteMessageConst.Notification.VISIBILITY, "setIconDescVisibility", "setCheckVisibility", "setSwitchChecked", "isChecked", "notifyEvent", "setSwitchEnabled", "isEnabled", "isSwitchEnabled", "setSwitchClickable", "isSwitchChecked", "setSwitchMaskVisibility", "setSwitchMaskOnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setIconMaskVisibility", "setIconMaskOnClickListener", "setOnCheckedChangeListener", "setSwitchLoading", "loading", "setIconDescTextSize", "size", "", "toMmSwitchAdapter", "MmSwitchAdapter", "FlowSwitchAdapter", "UDSwitchAdapter", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmNormalHintSwitchView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f435655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f435656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f435657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f435658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f435659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f435660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f435661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f435662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f435663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f435664j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f435665k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f435666l;

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowSwitch f435667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FlowSwitch f435668b;

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final boolean isChecked() {
            return this.f435667a.isChecked();
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final View getView() {
            return this.f435668b;
        }

        public a(FlowSwitch r100) {
            Intrinsics.checkNotNullParameter(r100, "switchView");
            this.f435667a = r100;
            this.f435668b = r100;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void a(Function1<? super Boolean, Unit> r100) {
            this.f435667a.setOnCheckedChangeListener(r100);
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void c(boolean r100) {
            this.f435667a.setLoading(r100);
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void b(boolean r100, Function1 r101) {
            this.f435667a.setChecked(r100);
        }
    }

    public interface b {
        void a(Function1<? super Boolean, Unit> r100);

        void b(boolean r100, Function1 r101);

        void c(boolean r100);

        View getView();

        boolean isChecked();
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UDSwitch f435669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UDSwitch f435670b;

        public static final class a implements CompoundButton.OnCheckedChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<Boolean, Unit> f435671a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super Boolean, Unit> r100) {
                this.f435671a = r100;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton r100, boolean r101) {
                Function1<Boolean, Unit> r102 = this.f435671a;
                if (r102 == null) goto L6;
                r102.invoke(Boolean.valueOf(r101));
                return;
            }
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void c(boolean r100) {
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final boolean isChecked() {
            return this.f435669a.isChecked();
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final View getView() {
            return this.f435670b;
        }

        public c(UDSwitch r100) {
            Intrinsics.checkNotNullParameter(r100, "switchView");
            this.f435669a = r100;
            this.f435670b = r100;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void a(Function1<? super Boolean, Unit> r100) {
            this.f435669a.setOnCheckedChangeListener(new a(r100));
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView.b
        public final void b(boolean r100, Function1 r101) {
            this.f435669a.setCheckedIgnoreEvent(r100);
        }
    }

    public final View getIcon() {
        return this.f435662h;
    }

    public MmNormalHintSwitchView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        R5(r100, null);
    }

    public final void S5(boolean r100) {
        b r101 = this.f435657c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isChecked() == r100) goto L9;
        r101.b(r100, this.f435658d);
        return;
    }

    public final void setCheckVisibility(int r100) {
        View r101 = this.f435663i;
        if (r101 == null) goto L6;
        r101.setVisibility(r100);
        return;
    }

    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f435655a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setContentColor(int r100) {
        TextView r101 = this.f435655a;
        if (r101 == null) goto L6;
        r101.setTextColor(UDColorUtils.getColor(getContext(), r100));
        return;
    }

    public final void setContentDesc(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f435656b;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setContentDescColor(int r100) {
        TextView r101 = this.f435656b;
        if (r101 == null) goto L6;
        r101.setTextColor(UDColorUtils.getColor(getContext(), r100));
        return;
    }

    public final void setContentDescHighlightTextColor(int r100) {
        TextView r101 = this.f435656b;
        if (r101 == null) goto L6;
        r101.setHighlightColor(UDColorUtils.getColor(getContext(), r100));
        return;
    }

    public final void setContentDescMovementMethod(MovementMethod r100) {
        Intrinsics.checkNotNullParameter(r100, "movement");
        TextView r101 = this.f435656b;
        if (r101 == null) goto L6;
        r101.setMovementMethod(r100);
        return;
    }

    public final void setIconDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f435661g;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setIconDescColor(int r100) {
        TextView r101 = this.f435661g;
        if (r101 == null) goto L6;
        r101.setTextColor(UDColorUtils.getColor(getContext(), r100));
        return;
    }

    public final void setIconDescTextSize(float r100) {
        TextView r101 = this.f435661g;
        if (r101 == null) goto L6;
        r101.setTextSize(r100);
        return;
    }

    public final void setIconDescVisibility(int r100) {
        TextView r101 = this.f435661g;
        if (r101 == null) goto L6;
        r101.setVisibility(r100);
        return;
    }

    public final void setIconMaskOnClickListener(final View.OnClickListener r100) {
        if (r100 != null) goto L6;
        View r101 = this.f435660f;
        if (r101 == null) goto L10;
        r101.setOnClickListener(null);
        return;
    L10:
        return;
    L6:
        View r102 = this.f435660f;
        if (r102 == null) goto L12;
        h.a(r102, new AnonymousClass1(r100));
        return;
    }

    public final void setIconMaskVisibility(int r100) {
        View r101 = this.f435660f;
        if (r101 == null) goto L6;
        r101.setVisibility(r100);
        return;
    }

    public final void setIconVisibility(int r100) {
        ImageView r101 = this.f435662h;
        if (r101 == null) goto L6;
        r101.setVisibility(r100);
        return;
    }

    public final void setOnCheckedChangeListener(Function1<? super Boolean, Unit> r100) {
        this.f435658d = r100;
        b r101 = this.f435657c;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final void setStyle(int r100) {
        if (r100 != MmSwitchViewStyle.SWITCH_ONLY.getValue()) goto L19;
        TextView r101 = this.f435661g;
        if (r101 == null) goto L7;
        r101.setVisibility(8);
    L7:
        ImageView r102 = this.f435662h;
        if (r102 == null) goto L10;
        r102.setVisibility(8);
    L10:
        TextView r103 = this.f435656b;
        if (r103 == null) goto L13;
        r103.setVisibility(8);
    L13:
        b r104 = this.f435657c;
        if (r104 == null) goto L130;
        View r105 = r104.getView();
        if (r105 == null) goto L131;
        r105.setVisibility(0);
        return;
    L131:
        return;
    L130:
        return;
    L19:
        if (r100 != MmSwitchViewStyle.SWITCH_HINT.getValue()) goto L35;
        TextView r106 = this.f435661g;
        if (r106 == null) goto L23;
        r106.setVisibility(8);
    L23:
        ImageView r107 = this.f435662h;
        if (r107 == null) goto L26;
        r107.setVisibility(8);
    L26:
        TextView r108 = this.f435656b;
        if (r108 == null) goto L29;
        r108.setVisibility(0);
    L29:
        b r109 = this.f435657c;
        if (r109 == null) goto L133;
        View r110 = r109.getView();
        if (r110 == null) goto L134;
        r110.setVisibility(0);
        return;
    L134:
        return;
    L133:
        return;
    L35:
        if (r100 != MmSwitchViewStyle.ICON_ONLY.getValue()) goto L51;
        TextView r111 = this.f435661g;
        if (r111 == null) goto L39;
        r111.setVisibility(0);
    L39:
        ImageView r112 = this.f435662h;
        if (r112 == null) goto L42;
        r112.setVisibility(0);
    L42:
        TextView r113 = this.f435656b;
        if (r113 == null) goto L45;
        r113.setVisibility(8);
    L45:
        b r114 = this.f435657c;
        if (r114 == null) goto L136;
        View r115 = r114.getView();
        if (r115 == null) goto L137;
        r115.setVisibility(8);
        return;
    L137:
        return;
    L136:
        return;
    L51:
        if (r100 != MmSwitchViewStyle.ICON_HINT.getValue()) goto L67;
        TextView r116 = this.f435661g;
        if (r116 == null) goto L55;
        r116.setVisibility(0);
    L55:
        ImageView r117 = this.f435662h;
        if (r117 == null) goto L58;
        r117.setVisibility(0);
    L58:
        TextView r118 = this.f435656b;
        if (r118 == null) goto L61;
        r118.setVisibility(0);
    L61:
        b r119 = this.f435657c;
        if (r119 == null) goto L139;
        View r120 = r119.getView();
        if (r120 == null) goto L140;
        r120.setVisibility(8);
        return;
    L140:
        return;
    L139:
        return;
    L67:
        if (r100 != MmSwitchViewStyle.CONTENT_ONLY.getValue()) goto L83;
        TextView r121 = this.f435661g;
        if (r121 == null) goto L71;
        r121.setVisibility(8);
    L71:
        ImageView r122 = this.f435662h;
        if (r122 == null) goto L74;
        r122.setVisibility(8);
    L74:
        TextView r123 = this.f435656b;
        if (r123 == null) goto L77;
        r123.setVisibility(8);
    L77:
        b r124 = this.f435657c;
        if (r124 == null) goto L142;
        View r125 = r124.getView();
        if (r125 == null) goto L143;
        r125.setVisibility(8);
        return;
    L143:
        return;
    L142:
        return;
    L83:
        if (r100 != MmSwitchViewStyle.CONTENT_HINT.getValue()) goto L99;
        TextView r126 = this.f435661g;
        if (r126 == null) goto L87;
        r126.setVisibility(8);
    L87:
        ImageView r127 = this.f435662h;
        if (r127 == null) goto L90;
        r127.setVisibility(8);
    L90:
        TextView r128 = this.f435656b;
        if (r128 == null) goto L93;
        r128.setVisibility(0);
    L93:
        b r129 = this.f435657c;
        if (r129 == null) goto L145;
        View r130 = r129.getView();
        if (r130 == null) goto L146;
        r130.setVisibility(8);
        return;
    L146:
        return;
    L145:
        return;
    L99:
        if (r100 != MmSwitchViewStyle.CHECK_ONLY.getValue()) goto L148;
        TextView r131 = this.f435655a;
        ConstraintLayout.LayoutParams r132 = null;
        if (r131 == null) goto L108;
        ViewGroup.LayoutParams r133 = r131.getLayoutParams();
        if ((r133 instanceof ConstraintLayout.LayoutParams) == false) goto L105;
        ConstraintLayout.LayoutParams r134 = (ConstraintLayout.LayoutParams) r133;
    L106:
        if (r134 == null) goto L108;
        r134.endToStart = R.id.setting_item_check_icon;
        r134.setMarginEnd(UIUtils.dp2px(r131.getContext(), 12.0f));
        r131.setLayoutParams(r134);
        goto L108
    L105:
        r134 = null;
    L108:
        View r135 = this.f435663i;
        if (r135 == null) goto L111;
        r135.setVisibility(4);
    L111:
        TextView r136 = this.f435661g;
        if (r136 == null) goto L114;
        r136.setVisibility(8);
    L114:
        ImageView r137 = this.f435662h;
        if (r137 == null) goto L117;
        r137.setVisibility(8);
    L117:
        TextView r138 = this.f435656b;
        if (r138 == null) goto L124;
        ViewGroup.LayoutParams r139 = r138.getLayoutParams();
        if ((r139 instanceof ConstraintLayout.LayoutParams) == false) goto L122;
        r132 = (ConstraintLayout.LayoutParams) r139;
    L122:
        if (r132 == null) goto L124;
        r132.endToStart = R.id.setting_item_check_icon;
        r132.setMarginEnd(UIUtils.dp2px(r138.getContext(), 12.0f));
        r138.setLayoutParams(r132);
        r138.setVisibility(0);
    L124:
        b r140 = this.f435657c;
        if (r140 == null) goto L149;
        View r141 = r140.getView();
        if (r141 == null) goto L150;
        r141.setVisibility(8);
        return;
    L150:
        return;
    L149:
        return;
    }

    public final void setSwitchChecked(boolean r100) {
        S5(r100);
    }

    public final void setSwitchClickable(boolean r100) {
        b r101 = this.f435657c;
        if (r101 == null) goto L8;
        View r102 = r101.getView();
        if (r102 == null) goto L9;
        r102.setClickable(r100);
        return;
    L9:
        return;
    }

    public final void setSwitchEnabled(boolean r100) {
        b r101 = this.f435657c;
        if (r101 == null) goto L8;
        View r102 = r101.getView();
        if (r102 == null) goto L9;
        r102.setEnabled(r100);
        return;
    L9:
        return;
    }

    public final void setSwitchLoading(boolean r100) {
        b r101 = this.f435657c;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public final void setSwitchMaskOnClickListener(final View.OnClickListener r100) {
        if (r100 != null) goto L6;
        View r101 = this.f435659e;
        if (r101 == null) goto L10;
        r101.setOnClickListener(null);
        return;
    L10:
        return;
    L6:
        View r102 = this.f435659e;
        if (r102 == null) goto L12;
        h.a(r102, new C119381(r100));
        return;
    }

    public final void setSwitchMaskVisibility(int r100) {
        View r101 = this.f435659e;
        if (r101 == null) goto L6;
        r101.setVisibility(r100);
        return;
    }

    public MmNormalHintSwitchView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        R5(r100, r101);
    }

    public final void R5(Context r100, AttributeSet r101) {
        MmRecordingUILaunchMode r102 = com.ss.android.lark.officesdk.minutes.ui.style.c.a(r100);
        com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.h r103 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r102);
        this.f435665k = r103.getDrawable().f();
        this.f435666l = r103.getColor().q();
        View r104 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r102).getLayout().t(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r100, r102)), this);
        this.f435664j = r104;
        View r105 = null;
        if (r104 == null) goto L5;
        TextView r106 = (TextView) r104.findViewById(R.id.setting_item_content);
    L6:
        this.f435655a = r106;
        View r107 = this.f435664j;
        if (r107 == null) goto L9;
        TextView r108 = (TextView) r107.findViewById(R.id.setting_item_content_desc);
    L10:
        this.f435656b = r108;
        View r109 = this.f435664j;
        if (r109 == null) goto L20;
        View r110 = r109.findViewById(R.id.setting_item_switch);
        if (r110 == null) goto L20;
        if ((r110 instanceof FlowSwitch) == false) goto L18;
        b r111 = new a((FlowSwitch) r110);
    L21:
        this.f435657c = r111;
        View r112 = this.f435664j;
        if (r112 == null) goto L24;
        View r113 = r112.findViewById(R.id.setting_item_mask);
    L25:
        this.f435659e = r113;
        View r114 = this.f435664j;
        if (r114 == null) goto L28;
        ImageView r115 = (ImageView) r114.findViewById(R.id.setting_item_icon);
    L29:
        this.f435662h = r115;
        View r116 = this.f435664j;
        if (r116 == null) goto L32;
        TextView r117 = (TextView) r116.findViewById(R.id.setting_item_icon_desc);
    L33:
        this.f435661g = r117;
        View r118 = this.f435664j;
        if (r118 == null) goto L36;
        View r119 = r118.findViewById(R.id.setting_icon_item_mask);
    L37:
        this.f435660f = r119;
        View r120 = this.f435664j;
        if (r120 == null) goto L40;
        r105 = r120.findViewById(R.id.setting_item_check_icon);
    L40:
        this.f435663i = r105;
        TypedArray r121 = r100.obtainStyledAttributes(r101, new int[]{R.attr.normal_content_desc_text, R.attr.normal_content_text, R.attr.normal_content_text_bold, R.attr.normal_icon_desc_text, R.attr.normal_icon_res, R.attr.normal_layout_style});
        String r122 = r121.getString(1);
        if (r122 == null) goto L43;
        setContent(r122);
    L43:
        String r123 = r121.getString(0);
        if (r123 == null) goto L46;
        setContentDesc(r123);
    L46:
        String r124 = r121.getString(3);
        if (r124 == null) goto L49;
        setIconDesc(r124);
    L49:
        int r125 = r121.getResourceId(4, this.f435665k);
        int r126 = this.f435666l;
        int r127 = wvb.b.f561601a;
        wvb.b.a(this.f435662h, r125, r126);
        setStyle(r121.getInteger(5, MmSwitchViewStyle.SWITCH_ONLY.getValue()));
        boolean r128 = r121.getBoolean(2, true);
        TextView r129 = this.f435655a;
        if (r129 == null) goto L54;
        TextPaint r130 = r129.getPaint();
        if (r130 == null) goto L54;
        r130.setFakeBoldText(r128);
    L54:
        r121.recycle();
        return;
    L36:
        r119 = null;
        goto L37
    L32:
        r117 = null;
        goto L33
    L28:
        r115 = null;
        goto L29
    L24:
        r113 = null;
        goto L25
    L18:
        if ((r110 instanceof UDSwitch) == false) goto L20;
        r111 = new c((UDSwitch) r110);
    L20:
        r111 = null;
        goto L21
    L9:
        r108 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }

    public MmNormalHintSwitchView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        R5(r100, r101);
    }
}
