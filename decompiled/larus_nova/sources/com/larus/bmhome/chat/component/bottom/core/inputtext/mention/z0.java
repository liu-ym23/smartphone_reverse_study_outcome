package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBW\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003JY\u0010\u0016\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionRecommendSnapshot;", "", "contacts", "", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/ContactSnapshot;", "groups", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/ReferenceSnapshot;", "drives", "conversations", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getContacts", "()Ljava/util/List;", "getGroups", "getDrives", "getConversations", "toRemoteData", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelRemoteData;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f298997a = 0;

    @SerializedName("contacts")
    private final List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a> contacts;

    @SerializedName("conversations")
    private final List<e1> conversations;

    @SerializedName("drives")
    private final List<e1> drives;

    @SerializedName("groups")
    private final List<e1> groups;

    public static final class a {
    }

    static {
    }

    public z0() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.contacts, r101.contacts) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groups, r101.groups) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.drives, r101.drives) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conversations, r101.conversations) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a> r100 = this.contacts;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<e1> r104 = this.groups;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<e1> r107 = this.drives;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<e1> r110 = this.conversations;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MentionRecommendSnapshot(contacts=" + this.contacts + ", groups=" + this.groups + ", drives=" + this.drives + ", conversations=" + this.conversations + ')';
    }

    public final f0 a() {
        List<e1> r100 = this.drives;
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        c1 r103 = null;
        if (r102.hasNext() == false) goto L13;
        e1 r104 = (e1) r102.next();
        if (r104 == null) goto L11;
        r103 = r104.a(InputReferenceType.DRIVE);
    L11:
        if (r103 == null) goto L6;
        r101.add(r103);
        goto L6
    L13:
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a> r105 = this.contacts;
        if (r105 != null) goto L16;
        r105 = CollectionsKt.emptyList();
    L16:
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L18:
        if (r107.hasNext() == false) goto L25;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a r108 = (com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a) r107.next();
        if (r108 == null) goto L22;
        qp8.c r109 = r108.a();
    L23:
        if (r109 == null) goto L18;
        r106.add(r109);
        goto L18
    L22:
        r109 = null;
        goto L23
    L25:
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r111 = r106.iterator();
    L27:
        if (r111.hasNext() == false) goto L29;
        r110.add(new c((qp8.c) r111.next(), null));
        goto L27
    L29:
        List<e1> r112 = this.groups;
        if (r112 != null) goto L32;
        r112 = CollectionsKt.emptyList();
    L32:
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
    L34:
        if (r114.hasNext() == false) goto L41;
        e1 r115 = (e1) r114.next();
        if (r115 == null) goto L38;
        c1 r116 = r115.a(InputReferenceType.GROUP);
    L39:
        if (r116 == null) goto L34;
        r113.add(r116);
        goto L34
    L38:
        r116 = null;
        goto L39
    L41:
        List<e1> r117 = this.conversations;
        if (r117 != null) goto L44;
        r117 = CollectionsKt.emptyList();
    L44:
        ArrayList r118 = new ArrayList();
        Iterator<T> r119 = r117.iterator();
    L46:
        if (r119.hasNext() == false) goto L54;
        e1 r120 = (e1) r119.next();
        if (r120 == null) goto L50;
        c1 r121 = r120.a(InputReferenceType.CONVERSATION);
    L51:
        if (r121 == null) goto L46;
        r118.add(r121);
        goto L46
    L50:
        r121 = null;
        goto L51
    L54:
        return new f0(r101, r110, r113, r118, 16);
    }

    public z0(List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a> r100, List<e1> r101, List<e1> r102, List<e1> r103) {
        this.contacts = r100;
        this.groups = r101;
        this.drives = r102;
        this.conversations = r103;
    }
}
