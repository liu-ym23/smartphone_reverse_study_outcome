package com.obric.assistant.live.util;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.obric.livecard.api.entity.Text;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sea.d;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/live/util/ObricUpdateBtnEvent;", "", "id", "", "disabled", "", "text", "Lcom/obric/livecard/api/entity/Text;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/obric/livecard/api/entity/Text;)V", "getId", "()Ljava/lang/String;", "getDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getText", "()Lcom/obric/livecard/api/entity/Text;", "btnId", "getBtnId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/obric/livecard/api/entity/Text;)Lcom/obric/assistant/live/util/ObricUpdateBtnEvent;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateBtnEvent {

    @SerializedName("btnId")
    private final String btnId;

    @SerializedName("disabled")
    private final Boolean disabled;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final transient String f390236id;

    @SerializedName("text")
    private final Text text;

    public ObricUpdateBtnEvent() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ObricUpdateBtnEvent copy$default(ObricUpdateBtnEvent r100, String r101, Boolean r102, Text r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f390236id;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.disabled;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.text;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.f390236id;
    }

    public final Boolean component2() {
        return this.disabled;
    }

    public final Text component3() {
        return this.text;
    }

    public final ObricUpdateBtnEvent copy(String r100, Boolean r101, Text r102) {
        return new ObricUpdateBtnEvent(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricUpdateBtnEvent) == true) goto L8;
        return false;
    L8:
        ObricUpdateBtnEvent r101 = (ObricUpdateBtnEvent) r100;
        if (Intrinsics.areEqual(this.f390236id, r101.f390236id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.disabled, r101.disabled) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.f390236id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.disabled;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Text r107 = this.text;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricUpdateBtnEvent(id=" + this.f390236id + ", disabled=" + this.disabled + ", text=" + this.text + ')';
    }

    public final String getBtnId() {
        return this.btnId;
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final String getId() {
        return this.f390236id;
    }

    public final Text getText() {
        return this.text;
    }

    public ObricUpdateBtnEvent(String r100, Boolean r101, Text r102) {
        this.f390236id = r100;
        this.disabled = r101;
        this.text = r102;
        if (r100 != null) goto L5;
        r100 = "actionBtn";
    L5:
        this.btnId = r100;
    }

    public /* synthetic */ ObricUpdateBtnEvent(String r110, Boolean r111, Text r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        Boolean r101 = Boolean.FALSE;
    L11:
        if ((r113 & 4) != 0) goto L13;
        Text r102 = r112;
    L22:
        this(r100, r101, r102);
        return;
    L13:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L15;
        String r103 = AppHost.f326268a.getApplication().getString(R.string.obric_phone_operation_pro_live_card_in_reply);
    L16:
        String r104 = r103;
        Intrinsics.checkNotNull(r104);
        if (r100 == null) goto L19;
        String r105 = "#E5FFFFFF";
    L20:
        r102 = new Text(r104, 14, r105, null, null, null, null, d.d(), 120, null);
        goto L22
    L19:
        r105 = "var:ai-gradient-a3";
        goto L20
    L15:
        r103 = AppHost.f326268a.getApplication().getString(R.string.obric_phone_operation_pro_live_card_reply);
        goto L16
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
