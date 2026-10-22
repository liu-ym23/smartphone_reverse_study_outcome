package com.bytedance.ee.bear.wikiv2.searchv2.enh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 @2\u00020\u0001:\u0003@ABB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\b\u00102\u001a\u00020)H\u0002J\b\u00103\u001a\u00020)H\u0002J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020)H\u0002J\b\u00108\u001a\u00020)H\u0002J\u0006\u00109\u001a\u00020)J\u0006\u0010:\u001a\u00020\u001bJ\u0010\u0010;\u001a\u00020)2\b\b\u0001\u0010<\u001a\u00020=J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010>\u001a\u00020)H\u0014J\b\u0010?\u001a\u00020)H\u0002R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0018\u00010'R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "clearFromXml", "Landroid/widget/ImageView;", "getClearFromXml", "()Landroid/widget/ImageView;", "setClearFromXml", "(Landroid/widget/ImageView;)V", "cancelFromXml", "Landroid/widget/TextView;", "getCancelFromXml", "()Landroid/widget/TextView;", "setCancelFromXml", "(Landroid/widget/TextView;)V", "inputFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getInputFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setInputFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "isSearching", "", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "viewDelegate", "Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar$ViewDelegate;)V", "khProvider", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "khObserver", "Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar$KHObserver;", "init", "", "bindView", "bindListener", "doClearInput", "doClickCancel", "doClickInput", "observeInput", "setPrepareInput", "setEndInput", "showKeyBoard", "hideKeyBoard", "doSearch", "queryKey", "", "requestInputFocus", "clearInputFocus", "onPrepareInput", "onEndInput", "setInputHint", "resid", "", "onDetachedFromWindow", "onClear", "Companion", "ViewDelegate", "KHObserver", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSearchbar extends LinearLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f241065i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f241066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f241067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SpaceEditText f241068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f241069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f241070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f241071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public pcb.a f241072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f241073h;

    public static final class a {
    }

    public final class b implements ocb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiSearchbar f241074a;

        public b(WikiSearchbar r100) {
            this.f241074a = r100;
        }

        @Override // ocb.a
        public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "khp");
            if (r100.isKeyboardShowing() == false) goto L5;
            return;
        L5:
            if (this.f241074a.getInputFromXml().isFocused() == false) goto L9;
            tt5.a.h("Wiki_WikiSearchbar", "KeyboardHeightObserver, keyboard dismiss, clearInputFocus.");
            WikiSearchbar r103 = this.f241074a;
            r103.getInputFromXml().setFocusableInTouchMode(true);
            r103.getInputFromXml().clearFocus();
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
        this.f241069d = false;
        rcb.c.d(this);
        getInputFromXml().setFocusableInTouchMode(true);
        getInputFromXml().clearFocus();
        getInputFromXml().setText("");
        getClearFromXml().setVisibility(8);
        getCancelFromXml().setVisibility(8);
        c r100 = this.f241071f;
        if (r100 == null) goto L6;
        r100.onExitSearch();
        return;
    }

    public final TextView getCancelFromXml() {
        KeyEvent.Callback r100 = this.f241067b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.cancel);
        this.f241067b = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final ImageView getClearFromXml() {
        KeyEvent.Callback r100 = this.f241066a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.clear);
        this.f241066a = (ImageView) r100;
    L6:
        return (ImageView) r100;
    }

    public final SpaceEditText getInputFromXml() {
        KeyEvent.Callback r100 = this.f241068c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.input);
        this.f241068c = (SpaceEditText) r100;
    L6:
        return (SpaceEditText) r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pcb.a r100 = this.f241072g;
        if (r100 == null) goto L5;
        r100.a(this.f241073h);
    L5:
        this.f241070e.clear();
    }

    public final c getViewDelegate() {
        return this.f241071f;
    }

    public final void setCancelFromXml(TextView r100) {
        this.f241067b = r100;
    }

    public final void setClearFromXml(ImageView r100) {
        this.f241066a = r100;
    }

    public final void setInputFromXml(SpaceEditText r100) {
        this.f241068c = r100;
    }

    public final void setInputHint(int r100) {
        getInputFromXml().setHint(r100);
    }

    public final void setViewDelegate(c r100) {
        this.f241071f = r100;
    }

    public WikiSearchbar(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f241070e = new CompositeDisposable();
        View.inflate(r100, R.layout.wiki_searchv2_bar, this);
    }
}
