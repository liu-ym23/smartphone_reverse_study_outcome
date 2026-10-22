package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u0012\u0012\u0007\u0010\u0086\u0002\u001a\u00020\u0002¢\u0006\u0006\b\u0087\u0002\u0010\u0088\u0002J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tJ\u0011\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001R\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R$\u0010,\u001a\u00020&2\u0006\u0010'\u001a\u00020&8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u000202018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R(\u0010;\u001a\u0004\u0018\u0001062\b\u0010'\u001a\u0004\u0018\u0001068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010\u0016R\u0014\u0010?\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u0010\u0016R\u0016\u0010A\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010\u0016R\u0016\u0010E\u001a\u0004\u0018\u00010B8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020\"8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bF\u0010$R\u0014\u0010I\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u0010\u0016R\u0016\u0010M\u001a\u0004\u0018\u00010J8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0016\u0010Q\u001a\u0004\u0018\u00010N8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0018\u0010T\u001a\u000606j\u0002`R8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bS\u00108R\u0016\u0010V\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bU\u0010\u0016R\u0018\u0010Y\u001a\u00060\"j\u0002`W8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bX\u0010$R\u001e\u0010_\u001a\u0004\u0018\u00010Z8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001e\u0010e\u001a\u0004\u0018\u00010`8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010k\u001a\u00020f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0014\u0010m\u001a\u00020\u00188\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bl\u0010\u001aR\u0014\u0010o\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bn\u0010\u0016R\u0016\u0010q\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bp\u0010\u0016R\u0016\u0010s\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\br\u0010\u0016R\u0016\u0010w\u001a\u0004\u0018\u00010t8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0014\u0010y\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bx\u0010\u0016R\u0016\u0010}\u001a\u0004\u0018\u00010z8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b{\u0010|R\u001e\u0010\u0081\u0001\u001a\u00020\u00188\u0016@\u0016X\u0096\u000f¢\u0006\r\u001a\u0004\b~\u0010\u001a\"\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R!\u0010\u008a\u0001\u001a\f\u0018\u00010\u0086\u0001j\u0005\u0018\u0001`\u0087\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000f¢\u0006\u000f\u001a\u0005\b\u008b\u0001\u0010\u0016\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\"\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000f¢\u0006\u000f\u001a\u0005\b\u008f\u0001\u0010\u0016\"\u0006\b\u0090\u0001\u0010\u008d\u0001R\u001a\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R!\u0010\u0096\u0001\u001a\u00020\r8\u0016@\u0016X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R$\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0016@\u0016X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001a\u0010£\u0001\u001a\u0005\u0018\u00010 \u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¡\u0001\u0010¢\u0001R\u0016\u0010¥\u0001\u001a\u00020\u00188\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010\u001aR \u0010¨\u0001\u001a\u00020\u00188\u0016@\u0016X\u0096\u000f¢\u0006\u000f\u001a\u0005\b¦\u0001\u0010\u001a\"\u0006\b§\u0001\u0010\u0080\u0001R\u0016\u0010ª\u0001\u001a\u00020\"8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b©\u0001\u0010$R\u001a\u0010®\u0001\u001a\u0005\u0018\u00010«\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R\u0016\u0010°\u0001\u001a\u00020\u00188\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¯\u0001\u0010\u001aR\u001f\u0010³\u0001\u001a\u000b\u0012\u0005\u0012\u00030±\u0001\u0018\u00010\u00108\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b²\u0001\u0010\u0013R\u001a\u0010·\u0001\u001a\u0005\u0018\u00010´\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001R%\u0010º\u0001\u001a\u0011\u0012\u0004\u0012\u00020\"\u0012\u0005\u0012\u00030¸\u0001\u0018\u0001018\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¹\u0001\u00104R\"\u0010½\u0001\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000f¢\u0006\u000f\u001a\u0005\b»\u0001\u0010\u0016\"\u0006\b¼\u0001\u0010\u008d\u0001R\u0018\u0010¿\u0001\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010\u0016R \u0010Ã\u0001\u001a\f\u0012\u0005\u0012\u00030Á\u0001\u0018\u00010À\u00018\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bÂ\u0001\u0010\u0013R\u001a\u0010Ç\u0001\u001a\u0005\u0018\u00010Ä\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u001a\u0010Ë\u0001\u001a\u0005\u0018\u00010È\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÉ\u0001\u0010Ê\u0001R\u0016\u0010Í\u0001\u001a\u00020\"8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bÌ\u0001\u0010$R\u001a\u0010Ñ\u0001\u001a\u0005\u0018\u00010Î\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÏ\u0001\u0010Ð\u0001R\u0018\u0010Õ\u0001\u001a\u00030Ò\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bÓ\u0001\u0010Ô\u0001R\u0018\u0010×\u0001\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bÖ\u0001\u0010\u0016R\u0016\u0010Ù\u0001\u001a\u00020\"8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bØ\u0001\u0010$R\u001c\u0010Û\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u00108\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bÚ\u0001\u0010\u0013R\u0018\u0010Ý\u0001\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bÜ\u0001\u0010\u0016R \u0010à\u0001\u001a\u00020\u00188\u0016@\u0016X\u0096\u000f¢\u0006\u000f\u001a\u0005\bÞ\u0001\u0010\u001a\"\u0006\bß\u0001\u0010\u0080\u0001R\"\u0010ã\u0001\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000f¢\u0006\u000f\u001a\u0005\bá\u0001\u0010\u0016\"\u0006\bâ\u0001\u0010\u008d\u0001R\u0018\u0010å\u0001\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bä\u0001\u0010\u0016R\u0016\u0010ç\u0001\u001a\u00020\u00188\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bæ\u0001\u0010\u001aR\"\u0010ê\u0001\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000f¢\u0006\u000f\u001a\u0005\bè\u0001\u0010\u0016\"\u0006\bé\u0001\u0010\u008d\u0001R\u0018\u0010ì\u0001\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\bë\u0001\u0010\u0016R \u0010ð\u0001\u001a\u00020\"8\u0016@\u0016X\u0096\u000f¢\u0006\u000f\u001a\u0005\bí\u0001\u0010$\"\u0006\bî\u0001\u0010ï\u0001R\u0016\u0010ò\u0001\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bñ\u0001\u0010\u0016R\u0016\u0010ô\u0001\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\bó\u0001\u0010\u0016R\u0017\u0010ö\u0001\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bõ\u0001\u0010\u0097\u0001R\u0016\u0010ø\u0001\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b÷\u0001\u0010\u0016R\"\u0010û\u0001\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000f¢\u0006\u000f\u001a\u0005\bù\u0001\u0010\u0016\"\u0006\bú\u0001\u0010\u008d\u0001R\u001b\u0010þ\u0001\u001a\u00070\"j\u0003`ü\u00018\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\bý\u0001\u0010$R \u0010\u0081\u0002\u001a\u00020\u00188\u0016@\u0016X\u0096\u000f¢\u0006\u000f\u001a\u0005\bÿ\u0001\u0010\u001a\"\u0006\b\u0080\u0002\u0010\u0080\u0001R\u0016\u0010\u0083\u0002\u001a\u00020\u00188\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0082\u0002\u0010\u001aR\u0016\u0010\u0085\u0002\u001a\u00020\"8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0084\u0002\u0010$¨\u0006\u0089\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/z0;", "Lcom/bytedance/android/livesdk/link/model/k5;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "uid", "", "isFromUser", "isToUser", "", "Lcom/bytedance/android/livesdk/link/model/t1;", "getUserScores", "()Ljava/util/List;", "userScores", "getScoreUpdateLogId", "()Ljava/lang/String;", "scoreUpdateLogId", "", "getUpdateMessageFrom", "()I", "updateMessageFrom", "Lcom/bytedance/android/livesdk/link/model/n3;", "getBreakthroughInfo", "()Lcom/bytedance/android/livesdk/link/model/n3;", "breakthroughInfo", "getSwitchPlayMode", "switchPlayMode", "", "getMatchType", "()J", "matchType", "Lcom/bytedance/android/livesdk/link/model/IBattleBarConfig;", "value", "getBattleBarConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleBarConfig;", "setBattleBarConfig", "(Lcom/bytedance/android/livesdk/link/model/IBattleBarConfig;)V", "battleBarConfig", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getFromUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "fromUser", "", "Lcom/bytedance/android/livesdk/link/model/t0$a;", "getAuxiliaryScoreInfo", "()Ljava/util/Map;", "auxiliaryScoreInfo", "Lcom/bytedance/android/live/base/model/message/m0;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "get_fromUserId", "_fromUserId", "get_guestId", "_guestId", "getAckMessage", "ackMessage", "Lcom/bytedance/android/live/liveinteract/plantform/model/f;", "getActionSource", "()Lcom/bytedance/android/live/liveinteract/plantform/model/f;", "actionSource", "getAnchorLinkMicId", "anchorLinkMicId", "getAnchorLinkMicIdStr", "anchorLinkMicIdStr", "Lcom/bytedance/android/livesdk/message/linker/b;", "getBackupInfo", "()Lcom/bytedance/android/livesdk/message/linker/b;", "backupInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IBanUser;", "getBanAnchorInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IBanUser;", "banAnchorInfo", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getBaseMessage2", "baseMessage2", "getBizTag", "bizTag", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "channelId", "Lcom/bytedance/android/livesdk/chatroom/model/t;", "getChorusAccompanimentInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/t;", "setChorusAccompanimentInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/t;)V", "chorusAccompanimentInfo", "Lcom/bytedance/android/livesdk/chatroom/model/v;", "getChorusCDNInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/v;", "setChorusCDNInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/v;)V", "chorusCDNInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUIInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setClientUIInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "clientUIInfo", "getControlType", "controlType", "getFromUserIdStr", "fromUserIdStr", "getFunctionType2", "functionType2", "getGameBarrageLinkerFinishReason", "gameBarrageLinkerFinishReason", "Lcom/bytedance/android/live/liveinteract/plantform/model/e;", "getGameInviteInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/e;", "gameInviteInfo", "getGetFromUserId", "getFromUserId", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getGuestLinkMicInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "guestLinkMicInfo", "getInitSource", "setInitSource", "(I)V", "initSource", "Lpy/k;", "getInviteImage", "()Lpy/k;", "inviteImage", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getInviteMsg", "()Lcom/bytedance/android/live/base/model/message/a5;", "inviteMsg", "getInvitePrompt", "setInvitePrompt", "(Ljava/lang/String;)V", "invitePrompt", "getInviteSubtitle", "setInviteSubtitle", "inviteSubtitle", "Lcom/bytedance/android/livesdk/message/model/c8;", "getInvitorInfo", "()Lcom/bytedance/android/livesdk/message/model/c8;", "invitorInfo", "isSupportCamera", "()Z", "setSupportCamera", "(Z)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "getJoinChannelData", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "setJoinChannelData", "(Lcom/bytedance/android/live/liveinteract/plantform/model/q0;)V", "joinChannelData", "Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "getJoinTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "joinTeamFightInfo", "getKickOutSource", "kickOutSource", "getLayout", "setLayout", "layout", "getLinkDuration", "linkDuration", "Lcom/bytedance/android/livesdk/link/model/c6;", "getLinkGameInfo", "()Lcom/bytedance/android/livesdk/link/model/c6;", "linkGameInfo", "getLinkType", "linkType", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getLinkedListUsers", "linkedListUsers", "Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "getLinkerBaseInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "linkerBaseInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "getLinkerContentMap", "linkerContentMap", "getLinkerSessionId", "setLinkerSessionId", "linkerSessionId", "getLiveCoreExtInfo", "liveCoreExtInfo", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "getLockedPositions", "lockedPositions", "Lcom/bytedance/android/live/liveinteract/plantform/model/e0;", "getMcuContent", "()Lcom/bytedance/android/live/liveinteract/plantform/model/e0;", "mcuContent", "Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "getMessageBoardInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "messageBoardInfo", "getMessageId2", "messageId2", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "multiRtcInfo", "getOpenSource", "openSource", "getPaidCount", "paidCount", "getPlayModes", "playModes", "getPrompts", "prompts", "getPushRtcType", "setPushRtcType", "pushRtcType", "getRemoteLinkerSessionId", "setRemoteLinkerSessionId", "remoteLinkerSessionId", "getReplyPrompts", "replyPrompts", "getReplyType", "replyType", "getRivalLinkmicIdStr", "setRivalLinkmicIdStr", "rivalLinkmicIdStr", "getRtcExtInfo", "rtcExtInfo", "getScene", "setScene", "(J)V", "scene", "getSceneLayoutInfo", "sceneLayoutInfo", "getSecFromUserId", "secFromUserId", "getSwitchToSilence", "switchToSilence", "getToUserId", "toUserId", "getTrackingData", "setTrackingData", "trackingData", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getType2", "type2", "getUiLayout", "setUiLayout", "uiLayout", "getValidScene", "validScene", "getVersion", "version", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/z0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkMicMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.z0, k5> implements k5, com.bytedance.android.livesdk.link.model.bridge.z0 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.z0 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.z0>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.z0>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getAckMessage() {
        return this.$$delegate_0.getAckMessage();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.liveinteract.plantform.model.f getActionSource() {
        return this.$$delegate_0.getActionSource();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public long getAnchorLinkMicId() {
        return this.$$delegate_0.getAnchorLinkMicId();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getAnchorLinkMicIdStr() {
        return this.$$delegate_0.getAnchorLinkMicIdStr();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.livesdk.message.linker.b getBackupInfo() {
        return this.$$delegate_0.getBackupInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public IBanUser getBanAnchorInfo() {
        return this.$$delegate_0.getBanAnchorInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.base.model.message.m0 getBaseMessage2() {
        return this.$$delegate_0.getBaseMessage2();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getBizTag() {
        return this.$$delegate_0.getBizTag();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public long getChannelId() {
        return this.$$delegate_0.getChannelId();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.livesdk.chatroom.model.t getChorusAccompanimentInfo() {
        return this.$$delegate_0.getChorusAccompanimentInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.livesdk.chatroom.model.v getChorusCDNInfo() {
        return this.$$delegate_0.getChorusCDNInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public ClientUIInfo getClientUIInfo() {
        return this.$$delegate_0.getClientUIInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return (com.bytedance.android.live.base.model.message.m0) get(1, k5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public int getControlType() {
        return this.$$delegate_0.getControlType();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getFromUserIdStr() {
        return this.$$delegate_0.getFromUserIdStr();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getFunctionType2() {
        return this.$$delegate_0.getFunctionType2();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getGameBarrageLinkerFinishReason() {
        return this.$$delegate_0.getGameBarrageLinkerFinishReason();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.liveinteract.plantform.model.e getGameInviteInfo() {
        return this.$$delegate_0.getGameInviteInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getGetFromUserId() {
        return this.$$delegate_0.getGetFromUserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.livesdk.link.model.bridge.j1 getGuestLinkMicInfo() {
        return this.$$delegate_0.getGuestLinkMicInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public int getInitSource() {
        return this.$$delegate_0.getInitSource();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public py.k getInviteImage() {
        return this.$$delegate_0.getInviteImage();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.base.model.message.a5 getInviteMsg() {
        return this.$$delegate_0.getInviteMsg();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getInvitePrompt() {
        return this.$$delegate_0.getInvitePrompt();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getInviteSubtitle() {
        return this.$$delegate_0.getInviteSubtitle();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.livesdk.message.model.c8 getInvitorInfo() {
        return this.$$delegate_0.getInvitorInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.liveinteract.plantform.model.q0 getJoinChannelData() {
        return this.$$delegate_0.getJoinChannelData();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.liveinteract.plantform.model.j0 getJoinTeamFightInfo() {
        return this.$$delegate_0.getJoinTeamFightInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public int getKickOutSource() {
        return this.$$delegate_0.getKickOutSource();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public int getLayout() {
        return this.$$delegate_0.getLayout();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public long getLinkDuration() {
        return this.$$delegate_0.getLinkDuration();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public c6 getLinkGameInfo() {
        return this.$$delegate_0.getLinkGameInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public int getLinkType() {
        return this.$$delegate_0.getLinkType();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedListUsers() {
        return this.$$delegate_0.getLinkedListUsers();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.liveinteract.plantform.model.q getLinkerBaseInfo() {
        return this.$$delegate_0.getLinkerBaseInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public Map<Long, com.bytedance.android.livesdk.link.model.bridge.g2> getLinkerContentMap() {
        return this.$$delegate_0.getLinkerContentMap();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getLinkerSessionId() {
        return this.$$delegate_0.getLinkerSessionId();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getLiveCoreExtInfo() {
        return this.$$delegate_0.getLiveCoreExtInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public List<LinkmicPositionItem> getLockedPositions() {
        return this.$$delegate_0.getLockedPositions();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.liveinteract.plantform.model.e0 getMcuContent() {
        return this.$$delegate_0.getMcuContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public IMessageBoardInfo getMessageBoardInfo() {
        return this.$$delegate_0.getMessageBoardInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public long getMessageId2() {
        return this.$$delegate_0.getMessageId2();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.livesdk.link.model.bridge.u1 getMultiLiveCoreInfo() {
        return this.$$delegate_0.getMultiLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo() {
        return this.$$delegate_0.getMultiRtcInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getOpenSource() {
        return this.$$delegate_0.getOpenSource();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public long getPaidCount() {
        return this.$$delegate_0.getPaidCount();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public List<Integer> getPlayModes() {
        return this.$$delegate_0.getPlayModes();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getPrompts() {
        return this.$$delegate_0.getPrompts();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public int getPushRtcType() {
        return this.$$delegate_0.getPushRtcType();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getRemoteLinkerSessionId() {
        return this.$$delegate_0.getRemoteLinkerSessionId();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getReplyPrompts() {
        return this.$$delegate_0.getReplyPrompts();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public int getReplyType() {
        return this.$$delegate_0.getReplyType();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getRivalLinkmicIdStr() {
        return this.$$delegate_0.getRivalLinkmicIdStr();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getRtcExtInfo() {
        return this.$$delegate_0.getRtcExtInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public long getScene() {
        return this.$$delegate_0.getScene();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getSceneLayoutInfo() {
        return this.$$delegate_0.getSceneLayoutInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getSecFromUserId() {
        return this.$$delegate_0.getSecFromUserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public boolean getSwitchToSilence() {
        return this.$$delegate_0.getSwitchToSilence();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getToUserId() {
        return this.$$delegate_0.getToUserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String getTrackingData() {
        return this.$$delegate_0.getTrackingData();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public long getType2() {
        return this.$$delegate_0.getType2();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public int getUiLayout() {
        return this.$$delegate_0.getUiLayout();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public int getValidScene() {
        return this.$$delegate_0.getValidScene();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public long getVersion() {
        return this.$$delegate_0.getVersion();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String get_fromUserId() {
        return this.$$delegate_0.get_fromUserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public String get_guestId() {
        return this.$$delegate_0.get_guestId();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public boolean isFromUser(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return this.$$delegate_0.isFromUser(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public boolean isSupportCamera() {
        return this.$$delegate_0.isSupportCamera();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public boolean isToUser(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return this.$$delegate_0.isToUser(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setChorusAccompanimentInfo(com.bytedance.android.livesdk.chatroom.model.t r2) {
        this.$$delegate_0.setChorusAccompanimentInfo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setChorusCDNInfo(com.bytedance.android.livesdk.chatroom.model.v r2) {
        this.$$delegate_0.setChorusCDNInfo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setClientUIInfo(ClientUIInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setClientUIInfo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setInitSource(int r2) {
        this.$$delegate_0.setInitSource(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setInvitePrompt(String r2) {
        this.$$delegate_0.setInvitePrompt(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setInviteSubtitle(String r2) {
        this.$$delegate_0.setInviteSubtitle(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setJoinChannelData(com.bytedance.android.live.liveinteract.plantform.model.q0 r2) {
        this.$$delegate_0.setJoinChannelData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setLayout(int r2) {
        this.$$delegate_0.setLayout(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setLinkerSessionId(String r2) {
        this.$$delegate_0.setLinkerSessionId(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setPushRtcType(int r2) {
        this.$$delegate_0.setPushRtcType(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setRemoteLinkerSessionId(String r2) {
        this.$$delegate_0.setRemoteLinkerSessionId(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setRivalLinkmicIdStr(String r2) {
        this.$$delegate_0.setRivalLinkmicIdStr(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setScene(long r2) {
        this.$$delegate_0.setScene(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setSupportCamera(boolean r2) {
        this.$$delegate_0.setSupportCamera(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setTrackingData(String r2) {
        this.$$delegate_0.setTrackingData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5, com.bytedance.android.livesdk.link.model.bridge.z0
    public void setUiLayout(int r2) {
        this.$$delegate_0.setUiLayout(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public Map<Long, t0.a> getAuxiliaryScoreInfo() {
        return (Map) get(92, k5.class, com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b());
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public IBattleBarConfig getBattleBarConfig() {
        return (IBattleBarConfig) get(90, k5.class, IBattleBarConfig.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public n3 getBreakthroughInfo() {
        return (n3) get(87, k5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public IBaseUser getFromUser() {
        return (IBaseUser) get(91, k5.class, IBaseUser.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public long getMatchType() {
        return ((Number) get(18, k5.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public String getScoreUpdateLogId() {
        return (String) get(82, k5.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public int getSwitchPlayMode() {
        return ((Number) get(83, k5.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public int getUpdateMessageFrom() {
        return ((Number) get(84, k5.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public List<t1> getUserScores() {
        return (List) get(17, k5.class);
    }

    public ILinkMicMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public void setBattleBarConfig(IBattleBarConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        set(90, "battle_bar_config", k5.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.k5
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r4) {
        set(1, "common", k5.class, r4);
    }
}
