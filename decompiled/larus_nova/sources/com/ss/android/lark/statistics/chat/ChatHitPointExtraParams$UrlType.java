package com.ss.android.lark.statistics.chat;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.ugc.aweme.discover.model.BackgroundConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/statistics/chat/ChatHitPointExtraParams$UrlType;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "FILE", BackgroundConfig.BackgroundType.TYPE_PICTURE, "MOMENTS", "AUDIO", ExifInterface.LONGITUDE_EAST, "LONG_TEXT", "GENERAL_DOC", "LIVE", "MINUTES", "FOLDER", "VC", "DRIVE", "VIDEO", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "ECOP", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatHitPointExtraParams$UrlType extends Enum<ChatHitPointExtraParams$UrlType> implements s5c.d {
    public static final ChatHitPointExtraParams$UrlType AUDIO = null;
    public static final ChatHitPointExtraParams$UrlType DOC = null;
    public static final ChatHitPointExtraParams$UrlType DOCX = null;
    public static final ChatHitPointExtraParams$UrlType DRIVE = null;
    public static final ChatHitPointExtraParams$UrlType E = null;
    public static final ChatHitPointExtraParams$UrlType ECOP = null;
    public static final ChatHitPointExtraParams$UrlType FILE = null;
    public static final ChatHitPointExtraParams$UrlType FOLDER = null;
    public static final ChatHitPointExtraParams$UrlType GENERAL_DOC = null;
    public static final ChatHitPointExtraParams$UrlType LIVE = null;
    public static final ChatHitPointExtraParams$UrlType LONG_TEXT = null;
    public static final ChatHitPointExtraParams$UrlType MINUTES = null;
    public static final ChatHitPointExtraParams$UrlType MOMENTS = null;
    public static final ChatHitPointExtraParams$UrlType PICTURE = null;
    public static final ChatHitPointExtraParams$UrlType VC = null;
    public static final ChatHitPointExtraParams$UrlType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatHitPointExtraParams$UrlType[] f440659a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440660b = null;
    private final String key;
    private final String value;

    public ChatHitPointExtraParams$UrlType() {
        throw null;
    }

    public static EnumEntries<ChatHitPointExtraParams$UrlType> getEntries() {
        return f440660b;
    }

    static {
        ChatHitPointExtraParams$UrlType r100 = new ChatHitPointExtraParams$UrlType(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 0, DocumentType.DOCX_NAME, null, 2, null);
        DOCX = r100;
        ChatHitPointExtraParams$UrlType r101 = new ChatHitPointExtraParams$UrlType("FILE", 1, "file", null, 2, null);
        FILE = r101;
        ChatHitPointExtraParams$UrlType r102 = new ChatHitPointExtraParams$UrlType(BackgroundConfig.BackgroundType.TYPE_PICTURE, 2, "picture", null, 2, null);
        PICTURE = r102;
        ChatHitPointExtraParams$UrlType r103 = new ChatHitPointExtraParams$UrlType("MOMENTS", 3, ShareChannel.WX_MOMENTS, null, 2, null);
        MOMENTS = r103;
        ChatHitPointExtraParams$UrlType r104 = new ChatHitPointExtraParams$UrlType("AUDIO", 4, "audio", null, 2, null);
        AUDIO = r104;
        ChatHitPointExtraParams$UrlType r105 = new ChatHitPointExtraParams$UrlType(ExifInterface.LONGITUDE_EAST, 5, "e", null, 2, null);
        E = r105;
        ChatHitPointExtraParams$UrlType r106 = new ChatHitPointExtraParams$UrlType("LONG_TEXT", 6, "long_text", null, 2, null);
        LONG_TEXT = r106;
        ChatHitPointExtraParams$UrlType r107 = new ChatHitPointExtraParams$UrlType("GENERAL_DOC", 7, "general_doc", null, 2, null);
        GENERAL_DOC = r107;
        ChatHitPointExtraParams$UrlType r108 = new ChatHitPointExtraParams$UrlType("LIVE", 8, "live", null, 2, null);
        LIVE = r108;
        ChatHitPointExtraParams$UrlType r110 = new ChatHitPointExtraParams$UrlType("MINUTES", 9, DocumentType.MINUTES_NAME, null, 2, null);
        MINUTES = r110;
        ChatHitPointExtraParams$UrlType r109 = new ChatHitPointExtraParams$UrlType("FOLDER", 10, DocumentType.FOLDER_NAME, null, 2, null);
        FOLDER = r109;
        ChatHitPointExtraParams$UrlType r111 = new ChatHitPointExtraParams$UrlType("VC", 11, ThumbGlideUrl.SOURCE_VC, null, 2, null);
        VC = r111;
        ChatHitPointExtraParams$UrlType r112 = new ChatHitPointExtraParams$UrlType("DRIVE", 12, "drive", null, 2, null);
        DRIVE = r112;
        ChatHitPointExtraParams$UrlType r113 = new ChatHitPointExtraParams$UrlType("VIDEO", 13, "video", null, 2, null);
        VIDEO = r113;
        ChatHitPointExtraParams$UrlType r114 = new ChatHitPointExtraParams$UrlType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 14, "doc", null, 2, null);
        DOC = r114;
        ChatHitPointExtraParams$UrlType r115 = new ChatHitPointExtraParams$UrlType("ECOP", 15, "ecop", null, 2, null);
        ECOP = r115;
        ChatHitPointExtraParams$UrlType[] r116 = {r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r109, r111, r112, r113, r114, r115};
        f440659a = r116;
        f440660b = EnumEntriesKt.enumEntries(r116);
    }

    public static ChatHitPointExtraParams$UrlType[] values() {
        return (ChatHitPointExtraParams$UrlType[]) f440659a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return s5c.d.b.c(this);
    }

    @Override // s5c.d
    public String getKey() {
        return this.key;
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static ChatHitPointExtraParams$UrlType valueOf(String r100) {
        return (ChatHitPointExtraParams$UrlType) r27.a.a(ChatHitPointExtraParams$UrlType.class, r100);
    }

    @Override // s5c.d
    public s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }

    public ChatHitPointExtraParams$UrlType(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "url_type";
    L5:
        super(r100, r101);
        this.value = r102;
        this.key = r103;
    }
}
