package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.platform.model.SlashMentionConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f298691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f298692b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f298691a, r101.f298691a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f298692b, r101.f298692b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f298691a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f298692b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AttachmentProtocolSource(remoteUri=" + this.f298691a + ", type=" + this.f298692b + ')';
    }

    public final String a() {
        String r100 = this.f298691a;
        String r101 = null;
        if (r100 == null) goto L28;
        Integer r102 = this.f298692b;
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r102.intValue() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L30;
        int r104 = r102.intValue();
        String r105 = StringsKt.substringBefore$default(r100, '/', null, 2, null);
        if ((!StringsKt.isBlank(r105)) == true) goto L18;
        r105 = null;
    L18:
        if (r105 == null) goto L31;
        String r106 = StringsKt.substringAfter(r100, '/', "");
        if ((true ^ StringsKt.isBlank(r106)) == false) goto L23;
        r101 = r106;
    L23:
        Uri.Builder r107 = new Uri.Builder().scheme(SlashMentionConfig.MENTION_CONTENT_ATTACHMENT).encodedAuthority(r105);
        if (r101 == null) goto L27;
        r107.encodedPath(HTTP.URL_DEFAULT.concat(r101));
    L27:
        return r107.appendQueryParameter("type", String.valueOf(r104)).build().toString();
    L31:
        return null;
    L30:
        return null;
    L9:
        r103 = false;
        goto L10
    L28:
        return null;
    }

    public final Integer getType() {
        return this.f298692b;
    }

    public a(String r100, Integer r101) {
        this.f298691a = r100;
        this.f298692b = r101;
    }
}
