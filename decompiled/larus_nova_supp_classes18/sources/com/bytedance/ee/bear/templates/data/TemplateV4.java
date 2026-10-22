package com.bytedance.ee.bear.templates.data;

import android.os.Parcel;
import android.os.Parcelable;
import ao5.e;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.templates.TemplateShowCardType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\bp\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000  \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002 \u0001Bï\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020#\u0012\b\b\u0002\u0010$\u001a\u00020\b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'\u0012\b\b\u0002\u0010(\u001a\u00020#\u0012\b\b\u0002\u0010)\u001a\u00020\u0005\u0012\b\b\u0002\u0010*\u001a\u00020\b\u0012\b\b\u0002\u0010+\u001a\u00020\b\u0012\b\b\u0002\u0010,\u001a\u00020\u0005¢\u0006\u0004\b-\u0010.J\u0006\u0010d\u001a\u00020#J\u0006\u0010e\u001a\u00020\u0005J\u0006\u0010f\u001a\u00020\u0005J\u0006\u0010g\u001a\u00020#J\u0006\u0010h\u001a\u00020#J\u0006\u0010i\u001a\u00020#J\u0006\u0010j\u001a\u00020#J\u0006\u0010k\u001a\u00020#J\u0006\u0010l\u001a\u00020#J\b\u0010m\u001a\u00020#H\u0002J\u0006\u0010n\u001a\u00020#J\u0006\u0010o\u001a\u00020#J\b\u0010p\u001a\u00020\bH\u0016J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\t\u0010s\u001a\u00020\bHÆ\u0003J\t\u0010t\u001a\u00020\u0005HÆ\u0003J\t\u0010u\u001a\u00020\u0005HÆ\u0003J\t\u0010v\u001a\u00020\u0005HÆ\u0003J\t\u0010w\u001a\u00020\bHÆ\u0003J\t\u0010x\u001a\u00020\u0005HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\t\u0010z\u001a\u00020\u0005HÆ\u0003J\t\u0010{\u001a\u00020\u0011HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\t\u0010}\u001a\u00020\u0005HÆ\u0003J\t\u0010~\u001a\u00020\u0005HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020!HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020#HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\bHÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0012\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020#HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0005HÆ\u0003Jò\u0002\u0010\u0094\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020#2\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\b2\b\b\u0002\u0010+\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020\u0005HÆ\u0001J\u0007\u0010\u0095\u0001\u001a\u00020\bJ\u0016\u0010\u0096\u0001\u001a\u00020#2\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001HÖ\u0003J\n\u0010\u0099\u0001\u001a\u00020\bHÖ\u0001J\n\u0010\u009a\u0001\u001a\u00020\u0005HÖ\u0001J\u001b\u0010\u009b\u0001\u001a\u00030\u009c\u00012\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u00100R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00100\"\u0004\b6\u00107R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b9\u00103R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u00100R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u00100R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u00100R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u00100R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u00100R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u00100R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u00100R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00103\"\u0004\bD\u0010ER\u0011\u0010\u0017\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bF\u0010>R\u0011\u0010\u0018\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bG\u0010>R\u0011\u0010\u0019\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bH\u0010>R\u0011\u0010\u001a\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bI\u0010>R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u00100R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u00100R\u0011\u0010\u001d\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bL\u00103R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u00100R\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bN\u00100R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010$\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00103\"\u0004\bV\u0010ER\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00100\"\u0004\bX\u00107R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010R\"\u0004\b^\u0010TR\u001a\u0010)\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00100\"\u0004\b`\u00107R\u0011\u0010*\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\ba\u00103R\u0011\u0010+\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bb\u00103R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bc\u00100¨\u0006¡\u0001"}, d2 = {"Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/util/io/NonProguard;", "Lcom/bytedance/ee/bear/templates/data/TemplateShowItemBaseData;", ResourceData.KEY_ID, "", "name", "objType", "", "objToken", "categoryId", "description", "source", "platform", "operationalLabel", "operationalLabelV2", "heat", "", "authorName", "fromUserId", "userAvatarUrl", "userName", "bottomLabelType", "createTime", "updateTime", "shareTime", "lastUsedTime", "boxColorBg", "boxColorShadow", "displayType", "coverToken", "coverDownloadUrl", "thumbnailExtra", "Lcom/bytedance/ee/bear/templates/data/ThumbnailExtra;", "enable", "", "templateType", "collectionId", "objTypes", "", "blankDocument", "templateSource", "effectiveStatus", "actionPreviewAndPerceive", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/templates/data/ThumbnailExtra;ZILjava/lang/String;Ljava/util/List;ZLjava/lang/String;IILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getObjType", "()I", "getObjToken", "getCategoryId", "setCategoryId", "(Ljava/lang/String;)V", "getDescription", "getSource", "getPlatform", "getOperationalLabel", "getOperationalLabelV2", "getHeat", "()J", "getAuthorName", "getFromUserId", "getUserAvatarUrl", "getUserName", "getBottomLabelType", "setBottomLabelType", "(I)V", "getCreateTime", "getUpdateTime", "getShareTime", "getLastUsedTime", "getBoxColorBg", "getBoxColorShadow", "getDisplayType", "getCoverToken", "getCoverDownloadUrl", "getThumbnailExtra", "()Lcom/bytedance/ee/bear/templates/data/ThumbnailExtra;", "getEnable", "()Z", "setEnable", "(Z)V", "getTemplateType", "setTemplateType", "getCollectionId", "setCollectionId", "getObjTypes", "()Ljava/util/List;", "setObjTypes", "(Ljava/util/List;)V", "getBlankDocument", "setBlankDocument", "getTemplateSource", "setTemplateSource", "getEffectiveStatus", "getActionPreviewAndPerceive", "getIcon", "hasNoPreviewPerceive", "getReportToken", "getReportName", "isSystemTemplate", "isCustomTemplate", "isBusinessTemplate", "isBlankDocumentTemplate", "isSceneTemplate", "isCustomized", "canReportNotEncryption", "checkToken", "isCipherInvalid", "getTemplateShowType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
    private final String id;
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
        public final TemplateV4 createFromParcel(Parcel r45) {
            Intrinsics.checkNotNullParameter(r45, "parcel");
            String r3 = r45.readString();
            String r4 = r45.readString();
            int r5 = r45.readInt();
            String r6 = r45.readString();
            String r7 = r45.readString();
            String r8 = r45.readString();
            int r9 = r45.readInt();
            String r10 = r45.readString();
            String r11 = r45.readString();
            String r12 = r45.readString();
            long r13 = r45.readLong();
            String r15 = r45.readString();
            String r16 = r45.readString();
            String r17 = r45.readString();
            String r18 = r45.readString();
            int r19 = r45.readInt();
            long r20 = r45.readLong();
            long r22 = r45.readLong();
            long r24 = r45.readLong();
            long r26 = r45.readLong();
            String r28 = r45.readString();
            String r29 = r45.readString();
            int r30 = r45.readInt();
            String r31 = r45.readString();
            String r32 = r45.readString();
            ThumbnailExtra r33 = ThumbnailExtra.CREATOR.createFromParcel(r45);
            if (r45.readInt() == 0) goto L5;
            boolean r1 = true;
        L6:
            int r35 = r45.readInt();
            String r36 = r45.readString();
            if (r45.readInt() != 0) goto L9;
            ArrayList r0 = null;
        L13:
            if (r45.readInt() == 0) goto L15;
            boolean r2 = true;
        L17:
            return new TemplateV4(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20, r22, r24, r26, r28, r29, r30, r31, r32, r33, r1, r35, r36, r0, r2, r45.readString(), r45.readInt(), r45.readInt(), r45.readString());
        L15:
            r2 = false;
            goto L17
        L9:
            int r14 = r45.readInt();
            r0 = new ArrayList(r14);
            int r21 = 0;
        L10:
            if (r21 == r14) goto L13;
            r0.add(Integer.valueOf(r45.readInt()));
            r21 = r21 + 1;
            r14 = r14;
            goto L10
        L5:
            r1 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateV4[] newArray(int r1) {
            return new TemplateV4[r1];
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
    public static /* synthetic */ TemplateV4 copy$default(TemplateV4 r17, String r18, String r19, int r20, String r21, String r22, String r23, int r24, String r25, String r26, String r27, long r28, String r30, String r31, String r32, String r33, int r34, long r35, long r37, long r39, long r41, String r43, String r44, int r45, String r46, String r47, ThumbnailExtra r48, boolean r49, int r50, String r51, List r52, boolean r53, String r54, int r55, int r56, String r57, int r58, int r59, Object r60) {
        if ((r58 & 1) == 0) goto L5;
        String r2 = r17.id;
    L7:
        if ((r58 & 2) == 0) goto L9;
        String r3 = r17.name;
    L11:
        if ((r58 & 4) == 0) goto L13;
        int r4 = r17.objType;
    L15:
        if ((r58 & 8) == 0) goto L17;
        String r5 = r17.objToken;
    L19:
        if ((r58 & 16) == 0) goto L21;
        String r6 = r17.categoryId;
    L23:
        if ((r58 & 32) == 0) goto L25;
        String r7 = r17.description;
    L27:
        if ((r58 & 64) == 0) goto L29;
        int r8 = r17.source;
    L31:
        if ((r58 & 128) == 0) goto L33;
        String r9 = r17.platform;
    L35:
        if ((r58 & 256) == 0) goto L37;
        String r10 = r17.operationalLabel;
    L39:
        if ((r58 & 512) == 0) goto L41;
        String r11 = r17.operationalLabelV2;
    L43:
        if ((r58 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        long r12 = r17.heat;
    L47:
        if ((r58 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        String r14 = r17.authorName;
    L51:
        if ((r58 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        String r15 = r17.fromUserId;
    L54:
        String r36 = r15;
        if ((r58 & 8192) == 0) goto L57;
        String r16 = r17.userAvatarUrl;
    L58:
        String r38 = r16;
        if ((r58 & 16384) == 0) goto L61;
        String r110 = r17.userName;
    L62:
        String r310 = r110;
        if ((r58 & 32768) == 0) goto L65;
        int r111 = r17.bottomLabelType;
    L66:
        String r311 = r14;
        int r312 = r111;
        if ((r58 & 65536) == 0) goto L69;
        long r112 = r17.createTime;
    L70:
        long r313 = r112;
        if ((r58 & 131072) == 0) goto L73;
        long r113 = r17.updateTime;
    L74:
        long r314 = r113;
        if ((r58 & 262144) == 0) goto L77;
        long r114 = r17.shareTime;
    L78:
        long r315 = r114;
        if ((r58 & 524288) == 0) goto L81;
        long r115 = r17.lastUsedTime;
    L82:
        long r42 = r115;
        if ((r58 & 1048576) == 0) goto L85;
        String r116 = r17.boxColorBg;
    L87:
        if ((2097152 & r58) == 0) goto L89;
        String r117 = r17.boxColorShadow;
    L90:
        String r410 = r117;
        if ((r58 & 4194304) == 0) goto L93;
        int r118 = r17.displayType;
    L94:
        int r411 = r118;
        if ((r58 & 8388608) == 0) goto L97;
        String r119 = r17.coverToken;
    L98:
        String r412 = r119;
        if ((r58 & 16777216) == 0) goto L101;
        String r120 = r17.coverDownloadUrl;
    L102:
        String r413 = r120;
        if ((r58 & 33554432) == 0) goto L105;
        ThumbnailExtra r121 = r17.thumbnailExtra;
    L106:
        ThumbnailExtra r414 = r121;
        if ((r58 & 67108864) == 0) goto L109;
        boolean r122 = r17.enable;
    L110:
        boolean r415 = r122;
        if ((r58 & 134217728) == 0) goto L113;
        int r123 = r17.templateType;
    L114:
        int r510 = r123;
        if ((r58 & 268435456) == 0) goto L117;
        String r124 = r17.collectionId;
    L118:
        String r511 = r124;
        if ((r58 & 536870912) == 0) goto L121;
        List r125 = r17.objTypes;
    L122:
        List r512 = r125;
        if ((r58 & 1073741824) == 0) goto L125;
        boolean r126 = r17.blankDocument;
    L127:
        if ((r58 & Integer.MIN_VALUE) == 0) goto L129;
        String r1 = r17.templateSource;
    L130:
        String r513 = r1;
        if ((r59 & 1) == 0) goto L133;
        int r13 = r17.effectiveStatus;
    L134:
        int r514 = r13;
        if ((r59 & 2) == 0) goto L137;
        int r29 = r17.actionPreviewAndPerceive;
    L138:
        int r515 = r29;
        if ((r59 & 4) == 0) goto L141;
        String r40 = r17.icon;
    L143:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r311, r36, r38, r310, r312, r313, r314, r315, r42, r116, r410, r411, r412, r413, r414, r415, r510, r511, r512, r126, r513, r514, r515, r40);
    L141:
        r40 = r57;
        goto L143
    L137:
        r29 = r56;
        goto L138
    L133:
        r13 = r55;
        goto L134
    L129:
        r1 = r54;
        goto L130
    L125:
        r126 = r53;
        goto L127
    L121:
        r125 = r52;
        goto L122
    L117:
        r124 = r51;
        goto L118
    L113:
        r123 = r50;
        goto L114
    L109:
        r122 = r49;
        goto L110
    L105:
        r121 = r48;
        goto L106
    L101:
        r120 = r47;
        goto L102
    L97:
        r119 = r46;
        goto L98
    L93:
        r118 = r45;
        goto L94
    L89:
        r117 = r44;
        goto L90
    L85:
        r116 = r43;
        goto L87
    L81:
        r115 = r41;
        goto L82
    L77:
        r114 = r39;
        goto L78
    L73:
        r113 = r37;
        goto L74
    L69:
        r112 = r35;
        goto L70
    L65:
        r111 = r34;
        goto L66
    L61:
        r110 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L54
    L49:
        r14 = r30;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.id;
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

    public final TemplateV4 copy(String r44, String r45, int r46, String r47, String r48, String r49, int r50, String r51, String r52, String r53, long r54, String r56, String r57, String r58, String r59, int r60, long r61, long r63, long r65, long r67, String r69, String r70, int r71, String r72, String r73, ThumbnailExtra r74, boolean r75, int r76, String r77, List<Integer> r78, boolean r79, String r80, int r81, int r82, String r83) {
        Intrinsics.checkNotNullParameter(r44, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r45, "name");
        Intrinsics.checkNotNullParameter(r47, "objToken");
        Intrinsics.checkNotNullParameter(r48, "categoryId");
        Intrinsics.checkNotNullParameter(r49, "description");
        Intrinsics.checkNotNullParameter(r51, "platform");
        Intrinsics.checkNotNullParameter(r52, "operationalLabel");
        Intrinsics.checkNotNullParameter(r53, "operationalLabelV2");
        Intrinsics.checkNotNullParameter(r56, "authorName");
        Intrinsics.checkNotNullParameter(r57, "fromUserId");
        Intrinsics.checkNotNullParameter(r58, "userAvatarUrl");
        Intrinsics.checkNotNullParameter(r59, "userName");
        Intrinsics.checkNotNullParameter(r69, "boxColorBg");
        Intrinsics.checkNotNullParameter(r70, "boxColorShadow");
        Intrinsics.checkNotNullParameter(r72, "coverToken");
        Intrinsics.checkNotNullParameter(r73, "coverDownloadUrl");
        Intrinsics.checkNotNullParameter(r74, "thumbnailExtra");
        Intrinsics.checkNotNullParameter(r80, "templateSource");
        Intrinsics.checkNotNullParameter(r83, "icon");
        return new TemplateV4(r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r56, r57, r58, r59, r60, r61, r63, r65, r67, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TemplateV4) == true) goto L8;
        return false;
    L8:
        TemplateV4 r9 = (TemplateV4) r8;
        if (Intrinsics.areEqual(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L15;
        return false;
    L15:
        if (this.objType == r9.objType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.objToken, r9.objToken) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.categoryId, r9.categoryId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.description, r9.description) == true) goto L27;
        return false;
    L27:
        if (this.source == r9.source) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.platform, r9.platform) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.operationalLabel, r9.operationalLabel) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.operationalLabelV2, r9.operationalLabelV2) == true) goto L39;
        return false;
    L39:
        if (this.heat == r9.heat) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.authorName, r9.authorName) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.fromUserId, r9.fromUserId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.userAvatarUrl, r9.userAvatarUrl) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.userName, r9.userName) == true) goto L54;
        return false;
    L54:
        if (this.bottomLabelType == r9.bottomLabelType) goto L57;
        return false;
    L57:
        if (this.createTime == r9.createTime) goto L60;
        return false;
    L60:
        if (this.updateTime == r9.updateTime) goto L63;
        return false;
    L63:
        if (this.shareTime == r9.shareTime) goto L66;
        return false;
    L66:
        if (this.lastUsedTime == r9.lastUsedTime) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.boxColorBg, r9.boxColorBg) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.boxColorShadow, r9.boxColorShadow) == true) goto L75;
        return false;
    L75:
        if (this.displayType == r9.displayType) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.coverToken, r9.coverToken) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.coverDownloadUrl, r9.coverDownloadUrl) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.thumbnailExtra, r9.thumbnailExtra) == true) goto L87;
        return false;
    L87:
        if (this.enable == r9.enable) goto L90;
        return false;
    L90:
        if (this.templateType == r9.templateType) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.collectionId, r9.collectionId) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.objTypes, r9.objTypes) == true) goto L99;
        return false;
    L99:
        if (this.blankDocument == r9.blankDocument) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.templateSource, r9.templateSource) == true) goto L105;
        return false;
    L105:
        if (this.effectiveStatus == r9.effectiveStatus) goto L108;
        return false;
    L108:
        if (this.actionPreviewAndPerceive == r9.actionPreviewAndPerceive) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.icon, r9.icon) == true) goto L113;
        return false;
    L113:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.objType) * 31) + this.objToken.hashCode()) * 31) + this.categoryId.hashCode()) * 31) + this.description.hashCode()) * 31) + this.source) * 31) + this.platform.hashCode()) * 31) + this.operationalLabel.hashCode()) * 31) + this.operationalLabelV2.hashCode()) * 31;
        long r1 = this.heat;
        int r2 = (((((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.authorName.hashCode()) * 31) + this.fromUserId.hashCode()) * 31) + this.userAvatarUrl.hashCode()) * 31) + this.userName.hashCode()) * 31) + this.bottomLabelType) * 31;
        long r3 = this.createTime;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.updateTime;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.shareTime;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.lastUsedTime;
        int r10 = (((((((((((((r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31) + this.boxColorBg.hashCode()) * 31) + this.boxColorShadow.hashCode()) * 31) + this.displayType) * 31) + this.coverToken.hashCode()) * 31) + this.coverDownloadUrl.hashCode()) * 31) + this.thumbnailExtra.hashCode()) * 31;
        int r11 = 1231;
        if (this.enable == false) goto L5;
        int r12 = 1231;
    L6:
        int r13 = (((r10 + r12) * 31) + this.templateType) * 31;
        String r14 = this.collectionId;
        int r15 = 0;
        if (r14 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r13 + r16) * 31;
        List<Integer> r18 = this.objTypes;
        if (r18 == null) goto L14;
        r15 = r18.hashCode();
    L14:
        int r19 = (r17 + r15) * 31;
        if (this.blankDocument == true) goto L19;
        r11 = 1237;
    L19:
        return ((((((((r19 + r11) * 31) + this.templateSource.hashCode()) * 31) + this.effectiveStatus) * 31) + this.actionPreviewAndPerceive) * 31) + this.icon.hashCode();
    L9:
        r16 = r14.hashCode();
        goto L10
    L5:
        r12 = 1237;
        goto L6
    }

    public String toString() {
        return "TemplateV4(id=" + this.id + ", name=" + this.name + ", objType=" + this.objType + ", objToken=" + this.objToken + ", categoryId=" + this.categoryId + ", description=" + this.description + ", source=" + this.source + ", platform=" + this.platform + ", operationalLabel=" + this.operationalLabel + ", operationalLabelV2=" + this.operationalLabelV2 + ", heat=" + this.heat + ", authorName=" + this.authorName + ", fromUserId=" + this.fromUserId + ", userAvatarUrl=" + this.userAvatarUrl + ", userName=" + this.userName + ", bottomLabelType=" + this.bottomLabelType + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", shareTime=" + this.shareTime + ", lastUsedTime=" + this.lastUsedTime + ", boxColorBg=" + this.boxColorBg + ", boxColorShadow=" + this.boxColorShadow + ", displayType=" + this.displayType + ", coverToken=" + this.coverToken + ", coverDownloadUrl=" + this.coverDownloadUrl + ", thumbnailExtra=" + this.thumbnailExtra + ", enable=" + this.enable + ", templateType=" + this.templateType + ", collectionId=" + this.collectionId + ", objTypes=" + this.objTypes + ", blankDocument=" + this.blankDocument + ", templateSource=" + this.templateSource + ", effectiveStatus=" + this.effectiveStatus + ", actionPreviewAndPerceive=" + this.actionPreviewAndPerceive + ", icon=" + this.icon + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.id);
        r3.writeString(this.name);
        r3.writeInt(this.objType);
        r3.writeString(this.objToken);
        r3.writeString(this.categoryId);
        r3.writeString(this.description);
        r3.writeInt(this.source);
        r3.writeString(this.platform);
        r3.writeString(this.operationalLabel);
        r3.writeString(this.operationalLabelV2);
        r3.writeLong(this.heat);
        r3.writeString(this.authorName);
        r3.writeString(this.fromUserId);
        r3.writeString(this.userAvatarUrl);
        r3.writeString(this.userName);
        r3.writeInt(this.bottomLabelType);
        r3.writeLong(this.createTime);
        r3.writeLong(this.updateTime);
        r3.writeLong(this.shareTime);
        r3.writeLong(this.lastUsedTime);
        r3.writeString(this.boxColorBg);
        r3.writeString(this.boxColorShadow);
        r3.writeInt(this.displayType);
        r3.writeString(this.coverToken);
        r3.writeString(this.coverDownloadUrl);
        this.thumbnailExtra.writeToParcel(r3, r4);
        r3.writeInt(this.enable ? 1 : 0);
        r3.writeInt(this.templateType);
        r3.writeString(this.collectionId);
        List<Integer> r5 = this.objTypes;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L9:
        r3.writeInt(this.blankDocument ? 1 : 0);
        r3.writeString(this.templateSource);
        r3.writeInt(this.effectiveStatus);
        r3.writeInt(this.actionPreviewAndPerceive);
        r3.writeString(this.icon);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.size());
        Iterator<Integer> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r3.writeInt(r6.next().intValue());
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
        int r0 = this.templateType;
        if (r0 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 4) goto L8;
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
        return this.id;
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

    public final void setBlankDocument(boolean r1) {
        this.blankDocument = r1;
    }

    public final void setBottomLabelType(int r1) {
        this.bottomLabelType = r1;
    }

    public final void setCategoryId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.categoryId = r2;
    }

    public final void setCollectionId(String r1) {
        this.collectionId = r1;
    }

    public final void setEnable(boolean r1) {
        this.enable = r1;
    }

    public final void setObjTypes(List<Integer> r1) {
        this.objTypes = r1;
    }

    public final void setTemplateSource(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.templateSource = r2;
    }

    public final void setTemplateType(int r1) {
        this.templateType = r1;
    }

    public TemplateV4(String r17, String r18, int r19, String r20, String r21, String r22, int r23, String r24, String r25, String r26, long r27, String r29, String r30, String r31, String r32, int r33, long r34, long r36, long r38, long r40, String r42, String r43, int r44, String r45, String r46, ThumbnailExtra r47, boolean r48, int r49, String r50, List<Integer> r51, boolean r52, String r53, int r54, int r55, String r56) {
        Intrinsics.checkNotNullParameter(r17, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r18, "name");
        Intrinsics.checkNotNullParameter(r20, "objToken");
        Intrinsics.checkNotNullParameter(r21, "categoryId");
        Intrinsics.checkNotNullParameter(r22, "description");
        Intrinsics.checkNotNullParameter(r24, "platform");
        Intrinsics.checkNotNullParameter(r25, "operationalLabel");
        Intrinsics.checkNotNullParameter(r26, "operationalLabelV2");
        Intrinsics.checkNotNullParameter(r29, "authorName");
        Intrinsics.checkNotNullParameter(r30, "fromUserId");
        Intrinsics.checkNotNullParameter(r31, "userAvatarUrl");
        Intrinsics.checkNotNullParameter(r32, "userName");
        Intrinsics.checkNotNullParameter(r42, "boxColorBg");
        Intrinsics.checkNotNullParameter(r43, "boxColorShadow");
        Intrinsics.checkNotNullParameter(r45, "coverToken");
        Intrinsics.checkNotNullParameter(r46, "coverDownloadUrl");
        Intrinsics.checkNotNullParameter(r47, "thumbnailExtra");
        Intrinsics.checkNotNullParameter(r53, "templateSource");
        Intrinsics.checkNotNullParameter(r56, "icon");
        this.id = r17;
        this.name = r18;
        this.objType = r19;
        this.objToken = r20;
        this.categoryId = r21;
        this.description = r22;
        this.source = r23;
        this.platform = r24;
        this.operationalLabel = r25;
        this.operationalLabelV2 = r26;
        this.heat = r27;
        this.authorName = r29;
        this.fromUserId = r30;
        this.userAvatarUrl = r31;
        this.userName = r32;
        this.bottomLabelType = r33;
        this.createTime = r34;
        this.updateTime = r36;
        this.shareTime = r38;
        this.lastUsedTime = r40;
        this.boxColorBg = r42;
        this.boxColorShadow = r43;
        this.displayType = r44;
        this.coverToken = r45;
        this.coverDownloadUrl = r46;
        this.thumbnailExtra = r47;
        this.enable = r48;
        this.templateType = r49;
        this.collectionId = r50;
        this.objTypes = r51;
        this.blankDocument = r52;
        this.templateSource = r53;
        this.effectiveStatus = r54;
        this.actionPreviewAndPerceive = r55;
        this.icon = r56;
    }

    public TemplateV4(String r42, String r43, int r44, String r45, String r46, String r47, int r48, String r49, String r50, String r51, long r52, String r54, String r55, String r56, String r57, int r58, long r59, long r61, long r63, long r65, String r67, String r68, int r69, String r70, String r71, ThumbnailExtra r72, boolean r73, int r74, String r75, List r76, boolean r77, String r78, int r79, int r80, String r81, int r82, int r83, DefaultConstructorMarker r84) {
        String r2 = "";
        if ((r82 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r82 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r82 & 4) == 0) goto L13;
        int r4 = sbb.e.g.b;
    L15:
        if ((r82 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r82 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r82 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r82 & 64) == 0) goto L29;
        int r8 = 0;
    L31:
        if ((r82 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r82 & 256) == 0) goto L37;
        String r11 = "";
    L39:
        if ((r82 & 512) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r82 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        long r16 = 0;
    L47:
        if ((r82 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        String r13 = "";
    L51:
        if ((r82 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        String r9 = "";
    L55:
        if ((r82 & 8192) == 0) goto L57;
        String r14 = "";
    L59:
        if ((r82 & 16384) == 0) goto L61;
        String r15 = "";
    L63:
        if ((r82 & 32768) == 0) goto L65;
        int r18 = 0;
    L67:
        if ((r82 & 65536) == 0) goto L69;
        long r19 = 0;
    L71:
        if ((r82 & 131072) == 0) goto L73;
        long r21 = 0;
    L75:
        if ((r82 & 262144) == 0) goto L77;
        long r23 = 0;
    L79:
        if ((r82 & 524288) == 0) goto L81;
        long r25 = 0;
    L83:
        if ((r82 & 1048576) == 0) goto L85;
        String r27 = "";
    L87:
        if ((r82 & 2097152) == 0) goto L89;
        String r28 = "";
    L90:
        int r30 = 1;
        if ((r82 & 4194304) == 0) goto L93;
        int r29 = 1;
    L95:
        if ((r82 & 8388608) == 0) goto L97;
        String r31 = "";
    L99:
        if ((r82 & 16777216) == 0) goto L101;
        String r32 = "";
    L103:
        if ((r82 & 33554432) == 0) goto L105;
        ThumbnailExtra r33 = new ThumbnailExtra(0, null, null, 7, null);
    L107:
        if ((r82 & 67108864) == 0) goto L109;
        boolean r34 = true;
    L111:
        if ((r82 & 134217728) == 0) goto L113;
        int r35 = 1;
    L115:
        if ((r82 & 268435456) == 0) goto L117;
        String r36 = null;
    L119:
        if ((r82 & 536870912) == 0) goto L121;
        List r37 = new ArrayList();
    L123:
        if ((r82 & 1073741824) == 0) goto L125;
        boolean r38 = false;
    L127:
        if ((r82 & Integer.MIN_VALUE) == 0) goto L129;
        String r0 = "";
    L131:
        if ((r83 & 1) == 0) goto L133;
        int r39 = 0;
    L135:
        if ((r83 & 2) != 0) goto L139;
        r30 = r80;
    L139:
        if ((r83 & 4) != 0) goto L142;
        r2 = r81;
    L142:
        this(r1, r3, r4, r5, r6, r7, r8, r10, r11, r12, r16, r13, r9, r14, r15, r18, r19, r21, r23, r25, r27, r28, r29, r31, r32, r33, r34, r35, r36, r37, r38, r0, r39, r30, r2);
        return;
    L133:
        r39 = r79;
        goto L135
    L129:
        r0 = r78;
        goto L131
    L125:
        r38 = r77;
        goto L127
    L121:
        r37 = r76;
        goto L123
    L117:
        r36 = r75;
        goto L119
    L113:
        r35 = r74;
        goto L115
    L109:
        r34 = r73;
        goto L111
    L105:
        r33 = r72;
        goto L107
    L101:
        r32 = r71;
        goto L103
    L97:
        r31 = r70;
        goto L99
    L93:
        r29 = r69;
        goto L95
    L89:
        r28 = r68;
        goto L90
    L85:
        r27 = r67;
        goto L87
    L81:
        r25 = r65;
        goto L83
    L77:
        r23 = r63;
        goto L79
    L73:
        r21 = r61;
        goto L75
    L69:
        r19 = r59;
        goto L71
    L65:
        r18 = r58;
        goto L67
    L61:
        r15 = r57;
        goto L63
    L57:
        r14 = r56;
        goto L59
    L53:
        r9 = r55;
        goto L55
    L49:
        r13 = r54;
        goto L51
    L45:
        r16 = r52;
        goto L47
    L41:
        r12 = r51;
        goto L43
    L37:
        r11 = r50;
        goto L39
    L33:
        r10 = r49;
        goto L35
    L29:
        r8 = r48;
        goto L31
    L25:
        r7 = r47;
        goto L27
    L21:
        r6 = r46;
        goto L23
    L17:
        r5 = r45;
        goto L19
    L13:
        r4 = r44;
        goto L15
    L9:
        r3 = r43;
        goto L11
    L5:
        r1 = r42;
        goto L7
    }
}
