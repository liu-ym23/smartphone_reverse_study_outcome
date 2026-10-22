package com.bytedance.ee.bear.templates.data;

import android.os.Parcel;
import android.os.Parcelable;
import ao5.e;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.ee.bear.templates.TemplateShowCardType;
import com.bytedance.ee.util.io.NonProguard;
import com.hihonor.honorid.core.data.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\bp\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000  \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002 \u0001Bï\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020#\u0012\b\b\u0002\u0010$\u001a\u00020\b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'\u0012\b\b\u0002\u0010(\u001a\u00020#\u0012\b\b\u0002\u0010)\u001a\u00020\u0005\u0012\b\b\u0002\u0010*\u001a\u00020\b\u0012\b\b\u0002\u0010+\u001a\u00020\b\u0012\b\b\u0002\u0010,\u001a\u00020\u0005¢\u0006\u0004\b-\u0010.J\u0006\u0010d\u001a\u00020#J\u0006\u0010e\u001a\u00020\u0005J\u0006\u0010f\u001a\u00020\u0005J\u0006\u0010g\u001a\u00020#J\u0006\u0010h\u001a\u00020#J\u0006\u0010i\u001a\u00020#J\u0006\u0010j\u001a\u00020#J\u0006\u0010k\u001a\u00020#J\u0006\u0010l\u001a\u00020#J\b\u0010m\u001a\u00020#H\u0002J\u0006\u0010n\u001a\u00020#J\u0006\u0010o\u001a\u00020#J\b\u0010p\u001a\u00020\bH\u0016J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\t\u0010s\u001a\u00020\bHÆ\u0003J\t\u0010t\u001a\u00020\u0005HÆ\u0003J\t\u0010u\u001a\u00020\u0005HÆ\u0003J\t\u0010v\u001a\u00020\u0005HÆ\u0003J\t\u0010w\u001a\u00020\bHÆ\u0003J\t\u0010x\u001a\u00020\u0005HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\t\u0010z\u001a\u00020\u0005HÆ\u0003J\t\u0010{\u001a\u00020\u0011HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\t\u0010}\u001a\u00020\u0005HÆ\u0003J\t\u0010~\u001a\u00020\u0005HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020!HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020#HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\bHÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0012\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020#HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0005HÆ\u0003Jò\u0002\u0010\u0094\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020#2\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\b2\b\b\u0002\u0010+\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020\u0005HÆ\u0001J\u0007\u0010\u0095\u0001\u001a\u00020\bJ\u0016\u0010\u0096\u0001\u001a\u00020#2\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001HÖ\u0003J\n\u0010\u0099\u0001\u001a\u00020\bHÖ\u0001J\n\u0010\u009a\u0001\u001a\u00020\u0005HÖ\u0001J\u001b\u0010\u009b\u0001\u001a\u00030\u009c\u00012\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u00100R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00100\"\u0004\b6\u00107R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b9\u00103R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u00100R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u00100R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u00100R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u00100R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u00100R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u00100R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u00100R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00103\"\u0004\bD\u0010ER\u0011\u0010\u0017\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bF\u0010>R\u0011\u0010\u0018\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bG\u0010>R\u0011\u0010\u0019\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bH\u0010>R\u0011\u0010\u001a\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bI\u0010>R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u00100R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u00100R\u0011\u0010\u001d\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bL\u00103R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u00100R\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bN\u00100R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010$\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00103\"\u0004\bV\u0010ER\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00100\"\u0004\bX\u00107R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010R\"\u0004\b^\u0010TR\u001a\u0010)\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00100\"\u0004\b`\u00107R\u0011\u0010*\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\ba\u00103R\u0011\u0010+\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bb\u00103R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bc\u00100¨\u0006¡\u0001"}, d2 = {"Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/util/io/NonProguard;", "Lcom/bytedance/ee/bear/templates/data/TemplateShowItemBaseData;", "id", "", "name", "objType", "", "objToken", "categoryId", "description", "source", "platform", "operationalLabel", "operationalLabelV2", "heat", "", "authorName", "fromUserId", "userAvatarUrl", "userName", "bottomLabelType", "createTime", UserInfo.UPDATE_TIME, "shareTime", "lastUsedTime", "boxColorBg", "boxColorShadow", "displayType", "coverToken", "coverDownloadUrl", "thumbnailExtra", "Lcom/bytedance/ee/bear/templates/data/ThumbnailExtra;", "enable", "", GXTemplateKey.GAIAX_TEMPLATE_TYPE, "collectionId", "objTypes", "", "blankDocument", "templateSource", "effectiveStatus", "actionPreviewAndPerceive", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/templates/data/ThumbnailExtra;ZILjava/lang/String;Ljava/util/List;ZLjava/lang/String;IILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getObjType", "()I", "getObjToken", "getCategoryId", "setCategoryId", "(Ljava/lang/String;)V", "getDescription", "getSource", "getPlatform", "getOperationalLabel", "getOperationalLabelV2", "getHeat", "()J", "getAuthorName", "getFromUserId", "getUserAvatarUrl", "getUserName", "getBottomLabelType", "setBottomLabelType", "(I)V", "getCreateTime", "getUpdateTime", "getShareTime", "getLastUsedTime", "getBoxColorBg", "getBoxColorShadow", "getDisplayType", "getCoverToken", "getCoverDownloadUrl", "getThumbnailExtra", "()Lcom/bytedance/ee/bear/templates/data/ThumbnailExtra;", "getEnable", "()Z", "setEnable", "(Z)V", "getTemplateType", "setTemplateType", "getCollectionId", "setCollectionId", "getObjTypes", "()Ljava/util/List;", "setObjTypes", "(Ljava/util/List;)V", "getBlankDocument", "setBlankDocument", "getTemplateSource", "setTemplateSource", "getEffectiveStatus", "getActionPreviewAndPerceive", "getIcon", "hasNoPreviewPerceive", "getReportToken", "getReportName", "isSystemTemplate", "isCustomTemplate", "isBusinessTemplate", "isBlankDocumentTemplate", "isSceneTemplate", "isCustomized", "canReportNotEncryption", "checkToken", "isCipherInvalid", "getTemplateShowType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateV4 extends e implements Parcelable, NonProguard {
    public static final int CORPORATE = 3;
    public static final Parcelable.Creator<TemplateV4> CREATOR = null;
    public static final int CUSTOM = 2;
    public static final a Companion = null;
    public static final int DISPLAY_TYPE_COVER = 1;
    public static final int DISPLAY_TYPE_MIXTURE = 3;
    public static final int DISPLAY_TYPE_THUMBNAIL = 2;
    public static final int HAS_PREVIEW_HAS_PERCEIVE = 1;
    public static final int NO_PREVIEW_HAS_PERCEIVE = 2;
    public static final int SYSTEM = 1;
    public static final int TYPE_CREATE_TIME = 2;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_SHARE_EDIT_TIME = 5;
    public static final int TYPE_SHARE_LAST_USE_TIME = 4;
    public static final int TYPE_SHARE_USER = 3;
    public static final int TYPE_USED = 1;
    private final int actionPreviewAndPerceive;
    private final String authorName;
    private boolean blankDocument;
    private int bottomLabelType;
    private final String boxColorBg;
    private final String boxColorShadow;
    private String categoryId;
    private String collectionId;
    private final String coverDownloadUrl;
    private final String coverToken;
    private final long createTime;
    private final String description;
    private final int displayType;
    private final int effectiveStatus;
    private boolean enable;
    private final String fromUserId;
    private final long heat;
    private final String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f239061id;
    private final long lastUsedTime;
    private final String name;
    private final String objToken;
    private final int objType;
    private List<Integer> objTypes;
    private final String operationalLabel;
    private final String operationalLabelV2;
    private final String platform;
    private final long shareTime;
    private final int source;
    private String templateSource;
    private int templateType;
    private final ThumbnailExtra thumbnailExtra;
    private final long updateTime;
    private final String userAvatarUrl;
    private final String userName;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Parcelable.Creator<TemplateV4> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateV4 createFromParcel(Parcel r410) {
            Intrinsics.checkNotNullParameter(r410, "parcel");
            String r100 = r410.readString();
            String r101 = r410.readString();
            int r102 = r410.readInt();
            String r103 = r410.readString();
            String r104 = r410.readString();
            String r105 = r410.readString();
            int r106 = r410.readInt();
            String r110 = r410.readString();
            String r111 = r410.readString();
            String r112 = r410.readString();
            long r113 = r410.readLong();
            String r114 = r410.readString();
            String r115 = r410.readString();
            String r116 = r410.readString();
            String r117 = r410.readString();
            int r118 = r410.readInt();
            long r210 = r410.readLong();
            long r211 = r410.readLong();
            long r212 = r410.readLong();
            long r213 = r410.readLong();
            String r214 = r410.readString();
            String r215 = r410.readString();
            int r310 = r410.readInt();
            String r311 = r410.readString();
            String r312 = r410.readString();
            ThumbnailExtra r313 = ThumbnailExtra.CREATOR.createFromParcel(r410);
            if (r410.readInt() == 0) goto L5;
            boolean r107 = true;
        L6:
            int r314 = r410.readInt();
            String r315 = r410.readString();
            if (r410.readInt() != 0) goto L9;
            ArrayList r108 = null;
        L13:
            if (r410.readInt() == 0) goto L15;
            boolean r109 = true;
        L17:
            return new TemplateV4(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r107, r314, r315, r108, r109, r410.readString(), r410.readInt(), r410.readInt(), r410.readString());
        L15:
            r109 = false;
            goto L17
        L9:
            int r119 = r410.readInt();
            r108 = new ArrayList(r119);
            int r120 = 0;
        L10:
            if (r120 == r119) goto L13;
            r108.add(Integer.valueOf(r410.readInt()));
            r120 = r120 + 1;
            r119 = r119;
            goto L10
        L5:
            r107 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateV4[] newArray(int r100) {
            return new TemplateV4[r100];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    public TemplateV4() {
        this(null, null, 0, null, null, null, 0, null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, null, null, 0, null, null, null, false, 0, null, null, false, null, 0, 0, null, -1, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TemplateV4 copy$default(TemplateV4 r110, String r111, String r112, int r210, String r211, String r212, String r213, int r214, String r215, String r216, String r217, long r218, String r310, String r311, String r312, String r313, int r314, long r315, long r316, long r317, long r410, String r411, String r412, int r413, String r414, String r415, ThumbnailExtra r416, boolean r417, int r510, String r511, List r512, boolean r513, String r514, int r515, int r516, String r517, int r518, int r519, Object r610) {
        if ((r518 & 1) == 0) goto L5;
        String r100 = r110.f239061id;
    L7:
        if ((r518 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r518 & 4) == 0) goto L13;
        int r102 = r110.objType;
    L15:
        if ((r518 & 8) == 0) goto L17;
        String r103 = r110.objToken;
    L19:
        if ((r518 & 16) == 0) goto L21;
        String r104 = r110.categoryId;
    L23:
        if ((r518 & 32) == 0) goto L25;
        String r105 = r110.description;
    L27:
        if ((r518 & 64) == 0) goto L29;
        int r106 = r110.source;
    L31:
        if ((r518 & 128) == 0) goto L33;
        String r107 = r110.platform;
    L35:
        if ((r518 & 256) == 0) goto L37;
        String r113 = r110.operationalLabel;
    L39:
        if ((r518 & 512) == 0) goto L41;
        String r114 = r110.operationalLabelV2;
    L43:
        if ((r518 & 1024) == 0) goto L45;
        long r115 = r110.heat;
    L47:
        if ((r518 & 2048) == 0) goto L49;
        String r116 = r110.authorName;
    L51:
        if ((r518 & 4096) == 0) goto L53;
        String r117 = r110.fromUserId;
    L54:
        String r318 = r117;
        if ((r518 & 8192) == 0) goto L57;
        String r118 = r110.userAvatarUrl;
    L58:
        String r319 = r118;
        if ((r518 & 16384) == 0) goto L61;
        String r119 = r110.userName;
    L62:
        String r320 = r119;
        if ((r518 & 32768) == 0) goto L65;
        int r120 = r110.bottomLabelType;
    L66:
        String r321 = r116;
        int r322 = r120;
        if ((r518 & 65536) == 0) goto L69;
        long r121 = r110.createTime;
    L70:
        long r323 = r121;
        if ((r518 & 131072) == 0) goto L73;
        long r122 = r110.updateTime;
    L74:
        long r324 = r122;
        if ((r518 & 262144) == 0) goto L77;
        long r123 = r110.shareTime;
    L78:
        long r325 = r123;
        if ((r518 & 524288) == 0) goto L81;
        long r124 = r110.lastUsedTime;
    L82:
        long r418 = r124;
        if ((r518 & 1048576) == 0) goto L85;
        String r125 = r110.boxColorBg;
    L87:
        if ((2097152 & r518) == 0) goto L89;
        String r126 = r110.boxColorShadow;
    L90:
        String r419 = r126;
        if ((r518 & 4194304) == 0) goto L93;
        int r127 = r110.displayType;
    L94:
        int r420 = r127;
        if ((r518 & 8388608) == 0) goto L97;
        String r128 = r110.coverToken;
    L98:
        String r421 = r128;
        if ((r518 & 16777216) == 0) goto L101;
        String r129 = r110.coverDownloadUrl;
    L102:
        String r422 = r129;
        if ((r518 & 33554432) == 0) goto L105;
        ThumbnailExtra r130 = r110.thumbnailExtra;
    L106:
        ThumbnailExtra r423 = r130;
        if ((r518 & 67108864) == 0) goto L109;
        boolean r131 = r110.enable;
    L110:
        boolean r424 = r131;
        if ((r518 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r132 = r110.templateType;
    L114:
        int r520 = r132;
        if ((r518 & 268435456) == 0) goto L117;
        String r133 = r110.collectionId;
    L118:
        String r521 = r133;
        if ((r518 & 536870912) == 0) goto L121;
        List r134 = r110.objTypes;
    L122:
        List r522 = r134;
        if ((r518 & 1073741824) == 0) goto L125;
        boolean r135 = r110.blankDocument;
    L127:
        if ((r518 & Integer.MIN_VALUE) == 0) goto L129;
        String r108 = r110.templateSource;
    L130:
        String r523 = r108;
        if ((r519 & 1) == 0) goto L133;
        int r109 = r110.effectiveStatus;
    L134:
        int r524 = r109;
        if ((r519 & 2) == 0) goto L137;
        int r136 = r110.actionPreviewAndPerceive;
    L138:
        int r525 = r136;
        if ((r519 & 4) == 0) goto L141;
        String r137 = r110.icon;
    L143:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r321, r318, r319, r320, r322, r323, r324, r325, r418, r125, r419, r420, r421, r422, r423, r424, r520, r521, r522, r135, r523, r524, r525, r137);
    L141:
        r137 = r517;
        goto L143
    L137:
        r136 = r516;
        goto L138
    L133:
        r109 = r515;
        goto L134
    L129:
        r108 = r514;
        goto L130
    L125:
        r135 = r513;
        goto L127
    L121:
        r134 = r512;
        goto L122
    L117:
        r133 = r511;
        goto L118
    L113:
        r132 = r510;
        goto L114
    L109:
        r131 = r417;
        goto L110
    L105:
        r130 = r416;
        goto L106
    L101:
        r129 = r415;
        goto L102
    L97:
        r128 = r414;
        goto L98
    L93:
        r127 = r413;
        goto L94
    L89:
        r126 = r412;
        goto L90
    L85:
        r125 = r411;
        goto L87
    L81:
        r124 = r410;
        goto L82
    L77:
        r123 = r317;
        goto L78
    L73:
        r122 = r316;
        goto L74
    L69:
        r121 = r315;
        goto L70
    L65:
        r120 = r314;
        goto L66
    L61:
        r119 = r313;
        goto L62
    L57:
        r118 = r312;
        goto L58
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
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
        r107 = r215;
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
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.f239061id;
    }

    public final String component10() {
        return this.operationalLabelV2;
    }

    public final long component11() {
        return this.heat;
    }

    public final String component12() {
        return this.authorName;
    }

    public final String component13() {
        return this.fromUserId;
    }

    public final String component14() {
        return this.userAvatarUrl;
    }

    public final String component15() {
        return this.userName;
    }

    public final int component16() {
        return this.bottomLabelType;
    }

    public final long component17() {
        return this.createTime;
    }

    public final long component18() {
        return this.updateTime;
    }

    public final long component19() {
        return this.shareTime;
    }

    public final String component2() {
        return this.name;
    }

    public final long component20() {
        return this.lastUsedTime;
    }

    public final String component21() {
        return this.boxColorBg;
    }

    public final String component22() {
        return this.boxColorShadow;
    }

    public final int component23() {
        return this.displayType;
    }

    public final String component24() {
        return this.coverToken;
    }

    public final String component25() {
        return this.coverDownloadUrl;
    }

    public final ThumbnailExtra component26() {
        return this.thumbnailExtra;
    }

    public final boolean component27() {
        return this.enable;
    }

    public final int component28() {
        return this.templateType;
    }

    public final String component29() {
        return this.collectionId;
    }

    public final int component3() {
        return this.objType;
    }

    public final List<Integer> component30() {
        return this.objTypes;
    }

    public final boolean component31() {
        return this.blankDocument;
    }

    public final String component32() {
        return this.templateSource;
    }

    public final int component33() {
        return this.effectiveStatus;
    }

    public final int component34() {
        return this.actionPreviewAndPerceive;
    }

    public final String component35() {
        return this.icon;
    }

    public final String component4() {
        return this.objToken;
    }

    public final String component5() {
        return this.categoryId;
    }

    public final String component6() {
        return this.description;
    }

    public final int component7() {
        return this.source;
    }

    public final String component8() {
        return this.platform;
    }

    public final String component9() {
        return this.operationalLabel;
    }

    public final TemplateV4 copy(String r410, String r411, int r412, String r413, String r414, String r415, int r510, String r511, String r512, String r513, long r514, String r515, String r516, String r517, String r518, int r610, long r611, long r612, long r613, long r614, String r615, String r710, int r711, String r712, String r713, ThumbnailExtra r714, boolean r715, int r716, String r717, List<Integer> r718, boolean r719, String r810, int r811, int r812, String r813) {
        Intrinsics.checkNotNullParameter(r410, "id");
        Intrinsics.checkNotNullParameter(r411, "name");
        Intrinsics.checkNotNullParameter(r413, "objToken");
        Intrinsics.checkNotNullParameter(r414, "categoryId");
        Intrinsics.checkNotNullParameter(r415, "description");
        Intrinsics.checkNotNullParameter(r511, "platform");
        Intrinsics.checkNotNullParameter(r512, "operationalLabel");
        Intrinsics.checkNotNullParameter(r513, "operationalLabelV2");
        Intrinsics.checkNotNullParameter(r515, "authorName");
        Intrinsics.checkNotNullParameter(r516, "fromUserId");
        Intrinsics.checkNotNullParameter(r517, "userAvatarUrl");
        Intrinsics.checkNotNullParameter(r518, "userName");
        Intrinsics.checkNotNullParameter(r615, "boxColorBg");
        Intrinsics.checkNotNullParameter(r710, "boxColorShadow");
        Intrinsics.checkNotNullParameter(r712, "coverToken");
        Intrinsics.checkNotNullParameter(r713, "coverDownloadUrl");
        Intrinsics.checkNotNullParameter(r714, "thumbnailExtra");
        Intrinsics.checkNotNullParameter(r810, "templateSource");
        Intrinsics.checkNotNullParameter(r813, "icon");
        return new TemplateV4(r410, r411, r412, r413, r414, r415, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TemplateV4) == true) goto L8;
        return false;
    L8:
        TemplateV4 r101 = (TemplateV4) r100;
        if (Intrinsics.areEqual(this.f239061id, r101.f239061id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (this.objType == r101.objType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.objToken, r101.objToken) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.categoryId, r101.categoryId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L27;
        return false;
    L27:
        if (this.source == r101.source) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.platform, r101.platform) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.operationalLabel, r101.operationalLabel) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.operationalLabelV2, r101.operationalLabelV2) == true) goto L39;
        return false;
    L39:
        if (this.heat == r101.heat) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.authorName, r101.authorName) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.fromUserId, r101.fromUserId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.userAvatarUrl, r101.userAvatarUrl) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L54;
        return false;
    L54:
        if (this.bottomLabelType == r101.bottomLabelType) goto L57;
        return false;
    L57:
        if (this.createTime == r101.createTime) goto L60;
        return false;
    L60:
        if (this.updateTime == r101.updateTime) goto L63;
        return false;
    L63:
        if (this.shareTime == r101.shareTime) goto L66;
        return false;
    L66:
        if (this.lastUsedTime == r101.lastUsedTime) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.boxColorBg, r101.boxColorBg) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.boxColorShadow, r101.boxColorShadow) == true) goto L75;
        return false;
    L75:
        if (this.displayType == r101.displayType) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.coverToken, r101.coverToken) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.coverDownloadUrl, r101.coverDownloadUrl) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.thumbnailExtra, r101.thumbnailExtra) == true) goto L87;
        return false;
    L87:
        if (this.enable == r101.enable) goto L90;
        return false;
    L90:
        if (this.templateType == r101.templateType) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.collectionId, r101.collectionId) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.objTypes, r101.objTypes) == true) goto L99;
        return false;
    L99:
        if (this.blankDocument == r101.blankDocument) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.templateSource, r101.templateSource) == true) goto L105;
        return false;
    L105:
        if (this.effectiveStatus == r101.effectiveStatus) goto L108;
        return false;
    L108:
        if (this.actionPreviewAndPerceive == r101.actionPreviewAndPerceive) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L113;
        return false;
    L113:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((((((((((this.f239061id.hashCode() * 31) + this.name.hashCode()) * 31) + this.objType) * 31) + this.objToken.hashCode()) * 31) + this.categoryId.hashCode()) * 31) + this.description.hashCode()) * 31) + this.source) * 31) + this.platform.hashCode()) * 31) + this.operationalLabel.hashCode()) * 31) + this.operationalLabelV2.hashCode()) * 31;
        long r101 = this.heat;
        int r102 = (((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.authorName.hashCode()) * 31) + this.fromUserId.hashCode()) * 31) + this.userAvatarUrl.hashCode()) * 31) + this.userName.hashCode()) * 31) + this.bottomLabelType) * 31;
        long r103 = this.createTime;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.updateTime;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.shareTime;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.lastUsedTime;
        int r110 = (((((((((((((r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31) + this.boxColorBg.hashCode()) * 31) + this.boxColorShadow.hashCode()) * 31) + this.displayType) * 31) + this.coverToken.hashCode()) * 31) + this.coverDownloadUrl.hashCode()) * 31) + this.thumbnailExtra.hashCode()) * 31;
        int r111 = 1231;
        if (this.enable == false) goto L5;
        int r112 = 1231;
    L6:
        int r113 = (((r110 + r112) * 31) + this.templateType) * 31;
        String r114 = this.collectionId;
        int r115 = 0;
        if (r114 != null) goto L9;
        int r116 = 0;
    L10:
        int r117 = (r113 + r116) * 31;
        List<Integer> r118 = this.objTypes;
        if (r118 == null) goto L14;
        r115 = r118.hashCode();
    L14:
        int r119 = (r117 + r115) * 31;
        if (this.blankDocument == true) goto L19;
        r111 = 1237;
    L19:
        return ((((((((r119 + r111) * 31) + this.templateSource.hashCode()) * 31) + this.effectiveStatus) * 31) + this.actionPreviewAndPerceive) * 31) + this.icon.hashCode();
    L9:
        r116 = r114.hashCode();
        goto L10
    L5:
        r112 = 1237;
        goto L6
    }

    public String toString() {
        return "TemplateV4(id=" + this.f239061id + ", name=" + this.name + ", objType=" + this.objType + ", objToken=" + this.objToken + ", categoryId=" + this.categoryId + ", description=" + this.description + ", source=" + this.source + ", platform=" + this.platform + ", operationalLabel=" + this.operationalLabel + ", operationalLabelV2=" + this.operationalLabelV2 + ", heat=" + this.heat + ", authorName=" + this.authorName + ", fromUserId=" + this.fromUserId + ", userAvatarUrl=" + this.userAvatarUrl + ", userName=" + this.userName + ", bottomLabelType=" + this.bottomLabelType + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", shareTime=" + this.shareTime + ", lastUsedTime=" + this.lastUsedTime + ", boxColorBg=" + this.boxColorBg + ", boxColorShadow=" + this.boxColorShadow + ", displayType=" + this.displayType + ", coverToken=" + this.coverToken + ", coverDownloadUrl=" + this.coverDownloadUrl + ", thumbnailExtra=" + this.thumbnailExtra + ", enable=" + this.enable + ", templateType=" + this.templateType + ", collectionId=" + this.collectionId + ", objTypes=" + this.objTypes + ", blankDocument=" + this.blankDocument + ", templateSource=" + this.templateSource + ", effectiveStatus=" + this.effectiveStatus + ", actionPreviewAndPerceive=" + this.actionPreviewAndPerceive + ", icon=" + this.icon + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f239061id);
        r100.writeString(this.name);
        r100.writeInt(this.objType);
        r100.writeString(this.objToken);
        r100.writeString(this.categoryId);
        r100.writeString(this.description);
        r100.writeInt(this.source);
        r100.writeString(this.platform);
        r100.writeString(this.operationalLabel);
        r100.writeString(this.operationalLabelV2);
        r100.writeLong(this.heat);
        r100.writeString(this.authorName);
        r100.writeString(this.fromUserId);
        r100.writeString(this.userAvatarUrl);
        r100.writeString(this.userName);
        r100.writeInt(this.bottomLabelType);
        r100.writeLong(this.createTime);
        r100.writeLong(this.updateTime);
        r100.writeLong(this.shareTime);
        r100.writeLong(this.lastUsedTime);
        r100.writeString(this.boxColorBg);
        r100.writeString(this.boxColorShadow);
        r100.writeInt(this.displayType);
        r100.writeString(this.coverToken);
        r100.writeString(this.coverDownloadUrl);
        this.thumbnailExtra.writeToParcel(r100, r101);
        r100.writeInt(this.enable ? 1 : 0);
        r100.writeInt(this.templateType);
        r100.writeString(this.collectionId);
        List<Integer> r102 = this.objTypes;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        r100.writeInt(this.blankDocument ? 1 : 0);
        r100.writeString(this.templateSource);
        r100.writeInt(this.effectiveStatus);
        r100.writeInt(this.actionPreviewAndPerceive);
        r100.writeString(this.icon);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Integer> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r100.writeInt(r103.next().intValue());
        goto L7
    }

    private final boolean canReportNotEncryption() {
        if (this.source == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // ao5.e
    public int getTemplateShowType() {
        if (this.blankDocument == false) goto L6;
        return TemplateShowCardType.SHOW_CARD_TYPE_BLANK.ordinal();
    L6:
        return TemplateShowCardType.SHOW_CARD_TYPE_COMMON.ordinal();
    }

    public final boolean hasNoPreviewPerceive() {
        if (this.actionPreviewAndPerceive != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isBusinessTemplate() {
        if (this.source != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isCipherInvalid() {
        if (this.effectiveStatus == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isCustomTemplate() {
        if (this.source != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isCustomized() {
        if (this.templateType != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSceneTemplate() {
        int r100 = this.templateType;
        if (r100 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 4) goto L8;
        return false;
    }

    public final boolean isSystemTemplate() {
        if (this.source == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean checkToken() {
        return !canReportNotEncryption();
    }

    public final String getReportName() {
        if (canReportNotEncryption() == false) goto L6;
        return this.name;
    L6:
        return du5.b.g(this.name);
    }

    public final String getReportToken() {
        if (canReportNotEncryption() == false) goto L6;
        return this.objToken;
    L6:
        return du5.b.g(this.objToken);
    }

    public final int getActionPreviewAndPerceive() {
        return this.actionPreviewAndPerceive;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final boolean getBlankDocument() {
        return this.blankDocument;
    }

    public final int getBottomLabelType() {
        return this.bottomLabelType;
    }

    public final String getBoxColorBg() {
        return this.boxColorBg;
    }

    public final String getBoxColorShadow() {
        return this.boxColorShadow;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final String getCoverDownloadUrl() {
        return this.coverDownloadUrl;
    }

    public final String getCoverToken() {
        return this.coverToken;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getDisplayType() {
        return this.displayType;
    }

    public final int getEffectiveStatus() {
        return this.effectiveStatus;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getFromUserId() {
        return this.fromUserId;
    }

    public final long getHeat() {
        return this.heat;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f239061id;
    }

    public final long getLastUsedTime() {
        return this.lastUsedTime;
    }

    public final String getName() {
        return this.name;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final List<Integer> getObjTypes() {
        return this.objTypes;
    }

    public final String getOperationalLabel() {
        return this.operationalLabel;
    }

    public final String getOperationalLabelV2() {
        return this.operationalLabelV2;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final long getShareTime() {
        return this.shareTime;
    }

    public final int getSource() {
        return this.source;
    }

    public final String getTemplateSource() {
        return this.templateSource;
    }

    public final int getTemplateType() {
        return this.templateType;
    }

    public final ThumbnailExtra getThumbnailExtra() {
        return this.thumbnailExtra;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final String getUserAvatarUrl() {
        return this.userAvatarUrl;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean isBlankDocumentTemplate() {
        return this.blankDocument;
    }

    public final void setBlankDocument(boolean r100) {
        this.blankDocument = r100;
    }

    public final void setBottomLabelType(int r100) {
        this.bottomLabelType = r100;
    }

    public final void setCategoryId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.categoryId = r100;
    }

    public final void setCollectionId(String r100) {
        this.collectionId = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setObjTypes(List<Integer> r100) {
        this.objTypes = r100;
    }

    public final void setTemplateSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templateSource = r100;
    }

    public final void setTemplateType(int r100) {
        this.templateType = r100;
    }

    public TemplateV4(String r110, String r111, int r112, String r210, String r211, String r212, int r213, String r214, String r215, String r216, long r217, String r218, String r310, String r311, String r312, int r313, long r314, long r315, long r316, long r410, String r411, String r412, int r413, String r414, String r415, ThumbnailExtra r416, boolean r417, int r418, String r510, List<Integer> r511, boolean r512, String r513, int r514, int r515, String r516) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r210, "objToken");
        Intrinsics.checkNotNullParameter(r211, "categoryId");
        Intrinsics.checkNotNullParameter(r212, "description");
        Intrinsics.checkNotNullParameter(r214, "platform");
        Intrinsics.checkNotNullParameter(r215, "operationalLabel");
        Intrinsics.checkNotNullParameter(r216, "operationalLabelV2");
        Intrinsics.checkNotNullParameter(r218, "authorName");
        Intrinsics.checkNotNullParameter(r310, "fromUserId");
        Intrinsics.checkNotNullParameter(r311, "userAvatarUrl");
        Intrinsics.checkNotNullParameter(r312, "userName");
        Intrinsics.checkNotNullParameter(r411, "boxColorBg");
        Intrinsics.checkNotNullParameter(r412, "boxColorShadow");
        Intrinsics.checkNotNullParameter(r414, "coverToken");
        Intrinsics.checkNotNullParameter(r415, "coverDownloadUrl");
        Intrinsics.checkNotNullParameter(r416, "thumbnailExtra");
        Intrinsics.checkNotNullParameter(r513, "templateSource");
        Intrinsics.checkNotNullParameter(r516, "icon");
        this.f239061id = r110;
        this.name = r111;
        this.objType = r112;
        this.objToken = r210;
        this.categoryId = r211;
        this.description = r212;
        this.source = r213;
        this.platform = r214;
        this.operationalLabel = r215;
        this.operationalLabelV2 = r216;
        this.heat = r217;
        this.authorName = r218;
        this.fromUserId = r310;
        this.userAvatarUrl = r311;
        this.userName = r312;
        this.bottomLabelType = r313;
        this.createTime = r314;
        this.updateTime = r315;
        this.shareTime = r316;
        this.lastUsedTime = r410;
        this.boxColorBg = r411;
        this.boxColorShadow = r412;
        this.displayType = r413;
        this.coverToken = r414;
        this.coverDownloadUrl = r415;
        this.thumbnailExtra = r416;
        this.enable = r417;
        this.templateType = r418;
        this.collectionId = r510;
        this.objTypes = r511;
        this.blankDocument = r512;
        this.templateSource = r513;
        this.effectiveStatus = r514;
        this.actionPreviewAndPerceive = r515;
        this.icon = r516;
    }

    public TemplateV4(String r410, String r411, int r412, String r413, String r414, String r415, int r416, String r417, String r510, String r511, long r512, String r513, String r514, String r515, String r516, int r517, long r518, long r610, long r611, long r612, String r613, String r614, int r615, String r710, String r711, ThumbnailExtra r712, boolean r713, int r714, String r715, List r716, boolean r717, String r718, int r719, int r810, String r811, int r812, int r813, DefaultConstructorMarker r814) {
        String r100 = "";
        if ((r812 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r812 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r812 & 4) == 0) goto L13;
        int r103 = sbb.e.f541296g.f541317b;
    L15:
        if ((r812 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r812 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r812 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r812 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r812 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r812 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r812 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r812 & 1024) == 0) goto L45;
        long r113 = 0;
    L47:
        if ((r812 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r812 & 4096) == 0) goto L53;
        String r108 = "";
    L55:
        if ((r812 & 8192) == 0) goto L57;
        String r115 = "";
    L59:
        if ((r812 & 16384) == 0) goto L61;
        String r116 = "";
    L63:
        if ((r812 & 32768) == 0) goto L65;
        int r117 = 0;
    L67:
        if ((r812 & 65536) == 0) goto L69;
        long r118 = 0;
    L71:
        if ((r812 & 131072) == 0) goto L73;
        long r210 = 0;
    L75:
        if ((r812 & 262144) == 0) goto L77;
        long r211 = 0;
    L79:
        if ((r812 & 524288) == 0) goto L81;
        long r212 = 0;
    L83:
        if ((r812 & 1048576) == 0) goto L85;
        String r213 = "";
    L87:
        if ((r812 & 2097152) == 0) goto L89;
        String r214 = "";
    L90:
        int r310 = 1;
        if ((r812 & 4194304) == 0) goto L93;
        int r215 = 1;
    L95:
        if ((r812 & 8388608) == 0) goto L97;
        String r311 = "";
    L99:
        if ((r812 & 16777216) == 0) goto L101;
        String r312 = "";
    L103:
        if ((r812 & 33554432) == 0) goto L105;
        ThumbnailExtra r313 = new ThumbnailExtra(0, null, null, 7, null);
    L107:
        if ((r812 & 67108864) == 0) goto L109;
        boolean r314 = true;
    L111:
        if ((r812 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r315 = 1;
    L115:
        if ((r812 & 268435456) == 0) goto L117;
        String r316 = null;
    L119:
        if ((r812 & 536870912) == 0) goto L121;
        List r317 = new ArrayList();
    L123:
        if ((r812 & 1073741824) == 0) goto L125;
        boolean r318 = false;
    L127:
        if ((r812 & Integer.MIN_VALUE) == 0) goto L129;
        String r109 = "";
    L131:
        if ((r813 & 1) == 0) goto L133;
        int r319 = 0;
    L135:
        if ((r813 & 2) != 0) goto L139;
        r310 = r810;
    L139:
        if ((r813 & 4) != 0) goto L142;
        r100 = r811;
    L142:
        this(r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r108, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r311, r312, r313, r314, r315, r316, r317, r318, r109, r319, r310, r100);
        return;
    L133:
        r319 = r719;
        goto L135
    L129:
        r109 = r718;
        goto L131
    L125:
        r318 = r717;
        goto L127
    L121:
        r317 = r716;
        goto L123
    L117:
        r316 = r715;
        goto L119
    L113:
        r315 = r714;
        goto L115
    L109:
        r314 = r713;
        goto L111
    L105:
        r313 = r712;
        goto L107
    L101:
        r312 = r711;
        goto L103
    L97:
        r311 = r710;
        goto L99
    L93:
        r215 = r615;
        goto L95
    L89:
        r214 = r614;
        goto L90
    L85:
        r213 = r613;
        goto L87
    L81:
        r212 = r612;
        goto L83
    L77:
        r211 = r611;
        goto L79
    L73:
        r210 = r610;
        goto L75
    L69:
        r118 = r518;
        goto L71
    L65:
        r117 = r517;
        goto L67
    L61:
        r116 = r516;
        goto L63
    L57:
        r115 = r515;
        goto L59
    L53:
        r108 = r514;
        goto L55
    L49:
        r114 = r513;
        goto L51
    L45:
        r113 = r512;
        goto L47
    L41:
        r112 = r511;
        goto L43
    L37:
        r111 = r510;
        goto L39
    L33:
        r110 = r417;
        goto L35
    L29:
        r107 = r416;
        goto L31
    L25:
        r106 = r415;
        goto L27
    L21:
        r105 = r414;
        goto L23
    L17:
        r104 = r413;
        goto L19
    L13:
        r103 = r412;
        goto L15
    L9:
        r102 = r411;
        goto L11
    L5:
        r101 = r410;
        goto L7
    }
}
