package com.suite.lark.platform.component.widget_biz_userstatus;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.span.AtInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public class UserStatusTextView extends LinkEmojiTextView {
    public final List<a> G1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public boolean f461155x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f461156y1;

    public interface a {
        void b();
    }

    public UserStatusTextView(Context r100) {
        super(r100);
        this.f461155x1 = false;
        this.G1 = new ArrayList();
        setShowTail(true);
        setNeedToRecognize(false);
        setShouldEllipsized(true);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        Iterator r101 = ((ArrayList) this.G1).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).b();
        goto L4
    }

    @Override // android.widget.TextView
    public void setMaxLines(int r100) {
        this.f461155x1 = false;
        super.setMaxLines(r100);
    }

    public void setShowArrow(boolean r100) {
        this.f461156y1 = r100;
    }

    public UserStatusTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f461155x1 = false;
        this.G1 = new ArrayList();
        setShowTail(true);
        setNeedToRecognize(false);
        setShouldEllipsized(true);
    }

    @Override // com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView
    public final void I(int r100, int r110) {
        if (this.f446402u == true) goto L5;
        return;
    L5:
        if (this.f446401t == true) goto L44;
        int r101 = getLineCount();
        Layout r102 = getLayout();
        int r103 = getMaxLines();
        if (r103 == 0) goto L33;
        if (r101 <= r103) goto L33;
        if (TextUtils.isEmpty(getText()) == true) goto L33;
        int r104 = r103 - 1;
        int r105 = r102.getLineEnd(r104);
        int r106 = r102.getLineStart(r104);
        if (r105 >= getText().length()) goto L16;
    L18:
        CharSequence r107 = getText().subSequence(0, r106);
        if ("\n".equals(String.valueOf(getText().charAt(getText().length() - 1))) == false) goto L21;
        CharSequence r108 = getText().subSequence(r106, getText().length() - 1);
    L22:
        CharSequence r109 = TextUtils.ellipsize(r108, getPaint(), getMeasuredWidth(), TextUtils.TruncateAt.END);
        SpannableStringBuilder r111 = new SpannableStringBuilder(r107);
        if (this.f461156y1 == true) goto L26;
        r111.append(r109);
    L30:
        setText(r111);
        this.f446401t = true;
        measure(r100, r110);
        return;
    L26:
        if (r109.length() <= 3) goto L28;
        r111.append(r109.subSequence(0, r109.length() - 3));
        r111.append(r109.charAt(r109.length() - 1));
    L29:
        r111.append(" ");
        U(R.drawable.contact_profile_description_more, r111);
        goto L30
    L28:
        r111.append(r109);
        goto L29
    L21:
        r108 = getText().subSequence(r106, getText().length());
        goto L22
    L16:
        if (this.f461156y1 == true) goto L18;
        return;
    L33:
        if (this.f461156y1 == true) goto L36;
        setText(new SpannableStringBuilder(getText()));
        this.f446401t = true;
        return;
    L36:
        if (r101 > 1) goto L39;
        return;
    L39:
        if (this.f461155x1 == true) goto L45;
        this.f461155x1 = true;
        Log.d("showTextEndWithCloseImage", this.f446401t + " -->" + getText());
        SpannableStringBuilder r112 = new SpannableStringBuilder(getText());
        r112.append(" ");
        U(R.drawable.contact_profile_description_close, r112);
        setText(r112);
        this.f446401t = true;
        return;
    L45:
        return;
    }

    public final void U(int r100, SpannableStringBuilder r101) {
        r101.append(" ");
        Drawable r102 = getResources().getDrawable(r100);
        r102.setBounds(0, 0, r102.getIntrinsicWidth(), r102.getIntrinsicHeight());
        ImageSpan r103 = new ImageSpan(r102, 1);
        int r104 = r101.length();
        r101.setSpan(r103, r104 - 1, r104, 33);
    }

    public UserStatusTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f461155x1 = false;
        this.G1 = new ArrayList();
        setShowTail(true);
        setNeedToRecognize(false);
        setShouldEllipsized(true);
    }

    @Override // com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView
    public final Map<String, Object> J(Context r100, String r101, AtInfo r102) {
        return new HashMap();
    }
}
