package com.bytedance.ee.bear.bitable.common.widgets.item;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableSpaceEditText;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.bytedance.ee.bear.widgets.universedesign.SimpleTagTextView;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UJ\u0015\u0010V\u001a\u00020S2\b\u0010W\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010XJ\u0017\u0010Y\u001a\u00020S2\n\b\u0001\u0010Z\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010XJ\u0010\u0010[\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UJ\u000e\u0010\\\u001a\u00020S2\u0006\u0010]\u001a\u00020GJ\u0010\u0010^\u001a\u00020S2\b\u0010_\u001a\u0004\u0018\u00010`J\u0017\u0010a\u001a\u00020S2\n\b\u0001\u0010b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010XJ\u0010\u0010c\u001a\u00020S2\b\u0010_\u001a\u0004\u0018\u00010`J\u0017\u0010d\u001a\u00020S2\n\b\u0001\u0010b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010XJ\u0015\u0010e\u001a\u00020S2\b\u0010f\u001a\u0004\u0018\u00010G¢\u0006\u0002\u0010gJ\u0010\u0010h\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UJ\u0010\u0010i\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UJ\u0017\u0010j\u001a\u00020S2\n\b\u0001\u0010Z\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010XJ\u0010\u0010k\u001a\u00020S2\b\u0010_\u001a\u0004\u0018\u00010`J\u0017\u0010l\u001a\u00020S2\n\b\u0001\u0010b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010XJ\u0010\u0010m\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UJ\u0006\u0010n\u001a\u00020\u0011J\u000e\u0010o\u001a\u00020S2\u0006\u0010p\u001a\u00020\u0007J\u0010\u0010q\u001a\u00020S2\b\u0010b\u001a\u0004\u0018\u00010rJ\u000e\u0010s\u001a\u00020S2\u0006\u0010t\u001a\u00020GJ&\u0010u\u001a\u00020S2\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u0007J\u0018\u0010z\u001a\u00020S2\u0006\u0010{\u001a\u00020\u00112\b\u0010T\u001a\u0004\u0018\u00010UJ\u0018\u0010z\u001a\u00020S2\u0006\u0010{\u001a\u00020|2\b\u0010T\u001a\u0004\u0018\u00010UJ\u0018\u0010}\u001a\u00020S2\u0006\u0010{\u001a\u00020~2\b\u0010_\u001a\u0004\u0018\u00010`J\u0018\u0010\u007f\u001a\u00020S2\u0007\u0010\u0080\u0001\u001a\u00020A2\u0007\u0010\u0081\u0001\u001a\u00020\u0007J\u0010\u0010\u0082\u0001\u001a\u00020S2\u0007\u0010\u0083\u0001\u001a\u00020\u0011R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001e\u0010%\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001e\u0010(\u001a\u0004\u0018\u00010)8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u0004\u0018\u00010/8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u0010\u0015R\u001e\u00107\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010\u0015R\u001e\u0010:\u001a\u0004\u0018\u00010;8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010@\u001a\u0004\u0018\u00010A8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006\u0085\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/item/CommonItemView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "leftEditTextFromXml", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableSpaceEditText;", "getLeftEditTextFromXml", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableSpaceEditText;", "setLeftEditTextFromXml", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableSpaceEditText;)V", "leftTextFromXml", "Landroid/widget/TextView;", "getLeftTextFromXml", "()Landroid/widget/TextView;", "setLeftTextFromXml", "(Landroid/widget/TextView;)V", "rightIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getRightIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setRightIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "leftIconFromXml", "Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "getLeftIconFromXml", "()Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "setLeftIconFromXml", "(Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;)V", "descFromXml", "getDescFromXml", "setDescFromXml", "leftIconTagFromXml", "getLeftIconTagFromXml", "setLeftIconTagFromXml", "itemSelectFromXml", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getItemSelectFromXml", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "setItemSelectFromXml", "(Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;)V", "tvTagFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;", "getTvTagFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;", "setTvTagFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;)V", "rightTextFromXml", "getRightTextFromXml", "setRightTextFromXml", "desc2FromXml", "getDesc2FromXml", "setDesc2FromXml", "itemContainerFromXml", "Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;", "getItemContainerFromXml", "()Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;", "setItemContainerFromXml", "(Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;)V", "wrapViewFromXml", "Landroid/view/View;", "getWrapViewFromXml", "()Landroid/view/View;", "setWrapViewFromXml", "(Landroid/view/View;)V", "editable", "", "getEditable", "()Z", "setEditable", "(Z)V", "callback", "Lcom/bytedance/ee/bear/bitable/common/widgets/item/Callback;", "getCallback", "()Lcom/bytedance/ee/bear/bitable/common/widgets/item/Callback;", "setCallback", "(Lcom/bytedance/ee/bear/bitable/common/widgets/item/Callback;)V", "setLeftText", "", "text", "", "setMaxLines", GXTemplateKey.STYLE_FONT_LINES, "(Ljava/lang/Integer;)V", "setLeftTextColor", "colorRes", "setPlaceholder", "bindEditText", "isClickable", "setLeftIcon", "icon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setLeftIconTint", "tint", "setLeftIconTag", "setLeftIconTagTint", "setSelect", "select", "(Ljava/lang/Boolean;)V", "setTagText", "setRightText", "setRightTextColor", "setRightIcon", "setRightIconTint", "setDesc", "getDesc", "setItemBackground", "resource", "setItemBackgroundTint", "Landroid/content/res/ColorStateList;", "disablePressStatus", "disable", "setRadius", "topLeft", "topRight", "bottomRight", "bottomLeft", "updateText", "view", "Landroid/widget/EditText;", "updateIcon", "Landroid/widget/ImageView;", "setViewRightMargin", BaseSwitches.V, GXTemplateKey.FLEXBOX_MARGIN, "adjustMaxWidth", "adjustView", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BitableSpaceEditText f209994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f209995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatImageView f209996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SyncIconImageView f209997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f209998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppCompatImageView f209999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDCheckBox f210000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SimpleTagTextView f210001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f210002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f210003j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RoundFrameLayout f210004k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f210005l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f210006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.common.widgets.item.b f210007n;

    public static final class a {
    }

    public static final class b implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonItemView f210008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f210009b;

        public b(CommonItemView r100, f r101) {
            this.f210008a = r100;
            this.f210009b = r101;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == false) goto L4;
            this.f210008a.getLeftEditTextFromXml().addTextChangedListener(this.f210009b);
            return;
        L4:
            this.f210008a.getLeftEditTextFromXml().removeTextChangedListener(this.f210009b);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonItemView f210010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<CharSequence, Unit> f210011b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(CommonItemView r100, Function1<? super CharSequence, Unit> r101) {
            this.f210010a = r100;
            this.f210011b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f210010a.getLeftEditTextFromXml().setText("");
            this.f210011b.invoke("");
            com.bytedance.ee.bear.bitable.common.widgets.item.b r101 = this.f210010a.getCallback();
            if (r101 == null) goto L6;
            r101.a("");
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonItemView f210012a;

        public d(CommonItemView r100) {
            this.f210012a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.ee.bear.bitable.common.widgets.item.b r101 = this.f210012a.getCallback();
            if (r101 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            r101.onClick(r100);
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonItemView f210013a;

        public e(CommonItemView r100) {
            this.f210013a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f210013a.getLeftEditTextFromXml().setFocusable(true);
            this.f210013a.getLeftEditTextFromXml().setFocusableInTouchMode(true);
            Editable r101 = this.f210013a.getLeftEditTextFromXml().getText();
            if (r101 == null) goto L5;
            this.f210013a.getLeftEditTextFromXml().setSelection(r101.length());
        L5:
            rcb.c.h(this.f210013a.getLeftEditTextFromXml(), null);
        }
    }

    public static final class f extends com.bytedance.ee.bear.bitable.common.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonItemView f210014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<CharSequence, Unit> f210015b;

        /* JADX WARN: Multi-variable type inference failed */
        public f(CommonItemView r100, Function1<? super CharSequence, Unit> r101) {
            this.f210014a = r100;
            this.f210015b = r101;
        }

        @Override // com.bytedance.ee.bear.bitable.common.j, android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            this.f210014a.requestLayout();
            if (this.f210014a.getLeftEditTextFromXml().hasFocus() == false) goto L10;
            this.f210015b.invoke(r100);
            com.bytedance.ee.bear.bitable.common.widgets.item.b r104 = this.f210014a.getCallback();
            if (r104 == null) goto L11;
            if (r100 != null) goto L8;
            r100 = "";
        L8:
            r104.a(r100);
            return;
        L11:
            return;
        }
    }

    static {
    }

    public CommonItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final TextView getDesc2FromXml() {
        KeyEvent.Callback r100 = this.f210003j;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.desc2);
        this.f210003j = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final TextView getDescFromXml() {
        KeyEvent.Callback r100 = this.f209998e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.desc);
        this.f209998e = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final RoundFrameLayout getItemContainerFromXml() {
        KeyEvent.Callback r100 = this.f210004k;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.item_container);
        this.f210004k = (RoundFrameLayout) r100;
    L6:
        return (RoundFrameLayout) r100;
    }

    public final UDCheckBox getItemSelectFromXml() {
        KeyEvent.Callback r100 = this.f210000g;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.item_select);
        this.f210000g = (UDCheckBox) r100;
    L6:
        return (UDCheckBox) r100;
    }

    public final BitableSpaceEditText getLeftEditTextFromXml() {
        KeyEvent.Callback r100 = this.f209994a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.left_edit_text);
        this.f209994a = (BitableSpaceEditText) r100;
    L6:
        return (BitableSpaceEditText) r100;
    }

    public final SyncIconImageView getLeftIconFromXml() {
        KeyEvent.Callback r100 = this.f209997d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.left_icon);
        this.f209997d = (SyncIconImageView) r100;
    L6:
        return (SyncIconImageView) r100;
    }

    public final AppCompatImageView getLeftIconTagFromXml() {
        KeyEvent.Callback r100 = this.f209999f;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.left_icon_tag);
        this.f209999f = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final TextView getLeftTextFromXml() {
        KeyEvent.Callback r100 = this.f209995b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.left_text);
        this.f209995b = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final AppCompatImageView getRightIconFromXml() {
        KeyEvent.Callback r100 = this.f209996c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.right_icon);
        this.f209996c = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final TextView getRightTextFromXml() {
        KeyEvent.Callback r100 = this.f210002i;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.right_text);
        this.f210002i = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final SimpleTagTextView getTvTagFromXml() {
        KeyEvent.Callback r100 = this.f210001h;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tv_tag);
        this.f210001h = (SimpleTagTextView) r100;
    L6:
        return (SimpleTagTextView) r100;
    }

    public final View getWrapViewFromXml() {
        View r100 = this.f210005l;
        if (r100 != null) goto L6;
        View r101 = findViewById(R.id.wrap_view);
        this.f210005l = r101;
        return r101;
    L6:
        return r100;
    }

    public final TextView getDesc() {
        if (TextUtils.isEmpty(getLeftTextFromXml().getText()) == false) goto L8;
        if (TextUtils.isEmpty(getTvTagFromXml().getText()) == false) goto L8;
        return getDesc2FromXml();
    L8:
        return getDescFromXml();
    }

    public final com.bytedance.ee.bear.bitable.common.widgets.item.b getCallback() {
        return this.f210007n;
    }

    public final boolean getEditable() {
        return this.f210006m;
    }

    public final void a(boolean r100) {
        if (this.f210006m == false) goto L5;
        Function1<CharSequence, Unit> r101 = new CommonItemView$bindEditText$updateClearIcon$1(this);
        r101.invoke(getLeftEditTextFromXml().getText());
        f r102 = new f(this, r101);
        getLeftEditTextFromXml().setOnFocusChangeListener(new b(this, r102));
        getRightIconFromXml().setOnClickListener(new c(this, r101));
        getLeftEditTextFromXml().setFocusable(false);
        getLeftEditTextFromXml().setFocusableInTouchMode(false);
        BitableSpaceEditText r103 = getLeftEditTextFromXml();
        Intrinsics.checkNotNullParameter(r103, "adjustView");
        getWrapViewFromXml().getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.ee.bear.bitable.common.widgets.item.d(this, r103));
        e r104 = new e(this);
        getLeftEditTextFromXml().setOnClickListener(r104);
        setOnClickListener(r104);
        getItemContainerFromXml().setBackgroundTintList(null);
        return;
    L5:
        getLeftEditTextFromXml().setOnFocusChangeListener(null);
        TextView r105 = getLeftTextFromXml();
        Intrinsics.checkNotNullParameter(r105, "adjustView");
        getWrapViewFromXml().getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.ee.bear.bitable.common.widgets.item.d(this, r105));
        if (r100 == false) goto L8;
        setOnClickListener(new d(this));
    L9:
        getRightIconFromXml().setOnClickListener(null);
        return;
    L8:
        setOnClickListener(null);
        goto L9
    }

    public final void setCallback(com.bytedance.ee.bear.bitable.common.widgets.item.b r100) {
        this.f210007n = r100;
    }

    public final void setDesc(String r100) {
        d(getDesc(), r100);
    }

    public final void setDesc2FromXml(TextView r100) {
        this.f210003j = r100;
    }

    public final void setDescFromXml(TextView r100) {
        this.f209998e = r100;
    }

    public final void setEditable(boolean r100) {
        this.f210006m = r100;
    }

    public final void setItemBackground(int r100) {
        getItemContainerFromXml().setBackgroundResource(r100);
    }

    public final void setItemBackgroundTint(ColorStateList r100) {
        getItemContainerFromXml().setBackgroundTintList(r100);
    }

    public final void setItemContainerFromXml(RoundFrameLayout r100) {
        this.f210004k = r100;
    }

    public final void setItemSelectFromXml(UDCheckBox r100) {
        this.f210000g = r100;
    }

    public final void setLeftEditTextFromXml(BitableSpaceEditText r100) {
        this.f209994a = r100;
    }

    public final void setLeftIcon(Icon r100) {
        c(getLeftIconFromXml(), r100);
        TextView r101 = getDescFromXml();
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        r101.setPadding(r102, 0, 0, 0);
        return;
    L5:
        r102 = n.d(32);
        goto L6
    }

    public final void setLeftIconFromXml(SyncIconImageView r100) {
        this.f209997d = r100;
    }

    public final void setLeftIconTag(Icon r100) {
        c(getLeftIconTagFromXml(), r100);
    }

    public final void setLeftIconTagFromXml(AppCompatImageView r100) {
        this.f209999f = r100;
    }

    public final void setLeftIconTagTint(Integer r100) {
        com.bytedance.ee.bear.bitable.panel.e.o(getLeftIconTagFromXml(), r100);
    }

    public final void setLeftIconTint(Integer r100) {
        com.bytedance.ee.bear.bitable.panel.e.o(getLeftIconFromXml(), r100);
    }

    public final void setLeftText(String r100) {
        int r101 = 8;
        if (this.f210006m == false) goto L9;
        BitableSpaceEditText r102 = getLeftEditTextFromXml();
        Intrinsics.checkNotNullParameter(r102, "view");
        r102.setText(r100);
        if (r100 == null) goto L8;
        r101 = 0;
    L8:
        r102.setVisibility(r101);
        d(getLeftTextFromXml(), null);
        return;
    L9:
        BitableSpaceEditText r103 = getLeftEditTextFromXml();
        Intrinsics.checkNotNullParameter(r103, "view");
        r103.setText(null);
        r103.setVisibility(8);
        d(getLeftTextFromXml(), r100);
    }

    public final void setLeftTextColor(Integer r100) {
        if (r100 == null) goto L8;
        r100.intValue();
        if (this.f210006m == false) goto L6;
        getLeftEditTextFromXml().setTextColor(AppCompatResources.getColorStateList(getContext(), r100.intValue()));
        return;
    L6:
        getLeftTextFromXml().setTextColor(AppCompatResources.getColorStateList(getContext(), r100.intValue()));
        return;
    }

    public final void setLeftTextFromXml(TextView r100) {
        this.f209995b = r100;
    }

    public final void setMaxLines(Integer r100) {
        if (this.f210006m == true) goto L9;
        if (r100 == null) goto L10;
        int r101 = r100.intValue();
        getLeftTextFromXml().setSingleLine(false);
        if (r100.intValue() <= 0) goto L11;
        getLeftTextFromXml().setMaxLines(r101);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void setPlaceholder(String r100) {
        getLeftEditTextFromXml().setHint(r100);
    }

    public final void setRightIcon(Icon r100) {
        c(getRightIconFromXml(), r100);
    }

    public final void setRightIconFromXml(AppCompatImageView r100) {
        this.f209996c = r100;
    }

    public final void setRightIconTint(Integer r100) {
        com.bytedance.ee.bear.bitable.panel.e.o(getRightIconFromXml(), r100);
    }

    public final void setRightText(String r100) {
        d(getRightTextFromXml(), r100);
    }

    public final void setRightTextColor(Integer r100) {
        if (r100 == null) goto L5;
        r100.intValue();
        getRightTextFromXml().setTextColor(AppCompatResources.getColorStateList(getContext(), r100.intValue()));
        return;
    }

    public final void setRightTextFromXml(TextView r100) {
        this.f210002i = r100;
    }

    public final void setSelect(Boolean r100) {
        UDCheckBox r101 = getItemSelectFromXml();
        boolean r102 = false;
        int r103 = 8;
        if (r100 == null) goto L5;
        b(getLeftIconFromXml(), n.d(8));
        r103 = 0;
    L6:
        r101.setVisibility(r103);
        UDCheckBox r104 = getItemSelectFromXml();
        if (r100 == null) goto L9;
        r102 = r100.booleanValue();
    L9:
        r104.setChecked(r102);
        return;
    L5:
        b(getLeftIconFromXml(), n.d(12));
        goto L6
    }

    public final void setTagText(String r100) {
        SimpleTagTextView r101 = getTvTagFromXml();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        SimpleTagTextView r103 = getTvTagFromXml();
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        r103.x(r100, UDTagsDrawable.TagColorSet.ORANGE);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setTvTagFromXml(SimpleTagTextView r100) {
        this.f210001h = r100;
    }

    public final void setWrapViewFromXml(View r100) {
        this.f210005l = r100;
    }

    public static void b(SyncIconImageView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if ((r100.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        r103.setMargins(r103.leftMargin, r103.topMargin, r101, r103.bottomMargin);
        return;
    }

    public static void c(AppCompatImageView r100, Icon r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 == null) goto L5;
        com.bytedance.ee.bear.bitable.panel.e.i(r100, r101);
    L5:
        if (r101 != null) goto L7;
        int r102 = 8;
    L8:
        r100.setVisibility(r102);
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public static void d(TextView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setText(r101);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        int r102 = 8;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public CommonItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.bitable_common_item_view, this, true);
        setItemBackground(R.color.bg_float);
        setItemBackgroundTint(ColorUtils.d(r100));
    }

    public /* synthetic */ CommonItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
