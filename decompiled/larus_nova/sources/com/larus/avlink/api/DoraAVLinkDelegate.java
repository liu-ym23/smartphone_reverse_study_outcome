package com.larus.avlink.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import b98.d;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.avlink.gallery.view.s1;
import com.larus.avlink.model.FlowDoraScene;
import com.larus.avlink.model.FlowDoraSceneState;
import com.larus.dora.impl.device.manage.holder.a0;
import com.larus.dora.impl.device.manage.holder.b0;
import com.larus.dora.impl.device.manage.holder.c0;
import com.larus.dora.impl.device.manage.holder.d0;
import com.larus.dora.impl.device.manage.holder.y;
import com.larus.dora.impl.device.manage.holder.z;
import com.larus.dora.impl.onboarding.b;
import com.larus.dora.o.impl.album.ODoraAlbumCardView;
import com.larus.dora.o.impl.diary.settings.f;
import com.larus.im.bean.bot.BotModel;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import w88.e;
import w88.i;
import w88.j;
import w88.k;
import w88.l;
import w88.s;
import w88.t;
import w88.u;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0012\n\u0002\b,\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u001d\u0010\t\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u001d\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u001d\u0010\f\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u0019\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\nH\u0096\u0001J\u000e\u0010\u0014\u001a\u00020\u0015H\u0096A¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0096\u0001J\t\u0010#\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0011H\u0096\u0001J\u0019\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\nH\u0096\u0001J\u0011\u0010(\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0096\u0001J\t\u0010)\u001a\u00020\bH\u0096\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\nH\u0096A¢\u0006\u0002\u0010-J1\u0010.\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011000/j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001100`1H\u0096\u0001J\u000b\u00102\u001a\u0004\u0018\u000103H\u0096\u0001J\u000b\u00104\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\t\u00105\u001a\u000206H\u0096\u0001J\u001d\u00107\u001a\u00020\u00052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u0010\u00109\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0002\u0010:J4\u0010;\u001a\u0002032\b\u0010<\u001a\u0004\u0018\u00010\u00112\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010'\u001a\u00020\n2\b\u0010?\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0002\u0010@J\t\u0010A\u001a\u00020BH\u0096\u0001J\t\u0010C\u001a\u00020DH\u0096\u0001J\u000e\u0010E\u001a\u00020FH\u0096A¢\u0006\u0002\u0010\u0016J\u001a\u0010G\u001a\u0004\u0018\u00010\u00112\b\u0010H\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0002\u0010IJ\t\u0010J\u001a\u00020\u0011H\u0096\u0001J\t\u0010K\u001a\u00020\u0011H\u0096\u0001J\u0018\u0010L\u001a\u0004\u0018\u00010\n2\u0006\u0010M\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0002\u0010NJ\u000b\u0010O\u001a\u0004\u0018\u00010>H\u0096\u0001J\u000b\u0010P\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RH\u0096\u0001J\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020U0R2\u0006\u0010V\u001a\u00020\bH\u0096\u0001J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020\n0RH\u0096\u0001J\t\u0010X\u001a\u00020\bH\u0096\u0001J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J!\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u00112\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010]H\u0096\u0001J!\u0010^\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u00112\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010]H\u0096\u0001J\u0019\u0010_\u001a\u00020\u00052\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010]H\u0096\u0001J1\u0010a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010b\u001a\u00020\b2\u0006\u0010[\u001a\u00020\u00112\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010]H\u0096\u0001J9\u0010c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010[\u001a\u00020\u00112\u000e\u0010d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010]2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010]H\u0096\u0001J\u0019\u0010f\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0096\u0001J3\u0010h\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\b\u0010k\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J3\u0010l\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\b\u0010k\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J3\u0010m\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\b\u0010k\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\t\u0010n\u001a\u00020\u0005H\u0096\u0001J\t\u0010o\u001a\u00020\u0005H\u0096\u0001JN\u0010p\u001a\u00020\u00052\f\u0010q\u001a\b\u0012\u0004\u0012\u00020r0R2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u00072!\u0010t\u001a\u001d\u0012\u0013\u0012\u00110u¢\u0006\f\bv\u0012\b\bw\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\t\u0010y\u001a\u00020\bH\u0096\u0001J\t\u0010z\u001a\u00020\bH\u0096\u0001J\t\u0010{\u001a\u00020\bH\u0096\u0001J\t\u0010|\u001a\u00020\bH\u0096\u0001J\t\u0010}\u001a\u00020\bH\u0096\u0001J\t\u0010~\u001a\u00020\bH\u0096\u0001J\t\u0010\u007f\u001a\u00020\bH\u0096\u0001J\u0012\u0010\u0080\u0001\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0096\u0001J\n\u0010\u0081\u0001\u001a\u00020\bH\u0096\u0001J\n\u0010\u0082\u0001\u001a\u00020\bH\u0096\u0001J\n\u0010\u0083\u0001\u001a\u00020\bH\u0096\u0001J\n\u0010\u0084\u0001\u001a\u00020\bH\u0096\u0001J\u0014\u0010\u0085\u0001\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\nH\u0096\u0001J\n\u0010\u0086\u0001\u001a\u00020\bH\u0096\u0001J\n\u0010\u0087\u0001\u001a\u00020\bH\u0096\u0001J\n\u0010\u0088\u0001\u001a\u00020\bH\u0096\u0001J\n\u0010\u0089\u0001\u001a\u00020\bH\u0096\u0001J\n\u0010\u008a\u0001\u001a\u00020\bH\u0096\u0001J\n\u0010\u008b\u0001\u001a\u00020\bH\u0096\u0001J\u0015\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00112\u0007\u0010\u008d\u0001\u001a\u00020\u0011H\u0096\u0001J\u001d\u0010\u008e\u0001\u001a\u00020\u00052\b\b\u0001\u0010'\u001a\u00020\n2\u0007\u0010\u008f\u0001\u001a\u00020\nH\u0096\u0001J\n\u0010\u0090\u0001\u001a\u00020\u0005H\u0096\u0001J\u001f\u0010\u0091\u0001\u001a\u00020\u00052\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00112\b\u0010M\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0012\u0010\u0093\u0001\u001a\n\u0012\u0005\u0012\u00030\u0095\u00010\u0094\u0001H\u0096\u0001J\u0012\u0010\u0096\u0001\u001a\n\u0012\u0005\u0012\u00030\u0097\u00010\u0094\u0001H\u0096\u0001J\u0011\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u0094\u0001H\u0096\u0001J\u001a\u0010\u0099\u0001\u001a\n\u0012\u0005\u0012\u00030\u009a\u00010\u0094\u00012\u0006\u0010V\u001a\u00020\bH\u0096\u0001J\u0013\u0010\u009b\u0001\u001a\u00020\u00052\u0007\u0010\u009c\u0001\u001a\u00020\bH\u0096\u0001J\u001c\u0010\u009d\u0001\u001a\u00020\u00052\u0007\u0010\u009e\u0001\u001a\u00020\n2\u0007\u0010\u009f\u0001\u001a\u00020uH\u0096\u0001J!\u0010 \u0001\u001a\u00020\u00052\u0015\u00108\u001a\u0011\u0012\u0005\u0012\u00030¡\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010¢\u0001\u001a\u00020\u00052\u0007\u0010£\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010¤\u0001\u001a\u00020\u00052\u0007\u0010¥\u0001\u001a\u00020\bH\u0096\u0001J\u0013\u0010¦\u0001\u001a\u00020\u00052\u0007\u0010§\u0001\u001a\u00020\u0011H\u0096\u0001J\u001e\u0010¨\u0001\u001a\u00020\u00052\u0007\u0010©\u0001\u001a\u00020\u00112\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u001c\u0010«\u0001\u001a\u00020\u00052\u0007\u0010¬\u0001\u001a\u00020\u00112\u0007\u0010\u00ad\u0001\u001a\u00020\u0011H\u0096\u0001J\u001a\u0010®\u0001\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0096\u0001J&\u0010¯\u0001\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\t\u0010°\u0001\u001a\u0004\u0018\u00010\u00112\u0007\u0010±\u0001\u001a\u00020\u0011H\u0096\u0001J\n\u0010²\u0001\u001a\u00020\u0011H\u0096\u0001JH\u0010³\u0001\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n2\u0007\u0010´\u0001\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\b\u0010k\u001a\u0004\u0018\u00010\u00112\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u001e\u0010¶\u0001\u001a\u00020\u00052\t\u0010·\u0001\u001a\u0004\u0018\u00010\u00112\u0007\u0010¸\u0001\u001a\u00020uH\u0096\u0001J\n\u0010¹\u0001\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010º\u0001\u001a\u00020\u00052\u0007\u0010\u0006\u001a\u00030»\u0001H\u0096\u0001J\n\u0010¼\u0001\u001a\u00020\u0005H\u0096\u0001J\n\u0010½\u0001\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010¾\u0001\u001a\u00020\u00052\u0007\u0010\u0006\u001a\u00030¿\u0001H\u0096\u0001J\u001e\u0010À\u0001\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u001e\u0010Á\u0001\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u001e\u0010Â\u0001\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u001e\u0010Ã\u0001\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u001c\u0010Ä\u0001\u001a\u00020\u00052\u0007\u0010Å\u0001\u001a\u00020\n2\u0007\u0010Æ\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010Ç\u0001\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020\bH\u0097\u0001J/\u0010É\u0001\u001a\u00020\u00052\u0007\u0010Ê\u0001\u001a\u00020\b2\t\u0010Ë\u0001\u001a\u0004\u0018\u00010\n2\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0003\u0010Í\u0001J\n\u0010Î\u0001\u001a\u00020\bH\u0096\u0001J\n\u0010Ï\u0001\u001a\u00020\u0005H\u0096\u0001J\u0015\u0010Ð\u0001\u001a\u00020\u00052\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u001b\u0010Ò\u0001\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0007\u0010Ó\u0001\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010Ô\u0001\u001a\u00020\u00052\u0007\u0010Õ\u0001\u001a\u00020\bH\u0096\u0001J\u0013\u0010Ö\u0001\u001a\u00020\u00052\u0007\u0010×\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010Ø\u0001\u001a\u00020\u00052\u0007\u0010Ù\u0001\u001a\u00020\u0011H\u0096\u0001J\"\u0010Ú\u0001\u001a\u00020\u00052\u0016\u0010×\u0001\u001a\u0011\u0012\u0005\u0012\u00030Û\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010Ü\u0001\u001a\u00020\u00052\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0003\u0010Ý\u0001J \u0010Þ\u0001\u001a\u00020\u00052\t\u0010ß\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010à\u0001\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J8\u0010á\u0001\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\r\u0010â\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110R2\u0013\u0010ã\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u0014\u0010ä\u0001\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0001J\u0013\u0010å\u0001\u001a\u00020\u00052\u0007\u0010æ\u0001\u001a\u00020\u0011H\u0096\u0001J\n\u0010ç\u0001\u001a\u00020\u0005H\u0096\u0001J.\u0010è\u0001\u001a\u00020\u00052\t\u0010é\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u00112\t\u0010ê\u0001\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0003\u0010ë\u0001J\u0013\u0010ì\u0001\u001a\u00020\b2\u0007\u0010í\u0001\u001a\u00020\u0011H\u0096\u0001JQ\u0010î\u0001\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\n2\u0007\u0010ï\u0001\u001a\u00020\u00112\u0006\u0010j\u001a\u00020\n2\b\u0010k\u001a\u0004\u0018\u00010\u00112\b\u0010?\u001a\u0004\u0018\u00010\n2\u0007\u0010ð\u0001\u001a\u00020u2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0011H\u0096\u0001¢\u0006\u0003\u0010ñ\u0001J\u001c\u0010ò\u0001\u001a\u00020\u00052\u0007\u0010ó\u0001\u001a\u00020\u00112\u0007\u0010ô\u0001\u001a\u00020\bH\u0096\u0001J\u0013\u0010õ\u0001\u001a\u00020\u00052\u0007\u0010ö\u0001\u001a\u00020\u0011H\u0096\u0001J\u001a\u0010÷\u0001\u001a\u00020\u00052\b\u0010g\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0003\u0010Ý\u0001J$\u0010ø\u0001\u001a\u00020\u00052\u0007\u0010ù\u0001\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020\nH\u0096\u0001J\n\u0010ú\u0001\u001a\u00020\u0005H\u0096\u0001J\n\u0010û\u0001\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010ü\u0001\u001a\u00020\u00052\u0007\u0010\u0006\u001a\u00030»\u0001H\u0096\u0001J\u0013\u0010ý\u0001\u001a\u00020\u00052\u0007\u0010\u0006\u001a\u00030¿\u0001H\u0096\u0001J\u0015\u0010þ\u0001\u001a\u00020\u00052\t\u0010×\u0001\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0013\u0010ÿ\u0001\u001a\u00020D2\u0007\u0010\u0080\u0002\u001a\u00020DH\u0096\u0001J\u0015\u0010\u0081\u0002\u001a\u00020\u00052\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010>H\u0096\u0001J\u0014\u0010\u0083\u0002\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u001e\u0010\u0084\u0002\u001a\u00020\u00052\b\b\u0001\u0010\u0010\u001a\u00020\n2\b\b\u0001\u0010g\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u0085\u0002\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\n\u0010\u0086\u0002\u001a\u00020\u0011H\u0096\u0001¨\u0006\u0087\u0002"}, d2 = {"Lcom/larus/avlink/api/DoraAVLinkDelegate;", "Lcom/larus/avlink/api/IDoraAVLinkService;", "<init>", "()V", "addOfflineRecordingUpdateListener", "", "listener", "Lkotlin/Function1;", "", "addRecordDurationListener", "", "addRecordingUpdateListener", "addTranslationStateListener", "bindFirstFeedShowView", "view", "Landroid/view/View;", "scene", "", "checkGAppUpdate", "source", "cleanupGalleryStorage", "Lcom/larus/avlink/api/GalleryStorageCleanupResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clickGuideTimes", "consumeProactiveSummaryCache", "createDiaryDetailContentView", "Lcom/larus/avlink/api/IDoraDiaryDetailContentView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "createMediaAlbumViewHelper", "Lcom/larus/avlink/api/IMediaAlbumViewHelper;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "discardPendingNotificationSummaries", "downgradeConfigUpdate", "enableCameraMockPlayback", "dataSetPath", "mode", "enableGUpdate", "enableVideoLiveAI", "getAlbumPreviewData", "Lcom/larus/avlink/api/DoraOAlbumPreviewData;", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCacheVadEvents", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "Lcom/flow/kmp/common/collections/CopyOnWriteArrayList;", "getCurrentCallTask", "Lcom/larus/avlink/api/IDoraRealtimeManager;", "getCurrentRecordingId", "getDatasetInjectTiming", "Lcom/larus/avlink/api/DatasetInjectTiming;", "getDiaryInsertPhotoEnabled", "callback", "getDoraCallMode", "()Ljava/lang/Integer;", "getDoraRealtimeManager", "conversationId", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "bizMode", "(Ljava/lang/String;Lcom/larus/im/bean/bot/BotModel;ILjava/lang/Integer;)Lcom/larus/avlink/api/IDoraRealtimeManager;", "getFaceSrModelState", "Lcom/larus/avlink/api/FaceSrModelState;", "getGalleryStoragePolicyConfig", "Lcom/larus/avlink/api/GalleryStoragePolicyConfig;", "getGalleryStorageStats", "Lcom/larus/avlink/api/GalleryStorageStats;", "getHardwareRecordingTitle", "productId", "(Ljava/lang/Integer;)Ljava/lang/String;", "getHookURL", "getHost", "getImageIdByMessageIdWithIntent", "messageId", "(Ljava/lang/String;)Ljava/lang/Integer;", "getMainBotInfo", "getRecordText", "getSimulLanguages", "", "Lcom/larus/avlink/api/DoraSimulLanguage;", "getSimulSubtitleHistory", "Lcom/larus/avlink/api/DoraSimulSubtitleItem;", "isTop", "getSupportedClientIntentType", "getVoiceInWakeup", "getWakeHistory", "guiEndOfflineRecord", "sourceTag", "onSuccess", "Lkotlin/Function0;", "guiEndRecord", "guiEndSimulInterpret", "onStopSi", "guiStartRecord", "isDeviceConnected", "guiStartSimulInterpret", "onStartSi", "onBlockStartSi", "handleRecordPreCheck", "state", "handleRecordWakeOff", "query", "vuiId", "kw", "handleRecordWakeReject", "handleRecordWakeUp", "idleInit", "initDoraAVLink", "injectDatasetPacks", "items", "Lcom/larus/avlink/api/DatasetInjectItem;", "onEnqueued", "onAllProcessed", "", "Lkotlin/ParameterName;", "name", "endTimeMillis", "isDeviceRecording", "isDoraCall", "isDoraCallDegrade", "isDoraG", "isDoraGEnable", "isDoraGuideDegrade", "isDoraNotifyDegrade", "isDoraSettingEntranceDegrade", "isEnvObserveSceneRunning", "isHardwareOfflineRecording", "isHonorDevice", "isInLiteLiveAI", "isInScene", "isInSystemNotify", "isMediaTransferOrProcessing", "isMusicActive", "isRecording", "isSessionRemind", "isSimulTranslating", "languageCodeToName", "code", "notifyDoraTakePicture", GearStrategyConsts.EV_QUALITY, "notifyMessageHistoryCleared", "notifyMessageRegenerated", "questionId", "observeAlbumCountChange", "Lkotlinx/coroutines/flow/Flow;", "Lcom/larus/avlink/api/DoraOAlbumCount;", "observeAlbumSyncState", "Lcom/larus/avlink/api/DoraOAlbumSyncState;", "observeSimulBudsState", "observeSimulSubtitles", "Lcom/larus/avlink/api/DoraSimulSubtitleEvent;", "onBudsStatedChanged", "isBothOutConnected", "onLocalIntentReceived", "intentType", "intentId", "onMusicPlayCallback", "Lcom/larus/avlink/model/DoraOnboardingMusicModel;", "onNaturalWakeupFuzzyWakeup", "result", "onNaturalWakeupVadChanged", "isStart", "onPlayTTS", "text", "onProActiveSummaryReceivedFromIm", "summaryId", "biz", "onProActiveSummaryReceivedFromPush", "title", "content", "onRejectStartVUI", "openDiaryBetaWeb", "date", "entry", "postProcessorVersion", "realOnVoiceWakeUp", "side", "extra", "recordNotificationReceived", "notificationId", "clientReceiveTimestampMs", "registerAccountStatusCallback", "registerAlbumMediaChangeListener", "Lcom/larus/avlink/api/DoraOAlbumMediaChangeListener;", "registerAutoGreetWearListener", "registerReceiveMessageListener", "registerSceneStateChangeListener", "Lcom/larus/avlink/common/SceneStateChangeListener;", "removeOfflineRecordingUpdateListener", "removeRecordDurationListener", "removeRecordingUpdateListener", "removeTranslationStateListener", "reportEnvObserveStatus", "status", "reason", "reportMicOccupyStatus", "isOccupy", "reportStatus", "link", "idleState", "currentIdleState", "(ZLjava/lang/Integer;Ljava/lang/Integer;)V", "requestP2PRTCVideoCallFromDeviceKey", "restartSimulInterpretForSettingChange", "sendNewcomerGuideQuery", "queryStarlingKey", "sendRecordMinutesText", "sendFuncChannel", "setDiaryInsertPhotoEnabled", "enabled", "setDoraSseFrontierDuration", "value", "setMockFilePath", "mockFilePath", "setOnAudioPlay", "", "setPendingEnvObserveEndReason", "(Ljava/lang/Integer;)V", "setupParams", "botId", "cvsId", "shareAlbumByIndex", "list", "onComplete", "shareAlbumZip", "shareVideoFile", "videoFile", "showRecordErrToast", "startDiscoverTabTryOnboarding", "noticeStarlingKey", "wakeMode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "startRecordFromRecorderApp", "requestId", "startSession", "requestMode", DyPayConstant.KEY_START_TIME, "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;JLjava/lang/String;)V", "startSseFrontierForProActiveNotificationSummary", "trigger", "isRetry", "stopRecord", "stopReason", "stopTask", "stopVUI", "isSilent", "triggerAlbumSync", "unRegisterReceiveMessageListener", "unregisterAlbumMediaChangeListener", "unregisterSceneStateChangeListener", "updateBotStyleId", "updateGalleryStoragePolicyConfig", "config", "updateMainBotInfo", "botModel", "updateMainConversationId", "updateSceneState", "updateTranslateSceneSwitch", "videoStabilizerVersion", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraAVLinkDelegate implements IDoraAVLinkService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DoraAVLinkDelegate f291640b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDoraAVLinkService f291641a;

    static {
        f291640b = new DoraAVLinkDelegate();
    }

    @Override // w88.r
    public final t A() {
        return this.f291641a.A();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void A0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f291641a.A0(r100, r101);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void A1() {
        this.f291641a.A1();
    }

    @Override // w88.r
    public final boolean B() {
        return this.f291641a.B();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void B0(@FlowDoraScene int r100, @FlowDoraSceneState int r101) {
        this.f291641a.B0(r100, r101);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final Flow<e> B1() {
        return this.f291641a.B1();
    }

    @Override // w88.r
    public final void C(String r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f291641a.C(r100, r101, r102);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void C0(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.C0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void C1(c0 r100) {
        Intrinsics.checkNotNullParameter("RecordMinutesUIComponent", "sourceTag");
        this.f291641a.C1(r100);
    }

    @Override // w88.r
    public final void D() {
        this.f291641a.D();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void D0(Context r100, Function0 r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("ODoraSimulInterpretFragment", "sourceTag");
        this.f291641a.D0(r100, r101, r102);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void D1() {
        this.f291641a.D1();
    }

    @Override // w88.r
    public final void E(int r100) {
        this.f291641a.E(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final List<Integer> E0() {
        return this.f291641a.E0();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean E1(int r100) {
        return this.f291641a.E1(r100);
    }

    @Override // w88.r
    public final void F(String r100) {
        this.f291641a.F(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void F0() {
        this.f291641a.F0();
    }

    @Override // w88.r
    public final boolean G() {
        return this.f291641a.G();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final List<j> G0() {
        return this.f291641a.G0();
    }

    @Override // w88.r
    public final void H() {
        this.f291641a.H();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final Flow<i> H0() {
        return this.f291641a.H0();
    }

    @Override // w88.r
    public final void I() {
        Intrinsics.checkNotNullParameter("init_dora_immediate", "source");
        this.f291641a.I();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void I0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "summaryId");
        this.f291641a.I0(r100, r101);
    }

    @Override // w88.r
    public final void J(int r100, int r110, int r111, int r112, int r113, String r114, String r115) {
        this.f291641a.J(r100, r110, r111, r112, r113, r114, r115);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void J0(int r100) {
        this.f291641a.J0(r100);
    }

    @Override // w88.r
    public final void K(b r100) {
        this.f291641a.K(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final String K0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "code");
        return this.f291641a.K0(r100);
    }

    @Override // w88.r
    public final boolean L() {
        return this.f291641a.L();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void L0(z r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.L0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void M0(Context r100, boolean r101, d0 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("RecordMinutesUIComponent", "sourceTag");
        this.f291641a.M0(r100, r101, r102);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void N0(Integer r100) {
        this.f291641a.N0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void O0(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.O0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean P0() {
        return this.f291641a.P0();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void Q0() {
        this.f291641a.Q0();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean R0() {
        return this.f291641a.R0();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void S0(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.S0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void T0(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.T0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void U0(b0 r100) {
        Intrinsics.checkNotNullParameter("RecordMinutesUIComponent", "sourceTag");
        this.f291641a.U0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void V0(Context r100, List r101, s1 r102) {
        Intrinsics.checkNotNullParameter(r101, "list");
        Intrinsics.checkNotNullParameter(r102, "onComplete");
        this.f291641a.V0(r100, r101, r102);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void W0(f r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f291641a.W0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final List<l> X0(boolean r100) {
        return this.f291641a.X0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean Y0() {
        return this.f291641a.Y0();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean Z0() {
        return this.f291641a.Z0();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stopReason");
        this.f291641a.a(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void a1(String r100, long r101) {
        this.f291641a.a1(r100, r101);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean b() {
        return this.f291641a.b();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void b1(int r100, int r101) {
        this.f291641a.b1(r100, r101);
    }

    @Override // w88.r
    public final Integer c() {
        return this.f291641a.c();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean c1(@FlowDoraScene int r100) {
        return this.f291641a.c1(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean d() {
        return this.f291641a.d();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void d1(boolean r100) {
        this.f291641a.d1(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final String e() {
        return this.f291641a.e();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void e1(int r100) {
        this.f291641a.e1(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f291641a.f(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean f1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        return this.f291641a.f1(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void g(int r100, long r101) {
        this.f291641a.g(r100, r101);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void g1(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.g1(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final String getHost() {
        return this.f291641a.getHost();
    }

    @Override // w88.r
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f291641a.h(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void h1(z r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.h1(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void i(boolean r100) {
        this.f291641a.i(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean i1(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "entry");
        return this.f291641a.i1(r100, r101, r102);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void idleInit() {
        this.f291641a.idleInit();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean isRecording() {
        return this.f291641a.isRecording();
    }

    @Override // w88.r
    public final boolean j() {
        return this.f291641a.j();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final Object j1(Continuation r100) {
        return this.f291641a.j1(r100);
    }

    @Override // w88.r
    public final void k(String r100, String r101) {
        this.f291641a.k(r100, r101);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean k1() {
        return this.f291641a.k1();
    }

    @Override // w88.r
    public final boolean l() {
        return this.f291641a.l();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final u l1(Context r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        return this.f291641a.l1(r100, r101);
    }

    @Override // w88.r
    public final void m(Function1<? super z98.f, Unit> r100) {
        this.f291641a.m(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void m1(ODoraAlbumCardView.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.m1(r100);
    }

    @Override // w88.r
    public final void n(Integer r100) {
        this.f291641a.n(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void n1(boolean r100) {
        this.f291641a.n1(r100);
    }

    @Override // w88.r
    public final void o(boolean r100) {
        this.f291641a.o(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean o1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        return this.f291641a.o1(r100);
    }

    @Override // w88.r
    public final void p() {
        Intrinsics.checkNotNullParameter("INLCallback_onNotify", "trigger");
        this.f291641a.p();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean p1() {
        return this.f291641a.p1();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final String postProcessorVersion() {
        return this.f291641a.postProcessorVersion();
    }

    @Override // w88.r
    public final String q() {
        return this.f291641a.q();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void q1(ODoraAlbumCardView.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.q1(r100);
    }

    @Override // w88.r
    public final void r(BotModel r100) {
        this.f291641a.r(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void r1() {
        this.f291641a.r1();
    }

    @Override // w88.r
    public final boolean s() {
        return this.f291641a.s();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final s s1(Context r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        return this.f291641a.s1(r100, r101);
    }

    @Override // w88.r
    public final void t(boolean r100, Integer r101, Integer r102) {
        this.f291641a.t(r100, r101, r102);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void t1(y r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.t1(r100);
    }

    @Override // w88.r
    public final void u() {
        this.f291641a.u();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final String u0() {
        return this.f291641a.u0();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final String u1(Integer r100) {
        return this.f291641a.u1(r100);
    }

    @Override // w88.r
    public final void v(String r100, String r101) {
        this.f291641a.v(r100, r101);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void v0(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.v0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void v1(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f291641a.v1(r100, r101);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final String videoStabilizerVersion() {
        return this.f291641a.videoStabilizerVersion();
    }

    @Override // w88.r
    public final void w(int r110, String r111, int r112, String r113, Integer r114, long r115, String r116) {
        Intrinsics.checkNotNullParameter(r111, "requestMode");
        this.f291641a.w(r110, r111, 0, r113, r114, r115, r116);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final Flow<k> w0(boolean r100) {
        return this.f291641a.w0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void w1() {
        this.f291641a.w1();
    }

    @Override // w88.r
    public final void x(String r100) {
        this.f291641a.x(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void x0(Function0<Unit> r100) {
        this.f291641a.x0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean x1() {
        return this.f291641a.x1();
    }

    @Override // w88.r
    public final boolean y() {
        return this.f291641a.y();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final void y0(y r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f291641a.y0(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final Integer y1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        return this.f291641a.y1(r100);
    }

    @Override // w88.r
    public final void z(String r100) {
        this.f291641a.z(r100);
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final Flow<Boolean> z0() {
        return this.f291641a.z0();
    }

    @Override // com.larus.avlink.api.IDoraAVLinkService
    public final boolean z1() {
        return this.f291641a.z1();
    }

    private DoraAVLinkDelegate() {
        Object r100 = ServiceManager.get().getService(IDoraAVLinkService.class);
        Intrinsics.checkNotNull(r100);
        this.f291641a = (IDoraAVLinkService) r100;
    }
}
