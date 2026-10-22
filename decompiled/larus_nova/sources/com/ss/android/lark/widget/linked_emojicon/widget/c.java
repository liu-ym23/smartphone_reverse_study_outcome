package com.ss.android.lark.widget.linked_emojicon.widget;

import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkEmojiTextView f446442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f446443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f446444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f446445d;

    public c(LinkEmojiTextView r100) {
        this.f446443b = new ArrayList();
        this.f446444c = false;
        this.f446442a = r100;
    }

    public final boolean a(String r100) {
        if (TextUtils.isEmpty(this.f446442a.getCurrentUserId()) == false) goto L5;
        return false;
    L5:
        if (this.f446442a.getCurrentUserId().equals(r100) == false) goto L7;
        return false;
    L7:
        if (CollectionUtils.isEmpty(this.f446445d) == false) goto L9;
        boolean r101 = false;
    L10:
        if (r101 == false) goto L12;
        return false;
    L12:
        if (r100.equals("all") == false) goto L14;
        return false;
    L14:
        if (this.f446444c == false) goto L21;
        return true;
    L21:
        return false;
    L9:
        r101 = this.f446445d.contains(r100);
        goto L10
    }
}
