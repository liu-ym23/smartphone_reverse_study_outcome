package com.bytedance.ee.bear.document.edit_toolbar.link;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001)B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\nH\u0016J*\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0014J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020%H\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/document/edit_toolbar/link/LinkEditText;", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "disableUrlStyle", "", "getDisableUrlStyle", "()Z", "setDisableUrlStyle", "(Z)V", "callback", "Lcom/bytedance/ee/bear/document/edit_toolbar/link/LinkEditText$Callback;", "getCallback", "()Lcom/bytedance/ee/bear/document/edit_toolbar/link/LinkEditText$Callback;", "setCallback", "(Lcom/bytedance/ee/bear/document/edit_toolbar/link/LinkEditText$Callback;)V", "init", "", "onTextContextMenuItem", "id", "onTextChanged", "text", "", "start", "lengthBefore", "lengthAfter", "removeUrlStyle", "Landroid/text/SpannableStringBuilder;", "removeContentEndLineBreak", "isFilterMenuWhiteList", "isWordOver", "Callback", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkEditText extends SpaceEditText {
    public boolean V0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public a f219594b1;

    public interface a {
        boolean a(int r100);
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean y(boolean r100) {
        return true;
    }

    public final a getCallback() {
        return this.f219594b1;
    }

    public final boolean getDisableUrlStyle() {
        return this.V0;
    }

    public LinkEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void C(SpannableStringBuilder r100) {
        int r101 = r100.length();
        int r102 = r101 - 1;
    L4:
        if ((-1) >= r102) goto L9;
        if (r100.charAt(r102) != '\n') goto L9;
        r101 = r101 - 1;
        r102 = r102 - 1;
    L9:
        if (r101 == r100.length()) goto L14;
        SpannableStringBuilder r103 = r100.replace(r101, r100.length(), "");
        setText(r103);
        setSelection(r103.length());
        return;
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText, androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        a r101 = this.f219594b1;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L10;
        return true;
    L10:
        return super.onTextContextMenuItem(r100);
    L5:
        if (r101.a(r100) != true) goto L7;
        r102 = true;
        goto L7
    }

    public final void setCallback(a r100) {
        this.f219594b1 = r100;
    }

    public final void setDisableUrlStyle(boolean r100) {
        this.V0 = r100;
    }

    public LinkEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public LinkEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        tt5.a.b("LinkEditText", "init: ");
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if ((r100 instanceof SpannableStringBuilder) == false) goto L23;
        boolean r104 = false;
        if (r100.length() <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L23;
        if (this.V0 == false) goto L22;
        SpannableStringBuilder r106 = (SpannableStringBuilder) r100;
        URLSpan[] r107 = (URLSpan[]) r106.getSpans(0, r106.length(), URLSpan.class);
        Intrinsics.checkNotNull(r107);
        if (r107.length != 0) goto L15;
        r104 = true;
    L15:
        if ((!r104) == false) goto L26;
        Iterator r108 = ArrayIteratorKt.iterator(r107);
    L18:
        if (r108.hasNext() == false) goto L20;
        r106.removeSpan((URLSpan) r108.next());
        goto L18
    L20:
        C(r106);
        return;
    L26:
        return;
    L22:
        C((SpannableStringBuilder) r100);
        goto L23
    L7:
        r105 = false;
    L23:
        super.onTextChanged(r100, r101, r102, r103);
    }
}
