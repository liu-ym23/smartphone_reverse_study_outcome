package com.bytedance.ee.bear.bitable.uikit.search;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableSpaceEditText;
import com.bytedance.ee.bear.bitable.common.j;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SearchConfigIcon;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u001a\u0010+\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010,2\b\u0010)\u001a\u0004\u0018\u00010*J\u000e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020&J\u0006\u00101\u001a\u00020&R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/search/SearchBar;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "rightIconWrapperFromXml", "getRightIconWrapperFromXml", "()Landroid/widget/FrameLayout;", "setRightIconWrapperFromXml", "(Landroid/widget/FrameLayout;)V", "leftEditTextFromXml", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableSpaceEditText;", "getLeftEditTextFromXml", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableSpaceEditText;", "setLeftEditTextFromXml", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableSpaceEditText;)V", "searchConfigFromXml", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SearchConfigIcon;", "getSearchConfigFromXml", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SearchConfigIcon;", "setSearchConfigFromXml", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SearchConfigIcon;)V", "enableClearSearchBtn", "", "getEnableClearSearchBtn", "()Z", "setEnableClearSearchBtn", "(Z)V", "callback", "Lcom/bytedance/ee/bear/bitable/common/widgets/item/Callback;", "getCallback", "()Lcom/bytedance/ee/bear/bitable/common/widgets/item/Callback;", "setCallback", "(Lcom/bytedance/ee/bear/bitable/common/widgets/item/Callback;)V", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/uikit/search/SearchBarModel;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setSearchConfig", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setHint", "hint", "", "resetSearch", "editTextClearFocus", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f216207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BitableSpaceEditText f216208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SearchConfigIcon f216209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f216210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.common.widgets.item.b f216211e;

    public static final class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchBar f216212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f216213b;

        public a(SearchBar r100, e r101) {
            this.f216212a = r100;
            this.f216213b = r101;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == false) goto L4;
            this.f216212a.getLeftEditTextFromXml().addTextChangedListener(this.f216213b);
            return;
        L4:
            this.f216212a.getLeftEditTextFromXml().removeTextChangedListener(this.f216213b);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchBar f216214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<CharSequence, Unit> f216215b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(SearchBar r100, Function1<? super CharSequence, Unit> r101) {
            this.f216214a = r100;
            this.f216215b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f216214a.getLeftEditTextFromXml().setText("");
            this.f216215b.invoke("");
            com.bytedance.ee.bear.bitable.common.widgets.item.b r101 = this.f216214a.getCallback();
            if (r101 == null) goto L6;
            r101.a("");
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchBar f216216a;

        public c(SearchBar r100) {
            this.f216216a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f216216a.getLeftEditTextFromXml().setFocusable(true);
            this.f216216a.getLeftEditTextFromXml().setFocusableInTouchMode(true);
            Editable r101 = this.f216216a.getLeftEditTextFromXml().getText();
            if (r101 == null) goto L5;
            this.f216216a.getLeftEditTextFromXml().setSelection(r101.length());
        L5:
            KeyboardUtils.showKeyboard(this.f216216a.getLeftEditTextFromXml());
        }
    }

    public static final class d extends com.bytedance.ee.bear.bitable.common.widgets.item.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gv4.a f216217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SearchBarModel f216218b;

        @Override // com.bytedance.ee.bear.bitable.common.widgets.item.b
        public final void a(CharSequence r100) {
            Intrinsics.checkNotNullParameter(r100, "s");
            this.f216217a.a(new SearchAction(this.f216218b.getId(), r100.toString()));
        }

        public d(gv4.a r100, SearchBarModel r101) {
            this.f216217a = r100;
            this.f216218b = r101;
        }
    }

    public static final class e extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchBar f216219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<CharSequence, Unit> f216220b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(SearchBar r100, Function1<? super CharSequence, Unit> r101) {
            this.f216219a = r100;
            this.f216220b = r101;
        }

        @Override // com.bytedance.ee.bear.bitable.common.j, android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (this.f216219a.getLeftEditTextFromXml().hasFocus() == false) goto L10;
            this.f216220b.invoke(r100);
            com.bytedance.ee.bear.bitable.common.widgets.item.b r104 = this.f216219a.getCallback();
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

    public final BitableSpaceEditText getLeftEditTextFromXml() {
        KeyEvent.Callback r100 = this.f216208b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.left_edit_text);
        this.f216208b = (BitableSpaceEditText) r100;
    L6:
        return (BitableSpaceEditText) r100;
    }

    public final FrameLayout getRightIconWrapperFromXml() {
        KeyEvent.Callback r100 = this.f216207a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.right_icon_wrapper);
        this.f216207a = (FrameLayout) r100;
    L6:
        return (FrameLayout) r100;
    }

    public final SearchConfigIcon getSearchConfigFromXml() {
        KeyEvent.Callback r100 = this.f216209c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.search_config);
        this.f216209c = (SearchConfigIcon) r100;
    L6:
        return (SearchConfigIcon) r100;
    }

    public final void a() {
        Editable r100 = getLeftEditTextFromXml().getText();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        getLeftEditTextFromXml().setText("");
    L11:
        getLeftEditTextFromXml().clearFocus();
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final com.bytedance.ee.bear.bitable.common.widgets.item.b getCallback() {
        return this.f216211e;
    }

    public final boolean getEnableClearSearchBtn() {
        return this.f216210d;
    }

    public SearchBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setCallback(com.bytedance.ee.bear.bitable.common.widgets.item.b r100) {
        this.f216211e = r100;
    }

    public final void setEnableClearSearchBtn(boolean r100) {
        this.f216210d = r100;
    }

    public final void setHint(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        getLeftEditTextFromXml().setHint(r100);
    }

    public final void setLeftEditTextFromXml(BitableSpaceEditText r100) {
        this.f216208b = r100;
    }

    public final void setRightIconWrapperFromXml(FrameLayout r100) {
        this.f216207a = r100;
    }

    public final void setSearchConfigFromXml(SearchConfigIcon r100) {
        this.f216209c = r100;
    }

    public SearchBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f216210d = true;
        LayoutInflater.from(r100).inflate(R.layout.bitable_search_bar_layout, this, true);
        Function1<CharSequence, Unit> r102 = new SearchBar$updateClearIcon$1(this);
        r102.invoke(getLeftEditTextFromXml().getText());
        e r103 = new e(this, r102);
        getLeftEditTextFromXml().setOnFocusChangeListener(new a(this, r103));
        getRightIconWrapperFromXml().setOnClickListener(new b(this, r102));
        c r104 = new c(this);
        getLeftEditTextFromXml().setOnClickListener(r104);
        setOnClickListener(r104);
    }

    public final void b(SearchBarModel r100, gv4.a r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "handler");
        getLeftEditTextFromXml().setHint(r100.getHint());
        this.f216211e = new d(r101, r100);
    }
}
