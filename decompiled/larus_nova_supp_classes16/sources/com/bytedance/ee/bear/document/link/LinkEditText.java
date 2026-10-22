package com.bytedance.ee.bear.document.link;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001)B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\nH\u0016J*\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0014J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020%H\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/document/link/LinkEditText;", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "disableUrlStyle", "", "getDisableUrlStyle", "()Z", "setDisableUrlStyle", "(Z)V", "callback", "Lcom/bytedance/ee/bear/document/link/LinkEditText$Callback;", "getCallback", "()Lcom/bytedance/ee/bear/document/link/LinkEditText$Callback;", "setCallback", "(Lcom/bytedance/ee/bear/document/link/LinkEditText$Callback;)V", "init", "", "onTextContextMenuItem", "id", "onTextChanged", "text", "", BatterySceneData.OPT_START, "lengthBefore", "lengthAfter", "removeUrlStyle", "Landroid/text/SpannableStringBuilder;", "removeContentEndLineBreak", "isFilterMenuWhiteList", "isWordOver", "Callback", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkEditText extends SpaceEditText {
    public boolean V0;
    public a b1;

    public interface a {
        boolean a(int r1);
    }

    public final boolean y(boolean r1) {
        return true;
    }

    public final a getCallback() {
        return this.b1;
    }

    public final boolean getDisableUrlStyle() {
        return this.V0;
    }

    public LinkEditText(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(SpannableStringBuilder r5) {
        int r0 = r5.length();
        int r1 = r0 - 1;
    L4:
        if ((-1) >= r1) goto L9;
        if (r5.charAt(r1) != '\n') goto L9;
        r0 = r0 - 1;
        r1 = r1 - 1;
    L9:
        if (r0 == r5.length()) goto L14;
        SpannableStringBuilder r6 = r5.replace(r0, r5.length(), "");
        setText(r6);
        setSelection(r6.length());
        return;
    }

    public final boolean onTextContextMenuItem(int r4) {
        a r0 = this.b1;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        return true;
    L10:
        return super.onTextContextMenuItem(r4);
    L5:
        if (r0.a(r4) != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void setCallback(a r1) {
        this.b1 = r1;
    }

    public final void setDisableUrlStyle(boolean r1) {
        this.V0 = r1;
    }

    public LinkEditText(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public LinkEditText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        tt5.a.b("LinkEditText", "init: ");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onTextChanged(CharSequence r4, int r5, int r6, int r7) {
        if ((r4 instanceof SpannableStringBuilder) == false) goto L23;
        boolean r1 = false;
        if (r4.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L23;
        if (this.V0 == false) goto L22;
        SpannableStringBuilder r8 = (SpannableStringBuilder) r4;
        URLSpan[] r9 = (URLSpan[]) r8.getSpans(0, r8.length(), URLSpan.class);
        Intrinsics.checkNotNull(r9);
        if (r9.length != 0) goto L15;
        r1 = true;
    L15:
        if ((!r1) == false) goto L26;
        Iterator r10 = ArrayIteratorKt.iterator(r9);
    L18:
        if (r10.hasNext() == false) goto L20;
        r8.removeSpan((URLSpan) r10.next());
        goto L18
    L20:
        C(r8);
        return;
    L26:
        return;
    L22:
        C((SpannableStringBuilder) r4);
        goto L23
    L7:
        r0 = false;
    L23:
        super/*android.widget.EditText*/.onTextChanged(r4, r5, r6, r7);
    }
}
