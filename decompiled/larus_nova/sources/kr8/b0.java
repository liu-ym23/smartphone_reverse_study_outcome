package kr8;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/larus/bmhome/music/mob/UseTemplate;", "Lcom/larus/bmhome/music/mob/MobEvent;", "mobKey", "", "enterFrom", GXTemplateKey.GAIAX_TEMPLATE_ID, GXTemplateKey.GAIAX_TEMPLATE_TYPE, "botId", "chatType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMobKey", "()Ljava/lang/String;", "getEnterFrom", "getTemplateId", "getTemplateType", "getBotId", "getChatType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b0 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f505852a;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("chat_type")
    private final String chatType;

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    private final String templateId;

    @SerializedName("template_type")
    private final String templateType;

    public b0() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f505852a, r101.f505852a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templateId, r101.templateId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateType, r101.templateType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.chatType, r101.chatType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f505852a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.enterFrom;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.templateId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.templateType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.botId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.chatType;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "UseTemplate(mobKey=" + this.f505852a + ", enterFrom=" + this.enterFrom + ", templateId=" + this.templateId + ", templateType=" + this.templateType + ", botId=" + this.botId + ", chatType=" + this.chatType + ')';
    }

    @Override // kr8.l
    public final String a() {
        return this.f505852a;
    }

    @Override // kr8.l
    public final void b(by7.e r100, JSONObject r101) {
        l.a.a(this, r100, r101);
    }

    public b0(String r100, String r101, String r102, String r103, String r104, int r105) {
        if ((r105 & 1) == 0) goto L5;
        String r106 = "use_template";
    L7:
        if ((r105 & 2) == 0) goto L10;
        r100 = "";
    L10:
        if ((r105 & 4) == 0) goto L13;
        r101 = "";
    L13:
        if ((r105 & 8) == 0) goto L16;
        r102 = "music";
    L16:
        if ((r105 & 16) == 0) goto L19;
        r103 = "";
    L19:
        if ((r105 & 32) == 0) goto L21;
        r104 = "";
    L21:
        this.f505852a = r106;
        this.enterFrom = r100;
        this.templateId = r101;
        this.templateType = r102;
        this.botId = r103;
        this.chatType = r104;
        return;
    L5:
        r106 = null;
        goto L7
    }
}
