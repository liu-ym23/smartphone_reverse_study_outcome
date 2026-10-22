package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0014J\\\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\rHÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/ScrollMoreText;", "Ljava/io/Serializable;", "icon", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "schema", "", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "showEvent", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "entranceLocation", "findSameType", "", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getEntranceLocation", "()Ljava/lang/String;", "getFindSameType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getSchema", "getShowEvent", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/voavhs/head/ScrollMoreText;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollMoreText implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName("entrance_location")
    private final String entranceLocation;

    @SerializedName("find_same_type")
    private final Integer findSameType;

    @SerializedName("icon")
    private final ImageModel icon;

    @SerializedName("jump_schema")
    private final String schema;

    @SerializedName("show_event")
    private final List<ShowEvent> showEvent;

    public ScrollMoreText() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScrollMoreText copy$default(ScrollMoreText r4, ImageModel r5, String r6, Action r7, List r8, String r9, Integer r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.icon;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.schema;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.action;
    L11:
        Action r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.showEvent;
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.entranceLocation;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.findSameType;
    L20:
        ImageModel r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final ImageModel component1() {
        return this.icon;
    }

    public final String component2() {
        return this.schema;
    }

    public final Action component3() {
        return this.action;
    }

    public final List<ShowEvent> component4() {
        return this.showEvent;
    }

    public final String component5() {
        return this.entranceLocation;
    }

    public final Integer component6() {
        return this.findSameType;
    }

    public final ScrollMoreText copy(ImageModel r9, String r10, Action r11, List<ShowEvent> r12, String r13, Integer r14) {
        return new ScrollMoreText(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ScrollMoreText) == false) goto L18;
        ScrollMoreText r4 = (ScrollMoreText) r3;
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.action, r4.action) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showEvent, r4.showEvent) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.entranceLocation, r4.entranceLocation) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.findSameType, r4.findSameType) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        ImageModel r0 = this.icon;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.schema;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Action r7 = this.action;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<ShowEvent> r10 = this.showEvent;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.entranceLocation;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.findSameType;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ScrollMoreText(icon=" + this.icon + ", schema=" + this.schema + ", action=" + this.action + ", showEvent=" + this.showEvent + ", entranceLocation=" + this.entranceLocation + ", findSameType=" + this.findSameType + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final String getEntranceLocation() {
        return this.entranceLocation;
    }

    public final Integer getFindSameType() {
        return this.findSameType;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final List<ShowEvent> getShowEvent() {
        return this.showEvent;
    }

    public ScrollMoreText(ImageModel r1, String r2, Action r3, List<ShowEvent> r4, String r5, Integer r6) {
        this.icon = r1;
        this.schema = r2;
        this.action = r3;
        this.showEvent = r4;
        this.entranceLocation = r5;
        this.findSameType = r6;
    }

    public /* synthetic */ ScrollMoreText(ImageModel r6, String r7, Action r8, List r9, String r10, Integer r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        ImageModel r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        Action r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        List r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        Integer r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
