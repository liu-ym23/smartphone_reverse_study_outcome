package com.bytedance.ee.bear;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.docupgrade.DocUpgradeInfo;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.mira.oat.ShareElfFile;
import com.ttnet.org.chromium.net.NetError;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0003\b\u0082\u0001\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 µ\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002µ\u0001B\u0089\u0003\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0015\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0015\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0015\u0012\b\b\u0002\u0010(\u001a\u00020)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010.\u001a\u00020/¢\u0006\u0004\b0\u00101J\u0006\u0010{\u001a\u00020\u0006J\u0006\u0010|\u001a\u00020\u0006J\u0006\u0010}\u001a\u00020\u0006J\u0006\u0010~\u001a\u00020\u0006J\u0006\u0010\u007f\u001a\u00020\u0006J\u0007\u0010\u0080\u0001\u001a\u00020\u0006J\u0007\u0010\u0081\u0001\u001a\u00020\u0006J\u0007\u0010\u0082\u0001\u001a\u00020\u0006J\u0007\u0010\u0083\u0001\u001a\u00020\u0006J\u0007\u0010\u0084\u0001\u001a\u00020\u0006J\"\u0010\u0085\u0001\u001a\u00020\u00062\u0007\u0010\u0086\u0001\u001a\u00020\u00062\u0007\u0010\u0087\u0001\u001a\u00020\u00062\u0007\u0010\u0088\u0001\u001a\u00020\u0006J\n\u0010\u0089\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010ª\u0001\u001a\u00020)HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0004HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010-HÆ\u0003J\n\u0010®\u0001\u001a\u00020/HÆ\u0003J\u008a\u0003\u0010¯\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00152\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010.\u001a\u00020/HÆ\u0001J\u0016\u0010°\u0001\u001a\u00020\u00062\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001HÖ\u0003J\n\u0010³\u0001\u001a\u00020\u0015HÖ\u0001J\n\u0010´\u0001\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00103R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00103R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00103R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00103R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00103R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u00103R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u00107\"\u0004\bA\u00109R\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u00107\"\u0004\bB\u00109R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u00103R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u00103R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bE\u00107R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00103R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u001a\u0010\u0016\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010H\"\u0004\bJ\u0010KR\u001a\u0010\u0017\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010H\"\u0004\bM\u0010KR\u001a\u0010\u0018\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010H\"\u0004\bO\u0010KR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010\u001b\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010H\"\u0004\bU\u0010KR\u001a\u0010\u001c\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010H\"\u0004\bW\u0010KR\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u00107\"\u0004\bX\u00109R\u001a\u0010\u001e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u00107\"\u0004\bZ\u00109R\u001a\u0010\u001f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00107\"\u0004\b\\\u00109R\u001a\u0010 \u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00103\"\u0004\b^\u00105R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u00103R\u0011\u0010\"\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b`\u0010HR\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u00103R\u0011\u0010$\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u00103R\u001a\u0010%\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010H\"\u0004\bd\u0010KR\u001a\u0010&\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00103\"\u0004\bf\u00105R\u001a\u0010'\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010H\"\u0004\bh\u0010KR\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u00103\"\u0004\bl\u00105R\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u00103R\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u001a\u0010r\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010H\"\u0004\bt\u0010KR\u001a\u0010u\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u00107\"\u0004\bw\u00109R\u001a\u0010x\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u00103\"\u0004\bz\u00105¨\u0006¶\u0001"}, d2 = {"Lcom/bytedance/ee/bear/DocMetaInfo;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "title", "", "secureKeyDelete", "", "creatorUid", "creatorName", "creatorTenantId", "ownerUid", "ownerName", "createTime", "subType", "isPined", "isStared", "appId", "appLink", "supportMobile", "icon", "realType", "", "realSubType", "getSecLabelCode", "canSetSecLabelCode", "secretLevel", "Lcom/bytedance/ee/bear/secret/SecretLevel;", "template_type", "secret_label_type", "is_external", "doubleCheckDefaultLabel", "mustSetLabel", "defaultSecretLabelId", "serverTime", "version", "editTime", "objId", "secLabelStatus", "recommendLabelId", "secLabelBannerType", "freshInfo", "Lcom/bytedance/ee/bear/DocFreshInfo;", "icon_info", "tenantName", "docUpgradeInfo", "Lcom/bytedance/ee/bear/docupgrade/DocUpgradeInfo;", "nodeId", "", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;IIIILcom/bytedance/ee/bear/secret/SecretLevel;IIZZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ILcom/bytedance/ee/bear/DocFreshInfo;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/docupgrade/DocUpgradeInfo;J)V", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "getSecureKeyDelete", "()Z", "setSecureKeyDelete", "(Z)V", "getCreatorUid", "getCreatorName", "getCreatorTenantId", "getOwnerUid", "getOwnerName", "getCreateTime", "getSubType", "setPined", "setStared", "getAppId", "getAppLink", "getSupportMobile", "getIcon", "getRealType", "()I", "getRealSubType", "setRealSubType", "(I)V", "getGetSecLabelCode", "setGetSecLabelCode", "getCanSetSecLabelCode", "setCanSetSecLabelCode", "getSecretLevel", "()Lcom/bytedance/ee/bear/secret/SecretLevel;", "setSecretLevel", "(Lcom/bytedance/ee/bear/secret/SecretLevel;)V", "getTemplate_type", "setTemplate_type", "getSecret_label_type", "setSecret_label_type", "set_external", "getDoubleCheckDefaultLabel", "setDoubleCheckDefaultLabel", "getMustSetLabel", "setMustSetLabel", "getDefaultSecretLabelId", "setDefaultSecretLabelId", "getServerTime", "getVersion", "getEditTime", "getObjId", "getSecLabelStatus", "setSecLabelStatus", "getRecommendLabelId", "setRecommendLabelId", "getSecLabelBannerType", "setSecLabelBannerType", "getFreshInfo", "()Lcom/bytedance/ee/bear/DocFreshInfo;", "getIcon_info", "setIcon_info", "getTenantName", "getDocUpgradeInfo", "()Lcom/bytedance/ee/bear/docupgrade/DocUpgradeInfo;", "getNodeId", "()J", "createSource", "getCreateSource", "setCreateSource", "wikiHomePage", "getWikiHomePage", "setWikiHomePage", "url", "getUrl", "setUrl", "isGetSecSuccess", "isGetSecDetailFail", "isSecCreateFail", "isNoSec", "isVisibleSecList", "isAutoMark", "isRecommendMark", "isSecretAdminDefault", "isSecretUnSet", "isSecTypeNotOnline", "isSecretBannerShow", "isForceSecret", "optEnable", "hasCollobrate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "docs-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocMetaInfo extends Result<Serializable> {
    public static final a Companion = null;
    public static final int DEFAULT_SEC_TYPE = -99999;
    private static final long serialVersionUID = 8194290170621603541L;
    private final String appId;
    private final String appLink;
    private int canSetSecLabelCode;
    private int createSource;
    private final String createTime;
    private final String creatorName;
    private final String creatorTenantId;
    private final String creatorUid;
    private String defaultSecretLabelId;
    private final DocUpgradeInfo docUpgradeInfo;
    private boolean doubleCheckDefaultLabel;
    private final String editTime;
    private final DocFreshInfo freshInfo;
    private int getSecLabelCode;
    private final String icon;
    private String icon_info;
    private boolean isPined;
    private boolean isStared;
    private boolean is_external;
    private boolean mustSetLabel;
    private final long nodeId;
    private final String objId;
    private final String ownerName;
    private final String ownerUid;
    private int realSubType;
    private final int realType;
    private String recommendLabelId;
    private int secLabelBannerType;
    private int secLabelStatus;
    private SecretLevel secretLevel;
    private int secret_label_type;
    private boolean secureKeyDelete;
    private final String serverTime;
    private final String subType;
    private final boolean supportMobile;
    private int template_type;
    private final String tenantName;
    private String title;
    private String url;
    private final int version;
    private boolean wikiHomePage;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DocMetaInfo() {
        this(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    }

    public DocMetaInfo(String r410) {
        Intrinsics.checkNotNullParameter(r410, "title");
        this(r410, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -2, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411) {
        Intrinsics.checkNotNullParameter(r410, "title");
        this(r410, r411, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -4, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        this(r410, r411, r412, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -8, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        this(r410, r411, r412, r413, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -16, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r414) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r414, "creatorTenantId");
        this(r410, r411, r412, r413, r414, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -32, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r414, String r415) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r414, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r415, "ownerUid");
        this(r410, r411, r412, r413, r414, r415, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -64, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r414, String r415, String r510) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r414, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r415, "ownerUid");
        Intrinsics.checkNotNullParameter(r510, "ownerName");
        this(r410, r411, r412, r413, r414, r415, r510, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, com.alipay.sdk.m.n.a.f25611g, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r414, String r415, String r510, String r511) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r414, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r415, "ownerUid");
        Intrinsics.checkNotNullParameter(r510, "ownerName");
        Intrinsics.checkNotNullParameter(r511, "createTime");
        this(r410, r411, r412, r413, r414, r415, r510, r511, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -256, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r414, String r415, String r510, String r511, String r512) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r414, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r415, "ownerUid");
        Intrinsics.checkNotNullParameter(r510, "ownerName");
        Intrinsics.checkNotNullParameter(r511, "createTime");
        Intrinsics.checkNotNullParameter(r512, "subType");
        this(r410, r411, r412, r413, r414, r415, r510, r511, r512, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, NetError.ERR_TTNET_FT_INVALID_CONNECTION, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r414, String r415, String r510, String r511, String r512, boolean r513) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r414, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r415, "ownerUid");
        Intrinsics.checkNotNullParameter(r510, "ownerName");
        Intrinsics.checkNotNullParameter(r511, "createTime");
        Intrinsics.checkNotNullParameter(r512, "subType");
        this(r410, r411, r412, r413, r414, r415, r510, r511, r512, r513, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1024, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r414, String r415, String r510, String r511, String r512, boolean r513, boolean r514) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r414, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r415, "ownerUid");
        Intrinsics.checkNotNullParameter(r510, "ownerName");
        Intrinsics.checkNotNullParameter(r511, "createTime");
        Intrinsics.checkNotNullParameter(r512, "subType");
        this(r410, r411, r412, r413, r414, r415, r510, r511, r512, r513, r514, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -2048, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r414, String r415, String r510, String r511, String r512, boolean r513, boolean r514, String r515) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r414, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r415, "ownerUid");
        Intrinsics.checkNotNullParameter(r510, "ownerName");
        Intrinsics.checkNotNullParameter(r511, "createTime");
        Intrinsics.checkNotNullParameter(r512, "subType");
        Intrinsics.checkNotNullParameter(r515, "appId");
        this(r410, r411, r412, r413, r414, r415, r510, r511, r512, r513, r514, r515, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -4096, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r414, String r415, String r510, String r511, String r512, boolean r513, boolean r514, String r515, String r516) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r414, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r415, "ownerUid");
        Intrinsics.checkNotNullParameter(r510, "ownerName");
        Intrinsics.checkNotNullParameter(r511, "createTime");
        Intrinsics.checkNotNullParameter(r512, "subType");
        Intrinsics.checkNotNullParameter(r515, "appId");
        Intrinsics.checkNotNullParameter(r516, "appLink");
        this(r410, r411, r412, r413, r414, r415, r510, r511, r512, r513, r514, r515, r516, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -8192, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r414, String r510, String r511, String r512, String r513, boolean r514, boolean r515, String r516, String r517, boolean r518) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r414, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r510, "ownerUid");
        Intrinsics.checkNotNullParameter(r511, "ownerName");
        Intrinsics.checkNotNullParameter(r512, "createTime");
        Intrinsics.checkNotNullParameter(r513, "subType");
        Intrinsics.checkNotNullParameter(r516, "appId");
        Intrinsics.checkNotNullParameter(r517, "appLink");
        this(r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r515, r516, r517, r518, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -16384, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -32768, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -65536, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -131072, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -262144, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -524288, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1048576, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -2097152, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -4194304, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -8388608, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -16777216, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -33554432, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -67108864, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711, String r712) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r712, "serverTime");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, 0, null, null, 0, null, 0, null, null, null, null, 0, -134217728, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711, String r712, int r713) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r712, "serverTime");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, null, null, 0, null, 0, null, null, null, null, 0, ShareElfFile.SectionHeader.SHF_MASKPROC, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711, String r712, int r713, String r714) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r712, "serverTime");
        Intrinsics.checkNotNullParameter(r714, "editTime");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, null, 0, null, 0, null, null, null, null, 0, -536870912, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711, String r712, int r713, String r714, String r715) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r712, "serverTime");
        Intrinsics.checkNotNullParameter(r714, "editTime");
        Intrinsics.checkNotNullParameter(r715, "objId");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, 0, null, 0, null, null, null, null, 0, -1073741824, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711, String r712, int r713, String r714, String r715, int r716) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r712, "serverTime");
        Intrinsics.checkNotNullParameter(r714, "editTime");
        Intrinsics.checkNotNullParameter(r715, "objId");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, null, 0, null, null, null, null, 0, Integer.MIN_VALUE, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711, String r712, int r713, String r714, String r715, int r716, String r717) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r712, "serverTime");
        Intrinsics.checkNotNullParameter(r714, "editTime");
        Intrinsics.checkNotNullParameter(r715, "objId");
        Intrinsics.checkNotNullParameter(r717, "recommendLabelId");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, 0, null, null, null, null, 0, 0, 63, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711, String r712, int r713, String r714, String r715, int r716, String r717, int r718) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r712, "serverTime");
        Intrinsics.checkNotNullParameter(r714, "editTime");
        Intrinsics.checkNotNullParameter(r715, "objId");
        Intrinsics.checkNotNullParameter(r717, "recommendLabelId");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, null, null, null, null, 0, 0, 62, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711, String r712, int r713, String r714, String r715, int r716, String r717, int r718, DocFreshInfo r719) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r712, "serverTime");
        Intrinsics.checkNotNullParameter(r714, "editTime");
        Intrinsics.checkNotNullParameter(r715, "objId");
        Intrinsics.checkNotNullParameter(r717, "recommendLabelId");
        Intrinsics.checkNotNullParameter(r719, "freshInfo");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, null, null, null, 0, 0, 60, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711, String r712, int r713, String r714, String r715, int r716, String r717, int r718, DocFreshInfo r719, String r810) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r712, "serverTime");
        Intrinsics.checkNotNullParameter(r714, "editTime");
        Intrinsics.checkNotNullParameter(r715, "objId");
        Intrinsics.checkNotNullParameter(r717, "recommendLabelId");
        Intrinsics.checkNotNullParameter(r719, "freshInfo");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, null, null, 0, 0, 56, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711, String r712, int r713, String r714, String r715, int r716, String r717, int r718, DocFreshInfo r719, String r810, String r811) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r712, "serverTime");
        Intrinsics.checkNotNullParameter(r714, "editTime");
        Intrinsics.checkNotNullParameter(r715, "objId");
        Intrinsics.checkNotNullParameter(r717, "recommendLabelId");
        Intrinsics.checkNotNullParameter(r719, "freshInfo");
        Intrinsics.checkNotNullParameter(r811, "tenantName");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, null, 0, 0, 48, null);
    }

    public DocMetaInfo(String r410, boolean r411, String r412, String r413, String r510, String r511, String r512, String r513, String r514, boolean r515, boolean r516, String r517, String r518, boolean r519, String r610, int r611, int r612, int r613, int r614, SecretLevel r615, int r616, int r617, boolean r618, boolean r619, boolean r710, String r711, String r712, int r713, String r714, String r715, int r716, String r717, int r718, DocFreshInfo r719, String r810, String r811, DocUpgradeInfo r812) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r510, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r511, "ownerUid");
        Intrinsics.checkNotNullParameter(r512, "ownerName");
        Intrinsics.checkNotNullParameter(r513, "createTime");
        Intrinsics.checkNotNullParameter(r514, "subType");
        Intrinsics.checkNotNullParameter(r517, "appId");
        Intrinsics.checkNotNullParameter(r518, "appLink");
        Intrinsics.checkNotNullParameter(r610, "icon");
        Intrinsics.checkNotNullParameter(r615, "secretLevel");
        Intrinsics.checkNotNullParameter(r711, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r712, "serverTime");
        Intrinsics.checkNotNullParameter(r714, "editTime");
        Intrinsics.checkNotNullParameter(r715, "objId");
        Intrinsics.checkNotNullParameter(r717, "recommendLabelId");
        Intrinsics.checkNotNullParameter(r719, "freshInfo");
        Intrinsics.checkNotNullParameter(r811, "tenantName");
        this(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, 0, 0, 32, null);
    }

    public static /* synthetic */ DocMetaInfo copy$default(DocMetaInfo r110, String r111, boolean r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, boolean r217, boolean r218, String r219, String r310, boolean r311, String r312, int r313, int r314, int r315, int r316, SecretLevel r317, int r318, int r319, boolean r410, boolean r411, boolean r412, String r413, String r414, int r415, String r416, String r417, int r418, String r419, int r510, DocFreshInfo r511, String r512, String r513, DocUpgradeInfo r514, long r515, int r516, int r517, Object r518) {
        if ((r516 & 1) == 0) goto L5;
        String r100 = r110.title;
    L7:
        if ((r516 & 2) == 0) goto L9;
        boolean r101 = r110.secureKeyDelete;
    L11:
        if ((r516 & 4) == 0) goto L13;
        String r102 = r110.creatorUid;
    L15:
        if ((r516 & 8) == 0) goto L17;
        String r103 = r110.creatorName;
    L19:
        if ((r516 & 16) == 0) goto L21;
        String r104 = r110.creatorTenantId;
    L23:
        if ((r516 & 32) == 0) goto L25;
        String r105 = r110.ownerUid;
    L27:
        if ((r516 & 64) == 0) goto L29;
        String r106 = r110.ownerName;
    L31:
        if ((r516 & 128) == 0) goto L33;
        String r107 = r110.createTime;
    L35:
        if ((r516 & 256) == 0) goto L37;
        String r113 = r110.subType;
    L39:
        if ((r516 & 512) == 0) goto L41;
        boolean r114 = r110.isPined;
    L43:
        if ((r516 & 1024) == 0) goto L45;
        boolean r115 = r110.isStared;
    L47:
        if ((r516 & 2048) == 0) goto L49;
        String r116 = r110.appId;
    L51:
        if ((r516 & 4096) == 0) goto L53;
        String r117 = r110.appLink;
    L55:
        if ((r516 & 8192) == 0) goto L57;
        boolean r118 = r110.supportMobile;
    L58:
        boolean r320 = r118;
        if ((r516 & 16384) == 0) goto L61;
        String r119 = r110.icon;
    L62:
        String r321 = r119;
        if ((r516 & 32768) == 0) goto L65;
        int r120 = r110.realType;
    L66:
        int r322 = r120;
        if ((r516 & 65536) == 0) goto L69;
        int r121 = r110.realSubType;
    L70:
        int r323 = r121;
        if ((r516 & 131072) == 0) goto L73;
        int r122 = r110.getSecLabelCode;
    L74:
        int r324 = r122;
        if ((r516 & 262144) == 0) goto L77;
        int r123 = r110.canSetSecLabelCode;
    L78:
        int r325 = r123;
        if ((r516 & 524288) == 0) goto L81;
        SecretLevel r124 = r110.secretLevel;
    L82:
        SecretLevel r326 = r124;
        if ((r516 & 1048576) == 0) goto L85;
        int r125 = r110.template_type;
    L86:
        int r327 = r125;
        if ((r516 & 2097152) == 0) goto L89;
        int r126 = r110.secret_label_type;
    L90:
        int r328 = r126;
        if ((r516 & 4194304) == 0) goto L93;
        boolean r127 = r110.is_external;
    L94:
        boolean r420 = r127;
        if ((r516 & 8388608) == 0) goto L97;
        boolean r128 = r110.doubleCheckDefaultLabel;
    L98:
        boolean r421 = r128;
        if ((r516 & 16777216) == 0) goto L101;
        boolean r129 = r110.mustSetLabel;
    L102:
        boolean r422 = r129;
        if ((r516 & 33554432) == 0) goto L105;
        String r130 = r110.defaultSecretLabelId;
    L106:
        String r423 = r130;
        if ((r516 & 67108864) == 0) goto L109;
        String r131 = r110.serverTime;
    L110:
        String r424 = r131;
        if ((r516 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r132 = r110.version;
    L114:
        int r425 = r132;
        if ((r516 & 268435456) == 0) goto L117;
        String r133 = r110.editTime;
    L118:
        String r426 = r133;
        if ((r516 & 536870912) == 0) goto L121;
        String r134 = r110.objId;
    L122:
        String r427 = r134;
        if ((r516 & 1073741824) == 0) goto L125;
        int r135 = r110.secLabelStatus;
    L127:
        if ((r516 & Integer.MIN_VALUE) == 0) goto L129;
        String r108 = r110.recommendLabelId;
    L130:
        String r428 = r108;
        if ((r517 & 1) == 0) goto L133;
        int r109 = r110.secLabelBannerType;
    L134:
        int r519 = r109;
        if ((r517 & 2) == 0) goto L137;
        DocFreshInfo r136 = r110.freshInfo;
    L138:
        DocFreshInfo r520 = r136;
        if ((r517 & 4) == 0) goto L141;
        String r137 = r110.icon_info;
    L142:
        String r521 = r137;
        if ((r517 & 8) == 0) goto L145;
        String r138 = r110.tenantName;
    L146:
        String r522 = r138;
        if ((r517 & 16) == 0) goto L149;
        DocUpgradeInfo r139 = r110.docUpgradeInfo;
    L150:
        String r329 = r117;
        int r429 = r135;
        if ((r517 & 32) == 0) goto L153;
        long r140 = r110.nodeId;
    L155:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r329, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r429, r428, r519, r520, r521, r522, r139, r140);
    L153:
        r140 = r515;
        goto L155
    L149:
        r139 = r514;
        goto L150
    L145:
        r138 = r513;
        goto L146
    L141:
        r137 = r512;
        goto L142
    L137:
        r136 = r511;
        goto L138
    L133:
        r109 = r510;
        goto L134
    L129:
        r108 = r419;
        goto L130
    L125:
        r135 = r418;
        goto L127
    L121:
        r134 = r417;
        goto L122
    L117:
        r133 = r416;
        goto L118
    L113:
        r132 = r415;
        goto L114
    L109:
        r131 = r414;
        goto L110
    L105:
        r130 = r413;
        goto L106
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
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
        return this.title;
    }

    public final boolean component10() {
        return this.isPined;
    }

    public final boolean component11() {
        return this.isStared;
    }

    public final String component12() {
        return this.appId;
    }

    public final String component13() {
        return this.appLink;
    }

    public final boolean component14() {
        return this.supportMobile;
    }

    public final String component15() {
        return this.icon;
    }

    public final int component16() {
        return this.realType;
    }

    public final int component17() {
        return this.realSubType;
    }

    public final int component18() {
        return this.getSecLabelCode;
    }

    public final int component19() {
        return this.canSetSecLabelCode;
    }

    public final boolean component2() {
        return this.secureKeyDelete;
    }

    public final SecretLevel component20() {
        return this.secretLevel;
    }

    public final int component21() {
        return this.template_type;
    }

    public final int component22() {
        return this.secret_label_type;
    }

    public final boolean component23() {
        return this.is_external;
    }

    public final boolean component24() {
        return this.doubleCheckDefaultLabel;
    }

    public final boolean component25() {
        return this.mustSetLabel;
    }

    public final String component26() {
        return this.defaultSecretLabelId;
    }

    public final String component27() {
        return this.serverTime;
    }

    public final int component28() {
        return this.version;
    }

    public final String component29() {
        return this.editTime;
    }

    public final String component3() {
        return this.creatorUid;
    }

    public final String component30() {
        return this.objId;
    }

    public final int component31() {
        return this.secLabelStatus;
    }

    public final String component32() {
        return this.recommendLabelId;
    }

    public final int component33() {
        return this.secLabelBannerType;
    }

    public final DocFreshInfo component34() {
        return this.freshInfo;
    }

    public final String component35() {
        return this.icon_info;
    }

    public final String component36() {
        return this.tenantName;
    }

    public final DocUpgradeInfo component37() {
        return this.docUpgradeInfo;
    }

    public final long component38() {
        return this.nodeId;
    }

    public final String component4() {
        return this.creatorName;
    }

    public final String component5() {
        return this.creatorTenantId;
    }

    public final String component6() {
        return this.ownerUid;
    }

    public final String component7() {
        return this.ownerName;
    }

    public final String component8() {
        return this.createTime;
    }

    public final String component9() {
        return this.subType;
    }

    public final DocMetaInfo copy(String r410, boolean r411, String r412, String r413, String r414, String r415, String r416, String r510, String r511, boolean r512, boolean r513, String r514, String r515, boolean r516, String r517, int r518, int r519, int r610, int r611, SecretLevel r612, int r613, int r614, boolean r615, boolean r616, boolean r617, String r618, String r619, int r710, String r711, String r712, int r713, String r714, int r715, DocFreshInfo r716, String r717, String r718, DocUpgradeInfo r719, long r810) {
        Intrinsics.checkNotNullParameter(r410, "title");
        Intrinsics.checkNotNullParameter(r412, "creatorUid");
        Intrinsics.checkNotNullParameter(r413, "creatorName");
        Intrinsics.checkNotNullParameter(r414, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r415, "ownerUid");
        Intrinsics.checkNotNullParameter(r416, "ownerName");
        Intrinsics.checkNotNullParameter(r510, "createTime");
        Intrinsics.checkNotNullParameter(r511, "subType");
        Intrinsics.checkNotNullParameter(r514, "appId");
        Intrinsics.checkNotNullParameter(r515, "appLink");
        Intrinsics.checkNotNullParameter(r517, "icon");
        Intrinsics.checkNotNullParameter(r612, "secretLevel");
        Intrinsics.checkNotNullParameter(r618, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r619, "serverTime");
        Intrinsics.checkNotNullParameter(r711, "editTime");
        Intrinsics.checkNotNullParameter(r712, "objId");
        Intrinsics.checkNotNullParameter(r714, "recommendLabelId");
        Intrinsics.checkNotNullParameter(r716, "freshInfo");
        Intrinsics.checkNotNullParameter(r718, "tenantName");
        return new DocMetaInfo(r410, r411, r412, r413, r414, r415, r416, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocMetaInfo) == true) goto L8;
        return false;
    L8:
        DocMetaInfo r101 = (DocMetaInfo) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (this.secureKeyDelete == r101.secureKeyDelete) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creatorUid, r101.creatorUid) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creatorName, r101.creatorName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.creatorTenantId, r101.creatorTenantId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ownerUid, r101.ownerUid) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ownerName, r101.ownerName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.subType, r101.subType) == true) goto L36;
        return false;
    L36:
        if (this.isPined == r101.isPined) goto L39;
        return false;
    L39:
        if (this.isStared == r101.isStared) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.appLink, r101.appLink) == true) goto L48;
        return false;
    L48:
        if (this.supportMobile == r101.supportMobile) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L54;
        return false;
    L54:
        if (this.realType == r101.realType) goto L57;
        return false;
    L57:
        if (this.realSubType == r101.realSubType) goto L60;
        return false;
    L60:
        if (this.getSecLabelCode == r101.getSecLabelCode) goto L63;
        return false;
    L63:
        if (this.canSetSecLabelCode == r101.canSetSecLabelCode) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.secretLevel, r101.secretLevel) == true) goto L69;
        return false;
    L69:
        if (this.template_type == r101.template_type) goto L72;
        return false;
    L72:
        if (this.secret_label_type == r101.secret_label_type) goto L75;
        return false;
    L75:
        if (this.is_external == r101.is_external) goto L78;
        return false;
    L78:
        if (this.doubleCheckDefaultLabel == r101.doubleCheckDefaultLabel) goto L81;
        return false;
    L81:
        if (this.mustSetLabel == r101.mustSetLabel) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.defaultSecretLabelId, r101.defaultSecretLabelId) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.serverTime, r101.serverTime) == true) goto L90;
        return false;
    L90:
        if (this.version == r101.version) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.editTime, r101.editTime) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.objId, r101.objId) == true) goto L99;
        return false;
    L99:
        if (this.secLabelStatus == r101.secLabelStatus) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.recommendLabelId, r101.recommendLabelId) == true) goto L105;
        return false;
    L105:
        if (this.secLabelBannerType == r101.secLabelBannerType) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.freshInfo, r101.freshInfo) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.icon_info, r101.icon_info) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.tenantName, r101.tenantName) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.docUpgradeInfo, r101.docUpgradeInfo) == true) goto L120;
        return false;
    L120:
        if (this.nodeId == r101.nodeId) goto L122;
        return false;
    L122:
        return true;
    }

    public int hashCode() {
        int r100 = this.title.hashCode() * 31;
        int r101 = 1231;
        if (this.secureKeyDelete == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((((((((((r100 + r102) * 31) + this.creatorUid.hashCode()) * 31) + this.creatorName.hashCode()) * 31) + this.creatorTenantId.hashCode()) * 31) + this.ownerUid.hashCode()) * 31) + this.ownerName.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.subType.hashCode()) * 31;
        if (this.isPined == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.isStared == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((((r105 + r106) * 31) + this.appId.hashCode()) * 31) + this.appLink.hashCode()) * 31;
        if (this.supportMobile == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (((((((((((((((((r107 + r108) * 31) + this.icon.hashCode()) * 31) + this.realType) * 31) + this.realSubType) * 31) + this.getSecLabelCode) * 31) + this.canSetSecLabelCode) * 31) + this.secretLevel.hashCode()) * 31) + this.template_type) * 31) + this.secret_label_type) * 31;
        if (this.is_external == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.doubleCheckDefaultLabel == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (r111 + r112) * 31;
        if (this.mustSetLabel == true) goto L30;
        r101 = 1237;
    L30:
        int r114 = (((((((((((((((((((r113 + r101) * 31) + this.defaultSecretLabelId.hashCode()) * 31) + this.serverTime.hashCode()) * 31) + this.version) * 31) + this.editTime.hashCode()) * 31) + this.objId.hashCode()) * 31) + this.secLabelStatus) * 31) + this.recommendLabelId.hashCode()) * 31) + this.secLabelBannerType) * 31) + this.freshInfo.hashCode()) * 31;
        String r115 = this.icon_info;
        int r116 = 0;
        if (r115 != null) goto L33;
        int r117 = 0;
    L34:
        int r118 = (((r114 + r117) * 31) + this.tenantName.hashCode()) * 31;
        DocUpgradeInfo r119 = this.docUpgradeInfo;
        if (r119 == null) goto L38;
        r116 = r119.hashCode();
    L38:
        long r120 = this.nodeId;
        return ((r118 + r116) * 31) + ((int) (r120 ^ (r120 >>> 32)));
    L33:
        r117 = r115.hashCode();
        goto L34
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "DocMetaInfo(title=" + this.title + ", secureKeyDelete=" + this.secureKeyDelete + ", creatorUid=" + this.creatorUid + ", creatorName=" + this.creatorName + ", creatorTenantId=" + this.creatorTenantId + ", ownerUid=" + this.ownerUid + ", ownerName=" + this.ownerName + ", createTime=" + this.createTime + ", subType=" + this.subType + ", isPined=" + this.isPined + ", isStared=" + this.isStared + ", appId=" + this.appId + ", appLink=" + this.appLink + ", supportMobile=" + this.supportMobile + ", icon=" + this.icon + ", realType=" + this.realType + ", realSubType=" + this.realSubType + ", getSecLabelCode=" + this.getSecLabelCode + ", canSetSecLabelCode=" + this.canSetSecLabelCode + ", secretLevel=" + this.secretLevel + ", template_type=" + this.template_type + ", secret_label_type=" + this.secret_label_type + ", is_external=" + this.is_external + ", doubleCheckDefaultLabel=" + this.doubleCheckDefaultLabel + ", mustSetLabel=" + this.mustSetLabel + ", defaultSecretLabelId=" + this.defaultSecretLabelId + ", serverTime=" + this.serverTime + ", version=" + this.version + ", editTime=" + this.editTime + ", objId=" + this.objId + ", secLabelStatus=" + this.secLabelStatus + ", recommendLabelId=" + this.recommendLabelId + ", secLabelBannerType=" + this.secLabelBannerType + ", freshInfo=" + this.freshInfo + ", icon_info=" + this.icon_info + ", tenantName=" + this.tenantName + ", docUpgradeInfo=" + this.docUpgradeInfo + ", nodeId=" + this.nodeId + ')';
    }

    public final boolean isAutoMark() {
        if (this.secLabelBannerType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isGetSecDetailFail() {
        if (this.getSecLabelCode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isGetSecSuccess() {
        if (this.getSecLabelCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNoSec() {
        if (this.getSecLabelCode != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRecommendMark() {
        if (this.secLabelBannerType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSecCreateFail() {
        if (this.getSecLabelCode != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSecTypeNotOnline() {
        if (this.secret_label_type != (-99999)) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSecretAdminDefault() {
        int r100 = this.secret_label_type;
        if (r100 != 2) goto L5;
        boolean r101 = true;
    L7:
        if (r100 != 4) goto L9;
        boolean r102 = true;
    L11:
        if (isGetSecSuccess() == false) goto L15;
        if (r101 == true) goto L17;
        if (r102 == false) goto L15;
        return true;
    L17:
        return true;
    L15:
        return false;
    L9:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L7
    }

    public final boolean isSecretUnSet() {
        if (this.secret_label_type != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isVisibleSecList() {
        if (this.canSetSecLabelCode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppLink() {
        return this.appLink;
    }

    public final int getCanSetSecLabelCode() {
        return this.canSetSecLabelCode;
    }

    public final int getCreateSource() {
        return this.createSource;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getCreatorName() {
        return this.creatorName;
    }

    public final String getCreatorTenantId() {
        return this.creatorTenantId;
    }

    public final String getCreatorUid() {
        return this.creatorUid;
    }

    public final String getDefaultSecretLabelId() {
        return this.defaultSecretLabelId;
    }

    public final DocUpgradeInfo getDocUpgradeInfo() {
        return this.docUpgradeInfo;
    }

    public final boolean getDoubleCheckDefaultLabel() {
        return this.doubleCheckDefaultLabel;
    }

    public final String getEditTime() {
        return this.editTime;
    }

    public final DocFreshInfo getFreshInfo() {
        return this.freshInfo;
    }

    public final int getGetSecLabelCode() {
        return this.getSecLabelCode;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIcon_info() {
        return this.icon_info;
    }

    public final boolean getMustSetLabel() {
        return this.mustSetLabel;
    }

    public final long getNodeId() {
        return this.nodeId;
    }

    public final String getObjId() {
        return this.objId;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final String getOwnerUid() {
        return this.ownerUid;
    }

    public final int getRealSubType() {
        return this.realSubType;
    }

    public final int getRealType() {
        return this.realType;
    }

    public final String getRecommendLabelId() {
        return this.recommendLabelId;
    }

    public final int getSecLabelBannerType() {
        return this.secLabelBannerType;
    }

    public final int getSecLabelStatus() {
        return this.secLabelStatus;
    }

    public final SecretLevel getSecretLevel() {
        return this.secretLevel;
    }

    public final int getSecret_label_type() {
        return this.secret_label_type;
    }

    public final boolean getSecureKeyDelete() {
        return this.secureKeyDelete;
    }

    public final String getServerTime() {
        return this.serverTime;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final boolean getSupportMobile() {
        return this.supportMobile;
    }

    public final int getTemplate_type() {
        return this.template_type;
    }

    public final String getTenantName() {
        return this.tenantName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getVersion() {
        return this.version;
    }

    public final boolean getWikiHomePage() {
        return this.wikiHomePage;
    }

    public final boolean isPined() {
        return this.isPined;
    }

    public final boolean isStared() {
        return this.isStared;
    }

    public final boolean is_external() {
        return this.is_external;
    }

    public final void setCanSetSecLabelCode(int r100) {
        this.canSetSecLabelCode = r100;
    }

    public final void setCreateSource(int r100) {
        this.createSource = r100;
    }

    public final void setDefaultSecretLabelId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.defaultSecretLabelId = r100;
    }

    public final void setDoubleCheckDefaultLabel(boolean r100) {
        this.doubleCheckDefaultLabel = r100;
    }

    public final void setGetSecLabelCode(int r100) {
        this.getSecLabelCode = r100;
    }

    public final void setIcon_info(String r100) {
        this.icon_info = r100;
    }

    public final void setMustSetLabel(boolean r100) {
        this.mustSetLabel = r100;
    }

    public final void setPined(boolean r100) {
        this.isPined = r100;
    }

    public final void setRealSubType(int r100) {
        this.realSubType = r100;
    }

    public final void setRecommendLabelId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recommendLabelId = r100;
    }

    public final void setSecLabelBannerType(int r100) {
        this.secLabelBannerType = r100;
    }

    public final void setSecLabelStatus(int r100) {
        this.secLabelStatus = r100;
    }

    public final void setSecretLevel(SecretLevel r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secretLevel = r100;
    }

    public final void setSecret_label_type(int r100) {
        this.secret_label_type = r100;
    }

    public final void setSecureKeyDelete(boolean r100) {
        this.secureKeyDelete = r100;
    }

    public final void setStared(boolean r100) {
        this.isStared = r100;
    }

    public final void setTemplate_type(int r100) {
        this.template_type = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    public final void setWikiHomePage(boolean r100) {
        this.wikiHomePage = r100;
    }

    public final void set_external(boolean r100) {
        this.is_external = r100;
    }

    public final boolean isSecretBannerShow(boolean r100, boolean r101, boolean r102) {
        if (isGetSecSuccess() == false) goto L8;
        if (this.secret_label_type != 1) goto L8;
        return false;
    L8:
        if (this.secret_label_type == (-99999)) goto L10;
        boolean r103 = true;
    L12:
        if (isSecretAdminDefault() == false) goto L17;
        if (r103 == false) goto L30;
        if (r100 == false) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L17:
        if (r101 == false) goto L20;
        if (r102 == false) goto L20;
        boolean r104 = true;
    L21:
        if (r100 == true) goto L25;
        if (r104 == true) goto L25;
        boolean r105 = false;
    L26:
        if (r103 == false) goto L32;
        if (r105 == false) goto L33;
        return true;
    L33:
        return false;
    L32:
        return false;
    L25:
        r105 = true;
    L20:
        r104 = false;
        goto L21
    L10:
        r103 = false;
        goto L12
    }

    public DocMetaInfo(String r110, boolean r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, boolean r217, String r218, String r219, boolean r310, String r311, int r312, int r313, int r314, int r315, SecretLevel r316, int r317, int r318, boolean r319, boolean r410, boolean r411, String r412, String r413, int r414, String r415, String r416, int r417, String r418, int r419, DocFreshInfo r510, String r511, String r512, DocUpgradeInfo r513, long r514) {
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r112, "creatorUid");
        Intrinsics.checkNotNullParameter(r210, "creatorName");
        Intrinsics.checkNotNullParameter(r211, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r212, "ownerUid");
        Intrinsics.checkNotNullParameter(r213, "ownerName");
        Intrinsics.checkNotNullParameter(r214, "createTime");
        Intrinsics.checkNotNullParameter(r215, "subType");
        Intrinsics.checkNotNullParameter(r218, "appId");
        Intrinsics.checkNotNullParameter(r219, "appLink");
        Intrinsics.checkNotNullParameter(r311, "icon");
        Intrinsics.checkNotNullParameter(r316, "secretLevel");
        Intrinsics.checkNotNullParameter(r412, "defaultSecretLabelId");
        Intrinsics.checkNotNullParameter(r413, "serverTime");
        Intrinsics.checkNotNullParameter(r415, "editTime");
        Intrinsics.checkNotNullParameter(r416, "objId");
        Intrinsics.checkNotNullParameter(r418, "recommendLabelId");
        Intrinsics.checkNotNullParameter(r510, "freshInfo");
        Intrinsics.checkNotNullParameter(r512, "tenantName");
        this.title = r110;
        this.secureKeyDelete = r111;
        this.creatorUid = r112;
        this.creatorName = r210;
        this.creatorTenantId = r211;
        this.ownerUid = r212;
        this.ownerName = r213;
        this.createTime = r214;
        this.subType = r215;
        this.isPined = r216;
        this.isStared = r217;
        this.appId = r218;
        this.appLink = r219;
        this.supportMobile = r310;
        this.icon = r311;
        this.realType = r312;
        this.realSubType = r313;
        this.getSecLabelCode = r314;
        this.canSetSecLabelCode = r315;
        this.secretLevel = r316;
        this.template_type = r317;
        this.secret_label_type = r318;
        this.is_external = r319;
        this.doubleCheckDefaultLabel = r410;
        this.mustSetLabel = r411;
        this.defaultSecretLabelId = r412;
        this.serverTime = r413;
        this.version = r414;
        this.editTime = r415;
        this.objId = r416;
        this.secLabelStatus = r417;
        this.recommendLabelId = r418;
        this.secLabelBannerType = r419;
        this.freshInfo = r510;
        this.icon_info = r511;
        this.tenantName = r512;
        this.docUpgradeInfo = r513;
        this.nodeId = r514;
        this.url = "";
    }

    public /* synthetic */ DocMetaInfo(String r410, boolean r411, String r412, String r413, String r414, String r415, String r510, String r511, String r512, boolean r513, boolean r514, String r515, String r516, boolean r517, String r518, int r519, int r610, int r611, int r612, SecretLevel r613, int r614, int r615, boolean r616, boolean r617, boolean r618, String r619, String r710, int r711, String r712, String r713, int r714, String r715, int r716, DocFreshInfo r717, String r718, String r719, DocUpgradeInfo r810, long r811, int r812, int r813, DefaultConstructorMarker r814) {
        if ((r812 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r812 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r812 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r812 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r812 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r812 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r812 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r812 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r812 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r812 & 512) == 0) goto L41;
        boolean r112 = false;
    L43:
        if ((r812 & 1024) == 0) goto L45;
        boolean r113 = false;
    L47:
        if ((r812 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r812 & 4096) == 0) goto L53;
        String r115 = "";
    L55:
        if ((r812 & 8192) == 0) goto L57;
        boolean r107 = false;
    L59:
        if ((r812 & 16384) == 0) goto L61;
        String r108 = "";
    L62:
        int r116 = -1;
        if ((r812 & 32768) == 0) goto L65;
        int r117 = -1;
    L67:
        if ((r812 & 65536) == 0) goto L69;
        int r118 = -1;
    L71:
        if ((r812 & 131072) == 0) goto L73;
        int r119 = 0;
    L75:
        if ((r812 & 262144) == 0) goto L77;
        int r210 = 0;
    L79:
        if ((r812 & 524288) == 0) goto L81;
        SecretLevel r211 = new SecretLevel(null, null, null, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 131071, null);
    L83:
        if ((r812 & 1048576) != 0) goto L87;
        r116 = r614;
    L87:
        if ((r812 & 2097152) == 0) goto L89;
        int r212 = DEFAULT_SEC_TYPE;
    L91:
        if ((r812 & 4194304) == 0) goto L93;
        boolean r213 = false;
    L95:
        if ((r812 & 8388608) == 0) goto L97;
        boolean r214 = false;
    L99:
        if ((r812 & 16777216) == 0) goto L101;
        boolean r215 = false;
    L103:
        if ((r812 & 33554432) == 0) goto L105;
        String r216 = "";
    L107:
        if ((r812 & 67108864) == 0) goto L109;
        String r217 = "";
    L111:
        if ((r812 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r218 = 0;
    L115:
        if ((r812 & 268435456) == 0) goto L117;
        String r219 = "";
    L119:
        if ((r812 & 536870912) == 0) goto L121;
        String r310 = "";
    L123:
        if ((r812 & 1073741824) == 0) goto L125;
        int r311 = 0;
    L127:
        if ((r812 & Integer.MIN_VALUE) == 0) goto L129;
        String r109 = "";
    L131:
        if ((r813 & 1) == 0) goto L133;
        int r312 = 0;
    L135:
        if ((r813 & 2) == 0) goto L137;
        DocFreshInfo r313 = new DocFreshInfo(0, 0, null, 0, 0, 0, 63, null);
    L138:
        DocUpgradeInfo r314 = null;
        if ((r813 & 4) == 0) goto L141;
        String r315 = null;
    L143:
        if ((r813 & 8) == 0) goto L145;
        String r316 = "";
    L147:
        if ((r813 & 16) != 0) goto L151;
        r314 = r810;
    L151:
        if ((r813 & 32) == 0) goto L153;
        long r317 = 0;
    L154:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r117, r118, r119, r210, r211, r116, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r109, r312, r313, r315, r316, r314, r317);
        return;
    L153:
        r317 = r811;
        goto L154
    L145:
        r316 = r719;
        goto L147
    L141:
        r315 = r718;
        goto L143
    L137:
        r313 = r717;
        goto L138
    L133:
        r312 = r716;
        goto L135
    L129:
        r109 = r715;
        goto L131
    L125:
        r311 = r714;
        goto L127
    L121:
        r310 = r713;
        goto L123
    L117:
        r219 = r712;
        goto L119
    L113:
        r218 = r711;
        goto L115
    L109:
        r217 = r710;
        goto L111
    L105:
        r216 = r619;
        goto L107
    L101:
        r215 = r618;
        goto L103
    L97:
        r214 = r617;
        goto L99
    L93:
        r213 = r616;
        goto L95
    L89:
        r212 = r615;
        goto L91
    L81:
        r211 = r613;
        goto L83
    L77:
        r210 = r612;
        goto L79
    L73:
        r119 = r611;
        goto L75
    L69:
        r118 = r610;
        goto L71
    L65:
        r117 = r519;
        goto L67
    L61:
        r108 = r518;
        goto L62
    L57:
        r107 = r517;
        goto L59
    L53:
        r115 = r516;
        goto L55
    L49:
        r114 = r515;
        goto L51
    L45:
        r113 = r514;
        goto L47
    L41:
        r112 = r513;
        goto L43
    L37:
        r111 = r512;
        goto L39
    L33:
        r110 = r511;
        goto L35
    L29:
        r106 = r510;
        goto L31
    L25:
        r105 = r415;
        goto L27
    L21:
        r104 = r414;
        goto L23
    L17:
        r103 = r413;
        goto L19
    L13:
        r102 = r412;
        goto L15
    L9:
        r101 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }
}
