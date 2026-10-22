package com.bytedance.ee.bear.share.export;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0098\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010#\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001a\u0010&\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010\u0011R\u001a\u0010)\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001a\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\u001a\u0010/\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001a\u00101\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u001a\u00103\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR\u001a\u00106\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u0010\u001fR\u001a\u00109\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R\u001a\u0010<\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017R\u001a\u0010?\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0015\"\u0004\bA\u0010\u0017R\u001a\u0010B\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017R\u001a\u0010E\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010\u0017R\u001a\u0010H\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0015\"\u0004\bJ\u0010\u0017R\u001a\u0010K\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0015\"\u0004\bM\u0010\u0017R\u001a\u0010N\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0015\"\u0004\bP\u0010\u0017R\u001a\u0010Q\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0015\"\u0004\bS\u0010\u0017R\u001a\u0010T\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u001d\"\u0004\bU\u0010\u001fR.\u0010V\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010Wj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R.\u0010]\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010Wj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010Z\"\u0004\b_\u0010\\R\u001a\u0010`\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u001d\"\u0004\bb\u0010\u001fR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010i\u001a\u0004\u0018\u00010jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0015\"\u0004\bq\u0010\u0017R\u001a\u0010r\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0015\"\u0004\bt\u0010\u0017R\u001a\u0010u\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u001d\"\u0004\bv\u0010\u001fR\u001a\u0010w\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0015\"\u0004\by\u0010\u0017R\u001a\u0010z\u001a\u00020{X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u001d\u0010\u0080\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u001d\"\u0005\b\u0081\u0001\u0010\u001fR\u001d\u0010\u0082\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u001d\"\u0005\b\u0084\u0001\u0010\u001fR\u001f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0015\"\u0005\b\u0087\u0001\u0010\u0017R$\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008c\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R$\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u0089\u0001\"\u0006\b\u008e\u0001\u0010\u008b\u0001R$\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008c\u0001\u001a\u0006\b\u008f\u0001\u0010\u0089\u0001\"\u0006\b\u0090\u0001\u0010\u008b\u0001R3\u0010\u0091\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010Wj\u000b\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u0001`XX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010Z\"\u0005\b\u0094\u0001\u0010\\R$\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008c\u0001\u001a\u0006\b\u0096\u0001\u0010\u0089\u0001\"\u0006\b\u0097\u0001\u0010\u008b\u0001¨\u0006\u0099\u0001"}, d2 = {"Lcom/bytedance/ee/bear/share/export/ShareParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "activity", "Landroidx/fragment/app/FragmentActivity;", "sourceFragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getSourceFragment", "()Landroidx/fragment/app/Fragment;", "source", "", "getSource", "()I", "setSource", "(I)V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "type", "getType", "setType", "isOwner", "", "()Z", "setOwner", "(Z)V", "url", "getUrl", "setUrl", "realToken", "getRealToken", "setRealToken", "realType", "getRealType", "setRealType", "docName", "getDocName", "setDocName", EventConstant.Key.MODULE, "getModule", "setModule", "isWiki", "setWiki", "isPhoenix", "setPhoenix", "passwordSharingEnable", "getPasswordSharingEnable", "setPasswordSharingEnable", "transferOwnerEnable", "getTransferOwnerEnable", "setTransferOwnerEnable", "originUrl", "getOriginUrl", "setOriginUrl", "createTime", "getCreateTime", "setCreateTime", "ownerUid", "getOwnerUid", "setOwnerUid", "subModule", "getSubModule", "setSubModule", "docContent", "getDocContent", "setDocContent", "docTopic", "getDocTopic", "setDocTopic", "mindnoteViewType", "getMindnoteViewType", "setMindnoteViewType", "subType", "getSubType", "setSubType", "feedId", "getFeedId", "setFeedId", "isAtVC", "setAtVC", "disabledShareTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDisabledShareTypes", "()Ljava/util/ArrayList;", "setDisabledShareTypes", "(Ljava/util/ArrayList;)V", "badgeShareTypes", "getBadgeShareTypes", "setBadgeShareTypes", "showExportImage", "getShowExportImage", "setShowExportImage", "exportImageRunnable", "Ljava/lang/Runnable;", "getExportImageRunnable", "()Ljava/lang/Runnable;", "setExportImageRunnable", "(Ljava/lang/Runnable;)V", "channelHandlers", "Lcom/bytedance/ee/bear/share/export/ShareChannelHandlers;", "getChannelHandlers", "()Lcom/bytedance/ee/bear/share/export/ShareChannelHandlers;", "setChannelHandlers", "(Lcom/bytedance/ee/bear/share/export/ShareChannelHandlers;)V", "ownerName", "getOwnerName", "setOwnerName", "spaceId", "getSpaceId", "setSpaceId", "isShareRoot", "setShareRoot", "ownerTenantId", "getOwnerTenantId", "setOwnerTenantId", "folderVersion", "Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "getFolderVersion", "()Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "setFolderVersion", "(Lcom/bytedance/ee/bear/list/dto/FolderVersion;)V", "isWikiShortcutInSpace", "setWikiShortcutInSpace", "adminPerceiveControl", "getAdminPerceiveControl", "setAdminPerceiveControl", "editionId", "getEditionId", "setEditionId", "isPro", "()Ljava/lang/Boolean;", "setPro", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isFa", "setFa", "isProAccessConfigBindRole", "setProAccessConfigBindRole", "bitableRoleMembers", "Lcom/bytedance/ee/bear/share/export/BitableShareRoleMember;", "getBitableRoleMembers", "setBitableRoleMembers", "expandAtInit", "getExpandAtInit", "setExpandAtInit", "ShareParamsBuilder", "features-share-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\"\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010#\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u0010\u0010&\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010'\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010(\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010)\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010*\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010+\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010,\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010-\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010.\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\"\u00100\u001a\u00020\u00002\u001a\u0010^\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u000101j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`2J\"\u00103\u001a\u00020\u00002\u001a\u0010^\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u000101j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`2J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u0010\u00104\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u00109\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u0010\u0010>\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0013J\u0010\u0010A\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010BJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\rJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u0016J\u000e\u0010_\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0016J\u0010\u0010L\u001a\u00020\u00002\b\u0010`\u001a\u0004\u0018\u00010\u0013J\u0015\u0010T\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010aJ\u0015\u0010O\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010aJ\u0015\u0010V\u001a\u00020\u00002\b\u0010^\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010aJ\"\u0010X\u001a\u00020\u00002\u001a\u0010^\u001a\u0016\u0012\u0004\u0012\u00020Y\u0018\u000101j\n\u0012\u0004\u0012\u00020Y\u0018\u0001`2J\u0010\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0004J\b\u0010f\u001a\u00020eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u000e\u0010\"\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00100\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u000101j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`2X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00103\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u000101j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`2X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u001a\u0010<\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u0010\u001eR\u001a\u0010>\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00106\"\u0004\b@\u00108R\u001a\u0010A\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001c\"\u0004\bH\u0010\u001eR\u001a\u0010I\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001c\"\u0004\bK\u0010\u001eR\u001c\u0010L\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00106\"\u0004\bN\u00108R\u001e\u0010O\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010T\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR\u001e\u0010V\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bV\u0010P\"\u0004\bW\u0010RR.\u0010X\u001a\u0016\u0012\u0004\u0012\u00020Y\u0018\u000101j\n\u0012\u0004\u0012\u00020Y\u0018\u0001`2X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006g"}, d2 = {"Lcom/bytedance/ee/bear/share/export/ShareParams$ShareParamsBuilder;", "Lcom/bytedance/ee/util/io/NonProguard;", "activity", "Landroidx/fragment/app/FragmentActivity;", "sourceFragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getSourceFragment", "()Landroidx/fragment/app/Fragment;", "source", "", "getSource", "()I", "setSource", "(I)V", "token", "", "type", "isOwner", "", "url", "realToken", "realType", "passwordSharingEnable", "getPasswordSharingEnable", "()Z", "setPasswordSharingEnable", "(Z)V", "transferOwnerEnable", "getTransferOwnerEnable", "setTransferOwnerEnable", "docName", EventConstant.Key.MODULE, "isWiki", "isPhoenix", "originUrl", "createTime", "ownerUid", "subModule", "docContent", "docTopic", "mindnoteViewType", "subType", "feedId", "isAtVC", "disabledShareTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "badgeShareTypes", "ownerName", "getOwnerName", "()Ljava/lang/String;", "setOwnerName", "(Ljava/lang/String;)V", "spaceId", "getSpaceId", "setSpaceId", "isShareRoot", "setShareRoot", "ownerTenantId", "getOwnerTenantId", "setOwnerTenantId", "folderVersion", "Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "getFolderVersion", "()Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "setFolderVersion", "(Lcom/bytedance/ee/bear/list/dto/FolderVersion;)V", "isWikiShortcutInSpace", "setWikiShortcutInSpace", "adminPerceiveControl", "getAdminPerceiveControl", "setAdminPerceiveControl", "editionId", "getEditionId", "setEditionId", "isPro", "()Ljava/lang/Boolean;", "setPro", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isFa", "setFa", "isProAccessConfigBindRole", "setProAccessConfigBindRole", "bitableRoleMembers", "Lcom/bytedance/ee/bear/share/export/BitableShareRoleMember;", "getBitableRoleMembers", "()Ljava/util/ArrayList;", "setBitableRoleMembers", "(Ljava/util/ArrayList;)V", "value", "wikiShortcutInSpace", "id", "(Ljava/lang/Boolean;)Lcom/bytedance/ee/bear/share/export/ShareParams$ShareParamsBuilder;", e1.REPLY_ACTION_APPLY, "", "params", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "build", "features-share-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        /* JADX WARN: Multi-variable type inference failed */
        public ShareParamsBuilder(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this(r100, null, 2, 0 == true ? 1 : 0);
        }

        public ShareParams build() {
            ShareParams r100 = new ShareParams(this.activity, this.sourceFragment);
            apply(r100);
            return r100;
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

        public final ShareParamsBuilder adminPerceiveControl(boolean r100) {
            this.adminPerceiveControl = r100;
            return this;
        }

        public final void apply(ShareParams r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            r100.setToken(this.token);
            r100.setType(this.type);
            r100.setRealToken(this.realToken);
            r100.setRealType(this.realType);
            r100.setOwner(this.isOwner);
            r100.setUrl(this.url);
            r100.setDocName(this.docName);
            r100.setModule(this.module);
            r100.setWiki(this.isWiki);
            r100.setPhoenix(this.isPhoenix);
            r100.setOriginUrl(this.originUrl);
            r100.setCreateTime(this.createTime);
            r100.setOwnerUid(this.ownerUid);
            r100.setSubModule(this.subModule);
            r100.setDocContent(this.docContent);
            r100.setDocTopic(this.docTopic);
            r100.setMindnoteViewType(this.mindnoteViewType);
            r100.setSubType(this.subType);
            r100.setFeedId(this.feedId);
            r100.setAtVC(this.isAtVC);
            r100.setDisabledShareTypes(this.disabledShareTypes);
            r100.setBadgeShareTypes(this.badgeShareTypes);
            r100.setPasswordSharingEnable(this.passwordSharingEnable);
            r100.setTransferOwnerEnable(this.transferOwnerEnable);
            r100.setOwnerName(this.ownerName);
            r100.setSpaceId(this.spaceId);
            r100.setShareRoot(this.isShareRoot);
            r100.setOwnerTenantId(this.ownerTenantId);
            r100.setFolderVersion(this.folderVersion);
            r100.setWikiShortcutInSpace(this.isWikiShortcutInSpace);
            r100.setAdminPerceiveControl(this.adminPerceiveControl);
            r100.setSource(this.source);
            r100.setEditionId(this.editionId);
            r100.setPro(this.isPro);
            r100.setFa(this.isFa);
            r100.setProAccessConfigBindRole(this.isProAccessConfigBindRole);
            r100.setBitableRoleMembers(this.bitableRoleMembers);
            if (this.originUrl.length() != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L9;
            this.originUrl = this.url;
            return;
        L9:
            return;
        L5:
            r101 = false;
            goto L6
        }

        public final ShareParamsBuilder badgeShareTypes(ArrayList<Integer> r100) {
            this.badgeShareTypes = r100;
            return this;
        }

        public final ShareParamsBuilder bitableRoleMembers(ArrayList<BitableShareRoleMember> r100) {
            this.bitableRoleMembers = r100;
            return this;
        }

        public final ShareParamsBuilder createTime(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.createTime = r100;
            return this;
        }

        public final ShareParamsBuilder disabledShareTypes(ArrayList<Integer> r100) {
            this.disabledShareTypes = r100;
            return this;
        }

        public final ShareParamsBuilder docContent(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.docContent = r100;
            return this;
        }

        public final ShareParamsBuilder docName(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.docName = r100;
            return this;
        }

        public final ShareParamsBuilder docTopic(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.docTopic = r100;
            return this;
        }

        public final ShareParamsBuilder editionId(String r100) {
            this.editionId = r100;
            return this;
        }

        public final ShareParamsBuilder feedId(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.feedId = r100;
            return this;
        }

        public final ShareParamsBuilder folderVersion(FolderVersion r100) {
            if (r100 != null) goto L4;
            r100 = new FolderVersion(0, 0, false, 7, null);
        L4:
            this.folderVersion = r100;
            return this;
        }

        public final ShareParamsBuilder isAtVC(boolean r100) {
            this.isAtVC = r100;
            return this;
        }

        public final ShareParamsBuilder isFa(Boolean r100) {
            this.isFa = r100;
            return this;
        }

        public final ShareParamsBuilder isOwner(boolean r100) {
            this.isOwner = r100;
            return this;
        }

        public final ShareParamsBuilder isPhoenix(boolean r100) {
            this.isPhoenix = r100;
            return this;
        }

        public final ShareParamsBuilder isPro(Boolean r100) {
            this.isPro = r100;
            return this;
        }

        public final ShareParamsBuilder isProAccessConfigBindRole(Boolean r100) {
            this.isProAccessConfigBindRole = r100;
            return this;
        }

        public final ShareParamsBuilder isShareRoot(boolean r100) {
            this.isShareRoot = r100;
            return this;
        }

        public final ShareParamsBuilder isWiki(boolean r100) {
            this.isWiki = r100;
            return this;
        }

        public final ShareParamsBuilder mindnoteViewType(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.mindnoteViewType = r100;
            return this;
        }

        public final ShareParamsBuilder module(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.module = r100;
            return this;
        }

        public final ShareParamsBuilder originUrl(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.originUrl = r100;
            return this;
        }

        public final ShareParamsBuilder ownerName(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.ownerName = r100;
            return this;
        }

        public final ShareParamsBuilder ownerTenantId(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.ownerTenantId = r100;
            return this;
        }

        public final ShareParamsBuilder ownerUid(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.ownerUid = r100;
            return this;
        }

        public final ShareParamsBuilder passwordSharingEnable(boolean r100) {
            this.passwordSharingEnable = r100;
            return this;
        }

        public final ShareParamsBuilder realToken(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.realToken = r100;
            return this;
        }

        public final ShareParamsBuilder realType(int r100) {
            this.realType = r100;
            return this;
        }

        public final void setAdminPerceiveControl(boolean r100) {
            this.adminPerceiveControl = r100;
        }

        public final void setBitableRoleMembers(ArrayList<BitableShareRoleMember> r100) {
            this.bitableRoleMembers = r100;
        }

        public final void setEditionId(String r100) {
            this.editionId = r100;
        }

        public final void setFa(Boolean r100) {
            this.isFa = r100;
        }

        public final void setFolderVersion(FolderVersion r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.folderVersion = r100;
        }

        public final void setOwnerName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.ownerName = r100;
        }

        public final void setOwnerTenantId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.ownerTenantId = r100;
        }

        public final void setPasswordSharingEnable(boolean r100) {
            this.passwordSharingEnable = r100;
        }

        public final void setPro(Boolean r100) {
            this.isPro = r100;
        }

        public final void setProAccessConfigBindRole(Boolean r100) {
            this.isProAccessConfigBindRole = r100;
        }

        public final void setShareRoot(boolean r100) {
            this.isShareRoot = r100;
        }

        public final void setSource(int r100) {
            this.source = r100;
        }

        public final void setSpaceId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.spaceId = r100;
        }

        public final void setTransferOwnerEnable(boolean r100) {
            this.transferOwnerEnable = r100;
        }

        public final void setWikiShortcutInSpace(boolean r100) {
            this.isWikiShortcutInSpace = r100;
        }

        public final ShareParamsBuilder source(int r100) {
            this.source = r100;
            return this;
        }

        public final ShareParamsBuilder spaceId(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.spaceId = r100;
            return this;
        }

        public final ShareParamsBuilder subModule(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.subModule = r100;
            return this;
        }

        public final ShareParamsBuilder subType(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.subType = r100;
            return this;
        }

        public final ShareParamsBuilder token(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.token = r100;
            return this;
        }

        public final ShareParamsBuilder transferOwnerEnable(boolean r100) {
            this.transferOwnerEnable = r100;
            return this;
        }

        public final ShareParamsBuilder type(int r100) {
            this.type = r100;
            return this;
        }

        public final ShareParamsBuilder url(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.url = r100;
            return this;
        }

        public final ShareParamsBuilder wikiShortcutInSpace(boolean r100) {
            this.isWikiShortcutInSpace = r100;
            return this;
        }

        public ShareParamsBuilder(FragmentActivity r100, Fragment r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.activity = r100;
            this.sourceFragment = r101;
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

        public /* synthetic */ ShareParamsBuilder(FragmentActivity r100, Fragment r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShareParams(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this(r100, null, 2, 0 == true ? 1 : 0);
    }

    public final n getChannelHandlers() {
        return null;
    }

    public final void setChannelHandlers(n r100) {
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

    public final void setAdminPerceiveControl(boolean r100) {
        this.adminPerceiveControl = r100;
    }

    public final void setAtVC(boolean r100) {
        this.isAtVC = r100;
    }

    public final void setBadgeShareTypes(ArrayList<Integer> r100) {
        this.badgeShareTypes = r100;
    }

    public final void setBitableRoleMembers(ArrayList<BitableShareRoleMember> r100) {
        this.bitableRoleMembers = r100;
    }

    public final void setCreateTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.createTime = r100;
    }

    public final void setDisabledShareTypes(ArrayList<Integer> r100) {
        this.disabledShareTypes = r100;
    }

    public final void setDocContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.docContent = r100;
    }

    public final void setDocName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.docName = r100;
    }

    public final void setDocTopic(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.docTopic = r100;
    }

    public final void setEditionId(String r100) {
        this.editionId = r100;
    }

    public final void setExpandAtInit(Boolean r100) {
        this.expandAtInit = r100;
    }

    public final void setExportImageRunnable(Runnable r100) {
        this.exportImageRunnable = r100;
    }

    public final void setFa(Boolean r100) {
        this.isFa = r100;
    }

    public final void setFeedId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.feedId = r100;
    }

    public final void setFolderVersion(FolderVersion r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.folderVersion = r100;
    }

    public final void setMindnoteViewType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mindnoteViewType = r100;
    }

    public final void setModule(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.module = r100;
    }

    public final void setOriginUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.originUrl = r100;
    }

    public final void setOwner(boolean r100) {
        this.isOwner = r100;
    }

    public final void setOwnerName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ownerName = r100;
    }

    public final void setOwnerTenantId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ownerTenantId = r100;
    }

    public final void setOwnerUid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ownerUid = r100;
    }

    public final void setPasswordSharingEnable(boolean r100) {
        this.passwordSharingEnable = r100;
    }

    public final void setPhoenix(boolean r100) {
        this.isPhoenix = r100;
    }

    public final void setPro(Boolean r100) {
        this.isPro = r100;
    }

    public final void setProAccessConfigBindRole(Boolean r100) {
        this.isProAccessConfigBindRole = r100;
    }

    public final void setRealToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.realToken = r100;
    }

    public final void setRealType(int r100) {
        this.realType = r100;
    }

    public final void setShareRoot(boolean r100) {
        this.isShareRoot = r100;
    }

    public final void setShowExportImage(boolean r100) {
        this.showExportImage = r100;
    }

    public final void setSource(int r100) {
        this.source = r100;
    }

    public final void setSpaceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.spaceId = r100;
    }

    public final void setSubModule(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subModule = r100;
    }

    public final void setSubType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subType = r100;
    }

    public final void setToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.token = r100;
    }

    public final void setTransferOwnerEnable(boolean r100) {
        this.transferOwnerEnable = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    public final void setWiki(boolean r100) {
        this.isWiki = r100;
    }

    public final void setWikiShortcutInSpace(boolean r100) {
        this.isWikiShortcutInSpace = r100;
    }

    public ShareParams(FragmentActivity r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.activity = r100;
        this.sourceFragment = r101;
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

    public /* synthetic */ ShareParams(FragmentActivity r100, Fragment r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
