package com.bytedance.ee.bear.share.export;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0098\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010#\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001a\u0010&\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010\u0011R\u001a\u0010)\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001a\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\u001a\u0010/\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001a\u00101\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u001a\u00103\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR\u001a\u00106\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u0010\u001fR\u001a\u00109\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R\u001a\u0010<\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017R\u001a\u0010?\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0015\"\u0004\bA\u0010\u0017R\u001a\u0010B\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017R\u001a\u0010E\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010\u0017R\u001a\u0010H\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0015\"\u0004\bJ\u0010\u0017R\u001a\u0010K\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0015\"\u0004\bM\u0010\u0017R\u001a\u0010N\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0015\"\u0004\bP\u0010\u0017R\u001a\u0010Q\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0015\"\u0004\bS\u0010\u0017R\u001a\u0010T\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u001d\"\u0004\bU\u0010\u001fR.\u0010V\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010Wj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R.\u0010]\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010Wj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010Z\"\u0004\b_\u0010\\R\u001a\u0010`\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u001d\"\u0004\bb\u0010\u001fR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010i\u001a\u0004\u0018\u00010jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0015\"\u0004\bq\u0010\u0017R\u001a\u0010r\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0015\"\u0004\bt\u0010\u0017R\u001a\u0010u\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u001d\"\u0004\bv\u0010\u001fR\u001a\u0010w\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0015\"\u0004\by\u0010\u0017R\u001a\u0010z\u001a\u00020{X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u001d\u0010\u0080\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u001d\"\u0005\b\u0081\u0001\u0010\u001fR\u001d\u0010\u0082\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u001d\"\u0005\b\u0084\u0001\u0010\u001fR\u001f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0015\"\u0005\b\u0087\u0001\u0010\u0017R$\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008c\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R$\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u0089\u0001\"\u0006\b\u008e\u0001\u0010\u008b\u0001R$\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008c\u0001\u001a\u0006\b\u008f\u0001\u0010\u0089\u0001\"\u0006\b\u0090\u0001\u0010\u008b\u0001R3\u0010\u0091\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010Wj\u000b\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u0001`XX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010Z\"\u0005\b\u0094\u0001\u0010\\R$\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008c\u0001\u001a\u0006\b\u0096\u0001\u0010\u0089\u0001\"\u0006\b\u0097\u0001\u0010\u008b\u0001¨\u0006\u0099\u0001"}, d2 = {"Lcom/bytedance/ee/bear/share/export/ShareParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "activity", "Landroidx/fragment/app/FragmentActivity;", "sourceFragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getSourceFragment", "()Landroidx/fragment/app/Fragment;", "source", "", "getSource", "()I", "setSource", "(I)V", ResourceData.KEY_TOKEN, "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", ResourceData.KEY_TYPE, "getType", "setType", "isOwner", "", "()Z", "setOwner", "(Z)V", ResourceData.KEY_URL, "getUrl", "setUrl", "realToken", "getRealToken", "setRealToken", "realType", "getRealType", "setRealType", "docName", "getDocName", "setDocName", "module", "getModule", "setModule", "isWiki", "setWiki", "isPhoenix", "setPhoenix", "passwordSharingEnable", "getPasswordSharingEnable", "setPasswordSharingEnable", "transferOwnerEnable", "getTransferOwnerEnable", "setTransferOwnerEnable", "originUrl", "getOriginUrl", "setOriginUrl", "createTime", "getCreateTime", "setCreateTime", "ownerUid", "getOwnerUid", "setOwnerUid", "subModule", "getSubModule", "setSubModule", "docContent", "getDocContent", "setDocContent", "docTopic", "getDocTopic", "setDocTopic", "mindnoteViewType", "getMindnoteViewType", "setMindnoteViewType", "subType", "getSubType", "setSubType", "feedId", "getFeedId", "setFeedId", "isAtVC", "setAtVC", "disabledShareTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDisabledShareTypes", "()Ljava/util/ArrayList;", "setDisabledShareTypes", "(Ljava/util/ArrayList;)V", "badgeShareTypes", "getBadgeShareTypes", "setBadgeShareTypes", "showExportImage", "getShowExportImage", "setShowExportImage", "exportImageRunnable", "Ljava/lang/Runnable;", "getExportImageRunnable", "()Ljava/lang/Runnable;", "setExportImageRunnable", "(Ljava/lang/Runnable;)V", "channelHandlers", "Lcom/bytedance/ee/bear/share/export/ShareChannelHandlers;", "getChannelHandlers", "()Lcom/bytedance/ee/bear/share/export/ShareChannelHandlers;", "setChannelHandlers", "(Lcom/bytedance/ee/bear/share/export/ShareChannelHandlers;)V", "ownerName", "getOwnerName", "setOwnerName", "spaceId", "getSpaceId", "setSpaceId", "isShareRoot", "setShareRoot", "ownerTenantId", "getOwnerTenantId", "setOwnerTenantId", "folderVersion", "Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "getFolderVersion", "()Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "setFolderVersion", "(Lcom/bytedance/ee/bear/list/dto/FolderVersion;)V", "isWikiShortcutInSpace", "setWikiShortcutInSpace", "adminPerceiveControl", "getAdminPerceiveControl", "setAdminPerceiveControl", "editionId", "getEditionId", "setEditionId", "isPro", "()Ljava/lang/Boolean;", "setPro", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isFa", "setFa", "isProAccessConfigBindRole", "setProAccessConfigBindRole", "bitableRoleMembers", "Lcom/bytedance/ee/bear/share/export/BitableShareRoleMember;", "getBitableRoleMembers", "setBitableRoleMembers", "expandAtInit", "getExpandAtInit", "setExpandAtInit", "ShareParamsBuilder", "features-share-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShareParams implements NonProguard {
    private final transient FragmentActivity activity;
    private boolean adminPerceiveControl;
    private ArrayList<Integer> badgeShareTypes;
    private ArrayList<BitableShareRoleMember> bitableRoleMembers;
    private transient n channelHandlers;
    private String createTime;
    private ArrayList<Integer> disabledShareTypes;
    private String docContent;
    private String docName;
    private String docTopic;
    private String editionId;
    private Boolean expandAtInit;
    private Runnable exportImageRunnable;
    private String feedId;
    private FolderVersion folderVersion;
    private boolean isAtVC;
    private Boolean isFa;
    private boolean isOwner;
    private boolean isPhoenix;
    private Boolean isPro;
    private Boolean isProAccessConfigBindRole;
    private boolean isShareRoot;
    private boolean isWiki;
    private boolean isWikiShortcutInSpace;
    private String mindnoteViewType;
    private String module;
    private String originUrl;
    private String ownerName;
    private String ownerTenantId;
    private String ownerUid;
    private boolean passwordSharingEnable;
    private String realToken;
    private int realType;
    private boolean showExportImage;
    private int source;
    private final transient Fragment sourceFragment;
    private String spaceId;
    private String subModule;
    private String subType;
    private String token;
    private boolean transferOwnerEnable;
    private int type;
    private String url;

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\"\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010#\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u0010\u0010&\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010'\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010(\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010)\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010*\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010+\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010,\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010-\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010.\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\"\u00100\u001a\u00020\u00002\u001a\u0010^\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u000101j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`2J\"\u00103\u001a\u00020\u00002\u001a\u0010^\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u000101j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`2J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u0010\u00104\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u00109\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u0010\u0010>\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010A\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010BJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\rJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u000e\u0010_\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0016J\u0010\u0010L\u001a\u00020\u00002\b\u0010`\u001a\u0004\u0018\u00010\u0013J\u0015\u0010T\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010aJ\u0015\u0010O\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010aJ\u0015\u0010V\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010aJ\"\u0010X\u001a\u00020\u00002\u001a\u0010^\u001a\u0016\u0012\u0004\u0012\u00020Y\u0018\u000101j\n\u0012\u0004\u0012\u00020Y\u0018\u0001`2J\u0010\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0004J\b\u0010f\u001a\u00020eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u000e\u0010\"\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00100\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u000101j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`2X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00103\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u000101j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`2X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u001a\u0010<\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u0010\u001eR\u001a\u0010>\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00106\"\u0004\b@\u00108R\u001a\u0010A\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001c\"\u0004\bH\u0010\u001eR\u001a\u0010I\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001c\"\u0004\bK\u0010\u001eR\u001c\u0010L\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00106\"\u0004\bN\u00108R\u001e\u0010O\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010T\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR\u001e\u0010V\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bV\u0010P\"\u0004\bW\u0010RR.\u0010X\u001a\u0016\u0012\u0004\u0012\u00020Y\u0018\u000101j\n\u0012\u0004\u0012\u00020Y\u0018\u0001`2X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006g"}, d2 = {"Lcom/bytedance/ee/bear/share/export/ShareParams$ShareParamsBuilder;", "Lcom/bytedance/ee/util/io/NonProguard;", "activity", "Landroidx/fragment/app/FragmentActivity;", "sourceFragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getSourceFragment", "()Landroidx/fragment/app/Fragment;", "source", "", "getSource", "()I", "setSource", "(I)V", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "isOwner", "", ResourceData.KEY_URL, "realToken", "realType", "passwordSharingEnable", "getPasswordSharingEnable", "()Z", "setPasswordSharingEnable", "(Z)V", "transferOwnerEnable", "getTransferOwnerEnable", "setTransferOwnerEnable", "docName", "module", "isWiki", "isPhoenix", "originUrl", "createTime", "ownerUid", "subModule", "docContent", "docTopic", "mindnoteViewType", "subType", "feedId", "isAtVC", "disabledShareTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "badgeShareTypes", "ownerName", "getOwnerName", "()Ljava/lang/String;", "setOwnerName", "(Ljava/lang/String;)V", "spaceId", "getSpaceId", "setSpaceId", "isShareRoot", "setShareRoot", "ownerTenantId", "getOwnerTenantId", "setOwnerTenantId", "folderVersion", "Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "getFolderVersion", "()Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "setFolderVersion", "(Lcom/bytedance/ee/bear/list/dto/FolderVersion;)V", "isWikiShortcutInSpace", "setWikiShortcutInSpace", "adminPerceiveControl", "getAdminPerceiveControl", "setAdminPerceiveControl", "editionId", "getEditionId", "setEditionId", "isPro", "()Ljava/lang/Boolean;", "setPro", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isFa", "setFa", "isProAccessConfigBindRole", "setProAccessConfigBindRole", "bitableRoleMembers", "Lcom/bytedance/ee/bear/share/export/BitableShareRoleMember;", "getBitableRoleMembers", "()Ljava/util/ArrayList;", "setBitableRoleMembers", "(Ljava/util/ArrayList;)V", "value", "wikiShortcutInSpace", ResourceData.KEY_ID, "(Ljava/lang/Boolean;)Lcom/bytedance/ee/bear/share/export/ShareParams$ShareParamsBuilder;", "apply", "", "params", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "build", "features-share-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class ShareParamsBuilder implements NonProguard {
        private final transient FragmentActivity activity;
        private boolean adminPerceiveControl;
        private ArrayList<Integer> badgeShareTypes;
        private ArrayList<BitableShareRoleMember> bitableRoleMembers;
        private String createTime;
        private ArrayList<Integer> disabledShareTypes;
        private String docContent;
        private String docName;
        private String docTopic;
        private String editionId;
        private String feedId;
        private FolderVersion folderVersion;
        private boolean isAtVC;
        private Boolean isFa;
        private boolean isOwner;
        private boolean isPhoenix;
        private Boolean isPro;
        private Boolean isProAccessConfigBindRole;
        private boolean isShareRoot;
        private boolean isWiki;
        private boolean isWikiShortcutInSpace;
        private String mindnoteViewType;
        private String module;
        private String originUrl;
        private String ownerName;
        private String ownerTenantId;
        private String ownerUid;
        private boolean passwordSharingEnable;
        private String realToken;
        private int realType;
        private int source;
        private final transient Fragment sourceFragment;
        private String spaceId;
        private String subModule;
        private String subType;
        private String token;
        private boolean transferOwnerEnable;
        private int type;
        private String url;

        public ShareParamsBuilder(FragmentActivity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Fragment r0 = null;
            this(r3, r0, 2, r0);
        }

        public ShareParams build() {
            ShareParams r0 = new ShareParams(this.activity, this.sourceFragment);
            apply(r0);
            return r0;
        }

        public final FragmentActivity getActivity() {
            return this.activity;
        }

        public final boolean getAdminPerceiveControl() {
            return this.adminPerceiveControl;
        }

        public final ArrayList<BitableShareRoleMember> getBitableRoleMembers() {
            return this.bitableRoleMembers;
        }

        public final String getEditionId() {
            return this.editionId;
        }

        public final FolderVersion getFolderVersion() {
            return this.folderVersion;
        }

        public final String getOwnerName() {
            return this.ownerName;
        }

        public final String getOwnerTenantId() {
            return this.ownerTenantId;
        }

        public final boolean getPasswordSharingEnable() {
            return this.passwordSharingEnable;
        }

        public final int getSource() {
            return this.source;
        }

        public final Fragment getSourceFragment() {
            return this.sourceFragment;
        }

        public final String getSpaceId() {
            return this.spaceId;
        }

        public final boolean getTransferOwnerEnable() {
            return this.transferOwnerEnable;
        }

        public final Boolean isFa() {
            return this.isFa;
        }

        public final Boolean isPro() {
            return this.isPro;
        }

        public final Boolean isProAccessConfigBindRole() {
            return this.isProAccessConfigBindRole;
        }

        public final boolean isShareRoot() {
            return this.isShareRoot;
        }

        public final boolean isWikiShortcutInSpace() {
            return this.isWikiShortcutInSpace;
        }

        public final ShareParamsBuilder adminPerceiveControl(boolean r1) {
            this.adminPerceiveControl = r1;
            return this;
        }

        public final void apply(ShareParams r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            r2.setToken(this.token);
            r2.setType(this.type);
            r2.setRealToken(this.realToken);
            r2.setRealType(this.realType);
            r2.setOwner(this.isOwner);
            r2.setUrl(this.url);
            r2.setDocName(this.docName);
            r2.setModule(this.module);
            r2.setWiki(this.isWiki);
            r2.setPhoenix(this.isPhoenix);
            r2.setOriginUrl(this.originUrl);
            r2.setCreateTime(this.createTime);
            r2.setOwnerUid(this.ownerUid);
            r2.setSubModule(this.subModule);
            r2.setDocContent(this.docContent);
            r2.setDocTopic(this.docTopic);
            r2.setMindnoteViewType(this.mindnoteViewType);
            r2.setSubType(this.subType);
            r2.setFeedId(this.feedId);
            r2.setAtVC(this.isAtVC);
            r2.setDisabledShareTypes(this.disabledShareTypes);
            r2.setBadgeShareTypes(this.badgeShareTypes);
            r2.setPasswordSharingEnable(this.passwordSharingEnable);
            r2.setTransferOwnerEnable(this.transferOwnerEnable);
            r2.setOwnerName(this.ownerName);
            r2.setSpaceId(this.spaceId);
            r2.setShareRoot(this.isShareRoot);
            r2.setOwnerTenantId(this.ownerTenantId);
            r2.setFolderVersion(this.folderVersion);
            r2.setWikiShortcutInSpace(this.isWikiShortcutInSpace);
            r2.setAdminPerceiveControl(this.adminPerceiveControl);
            r2.setSource(this.source);
            r2.setEditionId(this.editionId);
            r2.setPro(this.isPro);
            r2.setFa(this.isFa);
            r2.setProAccessConfigBindRole(this.isProAccessConfigBindRole);
            r2.setBitableRoleMembers(this.bitableRoleMembers);
            if (this.originUrl.length() != 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L9;
            this.originUrl = this.url;
            return;
        L9:
            return;
        L5:
            r3 = false;
            goto L6
        }

        public final ShareParamsBuilder badgeShareTypes(ArrayList<Integer> r1) {
            this.badgeShareTypes = r1;
            return this;
        }

        public final ShareParamsBuilder bitableRoleMembers(ArrayList<BitableShareRoleMember> r1) {
            this.bitableRoleMembers = r1;
            return this;
        }

        public final ShareParamsBuilder createTime(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.createTime = r1;
            return this;
        }

        public final ShareParamsBuilder disabledShareTypes(ArrayList<Integer> r1) {
            this.disabledShareTypes = r1;
            return this;
        }

        public final ShareParamsBuilder docContent(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.docContent = r1;
            return this;
        }

        public final ShareParamsBuilder docName(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.docName = r1;
            return this;
        }

        public final ShareParamsBuilder docTopic(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.docTopic = r1;
            return this;
        }

        public final ShareParamsBuilder editionId(String r1) {
            this.editionId = r1;
            return this;
        }

        public final ShareParamsBuilder feedId(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.feedId = r1;
            return this;
        }

        public final ShareParamsBuilder folderVersion(FolderVersion r7) {
            if (r7 != null) goto L4;
            r7 = new FolderVersion(0, 0, false, 7, null);
        L4:
            this.folderVersion = r7;
            return this;
        }

        public final ShareParamsBuilder isAtVC(boolean r1) {
            this.isAtVC = r1;
            return this;
        }

        public final ShareParamsBuilder isFa(Boolean r1) {
            this.isFa = r1;
            return this;
        }

        public final ShareParamsBuilder isOwner(boolean r1) {
            this.isOwner = r1;
            return this;
        }

        public final ShareParamsBuilder isPhoenix(boolean r1) {
            this.isPhoenix = r1;
            return this;
        }

        public final ShareParamsBuilder isPro(Boolean r1) {
            this.isPro = r1;
            return this;
        }

        public final ShareParamsBuilder isProAccessConfigBindRole(Boolean r1) {
            this.isProAccessConfigBindRole = r1;
            return this;
        }

        public final ShareParamsBuilder isShareRoot(boolean r1) {
            this.isShareRoot = r1;
            return this;
        }

        public final ShareParamsBuilder isWiki(boolean r1) {
            this.isWiki = r1;
            return this;
        }

        public final ShareParamsBuilder mindnoteViewType(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.mindnoteViewType = r1;
            return this;
        }

        public final ShareParamsBuilder module(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.module = r1;
            return this;
        }

        public final ShareParamsBuilder originUrl(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.originUrl = r1;
            return this;
        }

        public final ShareParamsBuilder ownerName(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.ownerName = r1;
            return this;
        }

        public final ShareParamsBuilder ownerTenantId(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.ownerTenantId = r1;
            return this;
        }

        public final ShareParamsBuilder ownerUid(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.ownerUid = r1;
            return this;
        }

        public final ShareParamsBuilder passwordSharingEnable(boolean r1) {
            this.passwordSharingEnable = r1;
            return this;
        }

        public final ShareParamsBuilder realToken(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.realToken = r1;
            return this;
        }

        public final ShareParamsBuilder realType(int r1) {
            this.realType = r1;
            return this;
        }

        public final void setAdminPerceiveControl(boolean r1) {
            this.adminPerceiveControl = r1;
        }

        public final void setBitableRoleMembers(ArrayList<BitableShareRoleMember> r1) {
            this.bitableRoleMembers = r1;
        }

        public final void setEditionId(String r1) {
            this.editionId = r1;
        }

        public final void setFa(Boolean r1) {
            this.isFa = r1;
        }

        public final void setFolderVersion(FolderVersion r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.folderVersion = r2;
        }

        public final void setOwnerName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.ownerName = r2;
        }

        public final void setOwnerTenantId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.ownerTenantId = r2;
        }

        public final void setPasswordSharingEnable(boolean r1) {
            this.passwordSharingEnable = r1;
        }

        public final void setPro(Boolean r1) {
            this.isPro = r1;
        }

        public final void setProAccessConfigBindRole(Boolean r1) {
            this.isProAccessConfigBindRole = r1;
        }

        public final void setShareRoot(boolean r1) {
            this.isShareRoot = r1;
        }

        public final void setSource(int r1) {
            this.source = r1;
        }

        public final void setSpaceId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.spaceId = r2;
        }

        public final void setTransferOwnerEnable(boolean r1) {
            this.transferOwnerEnable = r1;
        }

        public final void setWikiShortcutInSpace(boolean r1) {
            this.isWikiShortcutInSpace = r1;
        }

        public final ShareParamsBuilder source(int r1) {
            this.source = r1;
            return this;
        }

        public final ShareParamsBuilder spaceId(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.spaceId = r1;
            return this;
        }

        public final ShareParamsBuilder subModule(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.subModule = r1;
            return this;
        }

        public final ShareParamsBuilder subType(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.subType = r1;
            return this;
        }

        public final ShareParamsBuilder token(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.token = r1;
            return this;
        }

        public final ShareParamsBuilder transferOwnerEnable(boolean r1) {
            this.transferOwnerEnable = r1;
            return this;
        }

        public final ShareParamsBuilder type(int r1) {
            this.type = r1;
            return this;
        }

        public final ShareParamsBuilder url(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.url = r1;
            return this;
        }

        public final ShareParamsBuilder wikiShortcutInSpace(boolean r1) {
            this.isWikiShortcutInSpace = r1;
            return this;
        }

        public ShareParamsBuilder(FragmentActivity r7, Fragment r8) {
            Intrinsics.checkNotNullParameter(r7, "activity");
            this.activity = r7;
            this.sourceFragment = r8;
            this.token = "";
            this.url = "";
            this.realToken = "";
            this.passwordSharingEnable = true;
            this.transferOwnerEnable = true;
            this.docName = "";
            this.module = "";
            this.originUrl = "";
            this.createTime = "";
            this.ownerUid = "";
            this.subModule = "";
            this.docContent = "";
            this.docTopic = "";
            this.mindnoteViewType = "";
            this.subType = "";
            this.feedId = "";
            this.ownerName = "";
            this.spaceId = "";
            this.ownerTenantId = "";
            this.folderVersion = new FolderVersion(0, 0, false, 7, null);
        }

        public /* synthetic */ ShareParamsBuilder(FragmentActivity r1, Fragment r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }
    }

    public ShareParams(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Fragment r0 = null;
        this(r3, r0, 2, r0);
    }

    public final n getChannelHandlers() {
        return null;
    }

    public final void setChannelHandlers(n r1) {
    }

    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public final boolean getAdminPerceiveControl() {
        return this.adminPerceiveControl;
    }

    public final ArrayList<Integer> getBadgeShareTypes() {
        return this.badgeShareTypes;
    }

    public final ArrayList<BitableShareRoleMember> getBitableRoleMembers() {
        return this.bitableRoleMembers;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final ArrayList<Integer> getDisabledShareTypes() {
        return this.disabledShareTypes;
    }

    public final String getDocContent() {
        return this.docContent;
    }

    public final String getDocName() {
        return this.docName;
    }

    public final String getDocTopic() {
        return this.docTopic;
    }

    public final String getEditionId() {
        return this.editionId;
    }

    public final Boolean getExpandAtInit() {
        return this.expandAtInit;
    }

    public final Runnable getExportImageRunnable() {
        return this.exportImageRunnable;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final FolderVersion getFolderVersion() {
        return this.folderVersion;
    }

    public final String getMindnoteViewType() {
        return this.mindnoteViewType;
    }

    public final String getModule() {
        return this.module;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final String getOwnerTenantId() {
        return this.ownerTenantId;
    }

    public final String getOwnerUid() {
        return this.ownerUid;
    }

    public final boolean getPasswordSharingEnable() {
        return this.passwordSharingEnable;
    }

    public final String getRealToken() {
        return this.realToken;
    }

    public final int getRealType() {
        return this.realType;
    }

    public final boolean getShowExportImage() {
        return this.showExportImage;
    }

    public final int getSource() {
        return this.source;
    }

    public final Fragment getSourceFragment() {
        return this.sourceFragment;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final String getSubModule() {
        return this.subModule;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final String getToken() {
        return this.token;
    }

    public final boolean getTransferOwnerEnable() {
        return this.transferOwnerEnable;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isAtVC() {
        return this.isAtVC;
    }

    public final Boolean isFa() {
        return this.isFa;
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public final boolean isPhoenix() {
        return this.isPhoenix;
    }

    public final Boolean isPro() {
        return this.isPro;
    }

    public final Boolean isProAccessConfigBindRole() {
        return this.isProAccessConfigBindRole;
    }

    public final boolean isShareRoot() {
        return this.isShareRoot;
    }

    public final boolean isWiki() {
        return this.isWiki;
    }

    public final boolean isWikiShortcutInSpace() {
        return this.isWikiShortcutInSpace;
    }

    public final void setAdminPerceiveControl(boolean r1) {
        this.adminPerceiveControl = r1;
    }

    public final void setAtVC(boolean r1) {
        this.isAtVC = r1;
    }

    public final void setBadgeShareTypes(ArrayList<Integer> r1) {
        this.badgeShareTypes = r1;
    }

    public final void setBitableRoleMembers(ArrayList<BitableShareRoleMember> r1) {
        this.bitableRoleMembers = r1;
    }

    public final void setCreateTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.createTime = r2;
    }

    public final void setDisabledShareTypes(ArrayList<Integer> r1) {
        this.disabledShareTypes = r1;
    }

    public final void setDocContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.docContent = r2;
    }

    public final void setDocName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.docName = r2;
    }

    public final void setDocTopic(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.docTopic = r2;
    }

    public final void setEditionId(String r1) {
        this.editionId = r1;
    }

    public final void setExpandAtInit(Boolean r1) {
        this.expandAtInit = r1;
    }

    public final void setExportImageRunnable(Runnable r1) {
        this.exportImageRunnable = r1;
    }

    public final void setFa(Boolean r1) {
        this.isFa = r1;
    }

    public final void setFeedId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.feedId = r2;
    }

    public final void setFolderVersion(FolderVersion r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.folderVersion = r2;
    }

    public final void setMindnoteViewType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mindnoteViewType = r2;
    }

    public final void setModule(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.module = r2;
    }

    public final void setOriginUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.originUrl = r2;
    }

    public final void setOwner(boolean r1) {
        this.isOwner = r1;
    }

    public final void setOwnerName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ownerName = r2;
    }

    public final void setOwnerTenantId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ownerTenantId = r2;
    }

    public final void setOwnerUid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ownerUid = r2;
    }

    public final void setPasswordSharingEnable(boolean r1) {
        this.passwordSharingEnable = r1;
    }

    public final void setPhoenix(boolean r1) {
        this.isPhoenix = r1;
    }

    public final void setPro(Boolean r1) {
        this.isPro = r1;
    }

    public final void setProAccessConfigBindRole(Boolean r1) {
        this.isProAccessConfigBindRole = r1;
    }

    public final void setRealToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.realToken = r2;
    }

    public final void setRealType(int r1) {
        this.realType = r1;
    }

    public final void setShareRoot(boolean r1) {
        this.isShareRoot = r1;
    }

    public final void setShowExportImage(boolean r1) {
        this.showExportImage = r1;
    }

    public final void setSource(int r1) {
        this.source = r1;
    }

    public final void setSpaceId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.spaceId = r2;
    }

    public final void setSubModule(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.subModule = r2;
    }

    public final void setSubType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.subType = r2;
    }

    public final void setToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.token = r2;
    }

    public final void setTransferOwnerEnable(boolean r1) {
        this.transferOwnerEnable = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final void setUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.url = r2;
    }

    public final void setWiki(boolean r1) {
        this.isWiki = r1;
    }

    public final void setWikiShortcutInSpace(boolean r1) {
        this.isWikiShortcutInSpace = r1;
    }

    public ShareParams(FragmentActivity r7, Fragment r8) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        this.activity = r7;
        this.sourceFragment = r8;
        this.token = "";
        this.url = "";
        this.realToken = "";
        this.docName = "";
        this.module = "";
        this.passwordSharingEnable = true;
        this.transferOwnerEnable = true;
        this.originUrl = "";
        this.createTime = "";
        this.ownerUid = "";
        this.subModule = "";
        this.docContent = "";
        this.docTopic = "";
        this.mindnoteViewType = "";
        this.subType = "";
        this.feedId = "";
        this.ownerName = "";
        this.spaceId = "";
        this.ownerTenantId = "";
        this.folderVersion = new FolderVersion(0, 0, false, 7, null);
    }

    public /* synthetic */ ShareParams(FragmentActivity r1, Fragment r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
