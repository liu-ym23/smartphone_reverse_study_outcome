package ny8;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.ImageObject;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BË\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bHÆ\u0003JÒ\u0001\u0010/\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bHÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00066"}, d2 = {"Lcom/larus/canvas/service/bean/SsePullCanvasBlockInfoRequest;", "", "canvasType", "", "generateType", "localId", "", "sendMsgId", "replyMsgId", "conversationId", "instructionTab", "", "Lcom/larus/canvas/service/bean/InstructionTab;", "originImage", "Lcom/larus/canvas/service/bean/ImageObject;", "seqStart", "", "canvasId", "canvasSubId", EventConstant.Key.RETAIN_PROMPT, "displayPromptPerRound", "refImages", "originBlocks", "Lcom/larus/canvas/service/bean/CanvasBlock;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/larus/canvas/service/bean/ImageObject;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "getOriginBlocks", "()Ljava/util/List;", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "()Ljava/lang/Long;", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/larus/canvas/service/bean/ImageObject;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/larus/canvas/service/bean/SsePullCanvasBlockInfoRequest;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient List<CanvasBlock> f521224a;

    @SerializedName("canvas_id")
    public final Long canvasId;

    @SerializedName("canvas_sub_id")
    public final Long canvasSubId;

    @SerializedName("canvas_type")
    public final Integer canvasType;

    @SerializedName("conversation_id")
    public final String conversationId;

    @SerializedName("display_prompt_per_round")
    public final String displayPromptPerRound;

    @SerializedName("generate_type")
    public final Integer generateType;

    @SerializedName("instruction_tab")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final List<InstructionTab> instructionTab;

    @SerializedName("local_id")
    public final String localId;

    @SerializedName("origin_image")
    public final ImageObject originImage;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    public final String prompt;

    @SerializedName("ref_images")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final List<ImageObject> refImages;

    @SerializedName("reply_msg_id")
    public final String replyMsgId;

    @SerializedName("send_msg_id")
    public final String sendMsgId;

    @SerializedName("seq_start")
    public final Long seqStart;

    public k() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.canvasType, r101.canvasType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.generateType, r101.generateType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localId, r101.localId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sendMsgId, r101.sendMsgId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.replyMsgId, r101.replyMsgId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.instructionTab, r101.instructionTab) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.originImage, r101.originImage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.seqStart, r101.seqStart) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.canvasId, r101.canvasId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.canvasSubId, r101.canvasSubId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.prompt, r101.prompt) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.displayPromptPerRound, r101.displayPromptPerRound) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.refImages, r101.refImages) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f521224a, r101.f521224a) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.canvasType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.generateType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.localId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.sendMsgId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.replyMsgId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.conversationId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<InstructionTab> r119 = this.instructionTab;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        ImageObject r122 = this.originImage;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.seqStart;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.canvasId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Long r131 = this.canvasSubId;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.prompt;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.displayPromptPerRound;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        List<ImageObject> r140 = this.refImages;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return ((r139 + r101) * 31) + this.f521224a.hashCode();
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "SsePullCanvasBlockInfoRequest(canvasType=" + this.canvasType + ", generateType=" + this.generateType + ", localId=" + this.localId + ", sendMsgId=" + this.sendMsgId + ", replyMsgId=" + this.replyMsgId + ", conversationId=" + this.conversationId + ", instructionTab=" + this.instructionTab + ", originImage=" + this.originImage + ", seqStart=" + this.seqStart + ", canvasId=" + this.canvasId + ", canvasSubId=" + this.canvasSubId + ", prompt=" + this.prompt + ", displayPromptPerRound=" + this.displayPromptPerRound + ", refImages=" + this.refImages + ", originBlocks=" + this.f521224a + ')';
    }

    public k(Integer r110, Integer r111, String r210, String r211, String r212, String r213, List r214, ImageObject r215, Long r216, Long r217, Long r218, String r219, String r310, List r311, int r312) {
        if ((r312 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r312 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r312 & 64) == 0) goto L29;
        List r106 = null;
    L31:
        if ((r312 & 128) == 0) goto L33;
        ImageObject r112 = null;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Long r113 = null;
    L39:
        if ((r312 & 512) == 0) goto L41;
        Long r114 = null;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        Long r115 = null;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        String r116 = null;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        String r117 = null;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        List r107 = null;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        List<CanvasBlock> r108 = CollectionsKt.emptyList();
    L62:
        Intrinsics.checkNotNullParameter(r108, "originBlocks");
        this.canvasType = r100;
        this.generateType = r101;
        this.localId = r102;
        this.sendMsgId = r103;
        this.replyMsgId = r104;
        this.conversationId = r105;
        this.instructionTab = r106;
        this.originImage = r112;
        this.seqStart = r113;
        this.canvasId = r114;
        this.canvasSubId = r115;
        this.prompt = r116;
        this.displayPromptPerRound = r117;
        this.refImages = r107;
        this.f521224a = r108;
        return;
    L61:
        r108 = null;
        goto L62
    L57:
        r107 = r311;
        goto L59
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r112 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
