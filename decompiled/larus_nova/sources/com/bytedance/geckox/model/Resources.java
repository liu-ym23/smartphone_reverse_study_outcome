package com.bytedance.geckox.model;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J'\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\b\u0013R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/geckox/model/Resources;", "", "groups", "", "", "channels", "([Ljava/lang/String;[Ljava/lang/String;)V", "()V", "", "getChannels", "()Ljava/util/List;", "setChannels", "(Ljava/util/List;)V", "getGroups", "setGroups", "isHit", "", "group", "channel", "isHit$geckox_noasanRelease", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class Resources {
    private List<String> channels;
    private List<String> groups;

    public Resources() {
    }

    public final List<String> getChannels() {
        return this.channels;
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public final void setChannels(List<String> r100) {
        this.channels = r100;
    }

    public final void setGroups(List<String> r100) {
        this.groups = r100;
    }

    public Resources(String[] r100, String[] r101) {
        this();
        List<String> r102 = null;
        if (r100 == null) goto L5;
        List<String> r103 = ArraysKt.asList(r100);
    L6:
        this.groups = r103;
        if (r101 == null) goto L9;
        r102 = ArraysKt.asList(r101);
    L9:
        this.channels = r102;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final boolean isHit$geckox_noasanRelease(List<String> r100, String r101) {
        List<String> r102 = this.groups;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L19;
        List<String> r104 = this.channels;
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
    L18:
        return true;
    L13:
        if (r104.isEmpty() == true) goto L16;
        r105 = false;
    L19:
        if (r101 == null) goto L34;
        List<String> r106 = this.channels;
        if (r106 != null) goto L23;
    L26:
        boolean r107 = true;
    L27:
        if (r107 == true) goto L34;
        List<String> r108 = this.channels;
        if (r108 != null) goto L32;
        Intrinsics.throwNpe();
    L32:
        if (r108.contains(r101) == false) goto L34;
    L23:
        if (r106.isEmpty() == true) goto L26;
        r107 = false;
    L34:
        if (r100 == null) goto L66;
        List<String> r109 = this.groups;
        if (r109 != null) goto L38;
    L41:
        boolean r110 = true;
    L42:
        if (r110 == true) goto L67;
        List<String> r111 = this.groups;
        if (r111 != null) goto L46;
        Intrinsics.throwNpe();
    L46:
        Iterator<T> r112 = r111.iterator();
    L48:
        if (r112.hasNext() == false) goto L52;
        Object r113 = r112.next();
        if (r100.contains((String) r113) == false) goto L48;
    L53:
        CharSequence r114 = (CharSequence) r113;
        if (r114 != null) goto L56;
    L59:
        boolean r115 = true;
    L60:
        if (r115 == false) goto L18;
        return false;
    L56:
        if (r114.length() == 0) goto L59;
        r115 = false;
        goto L60
    L52:
        r113 = null;
        goto L53
    L67:
        return false;
    L38:
        if (r109.isEmpty() == true) goto L41;
        r110 = false;
        goto L42
    L66:
        return false;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
