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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u001a\u0010+\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010,2\b\u0010)\u001a\u0004\u0018\u00010*J\u000e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020&J\u0006\u00101\u001a\u00020&R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/search/SearchBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "rightIconWrapperFromXml", "getRightIconWrapperFromXml", "()Landroid/widget/FrameLayout;", "setRightIconWrapperFromXml", "(Landroid/widget/FrameLayout;)V", "leftEditTextFromXml", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableSpaceEditText;", "getLeftEditTextFromXml", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableSpaceEditText;", "setLeftEditTextFromXml", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableSpaceEditText;)V", "searchConfigFromXml", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SearchConfigIcon;", "getSearchConfigFromXml", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SearchConfigIcon;", "setSearchConfigFromXml", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SearchConfigIcon;)V", "enableClearSearchBtn", "", "getEnableClearSearchBtn", "()Z", "setEnableClearSearchBtn", "(Z)V", "callback", "Lcom/bytedance/ee/bear/bitable/common/widgets/item/Callback;", "getCallback", "()Lcom/bytedance/ee/bear/bitable/common/widgets/item/Callback;", "setCallback", "(Lcom/bytedance/ee/bear/bitable/common/widgets/item/Callback;)V", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/uikit/search/SearchBarModel;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setSearchConfig", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setHint", "hint", "", "resetSearch", "editTextClearFocus", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchBar extends FrameLayout {
    public FrameLayout a;
    public BitableSpaceEditText b;
    public SearchConfigIcon c;
    public boolean d;
    public com.bytedance.ee.bear.bitable.common.widgets.item.b e;

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ SearchBar a;
        public final /* synthetic */ e b;

        public a(SearchBar r1, e r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r1, boolean r2) {
            if (r2 == false) goto L4;
            this.a.getLeftEditTextFromXml().addTextChangedListener(this.b);
            return;
        L4:
            this.a.getLeftEditTextFromXml().removeTextChangedListener(this.b);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SearchBar a;
        public final /* synthetic */ Function1<CharSequence, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(SearchBar r1, Function1<? super CharSequence, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.getLeftEditTextFromXml().setText("");
            this.b.invoke("");
            com.bytedance.ee.bear.bitable.common.widgets.item.b r3 = this.a.getCallback();
            if (r3 == null) goto L6;
            r3.a("");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ SearchBar a;

        public c(SearchBar r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.getLeftEditTextFromXml().setFocusable(true);
            this.a.getLeftEditTextFromXml().setFocusableInTouchMode(true);
            Editable r3 = this.a.getLeftEditTextFromXml().getText();
            if (r3 == null) goto L5;
            this.a.getLeftEditTextFromXml().setSelection(r3.length());
        L5:
            KeyboardUtils.showKeyboard(this.a.getLeftEditTextFromXml());
        }
    }

    public static final class d extends com.bytedance.ee.bear.bitable.common.widgets.item.c {
        public final /* synthetic */ gv4.a a;
        public final /* synthetic */ SearchBarModel b;

        public final void a(CharSequence r4) {
            Intrinsics.checkNotNullParameter(r4, "s");
            this.a.a(new SearchAction(this.b.getId(), r4.toString()));
        }

        public d(gv4.a r1, SearchBarModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e extends j {
        public final /* synthetic */ SearchBar a;
        public final /* synthetic */ Function1<CharSequence, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(SearchBar r1, Function1<? super CharSequence, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            if (this.a.getLeftEditTextFromXml().hasFocus() == false) goto L10;
            this.b.invoke(r1);
            com.bytedance.ee.bear.bitable.common.widgets.item.b r5 = this.a.getCallback();
            if (r5 == null) goto L11;
            if (r1 != null) goto L8;
            r1 = "";
        L8:
            r5.a(r1);
            return;
        L11:
            return;
        }
    }

    public final BitableSpaceEditText getLeftEditTextFromXml() {
        BitableSpaceEditText r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131377762);
        this.b = r0;
    L6:
        return r0;
    }

    public final FrameLayout getRightIconWrapperFromXml() {
        KeyEvent.Callback r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131384594);
        this.a = (FrameLayout) r0;
    L6:
        return (FrameLayout) r0;
    }

    public final SearchConfigIcon getSearchConfigFromXml() {
        KeyEvent.Callback r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131385354);
        this.c = (SearchConfigIcon) r0;
    L6:
        return (SearchConfigIcon) r0;
    }

    public final void a() {
        Editable r0 = getLeftEditTextFromXml().getText();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        getLeftEditTextFromXml().setText("");
    L11:
        getLeftEditTextFromXml().clearFocus();
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final com.bytedance.ee.bear.bitable.common.widgets.item.b getCallback() {
        return this.e;
    }

    public final boolean getEnableClearSearchBtn() {
        return this.d;
    }

    public SearchBar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setCallback(com.bytedance.ee.bear.bitable.common.widgets.item.b r1) {
        this.e = r1;
    }

    public final void setEnableClearSearchBtn(boolean r1) {
        this.d = r1;
    }

    public final void setHint(String r2) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        getLeftEditTextFromXml().setHint(r2);
    }

    public final void setLeftEditTextFromXml(BitableSpaceEditText r1) {
        this.b = r1;
    }

    public final void setRightIconWrapperFromXml(FrameLayout r1) {
        this.a = r1;
    }

    public final void setSearchConfigFromXml(SearchConfigIcon r1) {
        this.c = r1;
    }

    public SearchBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.d = true;
        LayoutInflater.from(r3).inflate(2131559143, this, true);
        Function1<CharSequence, Unit> r5 = new SearchBar$updateClearIcon$1(this);
        r5.invoke(getLeftEditTextFromXml().getText());
        e r6 = new e(this, r5);
        getLeftEditTextFromXml().setOnFocusChangeListener(new a(this, r6));
        getRightIconWrapperFromXml().setOnClickListener(new b(this, r5));
        c r7 = new c(this);
        getLeftEditTextFromXml().setOnClickListener(r7);
        setOnClickListener(r7);
    }

    public final void b(SearchBarModel r3, gv4.a r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "handler");
        getLeftEditTextFromXml().setHint(r3.getHint());
        this.e = new d(r4, r3);
    }
}
