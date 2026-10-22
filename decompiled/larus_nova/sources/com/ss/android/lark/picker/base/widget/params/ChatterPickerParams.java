package com.ss.android.lark.picker.base.widget.params;

import com.ss.android.lark.picker.base.widget.utils.FG;
import com.ss.android.lark.search.dto.service.OnJobStatus;
import com.ss.android.lark.search.dto.service.Union;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001:\u0001HB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\b0<J\u0006\u0010=\u001a\u00020\nJ\u0006\u0010>\u001a\u00020\nJ\u0006\u0010?\u001a\u00020\nJ\u0006\u0010@\u001a\u00020\nJ\u0006\u0010A\u001a\u00020\nJ\u0006\u0010B\u001a\u00020\nJ\u0006\u0010C\u001a\u00020\nJ\u0006\u0010D\u001a\u00020\u0012J\u0006\u0010E\u001a\u00020\nJ\u0006\u0010F\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\nJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010G\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010$\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\nR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001e\u0010/\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006I"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/params/ChatterPickerParams;", "Lcom/ss/android/lark/picker/base/widget/params/BasePickerParams;", "builder", "Lcom/ss/android/lark/picker/base/widget/params/ChatterPickerParams$Builder;", "<init>", "(Lcom/ss/android/lark/picker/base/widget/params/ChatterPickerParams$Builder;)V", "mChatIds", "", "", "mIsCheckOUPermission", "", "mIsCheckSecretPermission", "mIsCheckCrossTenantAdminPermission", "mIsNeedSearchOuterUser", "mExcludeOuterContact", "mIgnoreSelf", "mUseChatterSearcher", "mSearchScene", "", "mIncludeSecretP2pChat", "mIncludeBot", "excludeWithoutChatUser", "excludeResignedUser", "onJobStatus", "Lcom/ss/android/lark/search/dto/service/OnJobStatus;", "includePublicGroup", "mIncludeMailContact", "enablePublicGroup", "enableSecretGroup", "enableMeetingGroup", "enableExternalGroup", "enableEmailContact", "needEnterpriseEmail", "needPullEnterpriseEmailData", "enableEmailSharedAccount", "mailGroupRole", "mailGroupId", "isInTeamId", "excludeUnJoinedGroup", "includeAI", "getIncludeAI", "()Z", "setIncludeAI", "(Z)V", "mustHaveChatWithAI", "getMustHaveChatWithAI", "setMustHaveChatWithAI", "onlyManageGroup", "getOnlyManageGroup", "()Ljava/lang/Boolean;", "setOnlyManageGroup", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "outerGroup", "Lcom/ss/android/lark/search/dto/service/Union;", "getOuterGroup", "()Lcom/ss/android/lark/search/dto/service/Union;", "setOuterGroup", "(Lcom/ss/android/lark/search/dto/service/Union;)V", "chatIds", "", "checkOUPermission", "checkSecretPermission", "needSearchOuterUser", "excludeOuterContact", "checkCrossTenantAdminPermission", "ignoreSelf", "useChatterSearcher", "searchScene", "includeSecretP2pChat", "includeBot", "includeMailContact", "Builder", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChatterPickerParams extends BasePickerParams {
    private boolean enableEmailContact;
    private boolean enableEmailSharedAccount;
    private boolean enableExternalGroup;
    private boolean enableMeetingGroup;
    private boolean enablePublicGroup;
    private boolean enableSecretGroup;
    private boolean excludeResignedUser;
    private boolean excludeUnJoinedGroup;
    private boolean excludeWithoutChatUser;
    private boolean includeAI;
    private boolean includePublicGroup;
    private String isInTeamId;
    private List<String> mChatIds;
    private boolean mExcludeOuterContact;
    private boolean mIgnoreSelf;
    private boolean mIncludeBot;
    private boolean mIncludeMailContact;
    private boolean mIncludeSecretP2pChat;
    private boolean mIsCheckCrossTenantAdminPermission;
    private boolean mIsCheckOUPermission;
    private boolean mIsCheckSecretPermission;
    private boolean mIsNeedSearchOuterUser;
    private int mSearchScene;
    private boolean mUseChatterSearcher;
    private String mailGroupId;
    private int mailGroupRole;
    private boolean mustHaveChatWithAI;
    private boolean needEnterpriseEmail;
    private boolean needPullEnterpriseEmailData;
    private OnJobStatus onJobStatus;
    private Boolean onlyManageGroup;
    private Union outerGroup;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b3\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0087\u0001\u001a\u00020\u00002\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u001b\u0010\u0089\u0001\u001a\u00020\u00002\u0010\u0010\u008a\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u008b\u0001H\u0016J\u0010\u0010\u008c\u0001\u001a\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00020\fJ\u0010\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00020\fJ\u0012\u0010\u008f\u0001\u001a\u00020\u00002\u0007\u0010\u0090\u0001\u001a\u00020\fH\u0016J\u0010\u0010\u0091\u0001\u001a\u00020\u00002\u0007\u0010\u0092\u0001\u001a\u00020\fJ\u0012\u0010\u0093\u0001\u001a\u00020\u00002\u0007\u0010\u0094\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0095\u0001\u001a\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0097\u0001\u001a\u00020\u00002\u0007\u0010\u0098\u0001\u001a\u00020\fH\u0016J\u001b\u0010\u0099\u0001\u001a\u00020\u00002\u0010\u0010\u009a\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u008b\u0001H\u0016J\u0012\u0010\u009b\u0001\u001a\u00020\u00002\u0007\u0010\u009c\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u009d\u0001\u001a\u00020\u00002\u0007\u0010\u009e\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u009f\u0001\u001a\u00020\u00002\u0007\u0010 \u0001\u001a\u00020'H\u0016J\u0012\u0010¡\u0001\u001a\u00020\u00002\u0007\u0010¢\u0001\u001a\u00020\fH\u0016J\u0012\u0010£\u0001\u001a\u00020\u00002\u0007\u0010¤\u0001\u001a\u00020\fH\u0016J\u0012\u0010¥\u0001\u001a\u00020\u00002\u0007\u0010¥\u0001\u001a\u00020\fH\u0016J\u0012\u0010¦\u0001\u001a\u00020\u00002\u0007\u0010§\u0001\u001a\u00020\u0006H\u0016J\u0011\u0010¨\u0001\u001a\u00020\u00002\u0006\u00102\u001a\u00020\fH\u0016J\u0011\u0010©\u0001\u001a\u00020\u00002\u0006\u00105\u001a\u00020\fH\u0016J\u0011\u0010ª\u0001\u001a\u00020\u00002\u0006\u00108\u001a\u000209H\u0016J\u0011\u0010«\u0001\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\fH\u0016J\u0011\u0010¬\u0001\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\fH\u0016J\u0011\u0010\u00ad\u0001\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\fH\u0016J\u0011\u0010®\u0001\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\fH\u0016J\u0011\u0010¯\u0001\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fH\u0016J\u0011\u0010°\u0001\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020'H\u0016J\u0011\u0010±\u0001\u001a\u00020\u00002\u0006\u0010_\u001a\u00020\u0006H\u0016J\u0011\u0010²\u0001\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\fH\u0016J\u0011\u0010³\u0001\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\fH\u0016J\u0011\u0010´\u0001\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\fH\u0016J\u0011\u0010µ\u0001\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\fH\u0016J\u0012\u0010¶\u0001\u001a\u00020\u00002\u0007\u0010·\u0001\u001a\u00020\fH\u0016J\u0011\u0010¸\u0001\u001a\u00020\u00002\u0006\u0010u\u001a\u00020\fH\u0016J\u0011\u0010¹\u0001\u001a\u00020\u00002\u0006\u0010{\u001a\u00020|H\u0016J\u0011\u0010º\u0001\u001a\u00020\u00002\u0006\u0010d\u001a\u00020\u0006H\u0016J\u0011\u0010»\u0001\u001a\u00020\u00002\u0006\u0010f\u001a\u00020\fH\u0016J\u0011\u0010¼\u0001\u001a\u00020\u00002\u0006\u0010i\u001a\u00020\fH\u0016J\u0011\u0010½\u0001\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\fH\u0016J\n\u0010¾\u0001\u001a\u00030¿\u0001H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\u001a\u0010/\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\u001a\u00102\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\u001a\u00105\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u0010\u0010R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000e\"\u0004\b@\u0010\u0010R\u001a\u0010A\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000e\"\u0004\bC\u0010\u0010R\u001a\u0010D\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000e\"\u0004\bF\u0010\u0010R\u001a\u0010G\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000e\"\u0004\bI\u0010\u0010R\u001a\u0010J\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u000e\"\u0004\bL\u0010\u0010R\u001a\u0010M\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u000e\"\u0004\bO\u0010\u0010R\u001a\u0010P\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u000e\"\u0004\bR\u0010\u0010R\u001a\u0010S\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u000e\"\u0004\bU\u0010\u0010R\u001a\u0010V\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000e\"\u0004\bX\u0010\u0010R\u001a\u0010Y\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u000e\"\u0004\b[\u0010\u0010R\u001a\u0010\\\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010)\"\u0004\b^\u0010+R\u001a\u0010_\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010a\"\u0004\be\u0010cR\u001a\u0010f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u000e\"\u0004\bh\u0010\u0010R\u001a\u0010i\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u000e\"\u0004\bk\u0010\u0010R\u001a\u0010l\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u000e\"\u0004\bn\u0010\u0010R\u001a\u0010o\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u000e\"\u0004\bq\u0010\u0010R\u001a\u0010r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u000e\"\u0004\bt\u0010\u0010R\u001e\u0010u\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010z\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001d\u0010{\u001a\u0004\u0018\u00010|X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u001d\u0010\u0081\u0001\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u000e\"\u0005\b\u0083\u0001\u0010\u0010R\u001f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010a\"\u0005\b\u0086\u0001\u0010c¨\u0006À\u0001"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/params/ChatterPickerParams$Builder;", "", "<init>", "()V", "mChatIds", "", "", "getMChatIds", "()Ljava/util/List;", "setMChatIds", "(Ljava/util/List;)V", "mIsCheckOUPermission", "", "getMIsCheckOUPermission", "()Z", "setMIsCheckOUPermission", "(Z)V", "mIsCheckSecretPermission", "getMIsCheckSecretPermission", "setMIsCheckSecretPermission", "mIsCheckCrossTenantAdminPermission", "getMIsCheckCrossTenantAdminPermission", "setMIsCheckCrossTenantAdminPermission", "mIsNeedSearchOuterUser", "getMIsNeedSearchOuterUser", "setMIsNeedSearchOuterUser", "mExcludeOuterContact", "getMExcludeOuterContact", "setMExcludeOuterContact", "mRequiredList", "getMRequiredList", "setMRequiredList", "mIgnoreSelf", "getMIgnoreSelf", "setMIgnoreSelf", "mUseChatterSearcher", "getMUseChatterSearcher", "setMUseChatterSearcher", "mSearchScene", "", "getMSearchScene", "()I", "setMSearchScene", "(I)V", "mIncludeSecretP2pChat", "getMIncludeSecretP2pChat", "setMIncludeSecretP2pChat", "mIncludeBot", "getMIncludeBot", "setMIncludeBot", "excludeWithoutChatUser", "getExcludeWithoutChatUser", "setExcludeWithoutChatUser", "excludeResignedUser", "getExcludeResignedUser", "setExcludeResignedUser", "onJobStatus", "Lcom/ss/android/lark/search/dto/service/OnJobStatus;", "getOnJobStatus", "()Lcom/ss/android/lark/search/dto/service/OnJobStatus;", "setOnJobStatus", "(Lcom/ss/android/lark/search/dto/service/OnJobStatus;)V", "mIncludeMailContact", "getMIncludeMailContact", "setMIncludeMailContact", "includePublicGroup", "getIncludePublicGroup", "setIncludePublicGroup", "enablePublicGroup", "getEnablePublicGroup", "setEnablePublicGroup", "enableSecretGroup", "getEnableSecretGroup", "setEnableSecretGroup", "enableMeetingGroup", "getEnableMeetingGroup", "setEnableMeetingGroup", "enableExternalGroup", "getEnableExternalGroup", "setEnableExternalGroup", "enableEmailContact", "getEnableEmailContact", "setEnableEmailContact", "needEnterpriseEmail", "getNeedEnterpriseEmail", "setNeedEnterpriseEmail", "needPullEnterpriseEmailData", "getNeedPullEnterpriseEmailData", "setNeedPullEnterpriseEmailData", "enableEmailSharedAccount", "getEnableEmailSharedAccount", "setEnableEmailSharedAccount", "mailGroupRole", "getMailGroupRole", "setMailGroupRole", "mailGroupId", "getMailGroupId", "()Ljava/lang/String;", "setMailGroupId", "(Ljava/lang/String;)V", "isInTeamId", "setInTeamId", "excludeUnJoinedGroup", "getExcludeUnJoinedGroup", "setExcludeUnJoinedGroup", "includeAI", "getIncludeAI", "setIncludeAI", "mustHaveChatWithAI", "getMustHaveChatWithAI", "setMustHaveChatWithAI", "enableSearchHistory", "getEnableSearchHistory", "setEnableSearchHistory", "shouldShowSelectedView", "getShouldShowSelectedView", "setShouldShowSelectedView", "onlyManageGroup", "getOnlyManageGroup", "()Ljava/lang/Boolean;", "setOnlyManageGroup", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "outerGroup", "Lcom/ss/android/lark/search/dto/service/Union;", "getOuterGroup", "()Lcom/ss/android/lark/search/dto/service/Union;", "setOuterGroup", "(Lcom/ss/android/lark/search/dto/service/Union;)V", "mEnableSpotLight", "getMEnableSpotLight", "setMEnableSpotLight", "tagName", "getTagName", "setTagName", "attachChatId", "chatId", "attachChatIds", "chatIds", "", "attachEnableSearchHistory", "enable", "attachShouldShowSelectedView", "attachCheckOUPermission", "isCheckOUPermission", "attachCheckCrossTenantAdminPermission", "isCheckAdminPermission", "attachCheckSecretPermission", "isCheckSecretPermission", "attachNeedSearchOuterUser", "needSearchOuterUser", "attachExcludeOuterContact", "excludeOuterContact", "attachRequiredList", "requiredList", "attachIgnoreSelf", "ignoreSelf", "attachUseChatterSearcher", "useChatterSearcher", "attachSearchScene", "searchScene", "attachIncludeSecretP2pChat", "includeSecretP2pChat", "attachIncludeBot", "includeBot", "enableSpotLight", "attachTagName", "tag", "attachExcludeWithoutChatUser", "attachExcludeResignedUser", "attachOnJobStatus", "attachIncludePublicGroup", "attachEmailContact", "attachEnterpriseEmail", "attachPullEnterpriseEmailData", "attachEmailSharedAccount", "attachMailGroupRole", "attachMailGroupId", "attachEnablePublicGroup", "attachEnableSecretGroup", "attachEnableMeetingGroup", "attachEnableExternalGroup", "attachIncludeMailContact", "includeMailContact", "attachOnlyManageGroup", "attachOuterGroup", "attachIsInTeamId", "attachExcludeUnJoinedGroup", "attachIncludeAI", "attachMustHaveChatWithAI", "build", "Lcom/ss/android/lark/picker/base/widget/params/ChatterPickerParams;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Builder {
        private boolean enableEmailContact;
        private boolean enableEmailSharedAccount;
        private boolean enableExternalGroup;
        private boolean enableMeetingGroup;
        private boolean enablePublicGroup;
        private boolean enableSearchHistory;
        private boolean enableSecretGroup;
        private boolean excludeResignedUser;
        private boolean excludeUnJoinedGroup;
        private boolean excludeWithoutChatUser;
        private boolean includeAI;
        private boolean includePublicGroup;
        private String isInTeamId;
        private List<String> mChatIds;
        private boolean mEnableSpotLight;
        private boolean mExcludeOuterContact;
        private boolean mIgnoreSelf;
        private boolean mIncludeBot;
        private boolean mIncludeMailContact;
        private boolean mIncludeSecretP2pChat;
        private boolean mIsCheckCrossTenantAdminPermission;
        private boolean mIsCheckOUPermission;
        private boolean mIsCheckSecretPermission;
        private boolean mIsNeedSearchOuterUser;
        private List<String> mRequiredList;
        private int mSearchScene;
        private boolean mUseChatterSearcher;
        private String mailGroupId;
        private int mailGroupRole;
        private boolean mustHaveChatWithAI;
        private boolean needEnterpriseEmail;
        private boolean needPullEnterpriseEmailData;
        private OnJobStatus onJobStatus;
        private Boolean onlyManageGroup;
        private Union outerGroup;
        private boolean shouldShowSelectedView;
        private String tagName;

        public ChatterPickerParams build() {
            return new ChatterPickerParams(this);
        }

        public Builder() {
            this.mChatIds = new ArrayList();
            this.mRequiredList = new ArrayList();
            this.excludeWithoutChatUser = true;
            this.excludeResignedUser = true;
            this.enablePublicGroup = true;
            this.enableSecretGroup = true;
            this.enableMeetingGroup = true;
            this.mailGroupRole = -1;
            this.mailGroupId = "";
            this.isInTeamId = "";
            this.shouldShowSelectedView = true;
        }

        public final boolean getEnableEmailContact() {
            return this.enableEmailContact;
        }

        public final boolean getEnableEmailSharedAccount() {
            return this.enableEmailSharedAccount;
        }

        public final boolean getEnableExternalGroup() {
            return this.enableExternalGroup;
        }

        public final boolean getEnableMeetingGroup() {
            return this.enableMeetingGroup;
        }

        public final boolean getEnablePublicGroup() {
            return this.enablePublicGroup;
        }

        public final boolean getEnableSearchHistory() {
            return this.enableSearchHistory;
        }

        public final boolean getEnableSecretGroup() {
            return this.enableSecretGroup;
        }

        public final boolean getExcludeResignedUser() {
            return this.excludeResignedUser;
        }

        public final boolean getExcludeUnJoinedGroup() {
            return this.excludeUnJoinedGroup;
        }

        public final boolean getExcludeWithoutChatUser() {
            return this.excludeWithoutChatUser;
        }

        public final boolean getIncludeAI() {
            return this.includeAI;
        }

        public final boolean getIncludePublicGroup() {
            return this.includePublicGroup;
        }

        public final List<String> getMChatIds() {
            return this.mChatIds;
        }

        public final boolean getMEnableSpotLight() {
            return this.mEnableSpotLight;
        }

        public final boolean getMExcludeOuterContact() {
            return this.mExcludeOuterContact;
        }

        public final boolean getMIgnoreSelf() {
            return this.mIgnoreSelf;
        }

        public final boolean getMIncludeBot() {
            return this.mIncludeBot;
        }

        public final boolean getMIncludeMailContact() {
            return this.mIncludeMailContact;
        }

        public final boolean getMIncludeSecretP2pChat() {
            return this.mIncludeSecretP2pChat;
        }

        public final boolean getMIsCheckCrossTenantAdminPermission() {
            return this.mIsCheckCrossTenantAdminPermission;
        }

        public final boolean getMIsCheckOUPermission() {
            return this.mIsCheckOUPermission;
        }

        public final boolean getMIsCheckSecretPermission() {
            return this.mIsCheckSecretPermission;
        }

        public final boolean getMIsNeedSearchOuterUser() {
            return this.mIsNeedSearchOuterUser;
        }

        public final List<String> getMRequiredList() {
            return this.mRequiredList;
        }

        public final int getMSearchScene() {
            return this.mSearchScene;
        }

        public final boolean getMUseChatterSearcher() {
            return this.mUseChatterSearcher;
        }

        public final String getMailGroupId() {
            return this.mailGroupId;
        }

        public final int getMailGroupRole() {
            return this.mailGroupRole;
        }

        public final boolean getMustHaveChatWithAI() {
            return this.mustHaveChatWithAI;
        }

        public final boolean getNeedEnterpriseEmail() {
            return this.needEnterpriseEmail;
        }

        public final boolean getNeedPullEnterpriseEmailData() {
            return this.needPullEnterpriseEmailData;
        }

        public final OnJobStatus getOnJobStatus() {
            return this.onJobStatus;
        }

        public final Boolean getOnlyManageGroup() {
            return this.onlyManageGroup;
        }

        public final Union getOuterGroup() {
            return this.outerGroup;
        }

        public final boolean getShouldShowSelectedView() {
            return this.shouldShowSelectedView;
        }

        public final String getTagName() {
            return this.tagName;
        }

        public final String isInTeamId() {
            return this.isInTeamId;
        }

        public Builder attachChatId(String r100) {
            if (r100 == null) goto L4;
            this.mChatIds.clear();
            this.mChatIds.add(r100);
        L4:
            return this;
        }

        public Builder attachChatIds(List<String> r100) {
            if (r100 == null) goto L4;
            this.mChatIds.clear();
            this.mChatIds.addAll(r100);
        L4:
            return this;
        }

        public final Builder attachCheckCrossTenantAdminPermission(boolean r100) {
            this.mIsCheckCrossTenantAdminPermission = r100;
            return this;
        }

        public Builder attachCheckOUPermission(boolean r100) {
            this.mIsCheckOUPermission = r100;
            return this;
        }

        public Builder attachCheckSecretPermission(boolean r100) {
            this.mIsCheckSecretPermission = r100;
            return this;
        }

        public Builder attachEmailContact(boolean r100) {
            this.enableEmailContact = r100;
            return this;
        }

        public Builder attachEmailSharedAccount(boolean r100) {
            this.enableEmailSharedAccount = r100;
            return this;
        }

        public Builder attachEnableExternalGroup(boolean r100) {
            this.enableExternalGroup = r100;
            return this;
        }

        public Builder attachEnableMeetingGroup(boolean r100) {
            this.enableMeetingGroup = r100;
            return this;
        }

        public Builder attachEnablePublicGroup(boolean r100) {
            this.enablePublicGroup = r100;
            return this;
        }

        public final Builder attachEnableSearchHistory(boolean r100) {
            this.enableSearchHistory = r100;
            return this;
        }

        public Builder attachEnableSecretGroup(boolean r100) {
            this.enableSecretGroup = r100;
            return this;
        }

        public Builder attachEnterpriseEmail(boolean r100) {
            this.needEnterpriseEmail = r100;
            return this;
        }

        public Builder attachExcludeOuterContact(boolean r100) {
            this.mExcludeOuterContact = r100;
            return this;
        }

        public Builder attachExcludeResignedUser(boolean r100) {
            this.excludeResignedUser = r100;
            return this;
        }

        public Builder attachExcludeUnJoinedGroup(boolean r100) {
            this.excludeUnJoinedGroup = r100;
            return this;
        }

        public Builder attachExcludeWithoutChatUser(boolean r100) {
            this.excludeWithoutChatUser = r100;
            return this;
        }

        public Builder attachIgnoreSelf(boolean r100) {
            this.mIgnoreSelf = r100;
            return this;
        }

        public Builder attachIncludeAI(boolean r100) {
            if (r100 == true) goto L4;
        L6:
            boolean r101 = false;
        L7:
            this.includeAI = r101;
            return this;
        L4:
            if (FG.INSTANCE.isCurrentEnable(FG.MY_AI) == false) goto L6;
            r101 = true;
            goto L7
        }

        public Builder attachIncludeBot(boolean r100) {
            this.mIncludeBot = r100;
            return this;
        }

        public Builder attachIncludeMailContact(boolean r100) {
            this.mIncludeMailContact = r100;
            return this;
        }

        public Builder attachIncludePublicGroup(boolean r100) {
            this.includePublicGroup = r100;
            return this;
        }

        public Builder attachIncludeSecretP2pChat(boolean r100) {
            this.mIncludeSecretP2pChat = r100;
            return this;
        }

        public Builder attachIsInTeamId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "isInTeamId");
            this.isInTeamId = r100;
            return this;
        }

        public Builder attachMailGroupId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "mailGroupId");
            this.mailGroupId = r100;
            return this;
        }

        public Builder attachMailGroupRole(int r100) {
            this.mailGroupRole = r100;
            return this;
        }

        public Builder attachMustHaveChatWithAI(boolean r100) {
            this.mustHaveChatWithAI = r100;
            return this;
        }

        public Builder attachNeedSearchOuterUser(boolean r100) {
            this.mIsNeedSearchOuterUser = r100;
            return this;
        }

        public Builder attachOnJobStatus(OnJobStatus r100) {
            Intrinsics.checkNotNullParameter(r100, "onJobStatus");
            this.onJobStatus = r100;
            return this;
        }

        public Builder attachOnlyManageGroup(boolean r100) {
            this.onlyManageGroup = Boolean.valueOf(r100);
            return this;
        }

        public Builder attachOuterGroup(Union r100) {
            Intrinsics.checkNotNullParameter(r100, "outerGroup");
            this.outerGroup = r100;
            return this;
        }

        public Builder attachPullEnterpriseEmailData(boolean r100) {
            this.needPullEnterpriseEmailData = r100;
            return this;
        }

        public Builder attachRequiredList(List<String> r100) {
            if (r100 == null) goto L4;
            this.mRequiredList.clear();
            this.mRequiredList.addAll(r100);
        L4:
            return this;
        }

        public Builder attachSearchScene(int r100) {
            this.mSearchScene = r100;
            return this;
        }

        public final Builder attachShouldShowSelectedView(boolean r100) {
            this.shouldShowSelectedView = r100;
            return this;
        }

        public Builder attachTagName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.tagName = r100;
            return this;
        }

        public Builder attachUseChatterSearcher(boolean r100) {
            this.mUseChatterSearcher = r100;
            return this;
        }

        public Builder enableSpotLight(boolean r100) {
            this.mEnableSpotLight = r100;
            return this;
        }

        public final void setEnableEmailContact(boolean r100) {
            this.enableEmailContact = r100;
        }

        public final void setEnableEmailSharedAccount(boolean r100) {
            this.enableEmailSharedAccount = r100;
        }

        public final void setEnableExternalGroup(boolean r100) {
            this.enableExternalGroup = r100;
        }

        public final void setEnableMeetingGroup(boolean r100) {
            this.enableMeetingGroup = r100;
        }

        public final void setEnablePublicGroup(boolean r100) {
            this.enablePublicGroup = r100;
        }

        public final void setEnableSearchHistory(boolean r100) {
            this.enableSearchHistory = r100;
        }

        public final void setEnableSecretGroup(boolean r100) {
            this.enableSecretGroup = r100;
        }

        public final void setExcludeResignedUser(boolean r100) {
            this.excludeResignedUser = r100;
        }

        public final void setExcludeUnJoinedGroup(boolean r100) {
            this.excludeUnJoinedGroup = r100;
        }

        public final void setExcludeWithoutChatUser(boolean r100) {
            this.excludeWithoutChatUser = r100;
        }

        public final void setInTeamId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.isInTeamId = r100;
        }

        public final void setIncludeAI(boolean r100) {
            this.includeAI = r100;
        }

        public final void setIncludePublicGroup(boolean r100) {
            this.includePublicGroup = r100;
        }

        public final void setMChatIds(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.mChatIds = r100;
        }

        public final void setMEnableSpotLight(boolean r100) {
            this.mEnableSpotLight = r100;
        }

        public final void setMExcludeOuterContact(boolean r100) {
            this.mExcludeOuterContact = r100;
        }

        public final void setMIgnoreSelf(boolean r100) {
            this.mIgnoreSelf = r100;
        }

        public final void setMIncludeBot(boolean r100) {
            this.mIncludeBot = r100;
        }

        public final void setMIncludeMailContact(boolean r100) {
            this.mIncludeMailContact = r100;
        }

        public final void setMIncludeSecretP2pChat(boolean r100) {
            this.mIncludeSecretP2pChat = r100;
        }

        public final void setMIsCheckCrossTenantAdminPermission(boolean r100) {
            this.mIsCheckCrossTenantAdminPermission = r100;
        }

        public final void setMIsCheckOUPermission(boolean r100) {
            this.mIsCheckOUPermission = r100;
        }

        public final void setMIsCheckSecretPermission(boolean r100) {
            this.mIsCheckSecretPermission = r100;
        }

        public final void setMIsNeedSearchOuterUser(boolean r100) {
            this.mIsNeedSearchOuterUser = r100;
        }

        public final void setMRequiredList(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.mRequiredList = r100;
        }

        public final void setMSearchScene(int r100) {
            this.mSearchScene = r100;
        }

        public final void setMUseChatterSearcher(boolean r100) {
            this.mUseChatterSearcher = r100;
        }

        public final void setMailGroupId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.mailGroupId = r100;
        }

        public final void setMailGroupRole(int r100) {
            this.mailGroupRole = r100;
        }

        public final void setMustHaveChatWithAI(boolean r100) {
            this.mustHaveChatWithAI = r100;
        }

        public final void setNeedEnterpriseEmail(boolean r100) {
            this.needEnterpriseEmail = r100;
        }

        public final void setNeedPullEnterpriseEmailData(boolean r100) {
            this.needPullEnterpriseEmailData = r100;
        }

        public final void setOnJobStatus(OnJobStatus r100) {
            this.onJobStatus = r100;
        }

        public final void setOnlyManageGroup(Boolean r100) {
            this.onlyManageGroup = r100;
        }

        public final void setOuterGroup(Union r100) {
            this.outerGroup = r100;
        }

        public final void setShouldShowSelectedView(boolean r100) {
            this.shouldShowSelectedView = r100;
        }

        public final void setTagName(String r100) {
            this.tagName = r100;
        }
    }

    public final List<String> chatIds() {
        return this.mChatIds;
    }

    public final boolean checkCrossTenantAdminPermission() {
        return this.mIsCheckCrossTenantAdminPermission;
    }

    public final boolean checkOUPermission() {
        return this.mIsCheckOUPermission;
    }

    public final boolean checkSecretPermission() {
        return this.mIsCheckSecretPermission;
    }

    public final boolean enableEmailContact() {
        return this.enableEmailContact;
    }

    public final boolean enableEmailSharedAccount() {
        return this.enableEmailSharedAccount;
    }

    public final boolean enableExternalGroup() {
        return this.enableExternalGroup;
    }

    public final boolean enableMeetingGroup() {
        return this.enableMeetingGroup;
    }

    public final boolean enablePublicGroup() {
        return this.enablePublicGroup;
    }

    public final boolean enableSecretGroup() {
        return this.enableSecretGroup;
    }

    public final boolean excludeOuterContact() {
        return this.mExcludeOuterContact;
    }

    public final boolean excludeResignedUser() {
        return this.excludeResignedUser;
    }

    public final boolean excludeUnJoinedGroup() {
        return this.excludeUnJoinedGroup;
    }

    public final boolean excludeWithoutChatUser() {
        return this.excludeWithoutChatUser;
    }

    public final boolean getIncludeAI() {
        return this.includeAI;
    }

    public final boolean getMustHaveChatWithAI() {
        return this.mustHaveChatWithAI;
    }

    public final Boolean getOnlyManageGroup() {
        return this.onlyManageGroup;
    }

    public final Union getOuterGroup() {
        return this.outerGroup;
    }

    public final boolean ignoreSelf() {
        return this.mIgnoreSelf;
    }

    public final boolean includeBot() {
        return this.mIncludeBot;
    }

    public final boolean includeMailContact() {
        return this.mIncludeMailContact;
    }

    public final boolean includePublicGroup() {
        return this.includePublicGroup;
    }

    public final boolean includeSecretP2pChat() {
        return this.mIncludeSecretP2pChat;
    }

    public final String isInTeamId() {
        return this.isInTeamId;
    }

    public final String mailGroupId() {
        return this.mailGroupId;
    }

    public final int mailGroupRole() {
        return this.mailGroupRole;
    }

    public final boolean needEnterpriseEmail() {
        return this.needEnterpriseEmail;
    }

    public final boolean needPullEnterpriseEmailData() {
        return this.needPullEnterpriseEmailData;
    }

    public final boolean needSearchOuterUser() {
        return this.mIsNeedSearchOuterUser;
    }

    public final OnJobStatus onJobStatus() {
        return this.onJobStatus;
    }

    public final int searchScene() {
        return this.mSearchScene;
    }

    public final boolean useChatterSearcher() {
        return this.mUseChatterSearcher;
    }

    public ChatterPickerParams(Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        ArrayList r101 = new ArrayList();
        this.mChatIds = r101;
        this.excludeWithoutChatUser = true;
        this.excludeResignedUser = true;
        this.enablePublicGroup = true;
        this.enableSecretGroup = true;
        this.enableMeetingGroup = true;
        this.mailGroupRole = -1;
        this.mailGroupId = "";
        this.isInTeamId = "";
        r101.clear();
        this.mChatIds.addAll(r100.getMChatIds());
        this.mIsCheckOUPermission = r100.getMIsCheckOUPermission();
        this.mIsCheckSecretPermission = r100.getMIsCheckSecretPermission();
        this.mIsCheckCrossTenantAdminPermission = r100.getMIsCheckCrossTenantAdminPermission();
        this.mIsNeedSearchOuterUser = r100.getMIsNeedSearchOuterUser();
        this.mExcludeOuterContact = r100.getMExcludeOuterContact();
        getMRequiredList().clear();
        getMRequiredList().addAll(r100.getMRequiredList());
        this.mIgnoreSelf = r100.getMIgnoreSelf();
        this.mUseChatterSearcher = r100.getMUseChatterSearcher();
        this.mSearchScene = r100.getMSearchScene();
        this.mIncludeSecretP2pChat = r100.getMIncludeSecretP2pChat();
        this.onlyManageGroup = r100.getOnlyManageGroup();
        this.outerGroup = r100.getOuterGroup();
        this.excludeWithoutChatUser = r100.getExcludeWithoutChatUser();
        this.excludeResignedUser = r100.getExcludeResignedUser();
        this.onJobStatus = r100.getOnJobStatus();
        this.mIncludeMailContact = r100.getMIncludeMailContact();
        this.includePublicGroup = r100.getIncludePublicGroup();
        this.enablePublicGroup = r100.getEnablePublicGroup();
        this.enableMeetingGroup = r100.getEnableMeetingGroup();
        this.enableSecretGroup = r100.getEnableSecretGroup();
        this.enableExternalGroup = r100.getEnableExternalGroup();
        this.enableEmailContact = r100.getEnableEmailContact();
        this.needEnterpriseEmail = r100.getNeedEnterpriseEmail();
        this.needPullEnterpriseEmailData = r100.getNeedPullEnterpriseEmailData();
        this.enableEmailSharedAccount = r100.getEnableEmailSharedAccount();
        this.mailGroupRole = r100.getMailGroupRole();
        this.mailGroupId = r100.getMailGroupId();
        this.isInTeamId = r100.isInTeamId();
        this.excludeUnJoinedGroup = r100.getExcludeUnJoinedGroup();
        this.includeAI = r100.getIncludeAI();
        this.mustHaveChatWithAI = r100.getMustHaveChatWithAI();
        this.mIncludeBot = r100.getMIncludeBot();
        setEnableSpotLight(r100.getMEnableSpotLight());
        setTagName4Spotlight(r100.getTagName());
        setEnableSearchHistory(r100.getEnableSearchHistory());
        setShouldShowSelectedView(r100.getShouldShowSelectedView());
    }

    public final void setIncludeAI(boolean r100) {
        this.includeAI = r100;
    }

    public final void setMustHaveChatWithAI(boolean r100) {
        this.mustHaveChatWithAI = r100;
    }

    public final void setOnlyManageGroup(Boolean r100) {
        this.onlyManageGroup = r100;
    }

    public final void setOuterGroup(Union r100) {
        this.outerGroup = r100;
    }
}
