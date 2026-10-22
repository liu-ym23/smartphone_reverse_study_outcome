package com.bytedance.ee.bear.wikiv2.searchv2.enh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.edittext.UDEditText;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 @2\u00020\u0001:\u0003@ABB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\b\u00102\u001a\u00020)H\u0002J\b\u00103\u001a\u00020)H\u0002J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020)H\u0002J\b\u00108\u001a\u00020)H\u0002J\u0006\u00109\u001a\u00020)J\u0006\u0010:\u001a\u00020\u001bJ\u0010\u0010;\u001a\u00020)2\b\b\u0001\u0010<\u001a\u00020=J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010>\u001a\u00020)H\u0014J\b\u0010?\u001a\u00020)H\u0002R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0018\u00010'R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "clearFromXml", "Landroid/widget/ImageView;", "getClearFromXml", "()Landroid/widget/ImageView;", "setClearFromXml", "(Landroid/widget/ImageView;)V", "cancelFromXml", "Landroid/widget/TextView;", "getCancelFromXml", "()Landroid/widget/TextView;", "setCancelFromXml", "(Landroid/widget/TextView;)V", "inputFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getInputFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setInputFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "isSearching", "", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "viewDelegate", "Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar$ViewDelegate;)V", "khProvider", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "khObserver", "Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar$KHObserver;", "init", "", "bindView", "bindListener", "doClearInput", "doClickCancel", "doClickInput", "observeInput", "setPrepareInput", "setEndInput", "showKeyBoard", "hideKeyBoard", "doSearch", "queryKey", "", "requestInputFocus", "clearInputFocus", "onPrepareInput", "onEndInput", "setInputHint", "resid", "", "onDetachedFromWindow", "onClear", "Companion", "ViewDelegate", "KHObserver", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSearchbar extends LinearLayout {
    public static final /* synthetic */ int i = 0;
    public ImageView a;
    public TextView b;
    public SpaceEditText c;
    public boolean d;
    public final CompositeDisposable e;
    public c f;
    public pcb.a g;
    public b h;

    public static final class a {
    }

    public final class b implements ocb.a {
        public final /* synthetic */ WikiSearchbar a;

        public b(WikiSearchbar r1) {
            this.a = r1;
        }

        public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "khp");
            if (r1.isKeyboardShowing() == false) goto L5;
            return;
        L5:
            if (this.a.getInputFromXml().isFocused() == false) goto L9;
            tt5.a.h("Wiki_WikiSearchbar", "KeyboardHeightObserver, keyboard dismiss, clearInputFocus.");
            WikiSearchbar r4 = this.a;
            r4.getInputFromXml().setFocusableInTouchMode(true);
            r4.getInputFromXml().clearFocus();
            return;
        }
    }

    public interface c {
        void a();

        void onExitSearch();
    }

    static {
    }

    public final void a() {
        tt5.a.h("Wiki_WikiSearchbar", "cancel click. ");
        this.d = false;
        rcb.c.d(this);
        getInputFromXml().setFocusableInTouchMode(true);
        getInputFromXml().clearFocus();
        getInputFromXml().setText("");
        getClearFromXml().setVisibility(8);
        getCancelFromXml().setVisibility(8);
        c r0 = this.f;
        if (r0 == null) goto L6;
        r0.onExitSearch();
        return;
    }

    public final TextView getCancelFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131365114);
        this.b = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final ImageView getClearFromXml() {
        KeyEvent.Callback r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131366927);
        this.a = (ImageView) r0;
    L6:
        return (ImageView) r0;
    }

    public final SpaceEditText getInputFromXml() {
        UDEditText r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131375324);
        this.c = (SpaceEditText) r0;
    L6:
        return (SpaceEditText) r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pcb.a r0 = this.g;
        if (r0 == null) goto L5;
        r0.a(this.h);
    L5:
        this.e.clear();
    }

    public final c getViewDelegate() {
        return this.f;
    }

    public final void setCancelFromXml(TextView r1) {
        this.b = r1;
    }

    public final void setClearFromXml(ImageView r1) {
        this.a = r1;
    }

    public final void setInputFromXml(SpaceEditText r1) {
        this.c = r1;
    }

    public final void setInputHint(int r2) {
        getInputFromXml().setHint(r2);
    }

    public final void setViewDelegate(c r1) {
        this.f = r1;
    }

    public WikiSearchbar(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.e = new CompositeDisposable();
        View.inflate(r1, 2131568251, this);
    }
}
