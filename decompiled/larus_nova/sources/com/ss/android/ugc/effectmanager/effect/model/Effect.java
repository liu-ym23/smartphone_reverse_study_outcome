package com.ss.android.ugc.effectmanager.effect.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
import com.larus.bmhome.share.panel.ShareType;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate;
import com.ss.ugc.effectplatform.model.AuthorThumbModel;
import com.ss.ugc.effectplatform.model.RankingEffectModel;
import com.ss.ugc.effectplatform.model.UrlModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 «\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0002«\u0002B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010¦\u0002\u001a\u00030§\u00022\b\u0010¨\u0002\u001a\u00030©\u00022\u0007\u0010ª\u0002\u001a\u00020\\H\u0016R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R4\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR4\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR4\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR0\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000\u00172\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR0\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR4\u0010)\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR$\u0010,\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR4\u0010/\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR$\u00102\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\rR4\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u00172\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u0010\u001a\"\u0004\b8\u0010\u001cR$\u0010:\u001a\u0002092\u0006\u0010\u0007\u001a\u0002098V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b@\u0010\u000b\"\u0004\bA\u0010\rR$\u0010B\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bC\u0010\u000b\"\u0004\bD\u0010\rR$\u0010E\u001a\u0002052\u0006\u0010\u0007\u001a\u0002058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010J\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bK\u0010\u000b\"\u0004\bL\u0010\rR$\u0010M\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bN\u0010\u000b\"\u0004\bO\u0010\rR(\u0010P\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bQ\u0010\u000b\"\u0004\bR\u0010\rR$\u0010S\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bT\u0010\u000b\"\u0004\bU\u0010\rR$\u0010V\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bW\u0010\u000b\"\u0004\bX\u0010\rR$\u0010Y\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bZ\u0010\u000b\"\u0004\b[\u0010\rR$\u0010]\u001a\u00020\\2\u0006\u0010\u0007\u001a\u00020\\8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bc\u0010\u000b\"\u0004\bd\u0010\rR(\u0010e\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bf\u0010\u000b\"\u0004\bg\u0010\rR$\u0010h\u001a\u00020\\2\u0006\u0010\u0007\u001a\u00020\\8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bi\u0010_\"\u0004\bj\u0010aR(\u0010k\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bl\u0010\u000b\"\u0004\bm\u0010\rR(\u0010n\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bo\u0010\u000b\"\u0004\bp\u0010\rR$\u0010r\u001a\u00020q2\u0006\u0010\u0007\u001a\u00020q8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR$\u0010w\u001a\u0002052\u0006\u0010\u0007\u001a\u0002058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bx\u0010G\"\u0004\by\u0010IR$\u0010z\u001a\u0002092\u0006\u0010\u0007\u001a\u0002098V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b{\u0010<\"\u0004\b|\u0010>R$\u0010}\u001a\u00020\\2\u0006\u0010\u0007\u001a\u00020\\8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b~\u0010_\"\u0004\b\u007f\u0010aR'\u0010\u0080\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0001\u0010\u000b\"\u0005\b\u0082\u0001\u0010\rR'\u0010\u0083\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0084\u0001\u0010\u000b\"\u0005\b\u0085\u0001\u0010\rR'\u0010\u0086\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0087\u0001\u0010\u000b\"\u0005\b\u0088\u0001\u0010\rR'\u0010\u0089\u0001\u001a\u00020q2\u0006\u0010\u0007\u001a\u00020q8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008a\u0001\u0010t\"\u0005\b\u008b\u0001\u0010vR'\u0010\u008c\u0001\u001a\u00020\\2\u0006\u0010\u0007\u001a\u00020\\8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008d\u0001\u0010_\"\u0005\b\u008e\u0001\u0010aR'\u0010\u008f\u0001\u001a\u00020q2\u0006\u0010\u0007\u001a\u00020q8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0090\u0001\u0010t\"\u0005\b\u0091\u0001\u0010vR'\u0010\u0092\u0001\u001a\u0002052\u0006\u0010\u0007\u001a\u0002058V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0093\u0001\u0010G\"\u0005\b\u0094\u0001\u0010IR'\u0010\u0095\u0001\u001a\u00020\\2\u0006\u0010\u0007\u001a\u00020\\8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0096\u0001\u0010_\"\u0005\b\u0097\u0001\u0010aR'\u0010\u0098\u0001\u001a\u0002052\u0006\u0010\u0007\u001a\u0002058V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0099\u0001\u0010G\"\u0005\b\u009a\u0001\u0010IR'\u0010\u009b\u0001\u001a\u00020q2\u0006\u0010\u0007\u001a\u00020q8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009c\u0001\u0010t\"\u0005\b\u009d\u0001\u0010vR'\u0010\u009e\u0001\u001a\u0002052\u0006\u0010\u0007\u001a\u0002058V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009f\u0001\u0010G\"\u0005\b \u0001\u0010IR'\u0010¡\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¢\u0001\u0010\u000b\"\u0005\b£\u0001\u0010\rR'\u0010¤\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¥\u0001\u0010\u000b\"\u0005\b¦\u0001\u0010\rR'\u0010§\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¨\u0001\u0010\u000b\"\u0005\b©\u0001\u0010\rR+\u0010«\u0001\u001a\u00030ª\u00012\u0007\u0010\u0007\u001a\u00030ª\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R+\u0010¯\u0001\u001a\u00030ª\u00012\u0007\u0010\u0007\u001a\u00030ª\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¯\u0001\u0010¬\u0001\"\u0006\b°\u0001\u0010®\u0001R+\u0010±\u0001\u001a\u00030ª\u00012\u0007\u0010\u0007\u001a\u00030ª\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b±\u0001\u0010¬\u0001\"\u0006\b²\u0001\u0010®\u0001R+\u0010³\u0001\u001a\u00030ª\u00012\u0007\u0010\u0007\u001a\u00030ª\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b³\u0001\u0010¬\u0001\"\u0006\b´\u0001\u0010®\u0001R+\u0010µ\u0001\u001a\u00030ª\u00012\u0007\u0010\u0007\u001a\u00030ª\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bµ\u0001\u0010¬\u0001\"\u0006\b¶\u0001\u0010®\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b·\u0001\u0010¸\u0001R+\u0010¹\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bº\u0001\u0010\u000b\"\u0005\b»\u0001\u0010\rR+\u0010¼\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b½\u0001\u0010\u000b\"\u0005\b¾\u0001\u0010\rR+\u0010¿\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÀ\u0001\u0010\u000b\"\u0005\bÁ\u0001\u0010\rR+\u0010Â\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÃ\u0001\u0010\u000b\"\u0005\bÄ\u0001\u0010\rR7\u0010Å\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÆ\u0001\u0010\u001a\"\u0005\bÇ\u0001\u0010\u001cR'\u0010È\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÉ\u0001\u0010\u000b\"\u0005\bÊ\u0001\u0010\rR+\u0010Ë\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÌ\u0001\u0010\u000b\"\u0005\bÍ\u0001\u0010\rR+\u0010Î\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÏ\u0001\u0010\u000b\"\u0005\bÐ\u0001\u0010\rR'\u0010Ñ\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÒ\u0001\u0010\u000b\"\u0005\bÓ\u0001\u0010\rR+\u0010Ô\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÕ\u0001\u0010\u000b\"\u0005\bÖ\u0001\u0010\rR+\u0010×\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bØ\u0001\u0010\u000b\"\u0005\bÙ\u0001\u0010\rR'\u0010Ú\u0001\u001a\u00020\\2\u0006\u0010\u0007\u001a\u00020\\8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÛ\u0001\u0010_\"\u0005\bÜ\u0001\u0010aR'\u0010Ý\u0001\u001a\u0002092\u0006\u0010\u0007\u001a\u0002098V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÞ\u0001\u0010<\"\u0005\bß\u0001\u0010>R'\u0010à\u0001\u001a\u0002092\u0006\u0010\u0007\u001a\u0002098V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bá\u0001\u0010<\"\u0005\bâ\u0001\u0010>R9\u0010ä\u0001\u001a\u000b\u0012\u0005\u0012\u00030ã\u0001\u0018\u00010\u00172\u000f\u0010\u0007\u001a\u000b\u0012\u0005\u0012\u00030ã\u0001\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bå\u0001\u0010\u001a\"\u0005\bæ\u0001\u0010\u001cR+\u0010ç\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bè\u0001\u0010\u000b\"\u0005\bé\u0001\u0010\rR'\u0010ê\u0001\u001a\u0002092\u0006\u0010\u0007\u001a\u0002098V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bë\u0001\u0010<\"\u0005\bì\u0001\u0010>R3\u0010í\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00178V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bî\u0001\u0010\u001a\"\u0005\bï\u0001\u0010\u001cR'\u0010ð\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bñ\u0001\u0010\u000b\"\u0005\bò\u0001\u0010\rR'\u0010ó\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bô\u0001\u0010\u000b\"\u0005\bõ\u0001\u0010\rR'\u0010ö\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b÷\u0001\u0010\u000b\"\u0005\bø\u0001\u0010\rR'\u0010ù\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bú\u0001\u0010\u000b\"\u0005\bû\u0001\u0010\rR'\u0010ü\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bý\u0001\u0010\u000b\"\u0005\bþ\u0001\u0010\rR'\u0010ÿ\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0002\u0010\u000b\"\u0005\b\u0081\u0002\u0010\rR+\u0010\u0082\u0002\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0083\u0002\u0010\u000b\"\u0005\b\u0084\u0002\u0010\rR'\u0010\u0085\u0002\u001a\u00020\\2\u0006\u0010\u0007\u001a\u00020\\8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0002\u0010_\"\u0005\b\u0087\u0002\u0010aR7\u0010\u0088\u0002\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0089\u0002\u0010\u001a\"\u0005\b\u008a\u0002\u0010\u001cR'\u0010\u008b\u0002\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008c\u0002\u0010\u000b\"\u0005\b\u008d\u0002\u0010\rR'\u0010\u008e\u0002\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008f\u0002\u0010\u000b\"\u0005\b\u0090\u0002\u0010\rR3\u0010\u0091\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00178V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0092\u0002\u0010\u001a\"\u0005\b\u0093\u0002\u0010\u001cR'\u0010\u0094\u0002\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0095\u0002\u0010\u000b\"\u0005\b\u0096\u0002\u0010\rR'\u0010\u0097\u0002\u001a\u0002092\u0006\u0010\u0007\u001a\u0002098V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0098\u0002\u0010<\"\u0005\b\u0099\u0002\u0010>R'\u0010\u009a\u0002\u001a\u0002092\u0006\u0010\u0007\u001a\u0002098V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009b\u0002\u0010<\"\u0005\b\u009c\u0002\u0010>R7\u0010\u009d\u0002\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009e\u0002\u0010\u001a\"\u0005\b\u009f\u0002\u0010\u001cR'\u0010 \u0002\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¡\u0002\u0010\u000b\"\u0005\b¢\u0002\u0010\rR'\u0010£\u0002\u001a\u0002092\u0006\u0010\u0007\u001a\u0002098V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¤\u0002\u0010<\"\u0005\b¥\u0002\u0010>¨\u0006¬\u0002"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectTemplate;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "kEffect", "Lcom/ss/ugc/effectplatform/model/Effect;", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "value", "", "adRawData", "getAdRawData", "()Ljava/lang/String;", "setAdRawData", "(Ljava/lang/String;)V", "ad_raw_data", "getAd_raw_data", "setAd_raw_data", "Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "avatar_thumb", "getAvatar_thumb", "()Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "setAvatar_thumb", "(Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;)V", "", "bindIds", "getBindIds", "()Ljava/util/List;", "setBindIds", "(Ljava/util/List;)V", "bind_ids", "getBind_ids", "setBind_ids", "challenge", "getChallenge", "setChallenge", "childEffects", "getChildEffects", "setChildEffects", "child_effects", "getChild_effects", "setChild_effects", "children", "getChildren", "setChildren", "composerParams", "getComposerParams", "setComposerParams", "composerPath", "getComposerPath", "setComposerPath", "composer_params", "getComposer_params", "setComposer_params", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "covers", "getCovers", "setCovers", "", "created_at", "getCreated_at", "()J", "setCreated_at", "(J)V", "designerEncryptedId", "getDesignerEncryptedId", "setDesignerEncryptedId", "designerId", "getDesignerId", "setDesignerId", "designer_avatar", "getDesigner_avatar", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setDesigner_avatar", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "designer_encrypted_id", "getDesigner_encrypted_id", "setDesigner_encrypted_id", "designer_id", "getDesigner_id", "setDesigner_id", "designer_nickname", "getDesigner_nickname", "setDesigner_nickname", "devicePlatform", "getDevicePlatform", "setDevicePlatform", "device_platform", "getDevice_platform", "setDevice_platform", "effectId", "getEffectId", "setEffectId", "", "effectType", "getEffectType", "()I", "setEffectType", "(I)V", MobConstants.EFFECT_ID, "getEffect_id", "setEffect_id", "effect_source_id", "getEffect_source_id", "setEffect_source_id", "effect_type", "getEffect_type", "setEffect_type", "extra", "getExtra", "setExtra", "extra_tag", "getExtra_tag", "setExtra_tag", "Lcom/ss/android/ugc/effectmanager/common/model/UrlModel;", "fileUrl", "getFileUrl", "()Lcom/ss/android/ugc/effectmanager/common/model/UrlModel;", "setFileUrl", "(Lcom/ss/android/ugc/effectmanager/common/model/UrlModel;)V", ShareType.FILE_URL, "getFile_url", "setFile_url", "force_insert_position", "getForce_insert_position", "setForce_insert_position", "force_insert_priority", "getForce_insert_priority", "setForce_insert_priority", "gradeKey", "getGradeKey", "setGradeKey", "grade_key", "getGrade_key", "setGrade_key", "hint", "getHint", "setHint", "hintFile", "getHintFile", "setHintFile", "hintFileFormat", "getHintFileFormat", "setHintFileFormat", "hintIcon", "getHintIcon", "setHintIcon", "hint_file", "getHint_file", "setHint_file", "hint_file_format", "getHint_file_format", "setHint_file_format", "hint_icon", "getHint_icon", "setHint_icon", "iconUrl", "getIconUrl", "setIconUrl", "icon_url", "getIcon_url", "setIcon_url", "id", "getId", "setId", "iopId", "getIopId", "setIopId", "iop_id", "getIop_id", "setIop_id", "", "isBusiness", "()Z", "setBusiness", "(Z)V", "isDownloaded", "setDownloaded", "isIsIop", "setIsIop", "is_busi", "set_busi", "is_iop", "set_iop", "getKEffect", "()Lcom/ss/ugc/effectplatform/model/Effect;", "keywords", "getKeywords", "setKeywords", "labels", "getLabels", "setLabels", "modelNames", "getModelNames", "setModelNames", "model_names_sec", "getModel_names_sec", "setModel_names_sec", "music", "getMusic", "setMusic", "name", "getName", "setName", InstantPlayContext.NICKNAME, "getNickname", "setNickname", "original_effect_id", "getOriginal_effect_id", "setOriginal_effect_id", "panel", "getPanel", "setPanel", "parent", "getParent", "setParent", "parentId", "getParentId", "setParentId", ShortVideoSegments.KEY_PROP_PROVIDER, "getProvider", "setProvider", "ptime", "getPtime", "setPtime", "publishTime", "getPublishTime", "setPublishTime", "Lcom/ss/ugc/effectplatform/model/RankingEffectModel;", "ranking_List", "getRanking_List", "setRanking_List", "recId", "getRecId", "setRecId", "rec_tag", "getRec_tag", "setRec_tag", "requirements", "getRequirements", "setRequirements", "resourceId", "getResourceId", "setResourceId", "resource_id", "getResource_id", "setResource_id", "schema", "getSchema", "setSchema", "sdkExtra", "getSdkExtra", "setSdkExtra", "sdk_extra", "getSdk_extra", "setSdk_extra", "searchType", "getSearchType", "setSearchType", "server_extra", "getServer_extra", "setServer_extra", "source", "getSource", "setSource", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "tagsUpdatedAt", "getTagsUpdatedAt", "setTagsUpdatedAt", "tags_updated_at", "getTags_updated_at", "setTags_updated_at", "types", "getTypes", "setTypes", "unzipPath", "getUnzipPath", "setUnzipPath", "use_number", "getUse_number", "setUse_number", PoolStatsTracker.USED_COUNT, "getUsed_count", "setUsed_count", "videoPlayURLs", "getVideoPlayURLs", "setVideoPlayURLs", "zipPath", "getZipPath", "setZipPath", "zipSize", "getZipSize", "setZipSize", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class Effect extends EffectTemplate {
    public static final Parcelable.Creator<Effect> CREATOR = null;
    public static final Companion Companion = null;
    private final transient com.ss.ugc.effectplatform.model.Effect kEffect;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/Effect$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Effect() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    static {
        Companion = new Companion(null);
        CREATOR = new Effect$Companion$CREATOR$1();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getAdRawData() {
        return super.getAdRawData();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getAd_raw_data() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getAd_raw_data();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getAd_raw_data();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public AuthorThumbModel getAvatar_thumb() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        AuthorThumbModel r101 = r100.getAvatar_thumb();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getAvatar_thumb();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public List<String> getBindIds() {
        return super.getBindIds();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<String> getBind_ids() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getBind_ids();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getBind_ids();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<String> getChallenge() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getChallenge();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getChallenge();
    }

    public final List<Effect> getChildEffects() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L7;
        List r101 = r100.getChild_effects();
        List r102 = r101;
        if (r101 == null) goto L7;
    L9:
        if ((!r102.isEmpty()) == false) goto L24;
        if ((ListProtector.get(r102, 0) instanceof Effect) == false) goto L16;
        if (r102 == null) goto L15;
        return r102;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.Effect>");
    L16:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r105.next()));
        goto L18
    L20:
        if (r100 == null) goto L22;
        r100.setChild_effects(r104);
    L22:
        super.setChild_effects(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getChild_effects();
        goto L9
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<com.ss.ugc.effectplatform.model.Effect> getChild_effects() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getChild_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getChild_effects();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<String> getChildren() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getChildren();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getChildren();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getComposerParams() {
        return super.getComposerParams();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<String> getComposerPath() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getComposerPath();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getComposerPath();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getComposer_params() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getComposer_params();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getComposer_params();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<UrlModel> getCovers() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<UrlModel> r101 = r100.getCovers();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCovers();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public long getCreated_at() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getCreated_at();
    L6:
        return super.getCreated_at();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getDesignerEncryptedId() {
        return super.getDesignerEncryptedId();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getDesignerId() {
        return super.getDesignerId();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public UrlModel getDesigner_avatar() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        UrlModel r101 = r100.getDesigner_avatar();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getDesigner_avatar();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getDesigner_encrypted_id() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getDesigner_encrypted_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getDesigner_encrypted_id();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getDesigner_id() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getDesigner_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getDesigner_id();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getDesigner_nickname() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getDesigner_nickname();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getDesigner_nickname();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getDevicePlatform() {
        return super.getDevicePlatform();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getDevice_platform() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getDevice_platform();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getDevice_platform();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getEffectId() {
        return super.getEffectId();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public int getEffectType() {
        return super.getEffectType();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getEffect_id() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getEffect_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getEffect_id();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getEffect_source_id() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getEffect_source_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getEffect_source_id();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public int getEffect_type() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getEffect_type();
    L6:
        return super.getEffect_type();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getExtra() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getExtra();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getExtra();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getExtra_tag() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getExtra_tag();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getExtra_tag();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public com.ss.android.ugc.effectmanager.common.model.UrlModel getFileUrl() {
        return super.getFileUrl();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public UrlModel getFile_url() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        UrlModel r101 = r100.getFile_url();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getFile_url();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public long getForce_insert_position() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getForce_insert_position();
    L6:
        return super.getForce_insert_position();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public int getForce_insert_priority() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getForce_insert_priority();
    L6:
        return super.getForce_insert_priority();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getGradeKey() {
        return super.getGradeKey();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getGrade_key() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getGrade_key();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getGrade_key();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getHint() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getHint();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getHint();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public com.ss.android.ugc.effectmanager.common.model.UrlModel getHintFile() {
        return super.getHintFile();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public int getHintFileFormat() {
        return super.getHintFileFormat();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public com.ss.android.ugc.effectmanager.common.model.UrlModel getHintIcon() {
        return super.getHintIcon();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public UrlModel getHint_file() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        UrlModel r101 = r100.getHint_file();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getHint_file();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public int getHint_file_format() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getHint_file_format();
    L6:
        return super.getHint_file_format();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public UrlModel getHint_icon() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        UrlModel r101 = r100.getHint_icon();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getHint_icon();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public com.ss.android.ugc.effectmanager.common.model.UrlModel getIconUrl() {
        return super.getIconUrl();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public UrlModel getIcon_url() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        UrlModel r101 = r100.getIcon_url();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getIcon_url();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getId() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getId();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getId();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getIopId() {
        return super.getIopId();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getIop_id() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getIop_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getIop_id();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getKeywords() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getKeywords();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getKeywords();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getLabels() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getLabels();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getLabels();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getModelNames() {
        return super.getModelNames();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getModel_names_sec() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getModel_names_sec();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getModel_names_sec();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<String> getMusic() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getMusic();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getMusic();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getName() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getName();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getName();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getNickname() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getNickname();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getNickname();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getOriginal_effect_id() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getOriginal_effect_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getOriginal_effect_id();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getPanel() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getPanel();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getPanel();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getParent() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getParent();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getParent();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getParentId() {
        return super.getParentId();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public int getProvider() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getProvider();
    L6:
        return super.getProvider();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public long getPtime() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getPtime();
    L6:
        return super.getPtime();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public long getPublishTime() {
        return super.getPublishTime();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<RankingEffectModel> getRanking_List() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<RankingEffectModel> r101 = r100.getRanking_List();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getRanking_List();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getRecId() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getRecId();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getRecId();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public long getRec_tag() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getRec_tag();
    L6:
        return super.getRec_tag();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<String> getRequirements() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getRequirements();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getRequirements();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getResourceId() {
        return super.getResourceId();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getResource_id() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getResource_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getResource_id();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getSchema() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getSchema();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getSchema();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getSdkExtra() {
        return super.getSdkExtra();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getSdk_extra() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getSdk_extra();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getSdk_extra();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getSearchType() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getSearchType();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getSearchType();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getServer_extra() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getServer_extra();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getServer_extra();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public int getSource() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getSource();
    L6:
        return super.getSource();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<String> getTags() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getTags();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public String getTagsUpdatedAt() {
        return super.getTagsUpdatedAt();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getTags_updated_at() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getTags_updated_at();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags_updated_at();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<String> getTypes() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getTypes();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTypes();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getUnzipPath() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getUnzipPath();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUnzipPath();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public long getUse_number() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getUse_number();
    L6:
        return super.getUse_number();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public long getUsed_count() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getUsed_count();
    L6:
        return super.getUsed_count();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public List<String> getVideoPlayURLs() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getVideoPlayURLs();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getVideoPlayURLs();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public String getZipPath() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getZipPath();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getZipPath();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public long getZipSize() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getZipSize();
    L6:
        return super.getZipSize();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public boolean isBusiness() {
        return super.isBusiness();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public boolean isDownloaded() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.isDownloaded();
    L6:
        return super.isDownloaded();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public boolean isIsIop() {
        return super.isIsIop();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public boolean is_busi() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.is_busi();
    L6:
        return super.is_busi();
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public boolean is_iop() {
        com.ss.ugc.effectplatform.model.Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.is_iop();
    L6:
        return super.is_iop();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public com.ss.ugc.effectplatform.model.Effect getKEffect() {
        return this.kEffect;
    }

    public Effect(com.ss.ugc.effectplatform.model.Effect r100) {
        super(r100);
        this.kEffect = r100;
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L165;
        String r102 = r101.getAd_raw_data();
        if (r102 == null) goto L7;
        super.setAd_raw_data(r102);
        Unit r103 = Unit.INSTANCE;
    L7:
        AuthorThumbModel r104 = r101.getAvatar_thumb();
        if (r104 == null) goto L10;
        super.setAvatar_thumb(r104);
        Unit r105 = Unit.INSTANCE;
    L10:
        List<String> r106 = r101.getBind_ids();
        if (r106 == null) goto L13;
        super.setBind_ids(r106);
        Unit r107 = Unit.INSTANCE;
    L13:
        List<String> r108 = r101.getChallenge();
        if (r108 == null) goto L16;
        super.setChallenge(r108);
        Unit r109 = Unit.INSTANCE;
    L16:
        List<com.ss.ugc.effectplatform.model.Effect> r110 = r101.getChild_effects();
        if (r110 == null) goto L19;
        super.setChild_effects(r110);
        Unit r111 = Unit.INSTANCE;
    L19:
        List<String> r112 = r101.getChildren();
        if (r112 == null) goto L22;
        super.setChildren(r112);
        Unit r113 = Unit.INSTANCE;
    L22:
        List<String> r114 = r101.getComposerPath();
        if (r114 == null) goto L25;
        super.setComposerPath(r114);
        Unit r115 = Unit.INSTANCE;
    L25:
        String r116 = r101.getComposer_params();
        if (r116 == null) goto L28;
        super.setComposer_params(r116);
        Unit r117 = Unit.INSTANCE;
    L28:
        List<UrlModel> r118 = r101.getCovers();
        if (r118 == null) goto L31;
        super.setCovers(r118);
        Unit r119 = Unit.INSTANCE;
    L31:
        super.setCreated_at(r101.getCreated_at());
        Unit r120 = Unit.INSTANCE;
        UrlModel r121 = r101.getDesigner_avatar();
        if (r121 == null) goto L34;
        super.setDesigner_avatar(r121);
    L34:
        String r122 = r101.getDesigner_encrypted_id();
        if (r122 == null) goto L37;
        super.setDesigner_encrypted_id(r122);
    L37:
        String r123 = r101.getDesigner_id();
        if (r123 == null) goto L40;
        super.setDesigner_id(r123);
    L40:
        String r124 = r101.getDesigner_nickname();
        if (r124 == null) goto L43;
        super.setDesigner_nickname(r124);
    L43:
        String r125 = r101.getDevice_platform();
        if (r125 == null) goto L46;
        super.setDevice_platform(r125);
    L46:
        String r126 = r101.getEffect_id();
        if (r126 == null) goto L49;
        super.setEffect_id(r126);
    L49:
        String r127 = r101.getEffect_source_id();
        if (r127 == null) goto L52;
        super.setEffect_source_id(r127);
    L52:
        super.setEffect_type(r101.getEffect_type());
        String r128 = r101.getExtra();
        if (r128 == null) goto L55;
        super.setExtra(r128);
    L55:
        String r129 = r101.getExtra_tag();
        if (r129 == null) goto L58;
        super.setExtra_tag(r129);
    L58:
        UrlModel r130 = r101.getFile_url();
        if (r130 == null) goto L61;
        super.setFile_url(r130);
    L61:
        super.setForce_insert_position(r101.getForce_insert_position());
        super.setForce_insert_priority(r101.getForce_insert_priority());
        String r131 = r101.getGrade_key();
        if (r131 == null) goto L64;
        super.setGrade_key(r131);
    L64:
        String r132 = r101.getHint();
        if (r132 == null) goto L67;
        super.setHint(r132);
    L67:
        UrlModel r133 = r101.getHint_file();
        if (r133 == null) goto L70;
        super.setHint_file(r133);
    L70:
        super.setHint_file_format(r101.getHint_file_format());
        UrlModel r134 = r101.getHint_icon();
        if (r134 == null) goto L73;
        super.setHint_icon(r134);
    L73:
        UrlModel r135 = r101.getIcon_url();
        if (r135 == null) goto L76;
        super.setIcon_url(r135);
    L76:
        String r136 = r101.getId();
        if (r136 == null) goto L79;
        super.setId(r136);
    L79:
        String r137 = r101.getIop_id();
        if (r137 == null) goto L82;
        super.setIop_id(r137);
    L82:
        super.setDownloaded(r101.isDownloaded());
        super.set_busi(r101.is_busi());
        super.set_iop(r101.is_iop());
        String r138 = r101.getKeywords();
        if (r138 == null) goto L85;
        super.setKeywords(r138);
    L85:
        String r139 = r101.getLabels();
        if (r139 == null) goto L88;
        super.setLabels(r139);
    L88:
        String r140 = r101.getModel_names();
        if (r140 == null) goto L91;
        super.setModel_names(r140);
    L91:
        String r141 = r101.getModel_names_sec();
        if (r141 == null) goto L94;
        super.setModel_names_sec(r141);
    L94:
        List<String> r142 = r101.getMusic();
        if (r142 == null) goto L97;
        super.setMusic(r142);
    L97:
        String r143 = r101.getName();
        if (r143 == null) goto L100;
        super.setName(r143);
    L100:
        String r144 = r101.getNickname();
        if (r144 == null) goto L103;
        super.setNickname(r144);
    L103:
        String r145 = r101.getOriginal_effect_id();
        if (r145 == null) goto L106;
        super.setOriginal_effect_id(r145);
    L106:
        String r146 = r101.getPanel();
        if (r146 == null) goto L109;
        super.setPanel(r146);
    L109:
        String r147 = r101.getParent();
        if (r147 == null) goto L112;
        super.setParent(r147);
    L112:
        String r148 = r101.getPlatformVersion();
        if (r148 == null) goto L115;
        super.setPlatformVersion(r148);
    L115:
        super.setProvider(r101.getProvider());
        super.setPtime(r101.getPtime());
        List<RankingEffectModel> r149 = r101.getRanking_List();
        if (r149 == null) goto L118;
        super.setRanking_List(r149);
    L118:
        String r150 = r101.getRecId();
        if (r150 == null) goto L121;
        super.setRecId(r150);
    L121:
        super.setRec_tag(r101.getRec_tag());
        List<String> r151 = r101.getRequirements();
        if (r151 == null) goto L124;
        super.setRequirements(r151);
    L124:
        List<String> r152 = r101.getRequirements_sec();
        if (r152 == null) goto L127;
        super.setRequirements_sec(r152);
    L127:
        String r153 = r101.getResource_id();
        if (r153 == null) goto L130;
        super.setResource_id(r153);
    L130:
        String r154 = r101.getSchema();
        if (r154 == null) goto L133;
        super.setSchema(r154);
    L133:
        String r155 = r101.getSdk_extra();
        if (r155 == null) goto L136;
        super.setSdk_extra(r155);
    L136:
        String r156 = r101.getSearchType();
        if (r156 == null) goto L139;
        super.setSearchType(r156);
    L139:
        String r157 = r101.getServer_extra();
        if (r157 == null) goto L142;
        super.setServer_extra(r157);
    L142:
        super.setSource(r101.getSource());
        List<String> r158 = r101.getTags();
        if (r158 == null) goto L145;
        super.setTags(r158);
    L145:
        String r159 = r101.getTags_updated_at();
        if (r159 == null) goto L148;
        super.setTags_updated_at(r159);
    L148:
        List<String> r160 = r101.getTypes();
        if (r160 == null) goto L151;
        super.setTypes(r160);
    L151:
        List<String> r161 = r101.getTypes_sec();
        if (r161 == null) goto L154;
        super.setTypes_sec(r161);
    L154:
        String r162 = r101.getUnzipPath();
        if (r162 == null) goto L157;
        super.setUnzipPath(r162);
    L157:
        super.setUse_number(r101.getUse_number());
        super.setUsed_count(r101.getUsed_count());
        List<String> r163 = r101.getVideoPlayURLs();
        if (r163 == null) goto L160;
        super.setVideoPlayURLs(r163);
    L160:
        String r164 = r101.getZipPath();
        if (r164 == null) goto L163;
        super.setZipPath(r164);
    L163:
        super.setZipSize(r101.getZipSize());
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setAdRawData(String r100) {
        super.setAdRawData(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setAd_raw_data(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setAd_raw_data(r100);
    L5:
        super.setAd_raw_data(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setAvatar_thumb(AuthorThumbModel r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setAvatar_thumb(r100);
    L5:
        super.setAvatar_thumb(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setBindIds(List<String> r100) {
        super.setBindIds(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setBind_ids(List<String> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setBind_ids(r100);
    L5:
        super.setBind_ids(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setBusiness(boolean r100) {
        super.setBusiness(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setChallenge(List<String> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setChallenge(r100);
    L5:
        super.setChallenge(r100);
    }

    public final void setChildEffects(List<? extends Effect> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setChild_effects(r100);
    L5:
        super.setChild_effects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setChild_effects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setChild_effects(r100);
    L5:
        super.setChild_effects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setChildren(List<String> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setChildren(r100);
    L5:
        super.setChildren(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setComposerParams(String r100) {
        super.setComposerParams(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setComposerPath(List<String> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setComposerPath(r100);
    L5:
        super.setComposerPath(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setComposer_params(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setComposer_params(r100);
    L5:
        super.setComposer_params(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setCovers(List<? extends UrlModel> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setCovers(r100);
    L5:
        super.setCovers(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setCreated_at(long r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setCreated_at(r100);
    L5:
        super.setCreated_at(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setDesignerEncryptedId(String r100) {
        super.setDesignerEncryptedId(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setDesignerId(String r100) {
        super.setDesignerId(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setDesigner_avatar(UrlModel r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setDesigner_avatar(r100);
    L5:
        super.setDesigner_avatar(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setDesigner_encrypted_id(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setDesigner_encrypted_id(r100);
    L5:
        super.setDesigner_encrypted_id(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setDesigner_id(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setDesigner_id(r100);
    L5:
        super.setDesigner_id(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setDesigner_nickname(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setDesigner_nickname(r100);
    L5:
        super.setDesigner_nickname(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setDevicePlatform(String r100) {
        super.setDevicePlatform(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setDevice_platform(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setDevice_platform(r100);
    L5:
        super.setDevice_platform(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setDownloaded(boolean r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setDownloaded(r100);
    L5:
        super.setDownloaded(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setEffectId(String r100) {
        super.setEffectId(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setEffectType(int r100) {
        super.setEffectType(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setEffect_id(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setEffect_id(r100);
    L5:
        super.setEffect_id(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setEffect_source_id(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setEffect_source_id(r100);
    L5:
        super.setEffect_source_id(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setEffect_type(int r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setEffect_type(r100);
    L5:
        super.setEffect_type(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setExtra(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setExtra(r100);
    L5:
        super.setExtra(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setExtra_tag(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setExtra_tag(r100);
    L5:
        super.setExtra_tag(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setFileUrl(com.ss.android.ugc.effectmanager.common.model.UrlModel r100) {
        super.setFileUrl(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setFile_url(UrlModel r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setFile_url(r100);
    L5:
        super.setFile_url(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setForce_insert_position(long r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setForce_insert_position(r100);
    L5:
        super.setForce_insert_position(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setForce_insert_priority(int r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setForce_insert_priority(r100);
    L5:
        super.setForce_insert_priority(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setGradeKey(String r100) {
        super.setGradeKey(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setGrade_key(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setGrade_key(r100);
    L5:
        super.setGrade_key(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setHint(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setHint(r100);
    L5:
        super.setHint(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setHintFile(com.ss.android.ugc.effectmanager.common.model.UrlModel r100) {
        super.setHintFile(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setHintFileFormat(int r100) {
        super.setHintFileFormat(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setHintIcon(com.ss.android.ugc.effectmanager.common.model.UrlModel r100) {
        super.setHintIcon(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setHint_file(UrlModel r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setHint_file(r100);
    L5:
        super.setHint_file(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setHint_file_format(int r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setHint_file_format(r100);
    L5:
        super.setHint_file_format(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setHint_icon(UrlModel r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setHint_icon(r100);
    L5:
        super.setHint_icon(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setIconUrl(com.ss.android.ugc.effectmanager.common.model.UrlModel r100) {
        super.setIconUrl(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setIcon_url(UrlModel r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setIcon_url(r100);
    L5:
        super.setIcon_url(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setId(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setId(r100);
    L5:
        super.setId(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setIopId(String r100) {
        super.setIopId(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setIop_id(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setIop_id(r100);
    L5:
        super.setIop_id(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setIsIop(boolean r100) {
        super.setIsIop(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setKeywords(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setKeywords(r100);
    L5:
        super.setKeywords(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setLabels(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setLabels(r100);
    L5:
        super.setLabels(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setModelNames(String r100) {
        super.setModelNames(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setModel_names_sec(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setModel_names_sec(r100);
    L5:
        super.setModel_names_sec(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setMusic(List<String> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setMusic(r100);
    L5:
        super.setMusic(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setName(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setName(r100);
    L5:
        super.setName(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setNickname(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setNickname(r100);
    L5:
        super.setNickname(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setOriginal_effect_id(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setOriginal_effect_id(r100);
    L5:
        super.setOriginal_effect_id(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setPanel(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setPanel(r100);
    L5:
        super.setPanel(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setParent(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setParent(r100);
    L5:
        super.setParent(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setParentId(String r100) {
        super.setParentId(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setProvider(int r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setProvider(r100);
    L5:
        super.setProvider(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setPtime(long r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setPtime(r100);
    L5:
        super.setPtime(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setPublishTime(long r100) {
        super.setPublishTime(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setRanking_List(List<? extends RankingEffectModel> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setRanking_List(r100);
    L5:
        super.setRanking_List(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setRecId(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setRecId(r100);
    L5:
        super.setRecId(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setRec_tag(long r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setRec_tag(r100);
    L5:
        super.setRec_tag(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setRequirements(List<String> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setRequirements(r100);
    L5:
        super.setRequirements(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setResourceId(String r100) {
        super.setResourceId(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setResource_id(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setResource_id(r100);
    L5:
        super.setResource_id(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setSchema(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setSchema(r100);
    L5:
        super.setSchema(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setSdkExtra(String r100) {
        super.setSdkExtra(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setSdk_extra(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setSdk_extra(r100);
    L5:
        super.setSdk_extra(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setSearchType(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setSearchType(r100);
    L5:
        super.setSearchType(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setServer_extra(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setServer_extra(r100);
    L5:
        super.setServer_extra(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setSource(int r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setSource(r100);
    L5:
        super.setSource(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setTags(List<String> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setTags(r100);
    L5:
        super.setTags(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate
    public void setTagsUpdatedAt(String r100) {
        super.setTagsUpdatedAt(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setTags_updated_at(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setTags_updated_at(r100);
    L5:
        super.setTags_updated_at(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setTypes(List<String> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setTypes(r100);
    L5:
        super.setTypes(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setUnzipPath(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setUnzipPath(r100);
    L5:
        super.setUnzipPath(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setUse_number(long r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setUse_number(r100);
    L5:
        super.setUse_number(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setUsed_count(long r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setUsed_count(r100);
    L5:
        super.setUsed_count(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setVideoPlayURLs(List<String> r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setVideoPlayURLs(r100);
    L5:
        super.setVideoPlayURLs(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setZipPath(String r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setZipPath(r100);
    L5:
        super.setZipPath(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void setZipSize(long r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setZipSize(r100);
    L5:
        super.setZipSize(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void set_busi(boolean r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.set_busi(r100);
    L5:
        super.set_busi(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect
    public void set_iop(boolean r100) {
        com.ss.ugc.effectplatform.model.Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.set_iop(r100);
    L5:
        super.set_iop(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectTemplate, com.ss.ugc.effectplatform.model.Effect, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        if (getKEffect() == null) goto L7;
        com.ss.ugc.effectplatform.model.Effect r102 = getKEffect();
        if (r102 == null) goto L9;
        r102.writeToParcel(r100, r101);
        return;
    L9:
        return;
    L7:
        super.writeToParcel(r100, r101);
    }

    public /* synthetic */ Effect(com.ss.ugc.effectplatform.model.Effect r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
