package com.bytedance.android.livesdk.ktvimpl.base;

import android.util.LongSparseArray;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.model.api.c0;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.plantform.utils.d0;
import com.bytedance.android.live.profit.dress.t;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.z0;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.sei.r;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KComponentCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvSingerViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.kh;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import fd2.x;
import fd2.y;
import fd2.z;
import gd0.v;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000Ì\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Ä\u00022\u00020\u0001:\u0002Å\u0002B\t¢\u0006\u0006\bÂ\u0002\u0010Ã\u0002J\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\nJ \u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\u0011J\u001a\u0010\u001f\u001a\u00020\u001e2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001c0\u001bJ\u0006\u0010 \u001a\u00020\u0011J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0011J,\u0010'\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010%\u001a\u00020\u00112\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110\u001bR$\u0010(\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R3\u0010?\u001a\u001e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=0<j\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=`>8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010D\u001a\u00020C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR!\u0010N\u001a\b\u0012\u0004\u0012\u00020I0H8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\"\u0010P\u001a\u00020O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R!\u0010`\u001a\b\u0012\u0004\u0012\u00020]0H8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b^\u0010K\u001a\u0004\b_\u0010MR-\u0010g\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020c0b0a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010K\u001a\u0004\be\u0010fR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0h8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bi\u0010K\u001a\u0004\bj\u0010kR!\u0010o\u001a\b\u0012\u0004\u0012\u00020l0h8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bm\u0010K\u001a\u0004\bn\u0010kR'\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020q0p0H8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\br\u0010K\u001a\u0004\bs\u0010MR\u001d\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00110u8\u0006¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u0017\u0010{\u001a\u00020z8\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R$\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010K\u001a\u0005\b\u0081\u0001\u0010kR$\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110a8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010K\u001a\u0005\b\u0084\u0001\u0010fR$\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010K\u001a\u0005\b\u0087\u0001\u0010fR%\u0010\u008c\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010K\u001a\u0005\b\u008b\u0001\u0010kR%\u0010\u0090\u0001\u001a\t\u0012\u0005\u0012\u00030\u008d\u00010h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010K\u001a\u0005\b\u008f\u0001\u0010kR%\u0010\u0094\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010H8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010K\u001a\u0005\b\u0093\u0001\u0010MR%\u0010\u0098\u0001\u001a\t\u0012\u0005\u0012\u00030\u0095\u00010a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010K\u001a\u0005\b\u0097\u0001\u0010fR%\u0010\u009c\u0001\u001a\t\u0012\u0005\u0012\u00030\u0099\u00010H8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010K\u001a\u0005\b\u009b\u0001\u0010MR%\u0010 \u0001\u001a\t\u0012\u0005\u0012\u00030\u009d\u00010a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010K\u001a\u0005\b\u009f\u0001\u0010fR%\u0010¤\u0001\u001a\t\u0012\u0005\u0012\u00030¡\u00010h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¢\u0001\u0010K\u001a\u0005\b£\u0001\u0010kR%\u0010§\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010H8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¥\u0001\u0010K\u001a\u0005\b¦\u0001\u0010MR%\u0010ª\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010H8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¨\u0001\u0010K\u001a\u0005\b©\u0001\u0010MR%\u0010\u00ad\u0001\u001a\t\u0012\u0005\u0012\u00030\u009d\u00010a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b«\u0001\u0010K\u001a\u0005\b¬\u0001\u0010fR%\u0010±\u0001\u001a\t\u0012\u0005\u0012\u00030®\u00010a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¯\u0001\u0010K\u001a\u0005\b°\u0001\u0010fR%\u0010´\u0001\u001a\t\u0012\u0005\u0012\u00030\u009d\u00010h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b²\u0001\u0010K\u001a\u0005\b³\u0001\u0010kR%\u0010·\u0001\u001a\t\u0012\u0005\u0012\u00030\u009d\u00010H8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bµ\u0001\u0010K\u001a\u0005\b¶\u0001\u0010MR'\u0010½\u0001\u001a\n\u0012\u0005\u0012\u00030¹\u00010¸\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\bº\u0001\u0010K\u001a\u0006\b»\u0001\u0010¼\u0001R#\u0010¿\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040¾\u00018\u0006¢\u0006\u0010\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001R%\u0010Æ\u0001\u001a\t\u0012\u0005\u0012\u00030Ã\u00010h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÄ\u0001\u0010K\u001a\u0005\bÅ\u0001\u0010kR&\u0010Ë\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0Ç\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\bÈ\u0001\u0010K\u001a\u0006\bÉ\u0001\u0010Ê\u0001R#\u0010Í\u0001\u001a\t\u0012\u0004\u0012\u00020=0Ì\u00018\u0006¢\u0006\u0010\n\u0006\bÍ\u0001\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010Ð\u0001R%\u0010Ô\u0001\u001a\t\u0012\u0005\u0012\u00030Ñ\u00010H8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÒ\u0001\u0010K\u001a\u0005\bÓ\u0001\u0010MR%\u0010Ø\u0001\u001a\t\u0012\u0005\u0012\u00030Õ\u00010a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÖ\u0001\u0010K\u001a\u0005\b×\u0001\u0010fR$\u0010Û\u0001\u001a\b\u0012\u0004\u0012\u00020=0h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÙ\u0001\u0010K\u001a\u0005\bÚ\u0001\u0010kR%\u0010Þ\u0001\u001a\t\u0012\u0005\u0012\u00030\u009d\u00010a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÜ\u0001\u0010K\u001a\u0005\bÝ\u0001\u0010fR$\u0010á\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bß\u0001\u0010K\u001a\u0005\bà\u0001\u0010fR$\u0010ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bâ\u0001\u0010K\u001a\u0005\bã\u0001\u0010fR%\u0010æ\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010H8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bä\u0001\u0010K\u001a\u0005\bå\u0001\u0010MR$\u0010é\u0001\u001a\n\u0012\u0005\u0012\u00030è\u00010ç\u00018\u0006¢\u0006\u0010\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001R%\u0010ð\u0001\u001a\t\u0012\u0005\u0012\u00030í\u00010h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bî\u0001\u0010K\u001a\u0005\bï\u0001\u0010kR%\u0010ô\u0001\u001a\t\u0012\u0005\u0012\u00030ñ\u00010h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bò\u0001\u0010K\u001a\u0005\bó\u0001\u0010kR%\u0010ø\u0001\u001a\t\u0012\u0005\u0012\u00030õ\u00010H8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bö\u0001\u0010K\u001a\u0005\b÷\u0001\u0010MR$\u0010û\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bù\u0001\u0010K\u001a\u0005\bú\u0001\u0010fR$\u0010þ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020H8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bü\u0001\u0010K\u001a\u0005\bý\u0001\u0010MR%\u0010\u0082\u0002\u001a\t\u0012\u0005\u0012\u00030ÿ\u00010h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0080\u0002\u0010K\u001a\u0005\b\u0081\u0002\u0010kR%\u0010\u0086\u0002\u001a\t\u0012\u0005\u0012\u00030\u0083\u00020H8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0084\u0002\u0010K\u001a\u0005\b\u0085\u0002\u0010MR#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020h8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0087\u0002\u0010K\u001a\u0005\b\u0088\u0002\u0010kR$\u0010\u008b\u0002\u001a\b\u0012\u0004\u0012\u00020\u00020h8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0089\u0002\u0010K\u001a\u0005\b\u008a\u0002\u0010kR\u001d\u0010\u008d\u0002\u001a\u00030\u008c\u00028\u0006¢\u0006\u0010\n\u0006\b\u008d\u0002\u0010\u008e\u0002\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002R+\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0002\u0010\u0092\u0002\u001a\u0006\b\u0091\u0002\u0010\u0093\u0002\"\u0006\b\u0094\u0002\u0010\u0095\u0002R$\u0010\u0097\u0002\u001a\b\u0012\u0004\u0012\u00020\u00110a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0096\u0002\u0010K\u001a\u0005\b\u0097\u0002\u0010fR%\u0010\u009b\u0002\u001a\t\u0012\u0005\u0012\u00030\u0098\u00020h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0099\u0002\u0010K\u001a\u0005\b\u009a\u0002\u0010kR%\u0010\u009f\u0002\u001a\t\u0012\u0005\u0012\u00030\u009c\u00020h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009d\u0002\u0010K\u001a\u0005\b\u009e\u0002\u0010kR$\u0010¢\u0002\u001a\b\u0012\u0004\u0012\u00020\u00020h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b \u0002\u0010K\u001a\u0005\b¡\u0002\u0010kR*\u0010¥\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110p0h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b£\u0002\u0010K\u001a\u0005\b¤\u0002\u0010kR+\u0010©\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¦\u00020p0h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b§\u0002\u0010K\u001a\u0005\b¨\u0002\u0010kR$\u0010¬\u0002\u001a\b\u0012\u0004\u0012\u00020\u00020a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bª\u0002\u0010K\u001a\u0005\b«\u0002\u0010fR*\u0010®\u0002\u001a\u00030\u00ad\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b®\u0002\u0010¯\u0002\u001a\u0006\b°\u0002\u0010±\u0002\"\u0006\b²\u0002\u0010³\u0002R%\u0010·\u0002\u001a\t\u0012\u0005\u0012\u00030´\u00020H8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bµ\u0002\u0010K\u001a\u0005\b¶\u0002\u0010MR$\u0010º\u0002\u001a\b\u0012\u0004\u0012\u00020\u00110a8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¸\u0002\u0010K\u001a\u0005\b¹\u0002\u0010fR$\u0010½\u0002\u001a\b\u0012\u0004\u0012\u00020\u00160h8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b»\u0002\u0010K\u001a\u0005\b¼\u0002\u0010kR%\u0010Á\u0002\u001a\t\u0012\u0005\u0012\u00030¾\u00020h8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¿\u0002\u0010K\u001a\u0005\bÀ\u0002\u0010k¨\u0006Æ\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "mId", "Lcom/bytedance/android/livesdk/ktvimpl/base/util/p;", "kotlin.jvm.PlatformType", "getLyricStateRecord", "targetScoreSelected", "", "setTargetScoreSelected", "(Ljava/lang/Long;)V", "targetDurationSelected", "setTargetDurationSelected", "Loe2/b;", "ktvRoomProvider", "Lsb0/b;", "dataEntityProxy", "", "isKtvScene", "initKtvCoreAndSingerViewModel", "openAudioKtv", "updateKtvAllStateValue", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/a;", "feedbackResult", "updateSingEndedFeedback", "clearKtvCoreAndSingerViewModel", "isKtvMode", "Lio/reactivex/functions/Consumer;", "Lsh6/b;", "consumer", "Lio/reactivex/disposables/Disposable;", "observeSingEndedFeedbackSei", "isCurrentUserIsSinger", "isSinger", "updateCurrentUserIsSinger", "Landroidx/lifecycle/LifecycleOwner;", "owner", "needObserveOnUi", "observer", "observerCurrentUserIsSinger", "dataContextDisposable", "Lio/reactivex/disposables/Disposable;", "getDataContextDisposable", "()Lio/reactivex/disposables/Disposable;", "setDataContextDisposable", "(Lio/reactivex/disposables/Disposable;)V", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;", "opusMvService", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;", "getOpusMvService", "()Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;", "setOpusMvService", "(Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;)V", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "giftReportParam", "Ljava/util/HashMap;", "getGiftReportParam", "()Ljava/util/HashMap;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;", "lyricResourceManager", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;", "getLyricResourceManager", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/livesdk/message/model/kh;", "openKtvEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getOpenKtvEvent", "()Lcom/bytedance/live/datacontext/k;", "openKtvEvent", "Lcom/bytedance/android/live/ktv/common/util/e;", "bizLcMager", "Lcom/bytedance/android/live/ktv/common/util/e;", "getBizLcMager", "()Lcom/bytedance/android/live/ktv/common/util/e;", "setBizLcMager", "(Lcom/bytedance/android/live/ktv/common/util/e;)V", "Lcom/bytedance/android/live/ktv/common/util/k;", "statisticHelper", "Lcom/bytedance/android/live/ktv/common/util/k;", "getStatisticHelper", "()Lcom/bytedance/android/live/ktv/common/util/k;", "setStatisticHelper", "(Lcom/bytedance/android/live/ktv/common/util/k;)V", "Lod2/b;", "openKtvRoomDialogEvent$delegate", "getOpenKtvRoomDialogEvent", "openKtvRoomDialogEvent", "Lcom/bytedance/live/datacontext/m;", "", "Lcom/bytedance/android/live/ktv/common/model/bean/f;", "musicDownloadResourceMap$delegate", "getMusicDownloadResourceMap", "()Lcom/bytedance/live/datacontext/m;", "musicDownloadResourceMap", "Lcom/bytedance/live/datacontext/n;", "ktvRoomProvider$delegate", "getKtvRoomProvider", "()Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/liveinteract/plantform/utils/d0;", "streamInfoSender$delegate", "getStreamInfoSender", "streamInfoSender", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/y;", "linkMicSettingUpdate$delegate", "getLinkMicSettingUpdate", "linkMicSettingUpdate", "Landroidx/lifecycle/MutableLiveData;", "realOpenStateData", "Landroidx/lifecycle/MutableLiveData;", "getRealOpenStateData", "()Landroidx/lifecycle/MutableLiveData;", "Llb0/b;", "ktvMvBackRound", "Llb0/b;", "getKtvMvBackRound", "()Llb0/b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/util/h;", "bigEventHelper$delegate", "getBigEventHelper", "bigEventHelper", "currentUserIsSinger$delegate", "getCurrentUserIsSinger", "currentUserIsSinger", "hasBgm$delegate", "getHasBgm", "hasBgm", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "currentSongOfSelf$delegate", "getCurrentSongOfSelf", "currentSongOfSelf", "Lcom/bytedance/android/livesdk/ktvimpl/base/i;", "ktvCoreController$delegate", "getKtvCoreController", "ktvCoreController", "", "ktvRoomLabelChangeEvent$delegate", "getKtvRoomLabelChangeEvent", "ktvRoomLabelChangeEvent", "Lcom/bytedance/android/livesdk/ktvimpl/base/p;", "realTimeInfoModel$delegate", "getRealTimeInfoModel", "realTimeInfoModel", "Lfd2/z;", "ktvComponentSingerUserIdChangedEvent$delegate", "getKtvComponentSingerUserIdChangedEvent", "ktvComponentSingerUserIdChangedEvent", "", "ktvComponentStatus$delegate", "getKtvComponentStatus", "ktvComponentStatus", "Lcom/bytedance/android/livesdk/message/model/OrderInfo;", "ktvCurrentSingOrderInfo$delegate", "getKtvCurrentSingOrderInfo", "ktvCurrentSingOrderInfo", "ktvStageIdleEvent$delegate", "getKtvStageIdleEvent", "ktvStageIdleEvent", "ktvStagePreparedEvent$delegate", "getKtvStagePreparedEvent", "ktvStagePreparedEvent", "ktvAllState$delegate", "getKtvAllState", "ktvAllState", "Lcom/bytedance/android/livesdk/ktvimpl/base/util/e;", "ktvRoomStrategy$delegate", "getKtvRoomStrategy", "ktvRoomStrategy", "ktvCardViewSizeChanged$delegate", "getKtvCardViewSizeChanged", "ktvCardViewSizeChanged", "ktvStageReadyEvent$delegate", "getKtvStageReadyEvent", "ktvStageReadyEvent", "Lcom/bytedance/live/datacontext/i;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/m;", "seiProcessor$delegate", "getSeiProcessor", "()Lcom/bytedance/live/datacontext/i;", "seiProcessor", "Landroid/util/LongSparseArray;", "lyricStateRecordMap", "Landroid/util/LongSparseArray;", "getLyricStateRecordMap", "()Landroid/util/LongSparseArray;", "Loe2/d;", "ktvRoomModel$delegate", "getKtvRoomModel", "ktvRoomModel", "Lcom/bytedance/live/datacontext/j;", "dataEntity$delegate", "getDataEntity", "()Lcom/bytedance/live/datacontext/j;", "dataEntity", "", "recentMusicInfo", "Ljava/util/List;", "getRecentMusicInfo", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/model/a;", "openOpusPreViewDialog$delegate", "getOpenOpusPreViewDialog", "openOpusPreViewDialog", "Lfd2/y;", "ktvRoomInfo$delegate", "getKtvRoomInfo", "ktvRoomInfo", "currentMvVid$delegate", "getCurrentMvVid", "currentMvVid", "curKtvMode$delegate", "getCurKtvMode", "curKtvMode", "curIsMultipleKtvMode$delegate", "getCurIsMultipleKtvMode", "curIsMultipleKtvMode", "isPushingExternalVideo$delegate", "isPushingExternalVideo", "echoStateCheckEvent$delegate", "getEchoStateCheckEvent", "echoStateCheckEvent", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lub0/a;", "lyricsChangeLiveData", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getLyricsChangeLiveData", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/c;", "ktvCoreViewModel$delegate", "getKtvCoreViewModel", "ktvCoreViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/d;", "ktvSingerViewModel$delegate", "getKtvSingerViewModel", "ktvSingerViewModel", "Lcom/bytedance/android/live/ktv/common/model/bean/a;", "countDownEvent$delegate", "getCountDownEvent", "countDownEvent", "enableKtvAtmosphere$delegate", "getEnableKtvAtmosphere", "enableKtvAtmosphere", "moveSongToOtherRoomEvent$delegate", "getMoveSongToOtherRoomEvent", "moveSongToOtherRoomEvent", "Lcom/bytedance/android/live/ktv/common/model/api/c0;", "ktvChallengeSettingPanelData$delegate", "getKtvChallengeSettingPanelData", "ktvChallengeSettingPanelData", "Lme2/b;", "prepareChallengeEvent$delegate", "getPrepareChallengeEvent", "prepareChallengeEvent", "targetScoreSelected$delegate", "getTargetScoreSelected", "durationSelected$delegate", "getDurationSelected", "durationSelected", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/b;", "kWidgetManager", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/b;", "getKWidgetManager", "()Lcom/bytedance/android/livesdk/ktvimpl/base/frame/b;", "isEnterKtvDirectly", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setEnterKtvDirectly", "(Ljava/lang/Boolean;)V", "isKtvRoomContextInit$delegate", "isKtvRoomContextInit", "Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;", "midiSkinContext$delegate", "getMidiSkinContext", "midiSkinContext", "Lcom/bytedance/android/live/profit/dress/t;", "linkmicRealTimeChorusDress$delegate", "getLinkmicRealTimeChorusDress", "linkmicRealTimeChorusDress", "ktvAddDressVersion$delegate", "getKtvAddDressVersion", "ktvAddDressVersion", "eachKtvTabHasMore$delegate", "getEachKtvTabHasMore", "eachKtvTabHasMore", "Lcom/bytedance/android/live/ktv/common/model/api/o0;", "labelList$delegate", "getLabelList", "labelList", "voiceKtvSwitchTime$delegate", "getVoiceKtvSwitchTime", "voiceKtvSwitchTime", "", "ktvInteractRegionOffset", "F", "getKtvInteractRegionOffset", "()F", "setKtvInteractRegionOffset", "(F)V", "Lcom/bytedance/android/livesdk/ktvimpl/base/util/i;", "ktvContainerPositionUpdateEvent$delegate", "getKtvContainerPositionUpdateEvent", "ktvContainerPositionUpdateEvent", "soundCardSelectedStatus$delegate", "getSoundCardSelectedStatus", "soundCardSelectedStatus", "singEndedFeedbackSei$delegate", "getSingEndedFeedbackSei", "singEndedFeedbackSei", "Lfd2/x;", "ktvComponentCmdForAnchor$delegate", "getKtvComponentCmdForAnchor", "ktvComponentCmdForAnchor", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "KtvContext";
    private static final boolean enableRoomStateSync = false;
    private final com.bytedance.live.datacontext.p bigEventHelper$delegate;
    private com.bytedance.android.live.ktv.common.util.e bizLcMager;
    private final com.bytedance.live.datacontext.p countDownEvent$delegate;
    private final com.bytedance.live.datacontext.p curIsMultipleKtvMode$delegate;
    private final com.bytedance.live.datacontext.p curKtvMode$delegate;
    private final com.bytedance.live.datacontext.p currentMvVid$delegate;
    private final com.bytedance.live.datacontext.p currentSongOfSelf$delegate;
    private final com.bytedance.live.datacontext.p currentUserIsSinger$delegate;
    private DataCenter dataCenter;
    private Disposable dataContextDisposable;
    private final com.bytedance.live.datacontext.p dataEntity$delegate;
    private final com.bytedance.live.datacontext.p durationSelected$delegate;
    private final com.bytedance.live.datacontext.p eachKtvTabHasMore$delegate;
    private final com.bytedance.live.datacontext.p echoStateCheckEvent$delegate;
    private final com.bytedance.live.datacontext.p enableKtvAtmosphere$delegate;
    private final HashMap<String, String> giftReportParam;
    private final com.bytedance.live.datacontext.p hasBgm$delegate;
    private Boolean isEnterKtvDirectly;
    private final com.bytedance.live.datacontext.p isKtvRoomContextInit$delegate;
    private final com.bytedance.live.datacontext.p isPushingExternalVideo$delegate;
    private final com.bytedance.android.livesdk.ktvimpl.base.frame.b kWidgetManager;
    private final com.bytedance.live.datacontext.p ktvAddDressVersion$delegate;
    private final com.bytedance.live.datacontext.p ktvAllState$delegate;
    private final com.bytedance.live.datacontext.p ktvCardViewSizeChanged$delegate;
    private final com.bytedance.live.datacontext.p ktvChallengeSettingPanelData$delegate;
    private final com.bytedance.live.datacontext.p ktvComponentCmdForAnchor$delegate;
    private final com.bytedance.live.datacontext.p ktvComponentSingerUserIdChangedEvent$delegate;
    private final com.bytedance.live.datacontext.p ktvComponentStatus$delegate;
    private final com.bytedance.live.datacontext.p ktvContainerPositionUpdateEvent$delegate;
    private final com.bytedance.live.datacontext.p ktvCoreController$delegate;
    private final com.bytedance.live.datacontext.p ktvCoreViewModel$delegate;
    private final com.bytedance.live.datacontext.p ktvCurrentSingOrderInfo$delegate;
    private float ktvInteractRegionOffset;
    private final lb0.b ktvMvBackRound;
    private final com.bytedance.live.datacontext.p ktvRoomInfo$delegate;
    private final com.bytedance.live.datacontext.p ktvRoomLabelChangeEvent$delegate;
    private final com.bytedance.live.datacontext.p ktvRoomModel$delegate;
    private final com.bytedance.live.datacontext.p ktvRoomProvider$delegate;
    private final com.bytedance.live.datacontext.p ktvRoomStrategy$delegate;
    private final com.bytedance.live.datacontext.p ktvSingerViewModel$delegate;
    private final com.bytedance.live.datacontext.p ktvStageIdleEvent$delegate;
    private final com.bytedance.live.datacontext.p ktvStagePreparedEvent$delegate;
    private final com.bytedance.live.datacontext.p ktvStageReadyEvent$delegate;
    private final com.bytedance.live.datacontext.p labelList$delegate;
    private final com.bytedance.live.datacontext.p linkMicSettingUpdate$delegate;
    private final com.bytedance.live.datacontext.p linkmicRealTimeChorusDress$delegate;
    private final com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h lyricResourceManager;
    private final LongSparseArray<com.bytedance.android.livesdk.ktvimpl.base.util.p> lyricStateRecordMap;
    private final NextLiveData<ub0.a> lyricsChangeLiveData;
    private final com.bytedance.live.datacontext.p midiSkinContext$delegate;
    private final com.bytedance.live.datacontext.p moveSongToOtherRoomEvent$delegate;
    private final com.bytedance.live.datacontext.p musicDownloadResourceMap$delegate;
    private final com.bytedance.live.datacontext.p openKtvEvent$delegate;
    private final com.bytedance.live.datacontext.p openKtvRoomDialogEvent$delegate;
    private final com.bytedance.live.datacontext.p openOpusPreViewDialog$delegate;
    private com.bytedance.android.livesdk.ktvapi.model.mv.g opusMvService;
    private final com.bytedance.live.datacontext.p prepareChallengeEvent$delegate;
    private final MutableLiveData<Boolean> realOpenStateData;
    private final com.bytedance.live.datacontext.p realTimeInfoModel$delegate;
    private final List<String> recentMusicInfo;
    private final com.bytedance.live.datacontext.p seiProcessor$delegate;
    private final com.bytedance.live.datacontext.p singEndedFeedbackSei$delegate;
    private final com.bytedance.live.datacontext.p soundCardSelectedStatus$delegate;
    private com.bytedance.android.live.ktv.common.util.k statisticHelper;
    private final com.bytedance.live.datacontext.p streamInfoSender$delegate;
    private final com.bytedance.live.datacontext.p targetScoreSelected$delegate;
    private final com.bytedance.live.datacontext.p voiceKtvSwitchTime$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static String h() {
            StringBuilder r0 = new StringBuilder();
            KtvContext r1 = g();
            if (r1 == null) goto L11;
            List<String> r2 = r1.getRecentMusicInfo();
            if (r2 == null) goto L11;
            Iterator<T> r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L11;
            r0.append((String) r3.next());
        L11:
            return r0.toString();
        }

        @JvmStatic
        public static boolean j() {
            Lazy r0 = KtvSettingHelper.a;
            return KtvUtilsKt.e();
        }

        @JvmStatic
        public static boolean k() {
            Lazy r0 = KtvSettingHelper.a;
            return KtvUtilsKt.g();
        }

        @JvmStatic
        public static boolean d() {
            return ((Boolean) KtvContext.access$getCurrentUserIsSinger$p(g()).getValue()).booleanValue();
        }

        @JvmStatic
        public static int e() {
            KtvContext r0 = g();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.m<Integer> r1 = r0.getKtvAllState();
            if (r1 == null) goto L7;
            Integer r2 = (Integer) r1.getValue();
        L9:
            return r2.intValue();
        L7:
            r2 = null;
            goto L9
        }

        @JvmStatic
        public static KtvContext g() {
            u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
            DataContext r1 = null;
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.n r2 = r0.b();
            if (r2 == null) goto L7;
            DataContext r3 = (DataContext) r2.getValue();
        L9:
            if ((r3 instanceof KtvContext) == true) goto L12;
            r3 = null;
        L12:
            if (((KtvContext) r3) == null) goto L25;
            u r4 = com.bytedance.android.live.liveinteract.api.utils.m.d();
            if (r4 == null) goto L18;
            com.bytedance.live.datacontext.n r5 = r4.b();
            if (r5 == null) goto L18;
            DataContext r6 = (DataContext) r5.getValue();
        L20:
            if ((r6 instanceof KtvContext) == false) goto L23;
            r1 = r6;
        L23:
            KtvContext r7 = (KtvContext) r1;
            Intrinsics.checkNotNull(r7);
            return r7;
        L18:
            r6 = null;
            goto L20
        L25:
            DataContext r8 = com.bytedance.live.datacontext.d.d(KtvContext.class);
            if ((r8 instanceof KtvContext) == true) goto L29;
            r8 = null;
        L29:
            if (((KtvContext) r8) == null) goto L36;
            DataContext r9 = com.bytedance.live.datacontext.d.d(KtvContext.class);
            if ((r9 instanceof KtvContext) == false) goto L34;
            r1 = r9;
        L34:
            KtvContext r10 = (KtvContext) r1;
            Intrinsics.checkNotNull(r10);
            return r10;
        L36:
            KtvContext r11 = new KtvContext();
            Lazy r12 = KtvCommonSettingHelper.a;     // Catch: Exception -> L46
            if (((Boolean) vm2.h.f3.getValue(null, vm2.h.a[212(0xd4, float:2.97E-43)])).booleanValue() == false) goto L44;
            u r13 = com.bytedance.android.live.liveinteract.api.utils.m.d();     // Catch: Exception -> L46
            if (r13 == null) goto L44;
            com.bytedance.live.datacontext.n r14 = r13.b();     // Catch: Exception -> L46
            if (r14 == null) goto L44;
            r14.setValue(r11);     // Catch: Exception -> L46
        L44:
            bb0.a r15 = bb0.b.a;     // Catch: Exception -> L46
            n r16 = n.a;     // Catch: Exception -> L46
            Intrinsics.checkNotNullParameter(r16, "ktvCommonInject");     // Catch: Exception -> L46
            bb0.b.a = r16;     // Catch: Exception -> L46
        L45:
            return r11;
        L7:
            r3 = null;
            goto L9
        }

        @JvmStatic
        public static boolean i() {
            KtvContext r0 = g();
            Long r1 = null;
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.n<Long> r2 = r0.getKtvAddDressVersion();
            if (r2 == null) goto L7;
            Long r3 = (Long) r2.getValue();
        L8:
            if (r3 == null) goto L17;
            KtvContext r4 = g();
            if (r4 == null) goto L15;
            com.bytedance.live.datacontext.n<Long> r5 = r4.getKtvAddDressVersion();
            if (r5 == null) goto L15;
            r1 = (Long) r5.getValue();
        L15:
            if ((!Intrinsics.areEqual(r1, (Long) com.bytedance.android.livesdk.sharedpref.c.i.getValue())) == false) goto L17;
            return true;
        L17:
            return false;
        L7:
            r3 = null;
            goto L8
        }

        @JvmStatic
        public static boolean l() {
            KtvContext r0 = g();
            if (r0 == null) goto L8;
            com.bytedance.live.datacontext.m<Integer> r1 = r0.getCurKtvMode();
            if (r1 == null) goto L8;
            if (((Number) r1.getValue()).intValue() != 3) goto L8;
        L16:
            return true;
        L8:
            KtvComponentContext r2 = KtvComponentContext.Companion.getContext();
            if (r2 == null) goto L13;
            com.bytedance.live.datacontext.n<Boolean> r3 = r2.isAudienceEnableSing();
            if (r3 == null) goto L13;
            Boolean r4 = (Boolean) r3.getValue();
        L15:
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == true) goto L16;
            return false;
        L13:
            r4 = null;
            goto L15
        }

        @JvmStatic
        public static boolean m() {
            com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
            if (r0 == null) goto L11;
            com.bytedance.live.datacontext.m r1 = r0.getRoom();
            if (r1 == null) goto L11;
            IRoom r2 = (IRoom) r1.getValue();
            if (r2 == null) goto L11;
            if (r2.isLiveTypeAudio() == true) goto L11;
            return true;
        L11:
            return false;
        }

        @JvmStatic
        public static void a(int r3) {
            int r0 = e();
            int r4 = r3 | r0;
            if (r4 == r0) goto L10;
            String r1 = bb0.b.b();
            ALogger.i(r1, ("addKtvState_change, curValue:" + r0 + ",newValue:" + r4) + ", invoke class :" + a.class.getSimpleName());
            KtvContext r2 = g();
            if (r2 == null) goto L11;
            com.bytedance.live.datacontext.m<Integer> r5 = r2.getKtvAllState();
            if (r5 == null) goto L12;
            r5.setValue(Integer.valueOf(r4));
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public static boolean c(int r1) {
            return v.a(e(), r1);
        }

        @JvmStatic
        public static long f(DataCenter r6) {
            com.bytedance.live.datacontext.m r7 = com.bytedance.android.live.liveinteract.api.utils.m.n(r6, null, 2).getSeiTimePair();
            if (r7 == null) goto L9;
            z0 r8 = (z0) r7.getValue();
            if (r8 == null) goto L11;
            long r0 = System.currentTimeMillis();
            return r8.a + (r0 - r8.b);
        L11:
            return 0;
        L9:
            return 0;
        }

        @JvmStatic
        public static void n(int r4) {
            int r0 = e();
            int r1 = v.b(r0, r4);
            if (r1 == r0) goto L10;
            String r5 = "removeKtvState_change, curValue:" + r0 + ",newValue:" + r1 + ",state:" + r4;
            ALogger.i(bb0.b.b(), r5 + ", invoke class :" + a.class.getSimpleName());
            KtvContext r6 = g();
            if (r6 == null) goto L11;
            com.bytedance.live.datacontext.m<Integer> r7 = r6.getKtvAllState();
            if (r7 == null) goto L12;
            r7.setValue(Integer.valueOf(r1));
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public static void b(long r5, String r7) {
            Intrinsics.checkNotNullParameter(r7, "title");
            KtvContext r0 = g();
            if (r0 == null) goto L16;
            List<String> r1 = r0.getRecentMusicInfo();
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.size() > ((Number) vm2.h.n3.getValue(null, vm2.h.a[220(0xdc, float:3.08E-43)])).intValue()) goto L9;
            boolean r2 = true;
        L10:
            if (r2 == true) goto L13;
            r1 = null;
        L13:
            if (r1 == null) goto L18;
            r1.add("(" + r5 + ", " + r7 + ')');
            return;
        L18:
            return;
        L9:
            r2 = false;
            goto L10
        }
    }

    public static final class b implements com.bytedance.android.livesdk.ktvimpl.base.viewmodel.a {
        public final /* synthetic */ sb0.b a;

        public b(sb0.b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.a
        public final boolean a(w r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.b().a();
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r0 = r3.b;
            if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L5;
        L7:
            return false;
        L5:
            if ((!Intrinsics.areEqual(r0.a(), this.a.f())) == false) goto L7;
            ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r3.b).getClass();
            return true;
        }
    }

    @JvmStatic
    public static final void addKtvState(int r1) {
        Companion.getClass();
        a.a(r1);
    }

    @JvmStatic
    public static final void addRecentMusicInfo(long r1, String r3) {
        Companion.getClass();
        a.b(r1, r3);
    }

    @JvmStatic
    public static final boolean containsState(int r1) {
        Companion.getClass();
        return a.c(r1);
    }

    @JvmStatic
    public static final boolean currentUserIsSinger() {
        Companion.getClass();
        return a.d();
    }

    @JvmStatic
    public static final int getCurrentKtvState() {
        Companion.getClass();
        return a.e();
    }

    @JvmStatic
    public static final long getCurrentPlayTimeInMillisecond(DataCenter r2) {
        Companion.getClass();
        return a.f(r2);
    }

    private final com.bytedance.live.datacontext.m<Boolean> getCurrentUserIsSinger() {
        return (com.bytedance.live.datacontext.m) this.currentUserIsSinger$delegate.a(this, $$delegatedProperties[7]);
    }

    private final com.bytedance.live.datacontext.n<Long> getDurationSelected() {
        return (com.bytedance.live.datacontext.n) this.durationSelected$delegate.a(this, $$delegatedProperties[40]);
    }

    @JvmStatic
    public static final KtvContext getKtvContext() {
        Companion.getClass();
        return a.g();
    }

    @JvmStatic
    public static final String getRecentMusicInfoStr() {
        Companion.getClass();
        return a.h();
    }

    private final com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.sei.a> getSingEndedFeedbackSei() {
        return (com.bytedance.live.datacontext.n) this.singEndedFeedbackSei$delegate.a(this, $$delegatedProperties[50]);
    }

    private final com.bytedance.live.datacontext.n<Long> getTargetScoreSelected() {
        return (com.bytedance.live.datacontext.n) this.targetScoreSelected$delegate.a(this, $$delegatedProperties[39]);
    }

    @JvmStatic
    public static final boolean hasNewKtvDress() {
        Companion.getClass();
        return a.i();
    }

    @JvmStatic
    public static final boolean inAudioChorusKtv() {
        Companion.getClass();
        return a.j();
    }

    @JvmStatic
    public static final boolean inAudioKtv() {
        Companion.getClass();
        return a.k();
    }

    @JvmStatic
    public static final boolean inMultipleKtv() {
        Companion.getClass();
        return a.l();
    }

    @JvmStatic
    public static final boolean inVideoRoom() {
        Companion.getClass();
        return a.m();
    }

    @JvmStatic
    public static final void removeKtvState(int r1) {
        Companion.getClass();
        a.n(r1);
    }

    public final com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.util.h> getBigEventHelper() {
        return (com.bytedance.live.datacontext.n) this.bigEventHelper$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.k<com.bytedance.android.live.ktv.common.model.bean.a> getCountDownEvent() {
        return (com.bytedance.live.datacontext.k) this.countDownEvent$delegate.a(this, $$delegatedProperties[34]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getCurIsMultipleKtvMode() {
        return (com.bytedance.live.datacontext.m) this.curIsMultipleKtvMode$delegate.a(this, $$delegatedProperties[29]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getCurKtvMode() {
        return (com.bytedance.live.datacontext.m) this.curKtvMode$delegate.a(this, $$delegatedProperties[28]);
    }

    public final com.bytedance.live.datacontext.n<String> getCurrentMvVid() {
        return (com.bytedance.live.datacontext.n) this.currentMvVid$delegate.a(this, $$delegatedProperties[27]);
    }

    public final com.bytedance.live.datacontext.n<KtvMusic> getCurrentSongOfSelf() {
        return (com.bytedance.live.datacontext.n) this.currentSongOfSelf$delegate.a(this, $$delegatedProperties[9]);
    }

    public final com.bytedance.live.datacontext.j<sb0.b> getDataEntity() {
        return (com.bytedance.live.datacontext.j) this.dataEntity$delegate.a(this, $$delegatedProperties[24]);
    }

    public final com.bytedance.live.datacontext.n<List<Boolean>> getEachKtvTabHasMore() {
        return (com.bytedance.live.datacontext.n) this.eachKtvTabHasMore$delegate.a(this, $$delegatedProperties[45]);
    }

    public final com.bytedance.live.datacontext.k<Object> getEchoStateCheckEvent() {
        return (com.bytedance.live.datacontext.k) this.echoStateCheckEvent$delegate.a(this, $$delegatedProperties[31]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getEnableKtvAtmosphere() {
        return (com.bytedance.live.datacontext.m) this.enableKtvAtmosphere$delegate.a(this, $$delegatedProperties[35]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getHasBgm() {
        return (com.bytedance.live.datacontext.m) this.hasBgm$delegate.a(this, $$delegatedProperties[8]);
    }

    public final com.bytedance.live.datacontext.n<Long> getKtvAddDressVersion() {
        return (com.bytedance.live.datacontext.n) this.ktvAddDressVersion$delegate.a(this, $$delegatedProperties[44]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getKtvAllState() {
        return (com.bytedance.live.datacontext.m) this.ktvAllState$delegate.a(this, $$delegatedProperties[18]);
    }

    public final com.bytedance.live.datacontext.n<Integer> getKtvCardViewSizeChanged() {
        return (com.bytedance.live.datacontext.n) this.ktvCardViewSizeChanged$delegate.a(this, $$delegatedProperties[20]);
    }

    public final com.bytedance.live.datacontext.n<c0> getKtvChallengeSettingPanelData() {
        return (com.bytedance.live.datacontext.n) this.ktvChallengeSettingPanelData$delegate.a(this, $$delegatedProperties[37]);
    }

    public final com.bytedance.live.datacontext.n<x> getKtvComponentCmdForAnchor() {
        return (com.bytedance.live.datacontext.n) this.ktvComponentCmdForAnchor$delegate.a(this, $$delegatedProperties[51]);
    }

    public final com.bytedance.live.datacontext.k<z> getKtvComponentSingerUserIdChangedEvent() {
        return (com.bytedance.live.datacontext.k) this.ktvComponentSingerUserIdChangedEvent$delegate.a(this, $$delegatedProperties[13]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getKtvComponentStatus() {
        return (com.bytedance.live.datacontext.m) this.ktvComponentStatus$delegate.a(this, $$delegatedProperties[14]);
    }

    public final com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.ktvimpl.base.util.i> getKtvContainerPositionUpdateEvent() {
        return (com.bytedance.live.datacontext.k) this.ktvContainerPositionUpdateEvent$delegate.a(this, $$delegatedProperties[48]);
    }

    public final com.bytedance.live.datacontext.n<i> getKtvCoreController() {
        return (com.bytedance.live.datacontext.n) this.ktvCoreController$delegate.a(this, $$delegatedProperties[10]);
    }

    public final com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> getKtvCoreViewModel() {
        return (com.bytedance.live.datacontext.n) this.ktvCoreViewModel$delegate.a(this, $$delegatedProperties[32]);
    }

    public final com.bytedance.live.datacontext.n<OrderInfo> getKtvCurrentSingOrderInfo() {
        return (com.bytedance.live.datacontext.n) this.ktvCurrentSingOrderInfo$delegate.a(this, $$delegatedProperties[15]);
    }

    public final com.bytedance.live.datacontext.m<y> getKtvRoomInfo() {
        return (com.bytedance.live.datacontext.m) this.ktvRoomInfo$delegate.a(this, $$delegatedProperties[26]);
    }

    public final com.bytedance.live.datacontext.k<Object> getKtvRoomLabelChangeEvent() {
        return (com.bytedance.live.datacontext.k) this.ktvRoomLabelChangeEvent$delegate.a(this, $$delegatedProperties[11]);
    }

    public final com.bytedance.live.datacontext.n<oe2.d> getKtvRoomModel() {
        return (com.bytedance.live.datacontext.n) this.ktvRoomModel$delegate.a(this, $$delegatedProperties[23]);
    }

    public final com.bytedance.live.datacontext.n<oe2.b> getKtvRoomProvider() {
        return (com.bytedance.live.datacontext.n) this.ktvRoomProvider$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.ktvimpl.base.util.e> getKtvRoomStrategy() {
        return (com.bytedance.live.datacontext.m) this.ktvRoomStrategy$delegate.a(this, $$delegatedProperties[19]);
    }

    public final com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> getKtvSingerViewModel() {
        return (com.bytedance.live.datacontext.n) this.ktvSingerViewModel$delegate.a(this, $$delegatedProperties[33]);
    }

    public final com.bytedance.live.datacontext.k<Object> getKtvStageIdleEvent() {
        return (com.bytedance.live.datacontext.k) this.ktvStageIdleEvent$delegate.a(this, $$delegatedProperties[16]);
    }

    public final com.bytedance.live.datacontext.k<Object> getKtvStagePreparedEvent() {
        return (com.bytedance.live.datacontext.k) this.ktvStagePreparedEvent$delegate.a(this, $$delegatedProperties[17]);
    }

    public final com.bytedance.live.datacontext.k<Integer> getKtvStageReadyEvent() {
        return (com.bytedance.live.datacontext.k) this.ktvStageReadyEvent$delegate.a(this, $$delegatedProperties[21]);
    }

    public final com.bytedance.live.datacontext.n<List<o0>> getLabelList() {
        return (com.bytedance.live.datacontext.n) this.labelList$delegate.a(this, $$delegatedProperties[46]);
    }

    public final com.bytedance.live.datacontext.k<List<com.bytedance.android.livesdk.chatroom.interact.model.y>> getLinkMicSettingUpdate() {
        return (com.bytedance.live.datacontext.k) this.linkMicSettingUpdate$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.n<t> getLinkmicRealTimeChorusDress() {
        return (com.bytedance.live.datacontext.n) this.linkmicRealTimeChorusDress$delegate.a(this, $$delegatedProperties[43]);
    }

    public final com.bytedance.live.datacontext.n<MidiSkinDressInfo> getMidiSkinContext() {
        return (com.bytedance.live.datacontext.n) this.midiSkinContext$delegate.a(this, $$delegatedProperties[42]);
    }

    public final com.bytedance.live.datacontext.k<Long> getMoveSongToOtherRoomEvent() {
        return (com.bytedance.live.datacontext.k) this.moveSongToOtherRoomEvent$delegate.a(this, $$delegatedProperties[36]);
    }

    public final com.bytedance.live.datacontext.m<Map<String, com.bytedance.android.live.ktv.common.model.bean.f>> getMusicDownloadResourceMap() {
        return (com.bytedance.live.datacontext.m) this.musicDownloadResourceMap$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.k<kh> getOpenKtvEvent() {
        return (com.bytedance.live.datacontext.k) this.openKtvEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.k<od2.b> getOpenKtvRoomDialogEvent() {
        return (com.bytedance.live.datacontext.k) this.openKtvRoomDialogEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.ktvimpl.mv.opus.model.a> getOpenOpusPreViewDialog() {
        return (com.bytedance.live.datacontext.k) this.openOpusPreViewDialog$delegate.a(this, $$delegatedProperties[25]);
    }

    public final com.bytedance.live.datacontext.k<me2.b> getPrepareChallengeEvent() {
        return (com.bytedance.live.datacontext.k) this.prepareChallengeEvent$delegate.a(this, $$delegatedProperties[38]);
    }

    public final com.bytedance.live.datacontext.m<p> getRealTimeInfoModel() {
        return (com.bytedance.live.datacontext.m) this.realTimeInfoModel$delegate.a(this, $$delegatedProperties[12]);
    }

    public final com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.ktvimpl.base.sei.m> getSeiProcessor() {
        return (com.bytedance.live.datacontext.i) this.seiProcessor$delegate.a(this, $$delegatedProperties[22]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getSoundCardSelectedStatus() {
        return (com.bytedance.live.datacontext.m) this.soundCardSelectedStatus$delegate.a(this, $$delegatedProperties[49]);
    }

    public final com.bytedance.live.datacontext.n<d0> getStreamInfoSender() {
        return (com.bytedance.live.datacontext.n) this.streamInfoSender$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.m<Long> getVoiceKtvSwitchTime() {
        return (com.bytedance.live.datacontext.m) this.voiceKtvSwitchTime$delegate.a(this, $$delegatedProperties[47]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isKtvRoomContextInit() {
        return (com.bytedance.live.datacontext.m) this.isKtvRoomContextInit$delegate.a(this, $$delegatedProperties[41]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isPushingExternalVideo() {
        return (com.bytedance.live.datacontext.m) this.isPushingExternalVideo$delegate.a(this, $$delegatedProperties[30]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KtvContext.class, "openKtvEvent", "getOpenKtvEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "openKtvRoomDialogEvent", "getOpenKtvRoomDialogEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "musicDownloadResourceMap", "getMusicDownloadResourceMap()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvRoomProvider", "getKtvRoomProvider()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "streamInfoSender", "getStreamInfoSender()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "linkMicSettingUpdate", "getLinkMicSettingUpdate()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "bigEventHelper", "getBigEventHelper()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "currentUserIsSinger", "getCurrentUserIsSinger()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "hasBgm", "getHasBgm()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "currentSongOfSelf", "getCurrentSongOfSelf()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvCoreController", "getKtvCoreController()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvRoomLabelChangeEvent", "getKtvRoomLabelChangeEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "realTimeInfoModel", "getRealTimeInfoModel()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvComponentSingerUserIdChangedEvent", "getKtvComponentSingerUserIdChangedEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvComponentStatus", "getKtvComponentStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvCurrentSingOrderInfo", "getKtvCurrentSingOrderInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvStageIdleEvent", "getKtvStageIdleEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvStagePreparedEvent", "getKtvStagePreparedEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvAllState", "getKtvAllState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvRoomStrategy", "getKtvRoomStrategy()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvCardViewSizeChanged", "getKtvCardViewSizeChanged()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvStageReadyEvent", "getKtvStageReadyEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "seiProcessor", "getSeiProcessor()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvRoomModel", "getKtvRoomModel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "dataEntity", "getDataEntity()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "openOpusPreViewDialog", "getOpenOpusPreViewDialog()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvRoomInfo", "getKtvRoomInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "currentMvVid", "getCurrentMvVid()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "curKtvMode", "getCurKtvMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "curIsMultipleKtvMode", "getCurIsMultipleKtvMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "isPushingExternalVideo", "isPushingExternalVideo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "echoStateCheckEvent", "getEchoStateCheckEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvCoreViewModel", "getKtvCoreViewModel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvSingerViewModel", "getKtvSingerViewModel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "countDownEvent", "getCountDownEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "enableKtvAtmosphere", "getEnableKtvAtmosphere()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "moveSongToOtherRoomEvent", "getMoveSongToOtherRoomEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvChallengeSettingPanelData", "getKtvChallengeSettingPanelData()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "prepareChallengeEvent", "getPrepareChallengeEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "targetScoreSelected", "getTargetScoreSelected()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "durationSelected", "getDurationSelected()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "isKtvRoomContextInit", "isKtvRoomContextInit()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "midiSkinContext", "getMidiSkinContext()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "linkmicRealTimeChorusDress", "getLinkmicRealTimeChorusDress()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvAddDressVersion", "getKtvAddDressVersion()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "eachKtvTabHasMore", "getEachKtvTabHasMore()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "labelList", "getLabelList()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "voiceKtvSwitchTime", "getVoiceKtvSwitchTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvContainerPositionUpdateEvent", "getKtvContainerPositionUpdateEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "soundCardSelectedStatus", "getSoundCardSelectedStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "singEndedFeedbackSei", "getSingEndedFeedbackSei()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvContext.class, "ktvComponentCmdForAnchor", "getKtvComponentCmdForAnchor()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
        enableRoomStateSync = ((Boolean) vm2.h.i3.getValue(null, vm2.h.a[215(0xd7, float:3.01E-43)])).booleanValue();
    }

    @JvmStatic
    public static final boolean inKtvComponent() {
        Companion.getClass();
        return a.c(1);
    }

    @JvmStatic
    public static final boolean isVideoInteractOpen() {
        Companion.getClass();
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.j r1 = r0.getVideoTalkRoomSubScene();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 == null) goto L11;
        int r4 = r3.a;
    L12:
        com.bytedance.android.livesdk.chatroom.viewmodel.e.a.getClass();
        return com.bytedance.android.livesdk.chatroom.viewmodel.e.a.a.contains(Integer.valueOf(r4));
    L11:
        r4 = 0;
        goto L12
    }

    public final void clearKtvCoreAndSingerViewModel() {
        ALogger.i("coreVm-check", "clearKtvCoreAndSingerViewModel");
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) getKtvCoreViewModel().getValue();
        if (r0 == null) goto L5;
        r0.clearData();
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r1 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) getKtvSingerViewModel().getValue();
        if (r1 == null) goto L8;
        r1.clearData();
    L8:
        getKtvCoreViewModel().setValue(null);
        getKtvSingerViewModel().setValue(null);
    }

    public KtvContext() {
        this.giftReportParam = new HashMap();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h r0 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h(this);
        r0.b = true;
        Unit r1 = Unit.INSTANCE;
        this.lyricResourceManager = r0;
        this.openKtvEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.bizLcMager = new com.bytedance.android.live.ktv.common.util.e();
        this.statisticHelper = new com.bytedance.android.live.ktv.common.util.k();
        this.openKtvRoomDialogEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.musicDownloadResourceMap$delegate = com.bytedance.live.datacontext.q.d(this, new LinkedHashMap());
        this.ktvRoomProvider$delegate = com.bytedance.live.datacontext.q.c(this);
        this.streamInfoSender$delegate = com.bytedance.live.datacontext.q.c(this);
        this.linkMicSettingUpdate$delegate = com.bytedance.live.datacontext.e.b(this);
        this.realOpenStateData = new MutableLiveData();
        lb0.b r2 = new lb0.b();
        r2.a = 0.7f;
        this.ktvMvBackRound = r2;
        this.bigEventHelper$delegate = com.bytedance.live.datacontext.q.c(this);
        Boolean r3 = Boolean.FALSE;
        this.currentUserIsSinger$delegate = com.bytedance.live.datacontext.q.d(this, r3);
        this.hasBgm$delegate = com.bytedance.live.datacontext.q.d(this, r3);
        this.currentSongOfSelf$delegate = com.bytedance.live.datacontext.q.c(this);
        this.ktvCoreController$delegate = com.bytedance.live.datacontext.q.c(this);
        this.ktvRoomLabelChangeEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.realTimeInfoModel$delegate = com.bytedance.live.datacontext.q.d(this, new p(0));
        this.ktvComponentSingerUserIdChangedEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.ktvComponentStatus$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.ktvCurrentSingOrderInfo$delegate = com.bytedance.live.datacontext.q.c(this);
        this.ktvStageIdleEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.ktvStagePreparedEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.ktvAllState$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.ktvRoomStrategy$delegate = com.bytedance.live.datacontext.q.d(this, new com.bytedance.android.livesdk.ktvimpl.base.util.b());
        this.ktvCardViewSizeChanged$delegate = com.bytedance.live.datacontext.q.c(this);
        this.ktvStageReadyEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        com.bytedance.android.livesdk.ktvimpl.base.sei.l r4 = new com.bytedance.android.livesdk.ktvimpl.base.sei.l();
        r4.a("ktv_sei", com.bytedance.android.livesdk.ktvimpl.base.sei.k.class);
        r4.a("ktv_score_sei", com.bytedance.android.livesdk.ktvimpl.base.sei.g.class);
        r4.a("ktv_hot_info", com.bytedance.android.livesdk.ktvimpl.base.sei.n.class);
        r4.a("ktv_hot_sei", com.bytedance.android.livesdk.ktvimpl.base.sei.o.class);
        r4.a("ktv_midi_feedback_sei", com.bytedance.android.livesdk.ktvimpl.base.sei.h.class);
        r4.a("ktv_midi_sei", com.bytedance.android.livesdk.ktvimpl.base.sei.i.class);
        r4.a("ktv_chorus_midi", r.class);
        com.bytedance.android.livesdk.ktvimpl.base.sei.m r5 = new com.bytedance.android.livesdk.ktvimpl.base.sei.m(r4);
        r5.h = r5.g;
        this.seiProcessor$delegate = ConstantKt.a(this, r5, KtvContext$seiProcessor$4.INSTANCE);
        this.lyricStateRecordMap = new LongSparseArray();
        this.ktvRoomModel$delegate = com.bytedance.live.datacontext.q.c(this);
        this.dataEntity$delegate = ConstantKt.c(this);
        this.recentMusicInfo = new ArrayList();
        this.openOpusPreViewDialog$delegate = com.bytedance.live.datacontext.e.b(this);
        this.ktvRoomInfo$delegate = com.bytedance.live.datacontext.q.d(this, y.b.a);
        this.currentMvVid$delegate = com.bytedance.live.datacontext.q.c(this);
        this.curKtvMode$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.curIsMultipleKtvMode$delegate = com.bytedance.live.datacontext.q.d(this, r3);
        this.isPushingExternalVideo$delegate = com.bytedance.live.datacontext.q.d(this, r3);
        this.echoStateCheckEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.lyricsChangeLiveData = new NextLiveData();
        this.ktvCoreViewModel$delegate = com.bytedance.live.datacontext.q.c(this);
        this.ktvSingerViewModel$delegate = com.bytedance.live.datacontext.q.c(this);
        this.countDownEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.enableKtvAtmosphere$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.TRUE);
        this.moveSongToOtherRoomEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.ktvChallengeSettingPanelData$delegate = com.bytedance.live.datacontext.q.c(this);
        this.prepareChallengeEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.targetScoreSelected$delegate = com.bytedance.live.datacontext.q.c(this);
        this.durationSelected$delegate = com.bytedance.live.datacontext.q.c(this);
        this.kWidgetManager = new com.bytedance.android.livesdk.ktvimpl.base.frame.b();
        this.isKtvRoomContextInit$delegate = com.bytedance.live.datacontext.q.d(this, r3);
        this.midiSkinContext$delegate = com.bytedance.live.datacontext.q.c(this);
        this.linkmicRealTimeChorusDress$delegate = com.bytedance.live.datacontext.q.c(this);
        this.ktvAddDressVersion$delegate = com.bytedance.live.datacontext.q.c(this);
        this.eachKtvTabHasMore$delegate = com.bytedance.live.datacontext.q.c(this);
        this.labelList$delegate = com.bytedance.live.datacontext.q.c(this);
        this.voiceKtvSwitchTime$delegate = com.bytedance.live.datacontext.q.d(this, 0L);
        this.ktvContainerPositionUpdateEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.soundCardSelectedStatus$delegate = com.bytedance.live.datacontext.q.d(this, r3);
        this.singEndedFeedbackSei$delegate = com.bytedance.live.datacontext.q.c(this);
        this.ktvComponentCmdForAnchor$delegate = com.bytedance.live.datacontext.q.c(this);
    }

    public final boolean isCurrentUserIsSinger() {
        return ((Boolean) getCurrentUserIsSinger().getValue()).booleanValue();
    }

    public final boolean isKtvMode() {
        if (v.a(((Number) getKtvAllState().getValue()).intValue(), 8) == true) goto L16;
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r0 == null) goto L15;
        com.bytedance.live.datacontext.j r1 = r0.s();
        if (r1 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = r2.t();
        if (r3 == null) goto L15;
        if (r3.a == 9) goto L16;
    L15:
        return false;
    L16:
        return true;
    }

    public static final /* synthetic */ boolean access$getEnableRoomStateSync$cp() {
        return enableRoomStateSync;
    }

    public final com.bytedance.android.live.ktv.common.util.e getBizLcMager() {
        return this.bizLcMager;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final Disposable getDataContextDisposable() {
        return this.dataContextDisposable;
    }

    public final HashMap<String, String> getGiftReportParam() {
        return this.giftReportParam;
    }

    public final com.bytedance.android.livesdk.ktvimpl.base.frame.b getKWidgetManager() {
        return this.kWidgetManager;
    }

    public final float getKtvInteractRegionOffset() {
        return this.ktvInteractRegionOffset;
    }

    public final lb0.b getKtvMvBackRound() {
        return this.ktvMvBackRound;
    }

    public final com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h getLyricResourceManager() {
        return this.lyricResourceManager;
    }

    public final LongSparseArray<com.bytedance.android.livesdk.ktvimpl.base.util.p> getLyricStateRecordMap() {
        return this.lyricStateRecordMap;
    }

    public final NextLiveData<ub0.a> getLyricsChangeLiveData() {
        return this.lyricsChangeLiveData;
    }

    public final com.bytedance.android.livesdk.ktvapi.model.mv.g getOpusMvService() {
        return this.opusMvService;
    }

    public final MutableLiveData<Boolean> getRealOpenStateData() {
        return this.realOpenStateData;
    }

    public final List<String> getRecentMusicInfo() {
        return this.recentMusicInfo;
    }

    public final com.bytedance.android.live.ktv.common.util.k getStatisticHelper() {
        return this.statisticHelper;
    }

    public final Boolean isEnterKtvDirectly() {
        return this.isEnterKtvDirectly;
    }

    public static final /* synthetic */ com.bytedance.live.datacontext.m access$getCurrentUserIsSinger$p(KtvContext r0) {
        return r0.getCurrentUserIsSinger();
    }

    public final com.bytedance.android.livesdk.ktvimpl.base.util.p getLyricStateRecord(long r2) {
        return this.lyricStateRecordMap.get(r2);
    }

    public final Disposable observeSingEndedFeedbackSei(Consumer<sh6.b<com.bytedance.android.livesdk.ktvimpl.base.sei.a>> r2) {
        Intrinsics.checkNotNullParameter(r2, "consumer");
        return getSingEndedFeedbackSei().a().subscribe(r2);
    }

    public final void setBizLcMager(com.bytedance.android.live.ktv.common.util.e r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bizLcMager = r2;
    }

    public final void setDataCenter(DataCenter r1) {
        this.dataCenter = r1;
    }

    public final void setDataContextDisposable(Disposable r1) {
        this.dataContextDisposable = r1;
    }

    public final void setEnterKtvDirectly(Boolean r1) {
        this.isEnterKtvDirectly = r1;
    }

    public final void setKtvInteractRegionOffset(float r1) {
        this.ktvInteractRegionOffset = r1;
    }

    public final void setOpusMvService(com.bytedance.android.livesdk.ktvapi.model.mv.g r1) {
        this.opusMvService = r1;
    }

    public final void setStatisticHelper(com.bytedance.android.live.ktv.common.util.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.statisticHelper = r2;
    }

    public final void setTargetDurationSelected(Long r2) {
        getDurationSelected().setValue(r2);
    }

    public final void setTargetScoreSelected(Long r2) {
        getTargetScoreSelected().setValue(r2);
    }

    public final void updateCurrentUserIsSinger(boolean r2) {
        getCurrentUserIsSinger().setValue(Boolean.valueOf(r2));
    }

    public final void updateKtvAllStateValue(boolean r3) {
        ALogger.i("KtvUtils", "updateKtvAllStateValue:" + r3);
        int r0 = ((Number) getKtvAllState().getValue()).intValue();
        if (r3 == false) goto L5;
        int r4 = v.b(r0, 1) | 8;
    L7:
        if (((Number) getKtvAllState().getValue()).intValue() == r4) goto L10;
        getKtvAllState().setValue(Integer.valueOf(r4));
        return;
    L10:
        return;
    L5:
        r4 = v.b(r0, 8);
        goto L7
    }

    public final void updateSingEndedFeedback(com.bytedance.android.livesdk.ktvimpl.base.sei.a r6) {
        Intrinsics.checkNotNullParameter(r6, "feedbackResult");
        if ((r6 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.n) == false) goto L8;
        StringBuilder r0 = new StringBuilder("updateSingEndedFeedback， hot: ");
        com.bytedance.android.livesdk.ktvimpl.base.sei.n r1 = (com.bytedance.android.livesdk.ktvimpl.base.sei.n) r6;
        r0.append(r1.c());
        String r2 = r0.toString();
        ALogger.i(bb0.b.b(), r2 + ", invoke class :KtvContext");
        if (r1.c() <= 0) goto L11;
        getSingEndedFeedbackSei().setValue(r6);
        return;
    L11:
        return;
    L8:
        if ((r6 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.h) == false) goto L13;
        ALogger.i("midi-check", "sendMidiFeedbackSei");
        getSingEndedFeedbackSei().setValue(r6);
        return;
    }

    public final void initKtvCoreAndSingerViewModel(oe2.b r3, sb0.b r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "ktvRoomProvider");
        Intrinsics.checkNotNullParameter(r4, "dataEntityProxy");
        if (r5 == false) goto L5;
        Companion.getClass();
        BaseCoreViewModel r6 = new BaseCoreViewModel(r3, r4, a.g());
    L6:
        r6.setSeiHandleInterceptor(new b(r4));
        getKtvCoreViewModel().setValue(r6);
        getKtvSingerViewModel().setValue(new KtvSingerViewModel(r3, r4, r6));
        getDataEntity().d(r4);
        return;
    L5:
        Companion.getClass();
        r6 = new KComponentCoreViewModel(r3, r4, a.g());
        goto L6
    }

    public final Disposable observerCurrentUserIsSinger(LifecycleOwner r2, boolean r3, Consumer<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (r2 == null) goto L7;
        if (r3 == false) goto L12;
        return ((ObservableSubscribeProxy) RxUtilKt.h(getCurrentUserIsSinger().a()).as(AutoDispose.bind(r2))).subscribe(r4);
    L12:
        return ((ObservableSubscribeProxy) getCurrentUserIsSinger().a().as(AutoDispose.bind(r2))).subscribe(r4);
    L7:
        if (r3 == false) goto L10;
        return RxUtilKt.h(getCurrentUserIsSinger().a()).subscribe(r4);
    L10:
        return getCurrentUserIsSinger().a().subscribe(r4);
    }

    public static /* synthetic */ void initKtvCoreAndSingerViewModel$default(KtvContext r0, oe2.b r1, sb0.b r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.initKtvCoreAndSingerViewModel(r1, r2, r3);
    }

    public static /* synthetic */ Disposable observerCurrentUserIsSinger$default(KtvContext r0, LifecycleOwner r1, boolean r2, Consumer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = false;
    L9:
        return r0.observerCurrentUserIsSinger(r1, r2, r3);
    }
}
