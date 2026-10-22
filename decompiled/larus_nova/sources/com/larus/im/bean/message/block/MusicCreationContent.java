package com.larus.im.bean.message.block;

import androidx.camera.video.AudioStats;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.im.bean.message.Image;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.Transient;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import ouc.d0;
import ouc.k;
import zc9.h0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u008b\u00012\u00020\u0001:\u0004\u008b\u0001\u008c\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0002\u0010\u000bBa\b\u0016\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0015BÍ\u0001\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\b\u0010 \u001a\u0004\u0018\u00010\n\u0012\b\u0010!\u001a\u0004\u0018\u00010\b\u0012\b\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0004\b\u0002\u0010$J3\u0010z\u001a\u00020{2+\b\u0002\u0010|\u001a%\u0012\u001a\u0012\u00180~j\u0003`\u0082\u0001¢\u0006\u000e\b\u007f\u0012\n\b\u0080\u0001\u0012\u0005\b\b(\u0081\u0001\u0012\u0005\u0012\u00030\u0083\u00010}J\t\u0010\u0084\u0001\u001a\u00020\nH\u0016J'\u0010\u0085\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u00002\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0007R&\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R&\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u0003\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R&\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0003\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R&\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0003\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R&\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u0003\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R&\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u0003\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R&\u0010\r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u0003\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R(\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010A\u0012\u0004\b<\u0010\u0003\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010C\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR&\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bH\u0010\u0003\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR(\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010A\u0012\u0004\bM\u0010\u0003\u001a\u0004\bN\u0010>\"\u0004\bO\u0010@R$\u0010P\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010E\"\u0004\bR\u0010GR&\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bS\u0010\u0003\u001a\u0004\bT\u0010'\"\u0004\bU\u0010)R(\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010A\u0012\u0004\bV\u0010\u0003\u001a\u0004\bW\u0010>\"\u0004\bX\u0010@R$\u0010\u0007\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010E\"\u0004\bZ\u0010GR&\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b[\u0010\u0003\u001a\u0004\b\\\u0010'\"\u0004\b]\u0010)R&\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b^\u0010\u0003\u001a\u0004\b_\u0010'\"\u0004\b`\u0010)R$\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\ba\u0010\u0003\u001a\u0004\bb\u0010c\"\u0004\bd\u0010\u0006R&\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\be\u0010\u0003\u001a\u0004\bf\u0010'\"\u0004\bg\u0010)R&\u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bh\u0010\u0003\u001a\u0004\bi\u0010'\"\u0004\bj\u0010)R(\u0010!\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010A\u0012\u0004\bk\u0010\u0003\u001a\u0004\bl\u0010>\"\u0004\bm\u0010@R$\u0010n\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010E\"\u0004\bo\u0010GR$\u0010p\u001a\u00020q8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\br\u0010\u0003\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bw\u0010\u0003\u001a\u0004\bx\u0010c\"\u0004\by\u0010\u0006¨\u0006\u008d\u0001\u0080å\b\u001b\u0080å\b\u0011\u0080å\b\u0014\u0080å\b \u0080å\b\f\u0080å\b!\u0080å\b\u0019\u0080å\b\u0017\u0080å\b\u001d\u0080å\b\u001f\u0080å\b\r\u0080å\b\u001a\u0080å\b\u0018\u0080å\b\u0012\u0080å\b\u000f\u0080å\b\u0013\u0080å\b\u001e\u0080å\b\u001c"}, d2 = {"Lcom/larus/im/bean/message/block/MusicCreationContent;", "", "<init>", "()V", "contentType", "", "(I)V", "musicGenFailed", "", "musicGenFailedMessage", "", "(ZLjava/lang/String;)V", "videoModel", "title", KtvSubElement.LYRIC, "cover", "Lcom/larus/im/bean/message/Image;", "shareInfo", "coverMainColor", "vid", "lyricsSeekContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "seen0", "creator", "lyrics", "titleEditedValue", "coverEditedValue", "musicGenFailedValue", "musicGenFailedMsg", "chunkUrl", "musicGenType", "useTemplateId", "uniqueTaskId", "isBlockValue", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/message/Image;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVid$annotations", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "getVideoModel$annotations", "getVideoModel", "setVideoModel", "getShareInfo$annotations", "getShareInfo", "setShareInfo", "getCreator$annotations", "getCreator", "setCreator", "getLyrics$annotations", "getLyrics", "setLyrics", "getLyricsSeekContent$annotations", "getLyricsSeekContent", "setLyricsSeekContent", "getTitle$annotations", "getTitle", d.f25925o, "getTitleEditedValue$imsdkkmp_api_release$annotations", "getTitleEditedValue$imsdkkmp_api_release", "()Ljava/lang/Boolean;", "setTitleEditedValue$imsdkkmp_api_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "value", "titleEdited", "getTitleEdited", "()Z", "setTitleEdited", "(Z)V", "getCover$annotations", "getCover", "()Lcom/larus/im/bean/message/Image;", "setCover", "(Lcom/larus/im/bean/message/Image;)V", "getCoverEditedValue$imsdkkmp_api_release$annotations", "getCoverEditedValue$imsdkkmp_api_release", "setCoverEditedValue$imsdkkmp_api_release", "coverEdited", "getCoverEdited", "setCoverEdited", "getCoverMainColor$annotations", "getCoverMainColor", "setCoverMainColor", "getMusicGenFailedValue$imsdkkmp_api_release$annotations", "getMusicGenFailedValue$imsdkkmp_api_release", "setMusicGenFailedValue$imsdkkmp_api_release", "getMusicGenFailed", "setMusicGenFailed", "getMusicGenFailedMsg$annotations", "getMusicGenFailedMsg", "setMusicGenFailedMsg", "getChunkUrl$annotations", "getChunkUrl", "setChunkUrl", "getMusicGenType$annotations", "getMusicGenType", "()I", "setMusicGenType", "getUseTemplateId$annotations", "getUseTemplateId", "setUseTemplateId", "getUniqueTaskId$annotations", "getUniqueTaskId", "setUniqueTaskId", "isBlockValue$imsdkkmp_api_release$annotations", "isBlockValue$imsdkkmp_api_release", "setBlockValue$imsdkkmp_api_release", "isBlock", "setBlock", "playList", "Lcom/larus/im/bean/message/block/player/ICreationPlayList;", "getPlayList$annotations", "getPlayList", "()Lcom/larus/im/bean/message/block/player/ICreationPlayList;", "setPlayList", "(Lcom/larus/im/bean/message/block/player/ICreationPlayList;)V", "getContentType$annotations", "getContentType", "setContentType", "getDurationSec", "", LynxVideoManagerLite.EVENT_ON_ERROR, "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/ParameterName;", "name", "e", "Lkotlin/Exception;", "", "toString", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public class MusicCreationContent {
    public static final b Companion = null;
    public static final int MUSIC_GEN_TYPE_USER = 2;
    public static final String TAG = "MusicCreationContent";
    private String chunkUrl;
    private transient int contentType;
    private Image cover;
    private Boolean coverEditedValue;
    private String coverMainColor;
    private String creator;
    private Boolean isBlockValue;
    private String lyrics;
    private String lyricsSeekContent;
    private String musicGenFailedMsg;
    private Boolean musicGenFailedValue;
    private int musicGenType;
    private transient ad9.b playList;
    private String shareInfo;
    private String title;
    private Boolean titleEditedValue;
    private String uniqueTaskId;
    private String useTemplateId;
    private String vid;
    private String videoModel;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<MusicCreationContent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346950a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346951b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346951b;
        }

        static {
            a r100 = new a();
            f346950a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.MusicCreationContent", r100, 18);
            r101.j("vid", true);
            r101.j("video_model", true);
            r101.j("share_info", true);
            r101.j("creator", true);
            r101.j(KtvSubElement.LYRIC, true);
            r101.j("captions_result", true);
            r101.j("title", true);
            r101.j("title_edited", true);
            r101.j("cover", true);
            r101.j("cover_edited", true);
            r101.j("cover_main_color", true);
            r101.j("music_gen_failed", true);
            r101.j("music_gen_failed_msg", true);
            r101.j("chunk_uri", true);
            r101.j("music_gen_type", true);
            r101.j("use_template_id", true);
            r101.j("unique_task_id", true);
            r101.j("is_block", true);
            f346951b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            i r101 = i.f520705a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(Image.a.f346642a), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), w0.f520792a, kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f346951b;
            c r101 = r310.beginStructure(r100);
            Boolean r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 4, r103, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 5, r103, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 6, r103, null);
            i r107 = i.f520705a;
            Boolean r114 = (Boolean) r101.decodeNullableSerializableElement(r100, 7, r107, null);
            Image r108 = (Image) r101.decodeNullableSerializableElement(r100, 8, Image.a.f346642a, null);
            Boolean r109 = (Boolean) r101.decodeNullableSerializableElement(r100, 9, r107, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 10, r103, null);
            Boolean r116 = (Boolean) r101.decodeNullableSerializableElement(r100, 11, r107, null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 12, r103, null);
            String r118 = (String) r101.decodeNullableSerializableElement(r100, 13, r103, null);
            int r119 = r101.decodeIntElement(r100, 14);
            String r120 = (String) r101.decodeNullableSerializableElement(r100, 15, r103, null);
            String r121 = (String) r101.decodeNullableSerializableElement(r100, 16, r103, null);
            Boolean r122 = (Boolean) r101.decodeNullableSerializableElement(r100, 17, r107, null);
            String r123 = r110;
            String r124 = r113;
            Boolean r125 = r116;
            String r126 = r106;
            String r210 = r121;
            Boolean r211 = r122;
            Image r127 = r108;
            int r128 = 262143;
            String r129 = r105;
            String r130 = r104;
            Boolean r131 = r109;
            String r132 = r111;
            String r133 = r112;
            Boolean r134 = r114;
            String r212 = r120;
            String r135 = r117;
            int r136 = r119;
            String r137 = r118;
        L45:
            r101.endStructure(r100);
            return new MusicCreationContent(r128, r130, r129, r126, r123, r132, r133, r124, r134, r127, r131, r115, r125, r135, r137, r136, r212, r210, r211, null);
        L5:
            String r138 = null;
            String r139 = null;
            String r140 = null;
            String r141 = null;
            String r142 = null;
            Boolean r143 = null;
            r124 = null;
            Boolean r144 = null;
            Boolean r145 = null;
            String r146 = null;
            r115 = null;
            String r213 = null;
            String r214 = null;
            String r215 = null;
            String r216 = null;
            Image r311 = null;
            r128 = 0;
            int r312 = 0;
            boolean r313 = true;
        L6:
            if (r313 == false) goto L44;
            int r147 = r101.decodeElementIndex(r100);
            switch(r147) {
                case -1: goto L43;
                case 0: goto L41;
                case 1: goto L38;
                case 2: goto L35;
                case 3: goto L33;
                case 4: goto L32;
                case 5: goto L30;
                case 6: goto L29;
                case 7: goto L26;
                case 8: goto L25;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L20;
                case 12: goto L19;
                case 13: goto L18;
                case 14: goto L17;
                case 15: goto L14;
                case 16: goto L12;
                case 17: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r147);
        L43:
            r102 = r102;
            r139 = r139;
            r313 = false;
            r213 = r213;
            r214 = r214;
            r138 = r138;
            goto L6
        L11:
            int r148 = 131072;
            r102 = (Boolean) r101.decodeNullableSerializableElement(r100, 17, i.f520705a, r102);
        L15:
            int r149 = r148 | r128;
        L21:
            String r217 = r138;
            r216 = r216;
            Image r150 = r311;
            int r151 = r312;
            String r152 = r139;
        L40:
            r312 = r151;
            r102 = r102;
            String r218 = r214;
            r138 = r217;
            Image r153 = r150;
            String r219 = r152;
            r128 = r149;
            String r154 = r215;
        L42:
            r215 = r154;
            r311 = r153;
            r139 = r219;
            r216 = r216;
            r214 = r218;
            goto L6
        L12:
            r139 = r139;
            r102 = r102;
            int r155 = 65536 | r128;
            r216 = (String) r101.decodeNullableSerializableElement(r100, 16, v2.f520790a, r216);
        L13:
            Image r156 = r311;
        L27:
            int r157 = r155;
            Image r158 = r156;
            r151 = r312;
        L28:
            r217 = r138;
            r152 = r139;
            int r314 = r157;
            r150 = r158;
            r149 = r314;
            goto L40
        L14:
            r102 = r102;
            r146 = (String) r101.decodeNullableSerializableElement(r100, 15, v2.f520790a, r146);
            r148 = 32768;
            goto L15
        L17:
            r139 = r139;
            r102 = r102;
            r157 = r128 | 16384;
            r216 = r216;
            r151 = r101.decodeIntElement(r100, 14);
            r158 = r311;
            goto L28
        L18:
            r139 = r139;
            r102 = r102;
            r216 = r216;
            r141 = (String) r101.decodeNullableSerializableElement(r100, 13, v2.f520790a, r141);
            r149 = r128 | 8192;
            goto L21
        L19:
            r139 = r139;
            r102 = r102;
            r216 = r216;
            r142 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r142);
            r149 = r128 | 4096;
            goto L21
        L20:
            r139 = r139;
            r102 = r102;
            r216 = r216;
            r144 = (Boolean) r101.decodeNullableSerializableElement(r100, 11, i.f520705a, r144);
            r149 = r128 | 2048;
            goto L21
        L22:
            r115 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r115);
            r155 = r128 | 1024;
        L24:
            r216 = r216;
            goto L13
        L23:
            r145 = (Boolean) r101.decodeNullableSerializableElement(r100, 9, i.f520705a, r145);
            r155 = r128 | 512;
            goto L24
        L25:
            r139 = r139;
            r102 = r102;
            r216 = r216;
            r311 = (Image) r101.decodeNullableSerializableElement(r100, 8, Image.a.f346642a, r311);
            r155 = r128 | 256;
            goto L13
        L26:
            r139 = r139;
            r102 = r102;
            r216 = r216;
            r156 = r311;
            r143 = (Boolean) r101.decodeNullableSerializableElement(r100, 7, i.f520705a, r143);
            r155 = r128 | 128;
            goto L27
        L29:
            r124 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r124);
            r149 = r128 | 64;
        L31:
            String r159 = r214;
            String r220 = r139;
        L37:
            r217 = r138;
            r152 = r220;
            r214 = r159;
        L39:
            r150 = r311;
            r151 = r312;
            goto L40
        L30:
            r138 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r138);
            r149 = r128 | 32;
            goto L31
        L32:
            r140 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r140);
            r149 = r128 | 16;
            String r160 = r139;
        L34:
            String r161 = r214;
            r220 = r160;
        L36:
            r159 = r161;
            r138 = r138;
            goto L37
        L33:
            r160 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r139);
            r149 = r128 | 8;
            goto L34
        L35:
            r138 = r138;
            r102 = r102;
            r216 = r216;
            r311 = r311;
            String r162 = r214;
            r220 = r139;
            r161 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r162);
            r149 = r128 | 4;
            goto L36
        L38:
            r217 = r138;
            r102 = r102;
            String r163 = r214;
            r216 = r216;
            r311 = r311;
            r215 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r215);
            r149 = r128 | 2;
            r152 = r139;
            r214 = r163;
            goto L39
        L41:
            r218 = r214;
            r216 = r216;
            r219 = r139;
            r128 = r128 | 1;
            r138 = r138;
            r213 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r213);
            r154 = r215;
            r153 = r311;
            r102 = r102;
            goto L42
        L44:
            String r221 = r138;
            String r222 = r214;
            String r223 = r139;
            r130 = r213;
            r137 = r141;
            r135 = r142;
            r212 = r146;
            r211 = r102;
            r123 = r223;
            r210 = r216;
            r136 = r312;
            r132 = r140;
            r125 = r144;
            r131 = r145;
            r129 = r215;
            r127 = r311;
            r134 = r143;
            r126 = r222;
            r133 = r221;
            goto L45
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            MusicCreationContent r102 = (MusicCreationContent) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346951b;
            muc.d r104 = r100.beginStructure(r103);
            MusicCreationContent.write$Self(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<MusicCreationContent> serializer() {
            return a.f346950a;
        }

        public static MusicCreationContent a(String r100, Function1 r101) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
            wt7.c r102 = wt7.a.f561230a;     // Catch: IllegalArgumentException -> L5 SerializationException -> L7
            juc.d<MusicCreationContent> r103 = MusicCreationContent.Companion.serializer();     // Catch: IllegalArgumentException -> L5 SerializationException -> L7
            r102.getClass();     // Catch: IllegalArgumentException -> L5 SerializationException -> L7
        L13:
            return (MusicCreationContent) wt7.c.a(r100, r103);
        L7:
            e = move-exception;
            r101.invoke(e);
        L9:
            return null;
        L5:
            e = move-exception;
            r101.invoke(e);
            goto L9
        }
    }

    public static /* synthetic */ Unit a(Exception r100) {
        return getDurationSec$lambda$0(r100);
    }

    @SerialName("chunk_uri")
    public static /* synthetic */ void getChunkUrl$annotations() {
    }

    @Transient
    public static /* synthetic */ void getContentType$annotations() {
    }

    @SerialName("cover")
    public static /* synthetic */ void getCover$annotations() {
    }

    @SerialName("cover_edited")
    public static /* synthetic */ void getCoverEditedValue$imsdkkmp_api_release$annotations() {
    }

    @SerialName("cover_main_color")
    public static /* synthetic */ void getCoverMainColor$annotations() {
    }

    @SerialName("creator")
    public static /* synthetic */ void getCreator$annotations() {
    }

    @SerialName(KtvSubElement.LYRIC)
    public static /* synthetic */ void getLyrics$annotations() {
    }

    @SerialName("captions_result")
    public static /* synthetic */ void getLyricsSeekContent$annotations() {
    }

    @SerialName("music_gen_failed_msg")
    public static /* synthetic */ void getMusicGenFailedMsg$annotations() {
    }

    @SerialName("music_gen_failed")
    public static /* synthetic */ void getMusicGenFailedValue$imsdkkmp_api_release$annotations() {
    }

    @SerialName("music_gen_type")
    public static /* synthetic */ void getMusicGenType$annotations() {
    }

    @Transient
    public static /* synthetic */ void getPlayList$annotations() {
    }

    @SerialName("share_info")
    public static /* synthetic */ void getShareInfo$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName("title_edited")
    public static /* synthetic */ void getTitleEditedValue$imsdkkmp_api_release$annotations() {
    }

    @SerialName("unique_task_id")
    public static /* synthetic */ void getUniqueTaskId$annotations() {
    }

    @SerialName("use_template_id")
    public static /* synthetic */ void getUseTemplateId$annotations() {
    }

    @SerialName("vid")
    public static /* synthetic */ void getVid$annotations() {
    }

    @SerialName("video_model")
    public static /* synthetic */ void getVideoModel$annotations() {
    }

    @SerialName("is_block")
    public static /* synthetic */ void isBlockValue$imsdkkmp_api_release$annotations() {
    }

    static {
        Companion = new b();
    }

    public MusicCreationContent() {
        this.vid = "";
        this.videoModel = "";
        this.shareInfo = "";
        this.creator = "";
        this.lyrics = "";
        this.lyricsSeekContent = "";
        this.title = "";
        Boolean r100 = Boolean.FALSE;
        this.titleEditedValue = r100;
        Boolean r110 = null;
        this.cover = new Image(null, null, null, null, null, null, null, null, null, null, null, r110, r110, null, 16383, null);
        this.coverEditedValue = r100;
        this.coverMainColor = "";
        this.musicGenFailedValue = r100;
        this.musicGenFailedMsg = "";
        this.chunkUrl = "";
        this.useTemplateId = "";
        this.uniqueTaskId = "";
        this.isBlockValue = r100;
        this.playList = new ad9.a();
    }

    public final boolean getCoverEdited() {
        Boolean r100 = this.coverEditedValue;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final boolean getMusicGenFailed() {
        Boolean r100 = this.musicGenFailedValue;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final boolean getTitleEdited() {
        Boolean r100 = this.titleEditedValue;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final boolean isBlock() {
        Boolean r100 = this.isBlockValue;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("vid=");
        r100.append(this.vid);
        r100.append(", musicGenFailed=");
        r100.append(getMusicGenFailed());
        r100.append(", musicGenFailedMsg=");
        r100.append(this.musicGenFailedMsg);
        r100.append(", chunkUrl=");
        String r101 = this.chunkUrl;
        if (r101 != null) goto L5;
        Boolean r102 = null;
    L10:
        r100.append(r102);
        r100.append(", playList itemId=");
        r100.append(this.playList.getItemId());
        return r100.toString();
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        r102 = Boolean.valueOf(r103);
        goto L10
    L7:
        r103 = false;
        goto L8
    }

    public final String getChunkUrl() {
        return this.chunkUrl;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final Image getCover() {
        return this.cover;
    }

    public final Boolean getCoverEditedValue$imsdkkmp_api_release() {
        return this.coverEditedValue;
    }

    public final String getCoverMainColor() {
        return this.coverMainColor;
    }

    public final String getCreator() {
        return this.creator;
    }

    public final String getLyrics() {
        return this.lyrics;
    }

    public final String getLyricsSeekContent() {
        return this.lyricsSeekContent;
    }

    public final String getMusicGenFailedMsg() {
        return this.musicGenFailedMsg;
    }

    public final Boolean getMusicGenFailedValue$imsdkkmp_api_release() {
        return this.musicGenFailedValue;
    }

    public final int getMusicGenType() {
        return this.musicGenType;
    }

    public final ad9.b getPlayList() {
        return this.playList;
    }

    public final String getShareInfo() {
        return this.shareInfo;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean getTitleEditedValue$imsdkkmp_api_release() {
        return this.titleEditedValue;
    }

    public final String getUniqueTaskId() {
        return this.uniqueTaskId;
    }

    public final String getUseTemplateId() {
        return this.useTemplateId;
    }

    public final String getVid() {
        return this.vid;
    }

    public final String getVideoModel() {
        return this.videoModel;
    }

    public final Boolean isBlockValue$imsdkkmp_api_release() {
        return this.isBlockValue;
    }

    public MusicCreationContent(int r210) {
        this.vid = "";
        this.videoModel = "";
        this.shareInfo = "";
        this.creator = "";
        this.lyrics = "";
        this.lyricsSeekContent = "";
        this.title = "";
        Boolean r100 = Boolean.FALSE;
        this.titleEditedValue = r100;
        Boolean r110 = null;
        this.cover = new Image(null, null, null, null, null, null, null, null, null, null, null, r110, r110, null, 16383, null);
        this.coverEditedValue = r100;
        this.coverMainColor = "";
        this.musicGenFailedValue = r100;
        this.musicGenFailedMsg = "";
        this.chunkUrl = "";
        this.useTemplateId = "";
        this.uniqueTaskId = "";
        this.isBlockValue = r100;
        this.playList = new ad9.a();
        this.contentType = r210;
    }

    private static final Unit getDurationSec$lambda$0(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Unit.INSTANCE;
    }

    public final double getDurationSec(Function1<? super Exception, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, LynxVideoManagerLite.EVENT_ON_ERROR);
        wt7.c r101 = wt7.a.f561230a;     // Catch: IllegalArgumentException -> L14
        String r102 = this.videoModel;     // Catch: IllegalArgumentException -> L14
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        juc.d<d0> r103 = d0.Companion.serializer();     // Catch: IllegalArgumentException -> L14
        r101.getClass();     // Catch: IllegalArgumentException -> L14
        d0 r104 = (d0) wt7.c.a(r102, r103);     // Catch: IllegalArgumentException -> L14
        if (r104 == null) goto L19;
        ouc.i r105 = (ouc.i) r104.get("video_duration");     // Catch: IllegalArgumentException -> L14
        if (r105 == null) goto L20;
        Double r106 = k.i(k.o(r105));     // Catch: IllegalArgumentException -> L14
        if (r106 == null) goto L21;
        return r106.doubleValue();
    L21:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L20:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L19:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L14:
        e = move-exception;
        r100.invoke(e);
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final void setBlock(boolean r100) {
        this.isBlockValue = Boolean.valueOf(r100);
    }

    public final void setBlockValue$imsdkkmp_api_release(Boolean r100) {
        this.isBlockValue = r100;
    }

    public final void setChunkUrl(String r100) {
        this.chunkUrl = r100;
    }

    public final void setContentType(int r100) {
        this.contentType = r100;
    }

    public final void setCover(Image r100) {
        this.cover = r100;
    }

    public final void setCoverEdited(boolean r100) {
        this.coverEditedValue = Boolean.valueOf(r100);
    }

    public final void setCoverEditedValue$imsdkkmp_api_release(Boolean r100) {
        this.coverEditedValue = r100;
    }

    public final void setCoverMainColor(String r100) {
        this.coverMainColor = r100;
    }

    public final void setCreator(String r100) {
        this.creator = r100;
    }

    public final void setLyrics(String r100) {
        this.lyrics = r100;
    }

    public final void setLyricsSeekContent(String r100) {
        this.lyricsSeekContent = r100;
    }

    public final void setMusicGenFailed(boolean r100) {
        this.musicGenFailedValue = Boolean.valueOf(r100);
    }

    public final void setMusicGenFailedMsg(String r100) {
        this.musicGenFailedMsg = r100;
    }

    public final void setMusicGenFailedValue$imsdkkmp_api_release(Boolean r100) {
        this.musicGenFailedValue = r100;
    }

    public final void setMusicGenType(int r100) {
        this.musicGenType = r100;
    }

    public final void setPlayList(ad9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.playList = r100;
    }

    public final void setShareInfo(String r100) {
        this.shareInfo = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setTitleEdited(boolean r100) {
        this.titleEditedValue = Boolean.valueOf(r100);
    }

    public final void setTitleEditedValue$imsdkkmp_api_release(Boolean r100) {
        this.titleEditedValue = r100;
    }

    public final void setUniqueTaskId(String r100) {
        this.uniqueTaskId = r100;
    }

    public final void setUseTemplateId(String r100) {
        this.useTemplateId = r100;
    }

    public final void setVid(String r100) {
        this.vid = r100;
    }

    public final void setVideoModel(String r100) {
        this.videoModel = r100;
    }

    public MusicCreationContent(boolean r210, String r211) {
        Intrinsics.checkNotNullParameter(r211, "musicGenFailedMessage");
        this.vid = "";
        this.videoModel = "";
        this.shareInfo = "";
        this.creator = "";
        this.lyrics = "";
        this.lyricsSeekContent = "";
        this.title = "";
        Boolean r100 = Boolean.FALSE;
        this.titleEditedValue = r100;
        Boolean r110 = null;
        this.cover = new Image(null, null, null, null, null, null, null, null, null, null, r110, r110, null, null, 16383, null);
        this.coverEditedValue = r100;
        this.coverMainColor = "";
        this.musicGenFailedValue = r100;
        this.musicGenFailedMsg = "";
        this.chunkUrl = "";
        this.useTemplateId = "";
        this.uniqueTaskId = "";
        this.isBlockValue = r100;
        this.playList = new ad9.a();
        setMusicGenFailed(r210);
        this.musicGenFailedMsg = r211;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final /* synthetic */ void write$Self(MusicCreationContent r210, muc.d r211, f r212) {
        boolean r100 = true;
        if (r211.shouldEncodeElementDefault(r212, 0) == false) goto L6;
    L4:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        r211.encodeNullableSerializableElement(r212, 0, v2.f520790a, r210.vid);
    L12:
        if (r211.shouldEncodeElementDefault(r212, 1) == false) goto L15;
    L13:
        boolean r102 = true;
    L18:
        if (r102 == false) goto L21;
        r211.encodeNullableSerializableElement(r212, 1, v2.f520790a, r210.videoModel);
    L21:
        if (r211.shouldEncodeElementDefault(r212, 2) == false) goto L24;
    L22:
        boolean r103 = true;
    L27:
        if (r103 == false) goto L30;
        r211.encodeNullableSerializableElement(r212, 2, v2.f520790a, r210.shareInfo);
    L30:
        if (r211.shouldEncodeElementDefault(r212, 3) == false) goto L33;
    L31:
        boolean r104 = true;
    L36:
        if (r104 == false) goto L39;
        r211.encodeNullableSerializableElement(r212, 3, v2.f520790a, r210.creator);
    L39:
        if (r211.shouldEncodeElementDefault(r212, 4) == false) goto L42;
    L40:
        boolean r105 = true;
    L45:
        if (r105 == false) goto L48;
        r211.encodeNullableSerializableElement(r212, 4, v2.f520790a, r210.lyrics);
    L48:
        if (r211.shouldEncodeElementDefault(r212, 5) == false) goto L51;
    L49:
        boolean r106 = true;
    L54:
        if (r106 == false) goto L57;
        r211.encodeNullableSerializableElement(r212, 5, v2.f520790a, r210.lyricsSeekContent);
    L57:
        if (r211.shouldEncodeElementDefault(r212, 6) == false) goto L60;
    L58:
        boolean r107 = true;
    L63:
        if (r107 == false) goto L66;
        r211.encodeNullableSerializableElement(r212, 6, v2.f520790a, r210.title);
    L66:
        if (r211.shouldEncodeElementDefault(r212, 7) == false) goto L69;
    L67:
        boolean r108 = true;
    L72:
        if (r108 == false) goto L75;
        r211.encodeNullableSerializableElement(r212, 7, i.f520705a, r210.titleEditedValue);
    L75:
        if (r211.shouldEncodeElementDefault(r212, 8) == false) goto L77;
    L76:
        boolean r109 = true;
    L81:
        if (r109 == false) goto L84;
        r211.encodeNullableSerializableElement(r212, 8, Image.a.f346642a, r210.cover);
    L84:
        if (r211.shouldEncodeElementDefault(r212, 9) == false) goto L87;
    L85:
        boolean r110 = true;
    L90:
        if (r110 == false) goto L93;
        r211.encodeNullableSerializableElement(r212, 9, i.f520705a, r210.coverEditedValue);
    L93:
        if (r211.shouldEncodeElementDefault(r212, 10) == false) goto L96;
    L94:
        boolean r111 = true;
    L99:
        if (r111 == false) goto L102;
        r211.encodeNullableSerializableElement(r212, 10, v2.f520790a, r210.coverMainColor);
    L102:
        if (r211.shouldEncodeElementDefault(r212, 11) == false) goto L105;
    L103:
        boolean r112 = true;
    L108:
        if (r112 == false) goto L111;
        r211.encodeNullableSerializableElement(r212, 11, i.f520705a, r210.musicGenFailedValue);
    L111:
        if (r211.shouldEncodeElementDefault(r212, 12) == false) goto L114;
    L112:
        boolean r113 = true;
    L117:
        if (r113 == false) goto L120;
        r211.encodeNullableSerializableElement(r212, 12, v2.f520790a, r210.musicGenFailedMsg);
    L120:
        if (r211.shouldEncodeElementDefault(r212, 13) == false) goto L123;
    L121:
        boolean r114 = true;
    L126:
        if (r114 == false) goto L129;
        r211.encodeNullableSerializableElement(r212, 13, v2.f520790a, r210.chunkUrl);
    L129:
        if (r211.shouldEncodeElementDefault(r212, 14) == false) goto L132;
    L130:
        boolean r115 = true;
    L135:
        if (r115 == false) goto L138;
        r211.encodeIntElement(r212, 14, r210.musicGenType);
    L138:
        if (r211.shouldEncodeElementDefault(r212, 15) == false) goto L141;
    L139:
        boolean r116 = true;
    L144:
        if (r116 == false) goto L147;
        r211.encodeNullableSerializableElement(r212, 15, v2.f520790a, r210.useTemplateId);
    L147:
        if (r211.shouldEncodeElementDefault(r212, 16) == false) goto L150;
    L148:
        boolean r117 = true;
    L153:
        if (r117 == false) goto L156;
        r211.encodeNullableSerializableElement(r212, 16, v2.f520790a, r210.uniqueTaskId);
    L156:
        if (r211.shouldEncodeElementDefault(r212, 17) == false) goto L159;
    L162:
        if (r100 == false) goto L165;
        r211.encodeNullableSerializableElement(r212, 17, i.f520705a, r210.isBlockValue);
        return;
    L165:
        return;
    L159:
        if (Intrinsics.areEqual(r210.isBlockValue, Boolean.FALSE) == false) goto L162;
        r100 = false;
        goto L162
    L150:
        if (Intrinsics.areEqual(r210.uniqueTaskId, "") == false) goto L148;
        r117 = false;
        goto L153
    L141:
        if (Intrinsics.areEqual(r210.useTemplateId, "") == false) goto L139;
        r116 = false;
        goto L144
    L132:
        if (r210.musicGenType != 0) goto L130;
        r115 = false;
        goto L135
    L123:
        if (Intrinsics.areEqual(r210.chunkUrl, "") == false) goto L121;
        r114 = false;
        goto L126
    L114:
        if (Intrinsics.areEqual(r210.musicGenFailedMsg, "") == false) goto L112;
        r113 = false;
        goto L117
    L105:
        if (Intrinsics.areEqual(r210.musicGenFailedValue, Boolean.FALSE) == false) goto L103;
        r112 = false;
        goto L108
    L96:
        if (Intrinsics.areEqual(r210.coverMainColor, "") == false) goto L94;
        r111 = false;
        goto L99
    L87:
        if (Intrinsics.areEqual(r210.coverEditedValue, Boolean.FALSE) == false) goto L85;
        r110 = false;
        goto L90
    L77:
        Image r118 = r210.cover;
        Object[] r119 = 0 == true ? 1 : 0;
        if (Intrinsics.areEqual(r118, new Image(null, null, null, null, null, null, null, r119, null, null, null, null, null, null, 16383, null)) == false) goto L76;
        r109 = false;
        goto L81
    L69:
        if (Intrinsics.areEqual(r210.titleEditedValue, Boolean.FALSE) == false) goto L67;
        r108 = false;
        goto L72
    L60:
        if (Intrinsics.areEqual(r210.title, "") == false) goto L58;
        r107 = false;
        goto L63
    L51:
        if (Intrinsics.areEqual(r210.lyricsSeekContent, "") == false) goto L49;
        r106 = false;
        goto L54
    L42:
        if (Intrinsics.areEqual(r210.lyrics, "") == false) goto L40;
        r105 = false;
        goto L45
    L33:
        if (Intrinsics.areEqual(r210.creator, "") == false) goto L31;
        r104 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r210.shareInfo, "") == false) goto L22;
        r103 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r210.videoModel, "") == false) goto L13;
        r102 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r210.vid, "") == false) goto L4;
        r101 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ double getDurationSec$default(MusicCreationContent r100, Function1 r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = new h0();
    L7:
        return r100.getDurationSec(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDurationSec");
    }

    public MusicCreationContent(String r210, String r211, String r212, Image r213, String r214, String r215, String r216, String r217, int r310) {
        String r100 = "";
        this.vid = "";
        this.videoModel = "";
        this.shareInfo = "";
        this.creator = "";
        this.lyrics = "";
        this.lyricsSeekContent = "";
        this.title = "";
        Boolean r101 = Boolean.FALSE;
        this.titleEditedValue = r101;
        Boolean r110 = null;
        this.cover = new Image(null, null, null, null, null, null, null, null, null, null, null, r110, r110, null, 16383, null);
        this.coverEditedValue = r101;
        this.coverMainColor = "";
        this.musicGenFailedValue = r101;
        this.musicGenFailedMsg = "";
        this.chunkUrl = "";
        this.useTemplateId = "";
        this.uniqueTaskId = "";
        this.isBlockValue = r101;
        this.playList = new ad9.a();
        if (r210 != null) goto L5;
        String r102 = "";
    L6:
        this.videoModel = r102;
        if (r211 != null) goto L9;
        String r103 = "";
    L10:
        this.title = r103;
        if (r212 != null) goto L13;
        String r104 = "";
    L14:
        this.lyrics = r104;
        if (r213 != null) goto L17;
        Image r105 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    L18:
        this.cover = r105;
        if (r214 != null) goto L21;
        String r106 = "";
    L22:
        this.shareInfo = r106;
        if (r215 != null) goto L25;
        String r107 = "";
    L26:
        this.coverMainColor = r107;
        if (r216 != null) goto L29;
        String r108 = "";
    L30:
        this.vid = r108;
        if (r217 == null) goto L34;
        r100 = r217;
    L34:
        this.lyricsSeekContent = r100;
        this.contentType = r310;
        return;
    L29:
        r108 = r216;
        goto L30
    L25:
        r107 = r215;
        goto L26
    L21:
        r106 = r214;
        goto L22
    L17:
        r105 = r213;
        goto L18
    L13:
        r104 = r212;
        goto L14
    L9:
        r103 = r211;
        goto L10
    L5:
        r102 = r210;
        goto L6
    }

    public MusicCreationContent(int r210, String r211, String r212, String r213, String r214, String r215, String r216, String r310, Boolean r311, Image r312, Boolean r313, String r314, Boolean r315, String r316, String r317, int r318, String r319, String r410, Boolean r411, q2 r412) {
        if ((r210 & 0) == 0) goto L5;
        b2.b(r210, 0, a.f346951b);
        throw null;
    L5:
        if ((r210 & 1) != 0) goto L7;
        this.vid = "";
    L9:
        if ((r210 & 2) != 0) goto L11;
        this.videoModel = "";
    L13:
        if ((r210 & 4) != 0) goto L15;
        this.shareInfo = "";
    L17:
        if ((r210 & 8) != 0) goto L19;
        this.creator = "";
    L21:
        if ((r210 & 16) != 0) goto L23;
        this.lyrics = "";
    L25:
        if ((r210 & 32) != 0) goto L27;
        this.lyricsSeekContent = "";
    L29:
        if ((r210 & 64) != 0) goto L31;
        this.title = "";
    L33:
        if ((r210 & 128) != 0) goto L35;
        Boolean r100 = Boolean.FALSE;
    L36:
        this.titleEditedValue = r100;
        if ((r210 & 256) != 0) goto L39;
        Image r101 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    L40:
        this.cover = r101;
        if ((r210 & 512) != 0) goto L43;
        Boolean r102 = Boolean.FALSE;
    L44:
        this.coverEditedValue = r102;
        if ((r210 & 1024) != 0) goto L47;
        this.coverMainColor = "";
    L49:
        if ((r210 & 2048) != 0) goto L51;
        Boolean r103 = Boolean.FALSE;
    L52:
        this.musicGenFailedValue = r103;
        if ((r210 & 4096) != 0) goto L55;
        this.musicGenFailedMsg = "";
    L57:
        if ((r210 & 8192) != 0) goto L59;
        this.chunkUrl = "";
    L61:
        if ((r210 & 16384) != 0) goto L63;
        this.musicGenType = 0;
    L65:
        if ((32768 & r210) != 0) goto L67;
        this.useTemplateId = "";
    L69:
        if ((65536 & r210) != 0) goto L71;
        this.uniqueTaskId = "";
    L73:
        if ((r210 & 131072) != 0) goto L75;
        Boolean r104 = Boolean.FALSE;
    L76:
        this.isBlockValue = r104;
        this.playList = new ad9.a();
        this.contentType = 0;
        return;
    L75:
        r104 = r411;
        goto L76
    L71:
        this.uniqueTaskId = r410;
        goto L73
    L67:
        this.useTemplateId = r319;
        goto L69
    L63:
        this.musicGenType = r318;
        goto L65
    L59:
        this.chunkUrl = r317;
        goto L61
    L55:
        this.musicGenFailedMsg = r316;
        goto L57
    L51:
        r103 = r315;
        goto L52
    L47:
        this.coverMainColor = r314;
        goto L49
    L43:
        r102 = r313;
        goto L44
    L39:
        r101 = r312;
        goto L40
    L35:
        r100 = r311;
        goto L36
    L31:
        this.title = r310;
        goto L33
    L27:
        this.lyricsSeekContent = r216;
        goto L29
    L23:
        this.lyrics = r215;
        goto L25
    L19:
        this.creator = r214;
        goto L21
    L15:
        this.shareInfo = r213;
        goto L17
    L11:
        this.videoModel = r212;
        goto L13
    L7:
        this.vid = r211;
        goto L9
    }
}
