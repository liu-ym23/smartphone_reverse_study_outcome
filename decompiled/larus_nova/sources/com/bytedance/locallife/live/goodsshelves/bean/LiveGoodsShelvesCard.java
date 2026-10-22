package com.bytedance.locallife.live.goodsshelves.bean;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.locallife.common.adapter.StringJsonAdapterFactory;
import com.bytedance.locallife.live.model.CardAtmosphere;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0003\b\u0083\u0001\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u009f\u0003\u0012\b\b\u0002\u00105\u001a\u00020\u0004\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010:\u001a\u00020\n\u0012\b\b\u0002\u0010;\u001a\u00020\u0004\u0012\b\b\u0002\u0010<\u001a\u00020\u0004\u0012\b\b\u0002\u0010=\u001a\u00020\u0004\u0012\b\b\u0002\u0010>\u001a\u00020\u0011\u0012\b\b\u0002\u0010?\u001a\u00020\u0011\u0012\b\b\u0002\u0010@\u001a\u00020\u0011\u0012\b\b\u0002\u0010A\u001a\u00020\u0004\u0012\b\b\u0002\u0010B\u001a\u00020\n\u0012\b\b\u0002\u0010C\u001a\u00020\u0004\u0012\b\b\u0002\u0010D\u001a\u00020\n\u0012\b\b\u0002\u0010E\u001a\u00020\n\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010H\u001a\u00020\n\u0012\b\b\u0002\u0010I\u001a\u00020\u0011\u0012\u0018\b\u0002\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 \u0012\b\b\u0002\u0010K\u001a\u00020\u0004\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010M\u001a\u00020\u0004\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010(\u0012\u0014\b\u0002\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0*\u0012\u0014\b\u0002\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0*\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010T\u001a\u00020\u0004\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u000103¢\u0006\u0006\b´\u0001\u0010µ\u0001J\b\u0010\u0003\u001a\u00020\u0000H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\r\u001a\u00020\nHÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0011HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0011HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0011HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\nHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0011HÆ\u0003J\u0019\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010$HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010(HÆ\u0003J\u0015\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0*HÆ\u0003J\u0015\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0*HÆ\u0003J\u0012\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0012\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b/\u0010.J\t\u00100\u001a\u00020\u0004HÆ\u0003J\u0012\u00101\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b1\u00102J\u000b\u00104\u001a\u0004\u0018\u000103HÆ\u0003J¦\u0003\u0010W\u001a\u00020\u00002\b\b\u0002\u00105\u001a\u00020\u00042\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010:\u001a\u00020\n2\b\b\u0002\u0010;\u001a\u00020\u00042\b\b\u0002\u0010<\u001a\u00020\u00042\b\b\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010>\u001a\u00020\u00112\b\b\u0002\u0010?\u001a\u00020\u00112\b\b\u0002\u0010@\u001a\u00020\u00112\b\b\u0002\u0010A\u001a\u00020\u00042\b\b\u0002\u0010B\u001a\u00020\n2\b\b\u0002\u0010C\u001a\u00020\u00042\b\b\u0002\u0010D\u001a\u00020\n2\b\b\u0002\u0010E\u001a\u00020\n2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010H\u001a\u00020\n2\b\b\u0002\u0010I\u001a\u00020\u00112\u0018\b\u0002\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 2\b\b\u0002\u0010K\u001a\u00020\u00042\n\b\u0002\u0010L\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010M\u001a\u00020\u00042\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010(2\u0014\b\u0002\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0*2\u0014\b\u0002\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0*2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010T\u001a\u00020\u00042\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010V\u001a\u0004\u0018\u000103HÆ\u0001¢\u0006\u0004\bW\u0010XJ\t\u0010Y\u001a\u00020\nHÖ\u0001J\t\u0010Z\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\\\u001a\u00020\u00112\b\u0010[\u001a\u0004\u0018\u00010!HÖ\u0003R\u0017\u00105\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b5\u0010]\u001a\u0004\b^\u0010_R$\u00106\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR$\u00107\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001c\u00108\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010j\u001a\u0004\bk\u0010lR$\u00109\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010j\u001a\u0004\bm\u0010l\"\u0004\bn\u0010oR\u0017\u0010:\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b:\u0010j\u001a\u0004\bp\u0010lR\u0017\u0010;\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b;\u0010]\u001a\u0004\bq\u0010_R\u0017\u0010<\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b<\u0010]\u001a\u0004\br\u0010_R\u0017\u0010=\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b=\u0010]\u001a\u0004\bs\u0010_R\u0017\u0010>\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b>\u0010t\u001a\u0004\b>\u0010uR\u0017\u0010?\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b?\u0010t\u001a\u0004\b?\u0010uR\"\u0010@\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010t\u001a\u0004\b@\u0010u\"\u0004\bv\u0010wR\u0017\u0010A\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bA\u0010]\u001a\u0004\bx\u0010_R\u0017\u0010B\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\bB\u0010j\u001a\u0004\by\u0010lR\u0017\u0010C\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bC\u0010]\u001a\u0004\bz\u0010_R\u0017\u0010D\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\bD\u0010j\u001a\u0004\b{\u0010lR\u0017\u0010E\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\bE\u0010j\u001a\u0004\b|\u0010lR\u0019\u0010F\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\bF\u0010}\u001a\u0004\b~\u0010\u007fR)\u0010G\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bG\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R$\u0010H\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bH\u0010j\u001a\u0005\b\u0085\u0001\u0010l\"\u0005\b\u0086\u0001\u0010oR#\u0010I\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\bI\u0010t\u001a\u0004\bI\u0010u\"\u0005\b\u0087\u0001\u0010wR7\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bJ\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R%\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0004\bK\u0010]\u001a\u0005\b\u008d\u0001\u0010_\"\u0006\b\u008e\u0001\u0010\u008f\u0001R)\u0010L\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bL\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R%\u0010M\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\bM\u0010]\u001a\u0005\b\u0095\u0001\u0010_\"\u0006\b\u0096\u0001\u0010\u008f\u0001R&\u0010N\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bN\u0010j\u001a\u0005\b\u0097\u0001\u0010l\"\u0005\b\u0098\u0001\u0010oR)\u0010O\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bO\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R3\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0*8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bP\u0010\u0088\u0001\u001a\u0006\b\u009e\u0001\u0010\u008a\u0001\"\u0006\b\u009f\u0001\u0010\u008c\u0001R3\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0*8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bQ\u0010\u0088\u0001\u001a\u0006\b \u0001\u0010\u008a\u0001\"\u0006\b¡\u0001\u0010\u008c\u0001R(\u0010R\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bR\u0010¢\u0001\u001a\u0005\b£\u0001\u0010.\"\u0006\b¤\u0001\u0010¥\u0001R(\u0010S\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bS\u0010¢\u0001\u001a\u0005\b¦\u0001\u0010.\"\u0006\b§\u0001\u0010¥\u0001R%\u0010T\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0004\bT\u0010]\u001a\u0005\b¨\u0001\u0010_\"\u0006\b©\u0001\u0010\u008f\u0001R'\u0010U\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bU\u0010ª\u0001\u001a\u0004\bU\u00102\"\u0006\b«\u0001\u0010¬\u0001R)\u0010V\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bV\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R&\u0010²\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010t\u001a\u0005\b²\u0001\u0010u\"\u0005\b³\u0001\u0010w¨\u0006¶\u0001"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesCard;", "Ljava/io/Serializable;", "", "clone", "", "component1", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardData;", "component2", "Lcom/bytedance/locallife/live/goodsshelves/bean/RewardTaskInfo;", "component3", "", "component4", "component5", "component6", "component7", "component8", "component9", "", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "Lcom/bytedance/locallife/live/goodsshelves/bean/MiniCardExtra;", "component18", "Lcom/bytedance/locallife/live/goodsshelves/bean/RecommendCardData;", "component19", "component20", "component21", "", "", "component22", "component23", "Lcom/bytedance/locallife/live/goodsshelves/bean/Groupinfo;", "component24", "component25", "component26", "Lcom/bytedance/locallife/live/model/CardAtmosphere;", "component27", "", "component28", "component29", "component30", "()Ljava/lang/Integer;", "component31", "component32", "component33", "()Ljava/lang/Boolean;", "Lcom/bytedance/locallife/live/goodsshelves/bean/l0;", "component34", "TransformType", "card_data", "product_reward_task_info", "cardId", "cardUrl", "component_id", "component_sub_type", "component_type", "create_time", "is_agg_card", "is_selected", "is_showing", "live_card_type", SendClosePdpEventParam.KEY_LYNX_URL, "source", "web_url", "place_order_url", "mini_card_extra", "single_recommend_card", "cli_extra", "isExplainingBar", "extraLog", "cardDynamicType", "groupInfo", "localOrder", "request_id", "cardAtmosphere", "extraMap", "extraSession", "enterType", "authType", "cloneFlag", "isTopShowing", "parsedFeConfig", "copy", "(ILcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardData;Lcom/bytedance/locallife/live/goodsshelves/bean/RewardTaskInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIZZZILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/live/goodsshelves/bean/MiniCardExtra;Lcom/bytedance/locallife/live/goodsshelves/bean/RecommendCardData;Ljava/lang/String;ZLjava/util/Map;ILcom/bytedance/locallife/live/goodsshelves/bean/Groupinfo;ILjava/lang/String;Lcom/bytedance/locallife/live/model/CardAtmosphere;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Boolean;Lcom/bytedance/locallife/live/goodsshelves/bean/l0;)Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesCard;", "toString", "hashCode", "other", "equals", "I", "getTransformType", "()I", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardData;", "getCard_data", "()Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardData;", "setCard_data", "(Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardData;)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/RewardTaskInfo;", "getProduct_reward_task_info", "()Lcom/bytedance/locallife/live/goodsshelves/bean/RewardTaskInfo;", "setProduct_reward_task_info", "(Lcom/bytedance/locallife/live/goodsshelves/bean/RewardTaskInfo;)V", "Ljava/lang/String;", "getCardId", "()Ljava/lang/String;", "getCardUrl", "setCardUrl", "(Ljava/lang/String;)V", "getComponent_id", "getComponent_sub_type", "getComponent_type", "getCreate_time", "Z", "()Z", "set_showing", "(Z)V", "getLive_card_type", "getLynx_url", "getSource", "getWeb_url", "getPlace_order_url", "Lcom/bytedance/locallife/live/goodsshelves/bean/MiniCardExtra;", "getMini_card_extra", "()Lcom/bytedance/locallife/live/goodsshelves/bean/MiniCardExtra;", "Lcom/bytedance/locallife/live/goodsshelves/bean/RecommendCardData;", "getSingle_recommend_card", "()Lcom/bytedance/locallife/live/goodsshelves/bean/RecommendCardData;", "setSingle_recommend_card", "(Lcom/bytedance/locallife/live/goodsshelves/bean/RecommendCardData;)V", "getCli_extra", "setCli_extra", "setExplainingBar", "Ljava/util/Map;", "getExtraLog", "()Ljava/util/Map;", "setExtraLog", "(Ljava/util/Map;)V", "getCardDynamicType", "setCardDynamicType", "(I)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/Groupinfo;", "getGroupInfo", "()Lcom/bytedance/locallife/live/goodsshelves/bean/Groupinfo;", "setGroupInfo", "(Lcom/bytedance/locallife/live/goodsshelves/bean/Groupinfo;)V", "getLocalOrder", "setLocalOrder", "getRequest_id", "setRequest_id", "Lcom/bytedance/locallife/live/model/CardAtmosphere;", "getCardAtmosphere", "()Lcom/bytedance/locallife/live/model/CardAtmosphere;", "setCardAtmosphere", "(Lcom/bytedance/locallife/live/model/CardAtmosphere;)V", "getExtraMap", "setExtraMap", "getExtraSession", "setExtraSession", "Ljava/lang/Integer;", "getEnterType", "setEnterType", "(Ljava/lang/Integer;)V", "getAuthType", "setAuthType", "getCloneFlag", "setCloneFlag", "Ljava/lang/Boolean;", "setTopShowing", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/l0;", "getParsedFeConfig", "()Lcom/bytedance/locallife/live/goodsshelves/bean/l0;", "setParsedFeConfig", "(Lcom/bytedance/locallife/live/goodsshelves/bean/l0;)V", "isTriggerImagePreload", "setTriggerImagePreload", "<init>", "(ILcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardData;Lcom/bytedance/locallife/live/goodsshelves/bean/RewardTaskInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIZZZILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/live/goodsshelves/bean/MiniCardExtra;Lcom/bytedance/locallife/live/goodsshelves/bean/RecommendCardData;Ljava/lang/String;ZLjava/util/Map;ILcom/bytedance/locallife/live/goodsshelves/bean/Groupinfo;ILjava/lang/String;Lcom/bytedance/locallife/live/model/CardAtmosphere;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Boolean;Lcom/bytedance/locallife/live/goodsshelves/bean/l0;)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveGoodsShelvesCard implements Serializable, Cloneable {
    private final int TransformType;

    @SerializedName(BdpAppEventConstant.PARAMS_AUTH_TYPE)
    private Integer authType;

    @SerializedName("card_atmosphere")
    private CardAtmosphere cardAtmosphere;

    @SerializedName("card_dynamic_type")
    private int cardDynamicType;

    @SerializedName("card_id")
    private final String cardId;

    @SerializedName("card_url")
    private String cardUrl;

    @SerializedName("card_data")
    @JsonAdapter(StringJsonAdapterFactory.class)
    private LiveLocalLifeCardData card_data;
    private String cli_extra;

    @SerializedName("clone_flag")
    private int cloneFlag;
    private final String component_id;
    private final int component_sub_type;
    private final int component_type;
    private final int create_time;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE)
    private Integer enterType;

    @SerializedName("extra_log")
    private Map<String, ? extends Object> extraLog;
    private Map<String, String> extraMap;
    private Map<String, String> extraSession;

    @SerializedName("group_info")
    private Groupinfo groupInfo;
    private boolean isExplainingBar;
    private Boolean isTopShowing;
    private boolean isTriggerImagePreload;
    private final boolean is_agg_card;
    private final boolean is_selected;
    private boolean is_showing;
    private final int live_card_type;
    private int localOrder;
    private final String lynx_url;
    private final MiniCardExtra mini_card_extra;
    private l0 parsedFeConfig;
    private final String place_order_url;

    @SerializedName("product_reward_task_info")
    private RewardTaskInfo product_reward_task_info;
    private String request_id;
    private RecommendCardData single_recommend_card;
    private final int source;
    private final String web_url;

    public LiveGoodsShelvesCard() {
        this(0, null, null, null, null, null, 0, 0, 0, false, false, false, 0, null, 0, null, null, null, null, null, false, null, 0, null, 0, null, null, null, null, null, null, 0, null, null, -1, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveGoodsShelvesCard copy$default(LiveGoodsShelvesCard r110, int r111, LiveLocalLifeCardData r112, RewardTaskInfo r210, String r211, String r212, String r213, int r214, int r215, int r216, boolean r217, boolean r218, boolean r219, int r310, String r311, int r312, String r313, String r314, MiniCardExtra r315, RecommendCardData r316, String r317, boolean r318, Map r319, int r410, Groupinfo r411, int r412, String r413, CardAtmosphere r414, Map r415, Map r416, Integer r417, Integer r418, int r419, Boolean r510, l0 r511, int r512, int r513, Object r514) {
        if ((r512 & 1) == 0) goto L5;
        int r100 = r110.TransformType;
    L7:
        if ((r512 & 2) == 0) goto L9;
        LiveLocalLifeCardData r101 = r110.card_data;
    L11:
        if ((r512 & 4) == 0) goto L13;
        RewardTaskInfo r102 = r110.product_reward_task_info;
    L15:
        if ((r512 & 8) == 0) goto L17;
        String r103 = r110.cardId;
    L19:
        if ((r512 & 16) == 0) goto L21;
        String r104 = r110.cardUrl;
    L23:
        if ((r512 & 32) == 0) goto L25;
        String r105 = r110.component_id;
    L27:
        if ((r512 & 64) == 0) goto L29;
        int r106 = r110.component_sub_type;
    L31:
        if ((r512 & 128) == 0) goto L33;
        int r107 = r110.component_type;
    L35:
        if ((r512 & 256) == 0) goto L37;
        int r113 = r110.create_time;
    L39:
        if ((r512 & 512) == 0) goto L41;
        boolean r114 = r110.is_agg_card;
    L43:
        if ((r512 & 1024) == 0) goto L45;
        boolean r115 = r110.is_selected;
    L47:
        if ((r512 & 2048) == 0) goto L49;
        boolean r116 = r110.is_showing;
    L51:
        if ((r512 & 4096) == 0) goto L53;
        int r117 = r110.live_card_type;
    L55:
        if ((r512 & 8192) == 0) goto L57;
        String r118 = r110.lynx_url;
    L58:
        String r320 = r118;
        if ((r512 & 16384) == 0) goto L61;
        int r119 = r110.source;
    L62:
        int r321 = r119;
        if ((r512 & 32768) == 0) goto L65;
        String r120 = r110.web_url;
    L66:
        String r322 = r120;
        if ((r512 & 65536) == 0) goto L69;
        String r121 = r110.place_order_url;
    L70:
        String r323 = r121;
        if ((r512 & 131072) == 0) goto L73;
        MiniCardExtra r122 = r110.mini_card_extra;
    L74:
        MiniCardExtra r324 = r122;
        if ((r512 & 262144) == 0) goto L77;
        RecommendCardData r123 = r110.single_recommend_card;
    L78:
        RecommendCardData r325 = r123;
        if ((r512 & 524288) == 0) goto L81;
        String r124 = r110.cli_extra;
    L82:
        String r326 = r124;
        if ((r512 & 1048576) == 0) goto L85;
        boolean r125 = r110.isExplainingBar;
    L86:
        boolean r327 = r125;
        if ((r512 & 2097152) == 0) goto L89;
        Map r126 = r110.extraLog;
    L90:
        Map r328 = r126;
        if ((r512 & 4194304) == 0) goto L93;
        int r127 = r110.cardDynamicType;
    L94:
        int r420 = r127;
        if ((r512 & 8388608) == 0) goto L97;
        Groupinfo r128 = r110.groupInfo;
    L98:
        Groupinfo r421 = r128;
        if ((r512 & 16777216) == 0) goto L101;
        int r129 = r110.localOrder;
    L102:
        int r422 = r129;
        if ((r512 & 33554432) == 0) goto L105;
        String r130 = r110.request_id;
    L106:
        String r423 = r130;
        if ((r512 & 67108864) == 0) goto L109;
        CardAtmosphere r131 = r110.cardAtmosphere;
    L110:
        CardAtmosphere r424 = r131;
        if ((r512 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Map r132 = r110.extraMap;
    L114:
        Map r425 = r132;
        if ((r512 & 268435456) == 0) goto L117;
        Map r133 = r110.extraSession;
    L118:
        Map r426 = r133;
        if ((r512 & 536870912) == 0) goto L121;
        Integer r134 = r110.enterType;
    L122:
        Integer r427 = r134;
        if ((r512 & 1073741824) == 0) goto L125;
        Integer r135 = r110.authType;
    L127:
        if ((r512 & Integer.MIN_VALUE) == 0) goto L129;
        int r108 = r110.cloneFlag;
    L130:
        int r428 = r108;
        if ((r513 & 1) == 0) goto L133;
        Boolean r109 = r110.isTopShowing;
    L134:
        Boolean r515 = r109;
        if ((r513 & 2) == 0) goto L137;
        l0 r136 = r110.parsedFeConfig;
    L139:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r135, r428, r515, r136);
    L137:
        r136 = r511;
        goto L139
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

    public final int component1() {
        return this.TransformType;
    }

    public final boolean component10() {
        return this.is_agg_card;
    }

    public final boolean component11() {
        return this.is_selected;
    }

    public final boolean component12() {
        return this.is_showing;
    }

    public final int component13() {
        return this.live_card_type;
    }

    public final String component14() {
        return this.lynx_url;
    }

    public final int component15() {
        return this.source;
    }

    public final String component16() {
        return this.web_url;
    }

    public final String component17() {
        return this.place_order_url;
    }

    public final MiniCardExtra component18() {
        return this.mini_card_extra;
    }

    public final RecommendCardData component19() {
        return this.single_recommend_card;
    }

    public final LiveLocalLifeCardData component2() {
        return this.card_data;
    }

    public final String component20() {
        return this.cli_extra;
    }

    public final boolean component21() {
        return this.isExplainingBar;
    }

    public final Map<String, Object> component22() {
        return this.extraLog;
    }

    public final int component23() {
        return this.cardDynamicType;
    }

    public final Groupinfo component24() {
        return this.groupInfo;
    }

    public final int component25() {
        return this.localOrder;
    }

    public final String component26() {
        return this.request_id;
    }

    public final CardAtmosphere component27() {
        return this.cardAtmosphere;
    }

    public final Map<String, String> component28() {
        return this.extraMap;
    }

    public final Map<String, String> component29() {
        return this.extraSession;
    }

    public final RewardTaskInfo component3() {
        return this.product_reward_task_info;
    }

    public final Integer component30() {
        return this.enterType;
    }

    public final Integer component31() {
        return this.authType;
    }

    public final int component32() {
        return this.cloneFlag;
    }

    public final Boolean component33() {
        return this.isTopShowing;
    }

    public final l0 component34() {
        return this.parsedFeConfig;
    }

    public final String component4() {
        return this.cardId;
    }

    public final String component5() {
        return this.cardUrl;
    }

    public final String component6() {
        return this.component_id;
    }

    public final int component7() {
        return this.component_sub_type;
    }

    public final int component8() {
        return this.component_type;
    }

    public final int component9() {
        return this.create_time;
    }

    public final LiveGoodsShelvesCard copy(int r310, LiveLocalLifeCardData r311, RewardTaskInfo r312, String r410, String r411, String r412, int r413, int r414, int r415, boolean r416, boolean r417, boolean r418, int r419, String r510, int r511, String r512, String r513, MiniCardExtra r514, RecommendCardData r515, String r516, boolean r517, Map<String, ? extends Object> r518, int r519, Groupinfo r610, int r611, String r612, CardAtmosphere r613, Map<String, String> r614, Map<String, String> r615, Integer r616, Integer r617, int r618, Boolean r619, l0 r710) {
        Intrinsics.checkNotNullParameter(r412, "component_id");
        Intrinsics.checkNotNullParameter(r510, SendClosePdpEventParam.KEY_LYNX_URL);
        Intrinsics.checkNotNullParameter(r512, "web_url");
        Intrinsics.checkNotNullParameter(r513, "place_order_url");
        Intrinsics.checkNotNullParameter(r516, "cli_extra");
        Intrinsics.checkNotNullParameter(r614, "extraMap");
        Intrinsics.checkNotNullParameter(r615, "extraSession");
        return new LiveGoodsShelvesCard(r310, r311, r312, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveGoodsShelvesCard) == true) goto L8;
        return false;
    L8:
        LiveGoodsShelvesCard r101 = (LiveGoodsShelvesCard) r100;
        if (this.TransformType == r101.TransformType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.card_data, r101.card_data) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.product_reward_task_info, r101.product_reward_task_info) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cardId, r101.cardId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cardUrl, r101.cardUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.component_id, r101.component_id) == true) goto L27;
        return false;
    L27:
        if (this.component_sub_type == r101.component_sub_type) goto L30;
        return false;
    L30:
        if (this.component_type == r101.component_type) goto L33;
        return false;
    L33:
        if (this.create_time == r101.create_time) goto L36;
        return false;
    L36:
        if (this.is_agg_card == r101.is_agg_card) goto L39;
        return false;
    L39:
        if (this.is_selected == r101.is_selected) goto L42;
        return false;
    L42:
        if (this.is_showing == r101.is_showing) goto L45;
        return false;
    L45:
        if (this.live_card_type == r101.live_card_type) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.lynx_url, r101.lynx_url) == true) goto L51;
        return false;
    L51:
        if (this.source == r101.source) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.web_url, r101.web_url) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.place_order_url, r101.place_order_url) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.mini_card_extra, r101.mini_card_extra) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.single_recommend_card, r101.single_recommend_card) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.cli_extra, r101.cli_extra) == true) goto L69;
        return false;
    L69:
        if (this.isExplainingBar == r101.isExplainingBar) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.extraLog, r101.extraLog) == true) goto L75;
        return false;
    L75:
        if (this.cardDynamicType == r101.cardDynamicType) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.groupInfo, r101.groupInfo) == true) goto L81;
        return false;
    L81:
        if (this.localOrder == r101.localOrder) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.request_id, r101.request_id) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.cardAtmosphere, r101.cardAtmosphere) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.extraMap, r101.extraMap) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.extraSession, r101.extraSession) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.enterType, r101.enterType) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.authType, r101.authType) == true) goto L102;
        return false;
    L102:
        if (this.cloneFlag == r101.cloneFlag) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.isTopShowing, r101.isTopShowing) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.parsedFeConfig, r101.parsedFeConfig) == true) goto L110;
        return false;
    L110:
        return true;
    }

    public int hashCode() {
        int r100 = this.TransformType * 31;
        LiveLocalLifeCardData r101 = this.card_data;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        RewardTaskInfo r105 = this.product_reward_task_info;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.cardId;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.cardUrl;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((((((((r110 + r112) * 31) + this.component_id.hashCode()) * 31) + this.component_sub_type) * 31) + this.component_type) * 31) + this.create_time) * 31;
        int r114 = 1231;
        if (this.is_agg_card == false) goto L21;
        int r115 = 1231;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.is_selected == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        if (this.is_showing == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (((((((((((r118 + r119) * 31) + this.live_card_type) * 31) + this.lynx_url.hashCode()) * 31) + this.source) * 31) + this.web_url.hashCode()) * 31) + this.place_order_url.hashCode()) * 31;
        MiniCardExtra r121 = this.mini_card_extra;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        RecommendCardData r124 = this.single_recommend_card;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (((r123 + r125) * 31) + this.cli_extra.hashCode()) * 31;
        if (this.isExplainingBar == true) goto L42;
        r114 = 1237;
    L42:
        int r127 = (r126 + r114) * 31;
        Map<String, ? extends Object> r128 = this.extraLog;
        if (r128 != null) goto L45;
        int r129 = 0;
    L46:
        int r130 = (((r127 + r129) * 31) + this.cardDynamicType) * 31;
        Groupinfo r131 = this.groupInfo;
        if (r131 != null) goto L49;
        int r132 = 0;
    L50:
        int r133 = (((r130 + r132) * 31) + this.localOrder) * 31;
        String r134 = this.request_id;
        if (r134 != null) goto L53;
        int r135 = 0;
    L54:
        int r136 = (r133 + r135) * 31;
        CardAtmosphere r137 = this.cardAtmosphere;
        if (r137 != null) goto L57;
        int r138 = 0;
    L58:
        int r139 = (((((r136 + r138) * 31) + this.extraMap.hashCode()) * 31) + this.extraSession.hashCode()) * 31;
        Integer r140 = this.enterType;
        if (r140 != null) goto L61;
        int r141 = 0;
    L62:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.authType;
        if (r143 != null) goto L65;
        int r144 = 0;
    L66:
        int r145 = (((r142 + r144) * 31) + this.cloneFlag) * 31;
        Boolean r146 = this.isTopShowing;
        if (r146 != null) goto L69;
        int r147 = 0;
    L70:
        int r148 = (r145 + r147) * 31;
        l0 r149 = this.parsedFeConfig;
        if (r149 == null) goto L75;
        r102 = r149.hashCode();
    L75:
        return r148 + r102;
    L69:
        r147 = r146.hashCode();
        goto L70
    L65:
        r144 = r143.hashCode();
        goto L66
    L61:
        r141 = r140.hashCode();
        goto L62
    L57:
        r138 = r137.hashCode();
        goto L58
    L53:
        r135 = r134.hashCode();
        goto L54
    L49:
        r132 = r131.hashCode();
        goto L50
    L45:
        r129 = r128.hashCode();
        goto L46
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = 1237;
        goto L30
    L25:
        r117 = 1237;
        goto L26
    L21:
        r115 = 1237;
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "LiveGoodsShelvesCard(TransformType=" + this.TransformType + ", card_data=" + this.card_data + ", product_reward_task_info=" + this.product_reward_task_info + ", cardId=" + this.cardId + ", cardUrl=" + this.cardUrl + ", component_id=" + this.component_id + ", component_sub_type=" + this.component_sub_type + ", component_type=" + this.component_type + ", create_time=" + this.create_time + ", is_agg_card=" + this.is_agg_card + ", is_selected=" + this.is_selected + ", is_showing=" + this.is_showing + ", live_card_type=" + this.live_card_type + ", lynx_url=" + this.lynx_url + ", source=" + this.source + ", web_url=" + this.web_url + ", place_order_url=" + this.place_order_url + ", mini_card_extra=" + this.mini_card_extra + ", single_recommend_card=" + this.single_recommend_card + ", cli_extra=" + this.cli_extra + ", isExplainingBar=" + this.isExplainingBar + ", extraLog=" + this.extraLog + ", cardDynamicType=" + this.cardDynamicType + ", groupInfo=" + this.groupInfo + ", localOrder=" + this.localOrder + ", request_id=" + this.request_id + ", cardAtmosphere=" + this.cardAtmosphere + ", extraMap=" + this.extraMap + ", extraSession=" + this.extraSession + ", enterType=" + this.enterType + ", authType=" + this.authType + ", cloneFlag=" + this.cloneFlag + ", isTopShowing=" + this.isTopShowing + ", parsedFeConfig=" + this.parsedFeConfig + ')';
    }

    public LiveGoodsShelvesCard clone() throws CloneNotSupportedException {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesCard");
        LiveGoodsShelvesCard r101 = (LiveGoodsShelvesCard) r100;
        LiveLocalLifeCardData r102 = this.card_data;
        if (r102 == null) goto L5;
        LiveLocalLifeCardData r103 = r102.clone();
    L6:
        r101.card_data = r103;
        r101.cloneFlag = -1;
        return r101;
    L5:
        r103 = null;
        goto L6
    }

    public final Integer getAuthType() {
        return this.authType;
    }

    public final CardAtmosphere getCardAtmosphere() {
        return this.cardAtmosphere;
    }

    public final int getCardDynamicType() {
        return this.cardDynamicType;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final String getCardUrl() {
        return this.cardUrl;
    }

    public final LiveLocalLifeCardData getCard_data() {
        return this.card_data;
    }

    public final String getCli_extra() {
        return this.cli_extra;
    }

    public final int getCloneFlag() {
        return this.cloneFlag;
    }

    public final String getComponent_id() {
        return this.component_id;
    }

    public final int getComponent_sub_type() {
        return this.component_sub_type;
    }

    public final int getComponent_type() {
        return this.component_type;
    }

    public final int getCreate_time() {
        return this.create_time;
    }

    public final Integer getEnterType() {
        return this.enterType;
    }

    public final Map<String, Object> getExtraLog() {
        return this.extraLog;
    }

    public final Map<String, String> getExtraMap() {
        return this.extraMap;
    }

    public final Map<String, String> getExtraSession() {
        return this.extraSession;
    }

    public final Groupinfo getGroupInfo() {
        return this.groupInfo;
    }

    public final int getLive_card_type() {
        return this.live_card_type;
    }

    public final int getLocalOrder() {
        return this.localOrder;
    }

    public final String getLynx_url() {
        return this.lynx_url;
    }

    public final MiniCardExtra getMini_card_extra() {
        return this.mini_card_extra;
    }

    public final l0 getParsedFeConfig() {
        return this.parsedFeConfig;
    }

    public final String getPlace_order_url() {
        return this.place_order_url;
    }

    public final RewardTaskInfo getProduct_reward_task_info() {
        return this.product_reward_task_info;
    }

    public final String getRequest_id() {
        return this.request_id;
    }

    public final RecommendCardData getSingle_recommend_card() {
        return this.single_recommend_card;
    }

    public final int getSource() {
        return this.source;
    }

    public final int getTransformType() {
        return this.TransformType;
    }

    public final String getWeb_url() {
        return this.web_url;
    }

    public final boolean isExplainingBar() {
        return this.isExplainingBar;
    }

    public final Boolean isTopShowing() {
        return this.isTopShowing;
    }

    public final boolean isTriggerImagePreload() {
        return this.isTriggerImagePreload;
    }

    public final boolean is_agg_card() {
        return this.is_agg_card;
    }

    public final boolean is_selected() {
        return this.is_selected;
    }

    public final boolean is_showing() {
        return this.is_showing;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8497clone() {
        return clone();
    }

    public final void setAuthType(Integer r100) {
        this.authType = r100;
    }

    public final void setCardAtmosphere(CardAtmosphere r100) {
        this.cardAtmosphere = r100;
    }

    public final void setCardDynamicType(int r100) {
        this.cardDynamicType = r100;
    }

    public final void setCardUrl(String r100) {
        this.cardUrl = r100;
    }

    public final void setCard_data(LiveLocalLifeCardData r100) {
        this.card_data = r100;
    }

    public final void setCli_extra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cli_extra = r100;
    }

    public final void setCloneFlag(int r100) {
        this.cloneFlag = r100;
    }

    public final void setEnterType(Integer r100) {
        this.enterType = r100;
    }

    public final void setExplainingBar(boolean r100) {
        this.isExplainingBar = r100;
    }

    public final void setExtraLog(Map<String, ? extends Object> r100) {
        this.extraLog = r100;
    }

    public final void setExtraMap(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraMap = r100;
    }

    public final void setExtraSession(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraSession = r100;
    }

    public final void setGroupInfo(Groupinfo r100) {
        this.groupInfo = r100;
    }

    public final void setLocalOrder(int r100) {
        this.localOrder = r100;
    }

    public final void setParsedFeConfig(l0 r100) {
        this.parsedFeConfig = r100;
    }

    public final void setProduct_reward_task_info(RewardTaskInfo r100) {
        this.product_reward_task_info = r100;
    }

    public final void setRequest_id(String r100) {
        this.request_id = r100;
    }

    public final void setSingle_recommend_card(RecommendCardData r100) {
        this.single_recommend_card = r100;
    }

    public final void setTopShowing(Boolean r100) {
        this.isTopShowing = r100;
    }

    public final void setTriggerImagePreload(boolean r100) {
        this.isTriggerImagePreload = r100;
    }

    public final void set_showing(boolean r100) {
        this.is_showing = r100;
    }

    public LiveGoodsShelvesCard(int r110, LiveLocalLifeCardData r111, RewardTaskInfo r112, String r113, String r114, String r115, int r116, int r117, int r118, boolean r119, boolean r210, boolean r211, int r212, String r213, int r214, String r215, String r216, MiniCardExtra r217, RecommendCardData r218, String r219, boolean r310, Map<String, ? extends Object> r311, int r312, Groupinfo r313, int r314, String r315, CardAtmosphere r316, Map<String, String> r317, Map<String, String> r318, Integer r319, Integer r410, int r411, Boolean r412, l0 r413) {
        Intrinsics.checkNotNullParameter(r115, "component_id");
        Intrinsics.checkNotNullParameter(r213, SendClosePdpEventParam.KEY_LYNX_URL);
        Intrinsics.checkNotNullParameter(r215, "web_url");
        Intrinsics.checkNotNullParameter(r216, "place_order_url");
        Intrinsics.checkNotNullParameter(r219, "cli_extra");
        Intrinsics.checkNotNullParameter(r317, "extraMap");
        Intrinsics.checkNotNullParameter(r318, "extraSession");
        this.TransformType = r110;
        this.card_data = r111;
        this.product_reward_task_info = r112;
        this.cardId = r113;
        this.cardUrl = r114;
        this.component_id = r115;
        this.component_sub_type = r116;
        this.component_type = r117;
        this.create_time = r118;
        this.is_agg_card = r119;
        this.is_selected = r210;
        this.is_showing = r211;
        this.live_card_type = r212;
        this.lynx_url = r213;
        this.source = r214;
        this.web_url = r215;
        this.place_order_url = r216;
        this.mini_card_extra = r217;
        this.single_recommend_card = r218;
        this.cli_extra = r219;
        this.isExplainingBar = r310;
        this.extraLog = r311;
        this.cardDynamicType = r312;
        this.groupInfo = r313;
        this.localOrder = r314;
        this.request_id = r315;
        this.cardAtmosphere = r316;
        this.extraMap = r317;
        this.extraSession = r318;
        this.enterType = r319;
        this.authType = r410;
        this.cloneFlag = r411;
        this.isTopShowing = r412;
        this.parsedFeConfig = r413;
    }

    public /* synthetic */ LiveGoodsShelvesCard(int r310, LiveLocalLifeCardData r311, RewardTaskInfo r312, String r313, String r314, String r410, int r411, int r412, int r413, boolean r414, boolean r415, boolean r416, int r417, String r418, int r419, String r510, String r511, MiniCardExtra r512, RecommendCardData r513, String r514, boolean r515, Map r516, int r517, Groupinfo r518, int r519, String r610, CardAtmosphere r611, Map r612, Map r613, Integer r614, Integer r615, int r616, Boolean r617, l0 r618, int r619, int r710, DefaultConstructorMarker r711) {
        if ((r619 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r619 & 2) == 0) goto L9;
        LiveLocalLifeCardData r101 = null;
    L11:
        if ((r619 & 4) == 0) goto L13;
        RewardTaskInfo r102 = null;
    L15:
        if ((r619 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r619 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r619 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r619 & 64) == 0) goto L29;
        int r110 = 0;
    L31:
        if ((r619 & 128) == 0) goto L33;
        int r111 = 0;
    L35:
        if ((r619 & 256) == 0) goto L37;
        int r112 = 0;
    L39:
        if ((r619 & 512) == 0) goto L41;
        boolean r113 = false;
    L43:
        if ((r619 & 1024) == 0) goto L45;
        boolean r114 = false;
    L47:
        if ((r619 & 2048) == 0) goto L49;
        boolean r115 = false;
    L51:
        if ((r619 & 4096) == 0) goto L53;
        int r106 = 0;
    L55:
        if ((r619 & 8192) == 0) goto L57;
        String r107 = "";
    L59:
        if ((r619 & 16384) == 0) goto L61;
        int r108 = 0;
    L63:
        if ((r619 & 32768) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r619 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r619 & 131072) == 0) goto L73;
        MiniCardExtra r118 = null;
    L75:
        if ((r619 & 262144) == 0) goto L77;
        RecommendCardData r119 = null;
    L79:
        if ((r619 & 524288) == 0) goto L81;
        String r210 = "";
    L83:
        if ((r619 & 1048576) == 0) goto L85;
        boolean r211 = false;
    L87:
        if ((r619 & 2097152) == 0) goto L89;
        Map r212 = null;
    L91:
        if ((r619 & 4194304) == 0) goto L93;
        int r213 = 0;
    L95:
        if ((r619 & 8388608) == 0) goto L97;
        Groupinfo r214 = null;
    L98:
        int r215 = 1;
        if ((r619 & 16777216) == 0) goto L101;
        int r216 = 1;
    L103:
        if ((r619 & 33554432) == 0) goto L105;
        String r217 = null;
    L107:
        if ((r619 & 67108864) == 0) goto L109;
        CardAtmosphere r218 = null;
    L111:
        if ((r619 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Map r219 = new LinkedHashMap();
    L115:
        if ((r619 & 268435456) == 0) goto L117;
        Map r315 = new LinkedHashMap();
    L119:
        if ((r619 & 536870912) == 0) goto L121;
        Integer r316 = 1;
    L123:
        if ((r619 & 1073741824) == 0) goto L125;
        Integer r317 = 0;
    L127:
        if ((r619 & Integer.MIN_VALUE) != 0) goto L131;
        r215 = r616;
    L131:
        if ((r710 & 1) == 0) goto L133;
        Boolean r109 = null;
    L135:
        if ((r710 & 2) == 0) goto L137;
        l0 r318 = null;
    L138:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r216, r217, r218, r219, r315, r316, r317, r215, r109, r318);
        return;
    L137:
        r318 = r618;
        goto L138
    L133:
        r109 = r617;
        goto L135
    L125:
        r317 = r615;
        goto L127
    L121:
        r316 = r614;
        goto L123
    L117:
        r315 = r613;
        goto L119
    L113:
        r219 = r612;
        goto L115
    L109:
        r218 = r611;
        goto L111
    L105:
        r217 = r610;
        goto L107
    L101:
        r216 = r519;
        goto L103
    L97:
        r214 = r518;
        goto L98
    L93:
        r213 = r517;
        goto L95
    L89:
        r212 = r516;
        goto L91
    L85:
        r211 = r515;
        goto L87
    L81:
        r210 = r514;
        goto L83
    L77:
        r119 = r513;
        goto L79
    L73:
        r118 = r512;
        goto L75
    L69:
        r117 = r511;
        goto L71
    L65:
        r116 = r510;
        goto L67
    L61:
        r108 = r419;
        goto L63
    L57:
        r107 = r418;
        goto L59
    L53:
        r106 = r417;
        goto L55
    L49:
        r115 = r416;
        goto L51
    L45:
        r114 = r415;
        goto L47
    L41:
        r113 = r414;
        goto L43
    L37:
        r112 = r413;
        goto L39
    L33:
        r111 = r412;
        goto L35
    L29:
        r110 = r411;
        goto L31
    L25:
        r105 = r410;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
