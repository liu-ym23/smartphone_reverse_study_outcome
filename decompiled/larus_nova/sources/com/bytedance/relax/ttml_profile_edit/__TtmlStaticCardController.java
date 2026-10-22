package com.bytedance.relax.ttml_profile_edit;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.relax.ttmlstatic.CardSession;
import com.bytedance.relax.ttmlstatic.b;
import com.bytedance.relax.ttmlstatic.d;
import com.bytedance.relax.ttmlstatic.g;
import com.bytedance.relax.ttmlstatic.h;
import com.bytedance.rts.kmp.foundation.i;
import com.bytedance.rts.kmp.foundation.m;
import com.bytedance.rts.kmp.foundation.r;
import com.lynx.tasm.event.LynxTouchEvent;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import r87.a0;
import r87.a1;
import r87.b0;
import r87.b1;
import r87.c0;
import r87.c1;
import r87.d0;
import r87.d1;
import r87.e;
import r87.e0;
import r87.e1;
import r87.f;
import r87.f0;
import r87.f1;
import r87.g0;
import r87.g1;
import r87.h0;
import r87.i0;
import r87.j0;
import r87.k;
import r87.k0;
import r87.l;
import r87.l0;
import r87.m0;
import r87.n;
import r87.n0;
import r87.o;
import r87.o0;
import r87.p;
import r87.p0;
import r87.q;
import r87.q0;
import r87.r0;
import r87.s;
import r87.s0;
import r87.t;
import r87.t0;
import r87.u;
import r87.u0;
import r87.v;
import r87.v0;
import r87.w;
import r87.w0;
import r87.x;
import r87.x0;
import r87.y;
import r87.y0;
import r87.z;
import r87.z0;
import s87.j;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0003\b\u0091\u0001\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\bV\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010¼\u0001\u001a\u00020\u000b2\u0017\u0010½\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u000b0/j\b\u0012\u0004\u0012\u00020\u000b`02\u0007\u0010¾\u0001\u001a\u00020\u001dH\u0016J\u0012\u0010¿\u0001\u001a\u00020\u00052\u0007\u0010À\u0001\u001a\u00020\u0001H\u0016J,\u0010Á\u0001\u001a\u00030Â\u00012\u0007\u0010Ã\u0001\u001a\u00020\u00012\u0017\u0010Ä\u0001\u001a\u0012\u0012\u0004\u0012\u00020#0/j\b\u0012\u0004\u0012\u00020#`0H\u0016J#\u0010Å\u0001\u001a\u00030Â\u00012\u0017\u0010Ä\u0001\u001a\u0012\u0012\u0004\u0012\u00020#0/j\b\u0012\u0004\u0012\u00020#`0H\u0016J-\u0010Æ\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0017\u0010Ä\u0001\u001a\u0012\u0012\u0004\u0012\u00020#0/j\b\u0012\u0004\u0012\u00020#`0H\u0016J:\u0010Ê\u0001\u001a\u00030Â\u00012\b\u0010Ä\u0001\u001a\u00030Â\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000b2\b\u0010Ì\u0001\u001a\u00030Â\u00012\b\u0010Í\u0001\u001a\u00030Â\u00012\u0007\u0010Î\u0001\u001a\u00020\u001dH\u0016J\u0013\u0010Ï\u0001\u001a\u00020\u000b2\b\u0010Ð\u0001\u001a\u00030Â\u0001H\u0016J\u0013\u0010Ñ\u0001\u001a\u00020\u000b2\b\u0010Ð\u0001\u001a\u00030Â\u0001H\u0016J\u0013\u0010Ò\u0001\u001a\u00020\u000b2\b\u0010Ð\u0001\u001a\u00030Â\u0001H\u0016J\u0013\u0010Ó\u0001\u001a\u00020\u000b2\b\u0010Ð\u0001\u001a\u00030Â\u0001H\u0016J\u001d\u0010Ô\u0001\u001a\u00020\u000b2\b\u0010Ð\u0001\u001a\u00030Â\u00012\b\u0010Ì\u0001\u001a\u00030Â\u0001H\u0016J\u0013\u0010Õ\u0001\u001a\u00020\u000b2\b\u0010Ð\u0001\u001a\u00030Â\u0001H\u0016J%\u0010Ö\u0001\u001a\u00020\u000b2\b\u0010Ì\u0001\u001a\u00030Â\u00012\u0007\u0010×\u0001\u001a\u00020\u000b2\u0007\u0010Ø\u0001\u001a\u00020\u000bH\u0016J\u0013\u0010Ù\u0001\u001a\u00020#2\b\u0010Ú\u0001\u001a\u00030Â\u0001H\u0016J'\u0010Û\u0001\u001a\u00030Â\u00012\u0007\u0010Ë\u0001\u001a\u00020\u000b2\b\u0010Ü\u0001\u001a\u00030Â\u00012\b\u0010Ì\u0001\u001a\u00030Â\u0001H\u0016J\u001d\u0010Ý\u0001\u001a\u00030Â\u00012\b\u0010Þ\u0001\u001a\u00030Â\u00012\u0007\u0010ß\u0001\u001a\u00020\u000bH\u0016J0\u0010à\u0001\u001a\u00030Â\u00012\u0007\u0010Ø\u0001\u001a\u00020\u000b2\b\u0010Ü\u0001\u001a\u00030Â\u00012\b\u0010Ì\u0001\u001a\u00030Â\u00012\u0007\u0010á\u0001\u001a\u00020\u001dH\u0016J\u0013\u0010â\u0001\u001a\u00030Â\u00012\u0007\u0010á\u0001\u001a\u00020\u001dH\u0016J%\u0010ã\u0001\u001a\u00020\u000b2\u0007\u0010á\u0001\u001a\u00020\u001d2\u0007\u0010ä\u0001\u001a\u00020\u000b2\b\u0010Ð\u0001\u001a\u00030Â\u0001H\u0016J\u0013\u0010å\u0001\u001a\u00020\u000b2\b\u0010Ð\u0001\u001a\u00030Â\u0001H\u0016J\u0014\u0010æ\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u0001H\u0016J\u0014\u0010ç\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u0001H\u0016J/\u0010è\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010é\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J/\u0010ì\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010í\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J/\u0010î\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010í\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J0\u0010ï\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010ð\u0001\u001a\u00020\u000b2\b\u0010ñ\u0001\u001a\u00030Â\u00012\u0007\u0010ò\u0001\u001a\u00020\u000bH\u0016J/\u0010ó\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010é\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J/\u0010ô\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010í\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J9\u0010õ\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010ö\u0001\u001a\u00020\u000b2\b\u0010÷\u0001\u001a\u00030Â\u00012\u0007\u0010ø\u0001\u001a\u00020\u000b2\u0007\u0010ù\u0001\u001a\u00020\u000bH\u0016J/\u0010ú\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010é\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J&\u0010û\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010ü\u0001\u001a\u00020\u000b2\u0007\u0010ý\u0001\u001a\u00020\u000bH\u0016J/\u0010þ\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010é\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J\u001e\u0010ÿ\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\b\u0010\u0080\u0002\u001a\u00030Â\u0001H\u0016J/\u0010\u0081\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010í\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J\u001e\u0010\u0082\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\b\u0010\u0083\u0002\u001a\u00030Â\u0001H\u0016J/\u0010\u0084\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010í\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J\u001e\u0010\u0085\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\b\u0010\u0086\u0002\u001a\u00030Â\u0001H\u0016J/\u0010\u0087\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010í\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J\u001e\u0010\u0088\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\b\u0010\u0089\u0002\u001a\u00030Â\u0001H\u0016J/\u0010\u008a\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010í\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J0\u0010\u008b\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010\u008c\u0002\u001a\u00020\u000b2\b\u0010\u008d\u0002\u001a\u00030Â\u00012\u0007\u0010\u008e\u0002\u001a\u00020\u000bH\u0016J/\u0010\u008f\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010í\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J'\u0010\u0090\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010\u0091\u0002\u001a\u00020\u000b2\b\u0010\u0092\u0002\u001a\u00030Â\u0001H\u0016J/\u0010\u0093\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010í\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J'\u0010\u0094\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\b\u0010\u0095\u0002\u001a\u00030Â\u00012\u0007\u0010\u0096\u0002\u001a\u00020\u000bH\u0016J'\u0010\u0097\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\b\u0010\u0098\u0002\u001a\u00030Â\u00012\u0007\u0010\u0099\u0002\u001a\u00020\u000bH\u0016J/\u0010\u009a\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0019\u0010í\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010ê\u0001j\u0003`ë\u0001H\u0016J\u0014\u0010\u009b\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u0001H\u0016J\u001e\u0010\u009c\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\b\u0010\u009d\u0002\u001a\u00030Â\u0001H\u0016J/\u0010\u009e\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010\u009f\u0002\u001a\u00020\u000b2\u0007\u0010 \u0002\u001a\u00020\u000b2\u0007\u0010¡\u0002\u001a\u00020\u000bH\u0016J&\u0010¢\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010£\u0002\u001a\u00020\u000b2\u0007\u0010¤\u0002\u001a\u00020\u000bH\u0016J&\u0010¥\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010¦\u0002\u001a\u00020\u001d2\u0007\u0010§\u0002\u001a\u00020\u000bH\u0016J&\u0010¨\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010©\u0002\u001a\u00020\u001d2\u0007\u0010ª\u0002\u001a\u00020\u000bH\u0016J&\u0010«\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010¬\u0002\u001a\u00020\u001d2\u0007\u0010\u00ad\u0002\u001a\u00020\u000bH\u0016J\u001d\u0010®\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010 \u0002\u001a\u00020\u000bH\u0016J\u001d\u0010¯\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010°\u0002\u001a\u00020\u001dH\u0016J\u001d\u0010±\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010²\u0002\u001a\u00020\u001dH\u0016J/\u0010³\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010´\u0002\u001a\u00020\u00012\u0007\u0010µ\u0002\u001a\u00020\u000b2\u0007\u0010Ø\u0001\u001a\u00020\u000bH\u0016J'\u0010¶\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\b\u0010·\u0002\u001a\u00030Â\u00012\u0007\u0010¸\u0002\u001a\u00020\u000bH\u0016J&\u0010¹\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010´\u0002\u001a\u00020\u00012\u0007\u0010µ\u0002\u001a\u00020\u000bH\u0016J&\u0010º\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010»\u0002\u001a\u00020\u001d2\u0007\u0010é\u0001\u001a\u00020\u0001H\u0016J\u001d\u0010¼\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010À\u0001\u001a\u00020\u0001H\u0016J&\u0010½\u0002\u001a\u00030Â\u00012\b\u0010È\u0001\u001a\u00030É\u00012\u0007\u0010À\u0001\u001a\u00020\u00012\u0007\u0010¾\u0002\u001a\u00020\u0001H\u0016J\u0014\u0010¿\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u0001H\u0016J\u0014\u0010À\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u0001H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001a\u0010+\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR*\u0010.\u001a\u0012\u0012\u0004\u0012\u00020#0/j\b\u0012\u0004\u0012\u00020#`0X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010%\"\u0004\b7\u0010'R\u001a\u00108\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010%\"\u0004\b:\u0010'R\u001a\u0010;\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010%\"\u0004\b=\u0010'R\u001a\u0010>\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010%\"\u0004\b@\u0010'R\u001a\u0010A\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010%\"\u0004\bC\u0010'R\u001a\u0010D\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010%\"\u0004\bF\u0010'R\u001a\u0010G\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010%\"\u0004\bI\u0010'R\u001a\u0010J\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010%\"\u0004\bL\u0010'R\u001a\u0010M\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010%\"\u0004\bO\u0010'R\u001a\u0010P\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010%\"\u0004\bR\u0010'R\u001a\u0010S\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010%\"\u0004\bU\u0010'R\u001a\u0010V\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010%\"\u0004\bX\u0010'R\u001a\u0010Y\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010%\"\u0004\b[\u0010'R\u001a\u0010\\\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010%\"\u0004\b^\u0010'R\u001a\u0010_\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010%\"\u0004\ba\u0010'R\u001a\u0010b\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010%\"\u0004\bd\u0010'R\u001a\u0010e\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010%\"\u0004\bg\u0010'R\u001a\u0010h\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010%\"\u0004\bj\u0010'R\u001a\u0010k\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010%\"\u0004\bm\u0010'R\u001a\u0010n\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010%\"\u0004\bp\u0010'R\u001a\u0010q\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010%\"\u0004\bs\u0010'R\u001a\u0010t\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010%\"\u0004\bv\u0010'R\u001a\u0010w\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010%\"\u0004\by\u0010'R\u001a\u0010z\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010%\"\u0004\b|\u0010'R\u001a\u0010}\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010%\"\u0004\b\u007f\u0010'R\u001d\u0010\u0080\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010%\"\u0005\b\u0082\u0001\u0010'R\u001d\u0010\u0083\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010%\"\u0005\b\u0085\u0001\u0010'R\u001d\u0010\u0086\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010%\"\u0005\b\u0088\u0001\u0010'R\u001d\u0010\u0089\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010%\"\u0005\b\u008b\u0001\u0010'R\u001d\u0010\u008c\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010%\"\u0005\b\u008e\u0001\u0010'R\u001d\u0010\u008f\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010%\"\u0005\b\u0091\u0001\u0010'R\u001d\u0010\u0092\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010%\"\u0005\b\u0094\u0001\u0010'R\u001d\u0010\u0095\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010%\"\u0005\b\u0097\u0001\u0010'R\u001d\u0010\u0098\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010%\"\u0005\b\u009a\u0001\u0010'R\u001d\u0010\u009b\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010%\"\u0005\b\u009d\u0001\u0010'R\u001d\u0010\u009e\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010%\"\u0005\b \u0001\u0010'R\u001d\u0010¡\u0001\u001a\u00020\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u001f\"\u0005\b£\u0001\u0010!R\u001d\u0010¤\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010%\"\u0005\b¦\u0001\u0010'R\u001d\u0010§\u0001\u001a\u00020\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010\u001f\"\u0005\b©\u0001\u0010!R\u001d\u0010ª\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010%\"\u0005\b¬\u0001\u0010'R\u001d\u0010\u00ad\u0001\u001a\u00020\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u001f\"\u0005\b¯\u0001\u0010!R\u001d\u0010°\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010%\"\u0005\b²\u0001\u0010'R\u001d\u0010³\u0001\u001a\u00020\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010\u001f\"\u0005\bµ\u0001\u0010!R\u001d\u0010¶\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010%\"\u0005\b¸\u0001\u0010'R\u001d\u0010¹\u0001\u001a\u00020\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010\u001f\"\u0005\b»\u0001\u0010!¨\u0006Á\u0002"}, d2 = {"Lcom/bytedance/relax/ttml_profile_edit/__TtmlStaticCardController;", "", "<init>", "()V", "__cardData", "Lcom/bytedance/relax/ttml_profile_edit/ProfileEditData;", "get__cardData", "()Lcom/bytedance/relax/ttml_profile_edit/ProfileEditData;", "set__cardData", "(Lcom/bytedance/relax/ttml_profile_edit/ProfileEditData;)V", "__instance_initialNickName", "", "get__instance_initialNickName", "()Ljava/lang/String;", "set__instance_initialNickName", "(Ljava/lang/String;)V", "__instance_initialUserName", "get__instance_initialUserName", "set__instance_initialUserName", "__instance_initialAvatarUrl", "get__instance_initialAvatarUrl", "set__instance_initialAvatarUrl", "__instance_pendingUserNameRequest", "get__instance_pendingUserNameRequest", "set__instance_pendingUserNameRequest", "__instance_pendingSaveRequest", "get__instance_pendingSaveRequest", "set__instance_pendingSaveRequest", "__instance_requestSeq", "", "get__instance_requestSeq", "()I", "set__instance_requestSeq", "(I)V", "__mountedRoot", "", "get__mountedRoot", "()J", "set__mountedRoot", "(J)V", "__scopeId", "get__scopeId", "set__scopeId", "__componentId", "get__componentId", "set__componentId", "__pendingDirty", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/kmp/foundation/RTSArray;", "get__pendingDirty", "()Ljava/util/ArrayList;", "set__pendingDirty", "(Ljava/util/ArrayList;)V", "__node_0", "get__node_0", "set__node_0", "__node_1", "get__node_1", "set__node_1", "__node_2", "get__node_2", "set__node_2", "__node_3", "get__node_3", "set__node_3", "__node_4", "get__node_4", "set__node_4", "__node_5", "get__node_5", "set__node_5", "__node_6", "get__node_6", "set__node_6", "__node_7", "get__node_7", "set__node_7", "__node_8", "get__node_8", "set__node_8", "__node_9", "get__node_9", "set__node_9", "__node_10", "get__node_10", "set__node_10", "__node_11", "get__node_11", "set__node_11", "__node_12", "get__node_12", "set__node_12", "__node_13", "get__node_13", "set__node_13", "__node_14", "get__node_14", "set__node_14", "__node_15", "get__node_15", "set__node_15", "__node_16", "get__node_16", "set__node_16", "__node_17", "get__node_17", "set__node_17", "__node_18", "get__node_18", "set__node_18", "__node_19", "get__node_19", "set__node_19", "__node_20", "get__node_20", "set__node_20", "__node_21", "get__node_21", "set__node_21", "__node_22", "get__node_22", "set__node_22", "__node_23", "get__node_23", "set__node_23", "__node_24", "get__node_24", "set__node_24", "__node_25", "get__node_25", "set__node_25", "__node_26", "get__node_26", "set__node_26", "__node_27", "get__node_27", "set__node_27", "__node_28", "get__node_28", "set__node_28", "__node_29", "get__node_29", "set__node_29", "__node_30", "get__node_30", "set__node_30", "__node_31", "get__node_31", "set__node_31", "__node_32", "get__node_32", "set__node_32", "__node_33", "get__node_33", "set__node_33", "__node_34", "get__node_34", "set__node_34", "__condition_wrapper_0", "get__condition_wrapper_0", "set__condition_wrapper_0", "__condition_branch_0", "get__condition_branch_0", "set__condition_branch_0", "__condition_wrapper_1", "get__condition_wrapper_1", "set__condition_wrapper_1", "__condition_branch_1", "get__condition_branch_1", "set__condition_branch_1", "__condition_wrapper_2", "get__condition_wrapper_2", "set__condition_wrapper_2", "__condition_branch_2", "get__condition_branch_2", "set__condition_branch_2", "__condition_wrapper_3", "get__condition_wrapper_3", "set__condition_wrapper_3", "__condition_branch_3", "get__condition_branch_3", "set__condition_branch_3", "__condition_wrapper_4", "get__condition_wrapper_4", "set__condition_wrapper_4", "__condition_branch_4", "get__condition_branch_4", "set__condition_branch_4", "__stringArrayAt", "values", "index", "__initialDecode", "data", "__applyPatch", "", "patch", "dirty", "__hasDirty", "__updateBindings", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/bytedance/relax/ttmlstatic/CardSession;", "__helper_canSubmit", "nickName", "isEnterpriseAccount", "saving", "userNameStatus", "__helper_displayCancel", "isOversea", "__helper_displayDone", "__helper_displayNickNameLabel", "__helper_displayTitle", "__helper_displayUserNameLabel", "__helper_displayUserNamePlaceholder", "__helper_displayUserNameValue", "enterpriseDisplayName", "userName", "__helper_neutral50ArgbColor", "isDarkMode", "__helper_showNickNameClear", "focused", "__helper_showNickNameErrorView", "showError", "nickNameError", "__helper_showUserNameClear", "status", "__helper_showUserNameError", "__helper_userNameErrorText", "validationError", "__helper_userNameTips", "__commitPending", "__action_onLoad", "__action_onPageTap", "event", "", "Lcom/bytedance/relax/ttmlstatic/BaseEvent;", "__action_onAvatarTap", "_event", "__action_onEnterpriseFieldTap", "__setData_3_0", "__set_value_3_0_3", "__set_value_3_0_4", "__set_value_3_0_21", "__action_onAvatarChanged", "__action_onCancel", "__setData_5_0", "__set_value_5_0_1", "__set_value_5_0_17", "__set_value_5_0_18", "__set_value_5_0_21", "__action_onNickNameInput", "__setData_6_0", "__set_value_6_0_2", "__set_value_6_0_21", "__action_onUserNameInput", "__setData_7_0", "__set_value_7_0_15", "__action_onNickNameFocus", "__setData_8_0", "__set_value_8_0_15", "__action_onNickNameBlur", "__setData_9_0", "__set_value_9_0_16", "__action_onUserNameFocus", "__setData_10_0", "__set_value_10_0_16", "__action_onUserNameBlur", "__setData_11_0", "__set_value_11_0_1", "__set_value_11_0_15", "__set_value_11_0_18", "__action_onClearNickName", "__setData_12_0", "__set_value_12_0_2", "__set_value_12_0_16", "__action_onClearUserName", "__setData_13_0", "__set_value_13_0_17", "__set_value_13_0_18", "__setData_13_1", "__set_value_13_1_20", "__set_value_13_1_21", "__action_onSave", "__action_hideKeyboard", "__setData_15_0", "__set_value_15_0_13", "__action_reportDirty", "nextNickName", "nextUserName", "nextAvatarUrl", "__action_setInputValue", "selector", "value", "__setData_17_0", "__set_value_17_0_14", "__set_value_17_0_19", "__setData_17_1", "__set_value_17_1_14", "__set_value_17_1_19", "__setData_17_2", "__set_value_17_2_14", "__set_value_17_2_19", "__action_checkUserNameAfterInput", "__setData_18_0", "__set_value_18_0_14", "__setData_18_1", "__set_value_18_1_14", "__action_applyUserNameResult", WsConstants.KEY_PAYLOAD, "requestId", "__setData_19_0", "__set_value_19_0_20", "__set_value_19_0_21", "__action_applySaveResult", "__dispatchAction", "actionId", "__initialRender", "__hostUpdate", "options", "__disposeGeneratedState", "__dispose", "profile_edit_relax_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class __TtmlStaticCardController {
    public static final int $stable = 8;
    private ProfileEditData __cardData;
    private String __componentId;
    private int __condition_branch_0;
    private int __condition_branch_1;
    private int __condition_branch_2;
    private int __condition_branch_3;
    private int __condition_branch_4;
    private long __condition_wrapper_0;
    private long __condition_wrapper_1;
    private long __condition_wrapper_2;
    private long __condition_wrapper_3;
    private long __condition_wrapper_4;
    private String __instance_initialAvatarUrl;
    private String __instance_initialNickName;
    private String __instance_initialUserName;
    private String __instance_pendingSaveRequest;
    private String __instance_pendingUserNameRequest;
    private int __instance_requestSeq;
    private long __mountedRoot;
    private long __node_0;
    private long __node_1;
    private long __node_10;
    private long __node_11;
    private long __node_12;
    private long __node_13;
    private long __node_14;
    private long __node_15;
    private long __node_16;
    private long __node_17;
    private long __node_18;
    private long __node_19;
    private long __node_2;
    private long __node_20;
    private long __node_21;
    private long __node_22;
    private long __node_23;
    private long __node_24;
    private long __node_25;
    private long __node_26;
    private long __node_27;
    private long __node_28;
    private long __node_29;
    private long __node_3;
    private long __node_30;
    private long __node_31;
    private long __node_32;
    private long __node_33;
    private long __node_34;
    private long __node_4;
    private long __node_5;
    private long __node_6;
    private long __node_7;
    private long __node_8;
    private long __node_9;
    private ArrayList<Long> __pendingDirty;
    private long __scopeId;

    public static /* synthetic */ Unit A(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$55(r100, r101, r102);
    }

    public static /* synthetic */ Unit B(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$31$lambda$30(r100, r101, r102);
    }

    public static /* synthetic */ Unit C(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_17_2$lambda$24(r100, r101);
    }

    public static /* synthetic */ Unit D(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$59$lambda$58(r100, r101, r102);
    }

    public static /* synthetic */ Unit E(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_3_0$lambda$8(r100, r101);
    }

    public static /* synthetic */ Unit F(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_11_0$lambda$15(r100, r101);
    }

    public static /* synthetic */ Unit G(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_18_1$lambda$27(r100, r101);
    }

    public static /* synthetic */ Unit H(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_7_0$lambda$11(r100, r101);
    }

    public static /* synthetic */ Unit I(__TtmlStaticCardController r100, CardSession r101, String r102, Object r103) {
        return __action_onSave$lambda$19(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit J(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_15_0$lambda$20(r100, r101);
    }

    public static /* synthetic */ Unit K(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$47(r100, r101, r102);
    }

    public static /* synthetic */ Unit L(Object r100) {
        return __action_setInputValue$lambda$21(r100);
    }

    public static /* synthetic */ Unit M(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_6_0$lambda$10(r100, r101);
    }

    public static /* synthetic */ Unit N(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$53$lambda$52(r100, r101, r102);
    }

    public static /* synthetic */ Unit O(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __updateBindings$lambda$5$lambda$4(r100, r101, r102);
    }

    public static /* synthetic */ Unit P(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$59(r100, r101, r102);
    }

    public static /* synthetic */ Unit Q(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$49(r100, r101, r102);
    }

    public static /* synthetic */ Unit R(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$37$lambda$36(r100, r101, r102);
    }

    public static /* synthetic */ Unit S(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_9_0$lambda$13(r100, r101);
    }

    public static /* synthetic */ Unit T(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$35$lambda$34(r100, r101, r102);
    }

    public static /* synthetic */ Unit U(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_18_0$lambda$26(r100, r101);
    }

    public static /* synthetic */ Unit V(__TtmlStaticCardController r100, CardSession r101, String r102, String r103, Object r104) {
        return __action_checkUserNameAfterInput$lambda$25(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit W(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$47$lambda$46(r100, r101, r102);
    }

    public static /* synthetic */ Unit X(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$41(r100, r101, r102);
    }

    public static /* synthetic */ Unit Y(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_5_0$lambda$9(r100, r101);
    }

    public static /* synthetic */ Unit Z(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$37(r100, r101, r102);
    }

    public static /* synthetic */ Unit a(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$39(r100, r101, r102);
    }

    public static /* synthetic */ Unit a0(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$31(r100, r101, r102);
    }

    public static /* synthetic */ Unit b(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_8_0$lambda$12(r100, r101);
    }

    public static /* synthetic */ Unit b0(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$57$lambda$56(r100, r101, r102);
    }

    public static /* synthetic */ Unit c(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$43(r100, r101, r102);
    }

    public static /* synthetic */ Unit c0(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$35(r100, r101, r102);
    }

    public static /* synthetic */ Unit d(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$39$lambda$38(r100, r101, r102);
    }

    public static /* synthetic */ Unit e(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_10_0$lambda$14(r100, r101);
    }

    public static /* synthetic */ Unit f(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$41$lambda$40(r100, r101, r102);
    }

    public static /* synthetic */ Unit g(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __updateBindings$lambda$7$lambda$6(r100, r101, r102);
    }

    public static /* synthetic */ Unit h(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$51$lambda$50(r100, r101, r102);
    }

    public static /* synthetic */ Unit i(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$43$lambda$42(r100, r101, r102);
    }

    public static /* synthetic */ Unit j(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$33$lambda$32(r100, r101, r102);
    }

    public static /* synthetic */ Unit k(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_17_1$lambda$23(r100, r101);
    }

    public static /* synthetic */ Unit l(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$57(r100, r101, r102);
    }

    public static /* synthetic */ Unit m(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$45$lambda$44(r100, r101, r102);
    }

    public static /* synthetic */ Unit n(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_13_1$lambda$18(r100, r101);
    }

    public static /* synthetic */ Unit o(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __updateBindings$lambda$5(r100, r101, r102);
    }

    public static /* synthetic */ Unit p(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$53(r100, r101, r102);
    }

    public static /* synthetic */ Unit q(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __updateBindings$lambda$7(r100, r101, r102);
    }

    public static /* synthetic */ Unit r(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_13_0$lambda$17(r100, r101);
    }

    public static /* synthetic */ Unit s(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_12_0$lambda$16(r100, r101);
    }

    public static /* synthetic */ Unit t(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_17_0$lambda$22(r100, r101);
    }

    public static /* synthetic */ Unit u(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$33(r100, r101, r102);
    }

    public static /* synthetic */ Unit v(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$45(r100, r101, r102);
    }

    public static /* synthetic */ Unit w(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$49$lambda$48(r100, r101, r102);
    }

    public static /* synthetic */ Unit x(CardSession r100, __TtmlStaticCardController r101, Object r102) {
        return __initialRender$lambda$51(r100, r101, r102);
    }

    public static /* synthetic */ Unit y(__TtmlStaticCardController r100, CardSession r101) {
        return __setData_19_0$lambda$28(r100, r101);
    }

    public static /* synthetic */ Unit z(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        return __initialRender$lambda$55$lambda$54(r100, r101, r102);
    }

    public String __helper_displayCancel(boolean r100) {
        if (r100 == false) goto L4;
        return "Cancel";
    L4:
        return "取消";
    }

    public String __helper_displayDone(boolean r100) {
        if (r100 == false) goto L4;
        return "Done";
    L4:
        return "完成";
    }

    public String __helper_displayNickNameLabel(boolean r100) {
        if (r100 == false) goto L4;
        return "Nickname";
    L4:
        return "昵称";
    }

    public String __helper_displayTitle(boolean r100) {
        if (r100 == false) goto L4;
        return "Profile";
    L4:
        return "个人资料";
    }

    public String __helper_displayUserNameLabel(boolean r100, boolean r101) {
        if (r100 == false) goto L5;
        return "用户名";
    L5:
        if (r101 == false) goto L7;
        return "企业";
    L7:
        return "豆包号";
    }

    public String __helper_displayUserNamePlaceholder(boolean r100) {
        if (r100 == false) goto L4;
        return "输入用户名";
    L4:
        return "输入豆包号";
    }

    public long __helper_neutral50ArgbColor(boolean r100) {
        if (r100 == false) goto L4;
        return 4286019447L;
    L4:
        return 4288256409L;
    }

    public boolean __helper_showUserNameError(int r100) {
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 4) goto L7;
        return true;
    L7:
        if (r100 == 5) goto L13;
        return false;
    L13:
        return true;
    }

    public String __helper_userNameTips(boolean r100) {
        if (r100 == false) goto L4;
        return "用户名只能使用字母、数字以及下划线，长度为 4-16 个字符";
    L4:
        return "豆包号只能使用字母、数字以及下划线，长度为 4-16 个字符";
    }

    public __TtmlStaticCardController() {
        this.__instance_initialNickName = "";
        this.__instance_initialUserName = "";
        this.__instance_initialAvatarUrl = "";
        this.__instance_pendingUserNameRequest = "";
        this.__instance_pendingSaveRequest = "";
        this.__componentId = "";
        this.__pendingDirty = i.b(new Long[]{0L});
        this.__condition_branch_0 = -1;
        this.__condition_branch_1 = -1;
        this.__condition_branch_2 = -1;
        this.__condition_branch_3 = -1;
        this.__condition_branch_4 = -1;
    }

    public void __updateBindings(final CardSession r310, ArrayList<Long> r311) {
        Intrinsics.checkNotNullParameter(r310, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r311, "dirty");
        i.b(new Boolean[0]);
        String r100 = "24 7 50 40 61 20";
        if ((((Number) ListProtector.get(r311, 0)).longValue() & 32802) == 0) goto L27;
        if (this.__condition_wrapper_0 == 0) goto L27;
        ProfileEditData r101 = this.__cardData;
        Intrinsics.checkNotNull(r101);
        String r102 = r101.getNickName();
        ProfileEditData r103 = this.__cardData;
        Intrinsics.checkNotNull(r103);
        boolean r104 = r103.getNickNameFocused();
        ProfileEditData r110 = this.__cardData;
        Intrinsics.checkNotNull(r110);
        int r105 = !__helper_showNickNameClear(r102, r104, r110.isEnterpriseAccount()) ? 1 : 0;
        int r106 = this.__condition_branch_0;
        if (r105 == r106) goto L27;
        if (r106 != 0) goto L16;
        if (this.__node_12 != 0) goto L12;
    L20:
        this.__condition_branch_0 = r105;
        if (r105 != 0) goto L24;
        this.__node_12 = r310.e().e(this.__scopeId);
        r310.e().l(this.__node_12, "ignore-focus", Boolean.TRUE);
        r310.e().n(this.__node_12, "24 7 50 40 61 20");
        r310.e().a(this.__node_12, LynxTouchEvent.EVENT_TOUCH_START, d.d(new h0(r310, this)));
        r310.e().b(this.__condition_wrapper_0, this.__node_12);
        this.__node_13 = r310.e().c("svg", this.__scopeId);
        r310.e().n(this.__node_13, "35 17");
        r310.e().l(this.__node_13, "content", "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"20\" height=\"20\" viewBox=\"0 0 20 20\"><path d=\"M10,0C4.477,0 0,4.477 0,10C0,15.523 4.477,20 10,20C15.523,20 20,15.523 20,10C20,4.477 15.523,0 10,0ZM12.121,6.464C12.512,6.074 13.145,6.074 13.535,6.464C13.926,6.855 13.926,7.488 13.535,7.879L11.414,10L13.535,12.121C13.926,12.512 13.926,13.145 13.535,13.536C13.145,13.926 12.512,13.926 12.121,13.536L10,11.414L7.879,13.536C7.488,13.926 6.855,13.926 6.464,13.536C6.074,13.145 6.074,12.512 6.464,12.121L8.586,10L6.464,7.879C6.074,7.488 6.074,6.855 6.464,6.464C6.855,6.074 7.488,6.074 7.879,6.464L10,8.586L12.121,6.464Z\" fill=\"#CCCCCC\"/></svg>");
        r310.e().b(this.__node_12, this.__node_13);
        goto L27
    L24:
        if (r105 != 1) goto L27;
        this.__node_14 = r310.e().e(this.__scopeId);
        r310.e().n(this.__node_14, "24 7");
        r310.e().b(this.__condition_wrapper_0, this.__node_14);
        goto L27
    L12:
        if (this.__node_13 == 0) goto L14;
        r310.e().j(this.__node_12, this.__node_13);
        r310.e().i(this.__node_13);
        this.__node_13 = 0;
    L14:
        r310.e().j(this.__condition_wrapper_0, this.__node_12);
        r310.e().i(this.__node_12);
        this.__node_12 = 0;
        goto L20
    L16:
        if (r106 != 1) goto L20;
        if (this.__node_14 == 0) goto L20;
        r310.e().j(this.__condition_wrapper_0, this.__node_14);
        r310.e().i(this.__node_14);
        this.__node_14 = 0;
    L27:
        if ((((Number) ListProtector.get(r311, 0)).longValue() & 393216) == 0) goto L50;
        if (this.__condition_wrapper_1 == 0) goto L50;
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        boolean r108 = r107.getShowNickNameError();
        ProfileEditData r109 = this.__cardData;
        Intrinsics.checkNotNull(r109);
        if (__helper_showNickNameErrorView(r108, r109.getNickNameError()) == false) goto L33;
        int r111 = 0;
    L34:
        int r112 = this.__condition_branch_1;
        if (r111 == r112) goto L50;
        if (r112 == 0) goto L38;
    L46:
        this.__condition_branch_1 = r111;
        if (r111 != 0) goto L50;
        this.__node_16 = r310.e().e(this.__scopeId);
        r310.e().n(this.__node_16, "58 44 14 50 40 20");
        r310.e().b(this.__condition_wrapper_1, this.__node_16);
        this.__node_17 = r310.e().c("svg", this.__scopeId);
        r310.e().n(this.__node_17, "3 63 13");
        r310.e().l(this.__node_17, "content", "<svg height=\"13\" viewBox=\"0 0 14 13\" width=\"14\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M7,12.835C6.154,12.835 5.358,12.672 4.613,12.346C3.873,12.024 3.219,11.58 2.652,11.013C2.085,10.446 1.638,9.792 1.313,9.051C0.991,8.306 0.83,7.511 0.83,6.665C0.83,5.822 0.991,5.029 1.313,4.284C1.634,3.539 2.078,2.883 2.646,2.316C3.217,1.749 3.873,1.305 4.613,0.983C5.358,0.662 6.152,0.501 6.994,0.501C7.836,0.501 8.629,0.662 9.374,0.983C10.119,1.305 10.775,1.749 11.342,2.316C11.909,2.883 12.353,3.539 12.675,4.284C13.001,5.029 13.164,5.822 13.164,6.665C13.164,7.511 13.003,8.306 12.681,9.051C12.359,9.792 11.915,10.446 11.348,11.013C10.781,11.58 10.125,12.024 9.38,12.346C8.636,12.672 7.842,12.835 7,12.835ZM7,11.705C7.698,11.705 8.352,11.573 8.961,11.311C9.571,11.053 10.106,10.693 10.567,10.232C11.029,9.771 11.388,9.235 11.646,8.626C11.905,8.017 12.034,7.363 12.034,6.665C12.034,5.966 11.905,5.313 11.646,4.703C11.388,4.094 11.029,3.558 10.567,3.097C10.106,2.636 9.569,2.276 8.955,2.018C8.346,1.76 7.692,1.631 6.994,1.631C6.295,1.631 5.642,1.76 5.032,2.018C4.427,2.276 3.894,2.636 3.433,3.097C2.971,3.558 2.612,4.094 2.354,4.703C2.095,5.313 1.966,5.966 1.966,6.665C1.966,7.363 2.095,8.017 2.354,8.626C2.612,9.235 2.971,9.771 3.433,10.232C3.894,10.693 4.429,11.053 5.039,11.311C5.648,11.573 6.302,11.705 7,11.705ZM6.994,7.706C6.664,7.706 6.494,7.538 6.486,7.204L6.403,4.164C6.399,3.994 6.452,3.857 6.562,3.751C6.672,3.645 6.814,3.592 6.987,3.592C7.157,3.592 7.298,3.647 7.413,3.757C7.527,3.863 7.582,4.001 7.578,4.17L7.489,7.204C7.48,7.538 7.315,7.706 6.994,7.706ZM6.994,9.673C6.812,9.673 6.653,9.612 6.518,9.489C6.386,9.362 6.321,9.21 6.321,9.032C6.321,8.854 6.386,8.704 6.518,8.582C6.649,8.455 6.807,8.391 6.994,8.391C7.18,8.391 7.339,8.452 7.47,8.575C7.605,8.698 7.673,8.85 7.673,9.032C7.673,9.214 7.605,9.367 7.47,9.489C7.339,9.612 7.18,9.673 6.994,9.673Z\" fill=\"#ff3b30\"/></svg>");
        r310.e().b(this.__node_16, this.__node_17);
        this.__node_18 = r310.e().d(this.__scopeId);
        r310.e().n(this.__node_18, "6 29 0 19 9");
        r310.e().b(this.__node_16, this.__node_18);
        h r113 = r310.e();
        long r114 = this.__node_18;
        ProfileEditData r115 = this.__cardData;
        Intrinsics.checkNotNull(r115);
        r113.o(r114, r115.getNickNameError());
        goto L50
    L38:
        if (this.__node_16 == 0) goto L46;
        if (this.__node_17 == 0) goto L43;
        r310.e().j(this.__node_16, this.__node_17);
        r310.e().i(this.__node_17);
        this.__node_17 = 0;
    L43:
        if (this.__node_18 == 0) goto L45;
        r310.e().j(this.__node_16, this.__node_18);
        r310.e().i(this.__node_18);
        this.__node_18 = 0;
    L45:
        r310.e().j(this.__condition_wrapper_1, this.__node_16);
        r310.e().i(this.__node_16);
        this.__node_16 = 0;
        goto L46
    L33:
        r111 = -1;
    L50:
        if ((((Number) ListProtector.get(r311, 0)).longValue() & 81956) == 0) goto L112;
        if (this.__condition_wrapper_2 == 0) goto L112;
        ProfileEditData r116 = this.__cardData;
        Intrinsics.checkNotNull(r116);
        if (r116.getUserNameStatus() != 2) goto L56;
        int r117 = 0;
    L63:
        int r118 = this.__condition_branch_2;
        if (r117 == r118) goto L112;
        if (r118 == 0) goto L67;
        r100 = "24 7 50 40 61 20";
        if (r118 != 1) goto L83;
        if (this.__node_24 != 0) goto L79;
    L95:
        this.__condition_branch_2 = r117;
        if (r117 != 0) goto L102;
        this.__node_22 = r310.e().e(this.__scopeId);
        r310.e().n(this.__node_22, r100);
        r310.e().b(this.__condition_wrapper_2, this.__node_22);
        this.__node_23 = r310.e().e(this.__scopeId);
        h r119 = r310.e();
        long r120 = this.__node_23;
        ProfileEditData r121 = this.__cardData;
        Intrinsics.checkNotNull(r121);
        if (r121.isDarkMode() == false) goto L100;
        String r122 = "35 17 65 1 37 42 15";
    L101:
        r119.n(r120, r122);
        r310.e().b(this.__node_22, this.__node_23);
        goto L112
    L100:
        r122 = "35 17 65 1 37 53 15";
        goto L101
    L102:
        String r123 = r100;
        if (r117 != 1) goto L106;
        this.__node_24 = r310.e().e(this.__scopeId);
        r310.e().n(this.__node_24, r123);
        r310.e().b(this.__condition_wrapper_2, this.__node_24);
        this.__node_25 = r310.e().c("svg", this.__scopeId);
        r310.e().n(this.__node_25, "35 17");
        r310.e().l(this.__node_25, "content", "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"22\" height=\"22\" viewBox=\"0 0 22 22\"><path d=\"M10.99,21.037C9.61,21.037 8.311,20.773 7.094,20.246C5.876,19.725 4.802,18.999 3.871,18.068C2.947,17.137 2.221,16.063 1.693,14.846C1.166,13.628 0.902,12.329 0.902,10.949C0.902,9.569 1.166,8.27 1.693,7.053C2.221,5.835 2.947,4.764 3.871,3.84C4.802,2.909 5.873,2.18 7.084,1.652C8.301,1.125 9.6,0.861 10.981,0.861C12.367,0.861 13.669,1.125 14.887,1.652C16.104,2.18 17.178,2.909 18.109,3.84C19.04,4.764 19.77,5.835 20.297,7.053C20.824,8.27 21.088,9.569 21.088,10.949C21.088,12.329 20.824,13.628 20.297,14.846C19.77,16.063 19.04,17.137 18.109,18.068C17.178,18.999 16.104,19.725 14.887,20.246C13.669,20.773 12.37,21.037 10.99,21.037ZM9.906,15.764C10.089,15.764 10.255,15.721 10.404,15.637C10.561,15.552 10.697,15.425 10.814,15.256L15.385,8.127C15.45,8.023 15.509,7.912 15.561,7.795C15.613,7.671 15.639,7.554 15.639,7.443C15.639,7.189 15.541,6.984 15.346,6.828C15.157,6.672 14.942,6.594 14.701,6.594C14.382,6.594 14.118,6.763 13.91,7.102L9.867,13.566L7.992,11.184C7.862,11.021 7.735,10.907 7.611,10.842C7.488,10.777 7.348,10.744 7.191,10.744C6.944,10.744 6.732,10.835 6.557,11.018C6.387,11.193 6.303,11.405 6.303,11.652C6.303,11.776 6.326,11.896 6.371,12.014C6.417,12.131 6.482,12.245 6.566,12.356L8.959,15.266C9.102,15.441 9.249,15.568 9.398,15.646C9.548,15.725 9.717,15.764 9.906,15.764Z\" fill=\"#34C759\"/></svg>");
        r310.e().b(this.__node_24, this.__node_25);
        goto L112
    L106:
        if (r117 != 2) goto L109;
        this.__node_26 = r310.e().e(this.__scopeId);
        r310.e().l(this.__node_26, "ignore-focus", Boolean.TRUE);
        r310.e().n(this.__node_26, r123);
        r310.e().a(this.__node_26, LynxTouchEvent.EVENT_TOUCH_START, d.d(new i0(r310, this)));
        r310.e().b(this.__condition_wrapper_2, this.__node_26);
        this.__node_27 = r310.e().c("svg", this.__scopeId);
        r310.e().n(this.__node_27, "35 17");
        r310.e().l(this.__node_27, "content", "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"20\" height=\"20\" viewBox=\"0 0 20 20\"><path d=\"M10,0C4.477,0 0,4.477 0,10C0,15.523 4.477,20 10,20C15.523,20 20,15.523 20,10C20,4.477 15.523,0 10,0ZM12.121,6.464C12.512,6.074 13.145,6.074 13.535,6.464C13.926,6.855 13.926,7.488 13.535,7.879L11.414,10L13.535,12.121C13.926,12.512 13.926,13.145 13.535,13.536C13.145,13.926 12.512,13.926 12.121,13.536L10,11.414L7.879,13.536C7.488,13.926 6.855,13.926 6.464,13.536C6.074,13.145 6.074,12.512 6.464,12.121L8.586,10L6.464,7.879C6.074,7.488 6.074,6.855 6.464,6.464C6.855,6.074 7.488,6.074 7.879,6.464L10,8.586L12.121,6.464Z\" fill=\"#CCCCCC\"/></svg>");
        r310.e().b(this.__node_26, this.__node_27);
        goto L112
    L109:
        if (r117 != 3) goto L112;
        this.__node_28 = r310.e().e(this.__scopeId);
        r310.e().n(this.__node_28, "24 7");
        r310.e().b(this.__condition_wrapper_2, this.__node_28);
        goto L112
    L79:
        if (this.__node_25 == 0) goto L81;
        r310.e().j(this.__node_24, this.__node_25);
        r310.e().i(this.__node_25);
        this.__node_25 = 0;
    L81:
        r310.e().j(this.__condition_wrapper_2, this.__node_24);
        r310.e().i(this.__node_24);
        this.__node_24 = 0;
        goto L95
    L83:
        if (r118 != 2) goto L91;
        if (this.__node_26 == 0) goto L95;
        if (this.__node_27 == 0) goto L89;
        r310.e().j(this.__node_26, this.__node_27);
        r310.e().i(this.__node_27);
        this.__node_27 = 0;
    L89:
        r310.e().j(this.__condition_wrapper_2, this.__node_26);
        r310.e().i(this.__node_26);
        this.__node_26 = 0;
        goto L95
    L91:
        if (r118 != 3) goto L95;
        if (this.__node_28 == 0) goto L95;
        r310.e().j(this.__condition_wrapper_2, this.__node_28);
        r310.e().i(this.__node_28);
        this.__node_28 = 0;
        goto L95
    L67:
        if (this.__node_22 != 0) goto L69;
        r100 = "24 7 50 40 61 20";
        goto L95
    L69:
        if (this.__node_23 == 0) goto L72;
        r310.e().j(this.__node_22, this.__node_23);
        r310.e().i(this.__node_23);
        this.__node_23 = 0;
    L72:
        r310.e().j(this.__condition_wrapper_2, this.__node_22);
        r310.e().i(this.__node_22);
        this.__node_22 = 0;
        goto L95
    L56:
        ProfileEditData r124 = this.__cardData;
        Intrinsics.checkNotNull(r124);
        if (r124.getUserNameStatus() != 3) goto L59;
        r117 = 1;
        goto L63
    L59:
        ProfileEditData r125 = this.__cardData;
        Intrinsics.checkNotNull(r125);
        String r126 = r125.getUserName();
        ProfileEditData r127 = this.__cardData;
        Intrinsics.checkNotNull(r127);
        boolean r128 = r127.getUserNameFocused();
        ProfileEditData r129 = this.__cardData;
        Intrinsics.checkNotNull(r129);
        boolean r130 = r129.isEnterpriseAccount();
        ProfileEditData r131 = this.__cardData;
        Intrinsics.checkNotNull(r131);
        if (__helper_showUserNameClear(r126, r128, r130, r131.getUserNameStatus()) == false) goto L62;
        r117 = 2;
        goto L63
    L62:
        r117 = 3;
    L112:
        if ((((Number) ListProtector.get(r311, 0)).longValue() & 16416) == 0) goto L158;
        if (this.__condition_wrapper_3 == 0) goto L158;
        ProfileEditData r132 = this.__cardData;
        Intrinsics.checkNotNull(r132);
        if (r132.isEnterpriseAccount() == false) goto L118;
        int r133 = 0;
    L122:
        int r134 = this.__condition_branch_3;
        if (r133 == r134) goto L158;
        if (r134 != 0) goto L129;
        if (this.__node_29 == 0) goto L144;
        r310.e().j(this.__condition_wrapper_3, this.__node_29);
        r310.e().i(this.__node_29);
        this.__node_29 = 0;
    L144:
        this.__condition_branch_3 = r133;
        if (r133 != 0) goto L148;
        this.__node_29 = r310.e().e(this.__scopeId);
        r310.e().b(this.__condition_wrapper_3, this.__node_29);
        goto L158
    L148:
        if (r133 != 1) goto L151;
        this.__node_30 = r310.e().e(this.__scopeId);
        r310.e().n(this.__node_30, "58 44 14 50 40 20");
        r310.e().b(this.__condition_wrapper_3, this.__node_30);
        this.__node_31 = r310.e().c("svg", this.__scopeId);
        r310.e().n(this.__node_31, "3 63 13");
        r310.e().l(this.__node_31, "content", "<svg height=\"13\" viewBox=\"0 0 14 13\" width=\"14\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M7,12.835C6.154,12.835 5.358,12.672 4.613,12.346C3.873,12.024 3.219,11.58 2.652,11.013C2.085,10.446 1.638,9.792 1.313,9.051C0.991,8.306 0.83,7.511 0.83,6.665C0.83,5.822 0.991,5.029 1.313,4.284C1.634,3.539 2.078,2.883 2.646,2.316C3.217,1.749 3.873,1.305 4.613,0.983C5.358,0.662 6.152,0.501 6.994,0.501C7.836,0.501 8.629,0.662 9.374,0.983C10.119,1.305 10.775,1.749 11.342,2.316C11.909,2.883 12.353,3.539 12.675,4.284C13.001,5.029 13.164,5.822 13.164,6.665C13.164,7.511 13.003,8.306 12.681,9.051C12.359,9.792 11.915,10.446 11.348,11.013C10.781,11.58 10.125,12.024 9.38,12.346C8.636,12.672 7.842,12.835 7,12.835ZM7,11.705C7.698,11.705 8.352,11.573 8.961,11.311C9.571,11.053 10.106,10.693 10.567,10.232C11.029,9.771 11.388,9.235 11.646,8.626C11.905,8.017 12.034,7.363 12.034,6.665C12.034,5.966 11.905,5.313 11.646,4.703C11.388,4.094 11.029,3.558 10.567,3.097C10.106,2.636 9.569,2.276 8.955,2.018C8.346,1.76 7.692,1.631 6.994,1.631C6.295,1.631 5.642,1.76 5.032,2.018C4.427,2.276 3.894,2.636 3.433,3.097C2.971,3.558 2.612,4.094 2.354,4.703C2.095,5.313 1.966,5.966 1.966,6.665C1.966,7.363 2.095,8.017 2.354,8.626C2.612,9.235 2.971,9.771 3.433,10.232C3.894,10.693 4.429,11.053 5.039,11.311C5.648,11.573 6.302,11.705 7,11.705ZM6.994,7.706C6.664,7.706 6.494,7.538 6.486,7.204L6.403,4.164C6.399,3.994 6.452,3.857 6.562,3.751C6.672,3.645 6.814,3.592 6.987,3.592C7.157,3.592 7.298,3.647 7.413,3.757C7.527,3.863 7.582,4.001 7.578,4.17L7.489,7.204C7.48,7.538 7.315,7.706 6.994,7.706ZM6.994,9.673C6.812,9.673 6.653,9.612 6.518,9.489C6.386,9.362 6.321,9.21 6.321,9.032C6.321,8.854 6.386,8.704 6.518,8.582C6.649,8.455 6.807,8.391 6.994,8.391C7.18,8.391 7.339,8.452 7.47,8.575C7.605,8.698 7.673,8.85 7.673,9.032C7.673,9.214 7.605,9.367 7.47,9.489C7.339,9.612 7.18,9.673 6.994,9.673Z\" fill=\"#ff3b30\"/></svg>");
        r310.e().b(this.__node_30, this.__node_31);
        this.__node_32 = r310.e().d(this.__scopeId);
        r310.e().n(this.__node_32, "6 29 0 19 9");
        r310.e().b(this.__node_30, this.__node_32);
        h r135 = r310.e();
        long r136 = this.__node_32;
        ProfileEditData r137 = this.__cardData;
        Intrinsics.checkNotNull(r137);
        int r138 = r137.getUserNameStatus();
        ProfileEditData r139 = this.__cardData;
        Intrinsics.checkNotNull(r139);
        String r140 = r139.getUserNameError();
        ProfileEditData r141 = this.__cardData;
        Intrinsics.checkNotNull(r141);
        r135.o(r136, __helper_userNameErrorText(r138, r140, r141.isOversea()));
        goto L158
    L151:
        if (r133 != 2) goto L158;
        this.__node_33 = r310.e().d(this.__scopeId);
        h r142 = r310.e();
        long r143 = this.__node_33;
        ProfileEditData r144 = this.__cardData;
        Intrinsics.checkNotNull(r144);
        if (r144.isDarkMode() == false) goto L155;
        String r145 = "58 44 49 52 29 27 25 21";
    L156:
        r142.n(r143, r145);
        r310.e().b(this.__condition_wrapper_3, this.__node_33);
        h r146 = r310.e();
        long r147 = this.__node_33;
        ProfileEditData r148 = this.__cardData;
        Intrinsics.checkNotNull(r148);
        r146.o(r147, __helper_userNameTips(r148.isOversea()));
        goto L158
    L155:
        r145 = "58 44 49 52 29 27 25 51";
        goto L156
    L129:
        if (r134 != 1) goto L140;
        if (this.__node_30 == 0) goto L144;
        if (this.__node_31 == 0) goto L136;
        r310.e().j(this.__node_30, this.__node_31);
        r310.e().i(this.__node_31);
        this.__node_31 = 0;
    L136:
        if (this.__node_32 == 0) goto L138;
        r310.e().j(this.__node_30, this.__node_32);
        r310.e().i(this.__node_32);
        this.__node_32 = 0;
    L138:
        r310.e().j(this.__condition_wrapper_3, this.__node_30);
        r310.e().i(this.__node_30);
        this.__node_30 = 0;
        goto L144
    L140:
        if (r134 != 2) goto L144;
        if (this.__node_33 == 0) goto L144;
        r310.e().j(this.__condition_wrapper_3, this.__node_33);
        r310.e().i(this.__node_33);
        this.__node_33 = 0;
        goto L144
    L118:
        ProfileEditData r149 = this.__cardData;
        Intrinsics.checkNotNull(r149);
        if (__helper_showUserNameError(r149.getUserNameStatus()) == false) goto L121;
        r133 = 1;
        goto L122
    L121:
        r133 = 2;
    L158:
        if ((((Number) ListProtector.get(r311, 0)).longValue() & 2097152) != 0) goto L160;
    L174:
        ArrayList r150 = i.b(new Long[]{0L, 0L});
        String r151 = "28 11 19 39";
        String r152 = "null cannot be cast to non-null type kotlin.Any";
        if ((((Number) ListProtector.get(r311, 0)).longValue() & 2) == 0) goto L199;
        int r153 = 0;
        if ((((Number) ListProtector.get(r150, 0)).longValue() & 512) != 0) goto L193;
        ListProtector.set(r150, 0, Long.valueOf(((Number) ListProtector.get(r150, 0)).longValue() | 512));
        if (this.__node_7 == 0) goto L192;
        h r154 = r310.e();
        long r155 = this.__node_7;
        ProfileEditData r156 = this.__cardData;
        Intrinsics.checkNotNull(r156);
        boolean r157 = r156.getDirty();
        ProfileEditData r158 = this.__cardData;
        Intrinsics.checkNotNull(r158);
        String r210 = r158.getNickName();
        ProfileEditData r159 = this.__cardData;
        Intrinsics.checkNotNull(r159);
        boolean r211 = r159.isEnterpriseAccount();
        ProfileEditData r160 = this.__cardData;
        Intrinsics.checkNotNull(r160);
        boolean r212 = r160.getSaving();
        ProfileEditData r161 = this.__cardData;
        Intrinsics.checkNotNull(r161);
        if (__helper_canSubmit(r157, r210, r211, r212, r161.getUserNameStatus()) == false) goto L186;
        ProfileEditData r162 = this.__cardData;
        Intrinsics.checkNotNull(r162);
        if (r162.isDarkMode() == false) goto L185;
        String r163 = "28 11 19 39";
    L190:
        r154.n(r155, r163);
        goto L192
    L185:
        r163 = "28 11 19 60";
        goto L190
    L186:
        ProfileEditData r164 = this.__cardData;
        Intrinsics.checkNotNull(r164);
        if (r164.isDarkMode() == false) goto L189;
        r163 = "28 11 19 33";
        goto L190
    L189:
        r163 = "28 11 19 55";
    L192:
        r153 = 0;
    L195:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 16777216) != 0) goto L202;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 16777216));
        if (this.__node_11 == 0) goto L200;
        h r165 = r310.e();
        long r166 = this.__node_11;
        ProfileEditData r167 = this.__cardData;
        Intrinsics.checkNotNull(r167);
        String r168 = r167.getNickName();
        Intrinsics.checkNotNull(r168, r152);
        r165.l(r166, "default-value", r168);
    L200:
        r153 = 0;
    L202:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & 4) == 0) goto L210;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 70368744177664L) != 0) goto L210;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 70368744177664L));
        if (this.__node_21 == 0) goto L208;
        h r169 = r310.e();
        long r170 = this.__node_21;
        ProfileEditData r171 = this.__cardData;
        Intrinsics.checkNotNull(r171);
        boolean r172 = r171.isEnterpriseAccount();
        ProfileEditData r173 = this.__cardData;
        Intrinsics.checkNotNull(r173);
        String r174 = r173.getEnterpriseDisplayName();
        ProfileEditData r175 = this.__cardData;
        Intrinsics.checkNotNull(r175);
        String r176 = __helper_displayUserNameValue(r172, r174, r175.getUserName());
        Intrinsics.checkNotNull(r176, r152);
        r169.l(r170, "default-value", r176);
    L208:
        r153 = 0;
    L210:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & 8) == 0) goto L218;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 2048) != 0) goto L218;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 2048));
        if (this.__node_8 == 0) goto L216;
        h r177 = r310.e();
        long r178 = this.__node_8;
        ProfileEditData r179 = this.__cardData;
        Intrinsics.checkNotNull(r179);
        String r180 = r179.getAvatarUrl();
        Intrinsics.checkNotNull(r180, r152);
        r177.l(r178, "avatarUrl", r180);
    L216:
        r153 = 0;
    L218:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & 16) == 0) goto L226;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 4096) != 0) goto L226;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 4096));
        if (this.__node_8 == 0) goto L224;
        h r181 = r310.e();
        long r182 = this.__node_8;
        ProfileEditData r183 = this.__cardData;
        Intrinsics.checkNotNull(r183);
        r181.l(r182, "isDefaultAvatar", Boolean.valueOf(r183.isDefaultAvatar()));
    L224:
        r153 = 0;
    L226:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & 32) == 0) goto L280;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 512) != 0) goto L244;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 512));
        if (this.__node_7 == 0) goto L242;
        h r184 = r310.e();
        long r185 = this.__node_7;
        ProfileEditData r186 = this.__cardData;
        Intrinsics.checkNotNull(r186);
        boolean r187 = r186.getDirty();
        ProfileEditData r188 = this.__cardData;
        Intrinsics.checkNotNull(r188);
        String r189 = r188.getNickName();
        ProfileEditData r190 = this.__cardData;
        Intrinsics.checkNotNull(r190);
        boolean r312 = r190.isEnterpriseAccount();
        ProfileEditData r191 = this.__cardData;
        Intrinsics.checkNotNull(r191);
        boolean r313 = r191.getSaving();
        ProfileEditData r192 = this.__cardData;
        Intrinsics.checkNotNull(r192);
        if (__helper_canSubmit(r187, r189, r312, r313, r192.getUserNameStatus()) == false) goto L237;
        ProfileEditData r193 = this.__cardData;
        Intrinsics.checkNotNull(r193);
        if (r193.isDarkMode() == false) goto L236;
        String r194 = "28 11 19 39";
    L241:
        r184.n(r185, r194);
        goto L242
    L236:
        r194 = "28 11 19 60";
        goto L241
    L237:
        ProfileEditData r195 = this.__cardData;
        Intrinsics.checkNotNull(r195);
        if (r195.isDarkMode() == false) goto L240;
        r194 = "28 11 19 33";
        goto L241
    L240:
        r194 = "28 11 19 55";
    L242:
        r153 = 0;
    L244:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & PlaybackStateCompat.ACTION_PLAY_FROM_URI) != 0) goto L256;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | PlaybackStateCompat.ACTION_PLAY_FROM_URI));
        if (this.__node_8 == 0) goto L254;
        h r196 = r310.e();
        long r197 = this.__node_8;
        ProfileEditData r198 = this.__cardData;
        Intrinsics.checkNotNull(r198);
        if (r198.getAvatarEditable() == false) goto L252;
        ProfileEditData r199 = this.__cardData;
        Intrinsics.checkNotNull(r199);
        if (r199.isEnterpriseAccount() == true) goto L252;
        boolean r200 = true;
    L253:
        r196.l(r197, "editable", Boolean.valueOf(r200));
    L252:
        r200 = false;
    L254:
        r153 = 0;
    L256:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 4194304) != 0) goto L262;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 4194304));
        if (this.__node_11 == 0) goto L260;
        h r201 = r310.e();
        long r202 = this.__node_11;
        ProfileEditData r203 = this.__cardData;
        Intrinsics.checkNotNull(r203);
        r201.l(r202, "disabled", Boolean.valueOf(r203.isEnterpriseAccount()));
    L260:
        r153 = 0;
    L262:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 2199023255552L) != 0) goto L268;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 2199023255552L));
        if (this.__node_19 == 0) goto L266;
        h r204 = r310.e();
        long r205 = this.__node_19;
        ProfileEditData r206 = this.__cardData;
        Intrinsics.checkNotNull(r206);
        boolean r207 = r206.isOversea();
        ProfileEditData r208 = this.__cardData;
        Intrinsics.checkNotNull(r208);
        r204.o(r205, __helper_displayUserNameLabel(r207, r208.isEnterpriseAccount()));
    L266:
        r153 = 0;
    L268:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 17592186044416L) != 0) goto L274;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 17592186044416L));
        if (this.__node_21 == 0) goto L272;
        h r209 = r310.e();
        long r213 = this.__node_21;
        ProfileEditData r214 = this.__cardData;
        Intrinsics.checkNotNull(r214);
        r209.l(r213, "disabled", Boolean.valueOf(r214.isEnterpriseAccount()));
    L272:
        r153 = 0;
    L274:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 70368744177664L) != 0) goto L280;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 70368744177664L));
        if (this.__node_21 == 0) goto L278;
        h r215 = r310.e();
        long r216 = this.__node_21;
        ProfileEditData r217 = this.__cardData;
        Intrinsics.checkNotNull(r217);
        boolean r218 = r217.isEnterpriseAccount();
        ProfileEditData r219 = this.__cardData;
        Intrinsics.checkNotNull(r219);
        String r220 = r219.getEnterpriseDisplayName();
        ProfileEditData r221 = this.__cardData;
        Intrinsics.checkNotNull(r221);
        String r222 = __helper_displayUserNameValue(r218, r220, r221.getUserName());
        Intrinsics.checkNotNull(r222, r152);
        r215.l(r216, "default-value", r222);
    L278:
        r153 = 0;
    L280:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & 64) == 0) goto L288;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 70368744177664L) != 0) goto L288;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 70368744177664L));
        if (this.__node_21 == 0) goto L286;
        h r223 = r310.e();
        long r224 = this.__node_21;
        ProfileEditData r225 = this.__cardData;
        Intrinsics.checkNotNull(r225);
        boolean r226 = r225.isEnterpriseAccount();
        ProfileEditData r227 = this.__cardData;
        Intrinsics.checkNotNull(r227);
        String r228 = r227.getEnterpriseDisplayName();
        ProfileEditData r229 = this.__cardData;
        Intrinsics.checkNotNull(r229);
        String r230 = __helper_displayUserNameValue(r226, r228, r229.getUserName());
        Intrinsics.checkNotNull(r230, r152);
        r223.l(r224, "default-value", r230);
    L286:
        r153 = 0;
    L288:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & 128) == 0) goto L296;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 16384) != 0) goto L296;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 16384));
        if (this.__node_8 == 0) goto L294;
        h r231 = r310.e();
        long r232 = this.__node_8;
        ProfileEditData r233 = this.__cardData;
        Intrinsics.checkNotNull(r233);
        String r234 = r233.getEnterFrom();
        Intrinsics.checkNotNull(r234, r152);
        r231.l(r232, "enterFrom", r234);
    L294:
        r153 = 0;
    L296:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & 256) == 0) goto L314;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 64) != 0) goto L314;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 64));
        if (this.__node_5 == 0) goto L312;
        h r235 = r310.e();
        long r236 = this.__node_5;
        ProfileEditData r237 = this.__cardData;
        Intrinsics.checkNotNull(r237);
        if (Intrinsics.areEqual(r237.getScene(), "account") == false) goto L307;
        ProfileEditData r238 = this.__cardData;
        Intrinsics.checkNotNull(r238);
        if (r238.isDarkMode() == false) goto L306;
        String r239 = "10 11 19 36 64";
    L311:
        r235.n(r236, r239);
        goto L312
    L306:
        r239 = "10 11 19 36 32";
        goto L311
    L307:
        ProfileEditData r240 = this.__cardData;
        Intrinsics.checkNotNull(r240);
        if (r240.isDarkMode() == false) goto L310;
        r239 = "28 11 19 36 64";
        goto L311
    L310:
        r239 = "28 11 19 36 32";
    L312:
        r153 = 0;
    L314:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & 1024) == 0) goto L363;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 16) != 0) goto L322;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 16));
        if (this.__node_3 == 0) goto L320;
        h r241 = r310.e();
        long r242 = this.__node_3;
        ProfileEditData r243 = this.__cardData;
        Intrinsics.checkNotNull(r243);
        r241.o(r242, __helper_displayCancel(r243.isOversea()));
    L320:
        r153 = 0;
    L322:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 128) != 0) goto L328;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 128));
        if (this.__node_5 == 0) goto L326;
        h r244 = r310.e();
        long r245 = this.__node_5;
        ProfileEditData r246 = this.__cardData;
        Intrinsics.checkNotNull(r246);
        r244.o(r245, __helper_displayTitle(r246.isOversea()));
    L326:
        r153 = 0;
    L328:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 1024) != 0) goto L334;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 1024));
        if (this.__node_7 == 0) goto L332;
        h r247 = r310.e();
        long r248 = this.__node_7;
        ProfileEditData r249 = this.__cardData;
        Intrinsics.checkNotNull(r249);
        r247.o(r248, __helper_displayDone(r249.isOversea()));
    L332:
        r153 = 0;
    L334:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) goto L340;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED));
        if (this.__node_9 == 0) goto L338;
        h r250 = r310.e();
        long r251 = this.__node_9;
        ProfileEditData r252 = this.__cardData;
        Intrinsics.checkNotNull(r252);
        r250.o(r251, __helper_displayNickNameLabel(r252.isOversea()));
    L338:
        r153 = 0;
    L340:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 2199023255552L) != 0) goto L346;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 2199023255552L));
        if (this.__node_19 == 0) goto L344;
        h r253 = r310.e();
        long r254 = this.__node_19;
        ProfileEditData r255 = this.__cardData;
        Intrinsics.checkNotNull(r255);
        boolean r256 = r255.isOversea();
        ProfileEditData r257 = this.__cardData;
        Intrinsics.checkNotNull(r257);
        r253.o(r254, __helper_displayUserNameLabel(r256, r257.isEnterpriseAccount()));
    L344:
        r153 = 0;
    L346:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 140737488355328L) != 0) goto L350;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 140737488355328L));
        if (this.__node_21 == 0) goto L350;
        h r258 = r310.e();
        long r259 = this.__node_21;
        ProfileEditData r260 = this.__cardData;
        Intrinsics.checkNotNull(r260);
        String r261 = __helper_displayUserNamePlaceholder(r260.isOversea());
        Intrinsics.checkNotNull(r261, r152);
        r258.l(r259, GXTemplateKey.GAIAX_PLACEHOLDER, r261);
    L350:
        int r262 = 1;
        if ((((Number) ListProtector.get(r150, 1)).longValue() & 64) != 0) goto L357;
        ListProtector.set(r150, 1, Long.valueOf(((Number) ListProtector.get(r150, 1)).longValue() | 64));
        if (this.__node_32 == 0) goto L355;
        h r263 = r310.e();
        long r264 = this.__node_32;
        ProfileEditData r265 = this.__cardData;
        Intrinsics.checkNotNull(r265);
        int r266 = r265.getUserNameStatus();
        ProfileEditData r267 = this.__cardData;
        Intrinsics.checkNotNull(r267);
        String r268 = r267.getUserNameError();
        ProfileEditData r269 = this.__cardData;
        Intrinsics.checkNotNull(r269);
        r263.o(r264, __helper_userNameErrorText(r266, r268, r269.isOversea()));
    L355:
        r262 = 1;
    L357:
        if ((((Number) ListProtector.get(r150, r262)).longValue() & 256) != 0) goto L361;
        ListProtector.set(r150, r262, Long.valueOf(((Number) ListProtector.get(r150, r262)).longValue() | 256));
        if (this.__node_33 == 0) goto L361;
        h r270 = r310.e();
        long r271 = this.__node_33;
        ProfileEditData r272 = this.__cardData;
        Intrinsics.checkNotNull(r272);
        r270.o(r271, __helper_userNameTips(r272.isOversea()));
    L361:
        r153 = 0;
    L363:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & 2048) == 0) goto L508;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 1) != 0) goto L375;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 1));
        if (this.__node_0 == 0) goto L373;
        h r273 = r310.e();
        long r274 = this.__node_0;
        ProfileEditData r275 = this.__cardData;
        Intrinsics.checkNotNull(r275);
        if (r275.isDarkMode() == false) goto L371;
        String r276 = "34 4";
    L372:
        r273.n(r274, r276);
        goto L373
    L371:
        r276 = "34 26";
    L373:
        r153 = 0;
    L375:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 8) != 0) goto L385;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 8));
        if (this.__node_3 == 0) goto L383;
        h r277 = r310.e();
        long r278 = this.__node_3;
        ProfileEditData r279 = this.__cardData;
        Intrinsics.checkNotNull(r279);
        if (r279.isDarkMode() == false) goto L381;
        String r280 = "28 11 19 64";
    L382:
        r277.n(r278, r280);
        goto L383
    L381:
        r280 = "28 11 19 32";
    L383:
        r153 = 0;
    L385:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 64) != 0) goto L401;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 64));
        if (this.__node_5 == 0) goto L399;
        h r281 = r310.e();
        long r282 = this.__node_5;
        ProfileEditData r283 = this.__cardData;
        Intrinsics.checkNotNull(r283);
        if (Intrinsics.areEqual(r283.getScene(), "account") == false) goto L394;
        ProfileEditData r284 = this.__cardData;
        Intrinsics.checkNotNull(r284);
        if (r284.isDarkMode() == false) goto L393;
        String r285 = "10 11 19 36 64";
    L398:
        r281.n(r282, r285);
        goto L399
    L393:
        r285 = "10 11 19 36 32";
        goto L398
    L394:
        ProfileEditData r286 = this.__cardData;
        Intrinsics.checkNotNull(r286);
        if (r286.isDarkMode() == false) goto L397;
        r285 = "28 11 19 36 64";
        goto L398
    L397:
        r285 = "28 11 19 36 32";
    L399:
        r153 = 0;
    L401:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 512) != 0) goto L417;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 512));
        if (this.__node_7 == 0) goto L415;
        h r287 = r310.e();
        long r288 = this.__node_7;
        ProfileEditData r289 = this.__cardData;
        Intrinsics.checkNotNull(r289);
        boolean r290 = r289.getDirty();
        ProfileEditData r291 = this.__cardData;
        Intrinsics.checkNotNull(r291);
        String r292 = r291.getNickName();
        ProfileEditData r293 = this.__cardData;
        Intrinsics.checkNotNull(r293);
        boolean r294 = r293.isEnterpriseAccount();
        ProfileEditData r295 = this.__cardData;
        Intrinsics.checkNotNull(r295);
        boolean r1100 = r295.getSaving();
        ProfileEditData r296 = this.__cardData;
        Intrinsics.checkNotNull(r296);
        if (__helper_canSubmit(r290, r292, r294, r1100, r296.getUserNameStatus()) == false) goto L410;
        ProfileEditData r297 = this.__cardData;
        Intrinsics.checkNotNull(r297);
        if (r297.isDarkMode() == false) goto L409;
        String r298 = "28 11 19 39";
    L414:
        r287.n(r288, r298);
        goto L415
    L409:
        r298 = "28 11 19 60";
        goto L414
    L410:
        ProfileEditData r299 = this.__cardData;
        Intrinsics.checkNotNull(r299);
        if (r299.isDarkMode() == false) goto L413;
        r298 = "28 11 19 33";
        goto L414
    L413:
        r298 = "28 11 19 55";
    L415:
        r153 = 0;
    L417:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != 0) goto L427;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | PlaybackStateCompat.ACTION_SET_REPEAT_MODE));
        if (this.__node_9 == 0) goto L425;
        h r300 = r310.e();
        long r301 = this.__node_9;
        ProfileEditData r302 = this.__cardData;
        Intrinsics.checkNotNull(r302);
        if (r302.isDarkMode() == false) goto L423;
        String r303 = "58 46 12 28 11 19 64";
    L424:
        r300.n(r301, r303);
        goto L425
    L423:
        r303 = "58 46 12 28 11 19 32";
    L425:
        r153 = 0;
    L427:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 1048576) != 0) goto L437;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 1048576));
        if (this.__node_10 == 0) goto L435;
        h r304 = r310.e();
        long r305 = this.__node_10;
        ProfileEditData r306 = this.__cardData;
        Intrinsics.checkNotNull(r306);
        if (r306.isDarkMode() == false) goto L433;
        String r307 = "18 43 8 57 7 50 40 20 59";
    L434:
        r304.n(r305, r307);
        goto L435
    L433:
        r307 = "18 43 8 57 7 50 40 20 41";
    L435:
        r153 = 0;
    L437:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 33554432) != 0) goto L443;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 33554432));
        if (this.__node_11 == 0) goto L441;
        h r308 = r310.e();
        long r309 = this.__node_11;
        ProfileEditData r314 = this.__cardData;
        Intrinsics.checkNotNull(r314);
        r308.l(r309, "placeholder-color", Long.valueOf(__helper_neutral50ArgbColor(r314.isDarkMode())));
    L441:
        r153 = 0;
    L443:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 67108864) != 0) goto L453;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 67108864));
        if (this.__node_11 == 0) goto L451;
        h r315 = r310.e();
        long r316 = this.__node_11;
        ProfileEditData r317 = this.__cardData;
        Intrinsics.checkNotNull(r317);
        if (r317.isDarkMode() == false) goto L449;
        String r318 = "7 6 28 45 64 2";
    L450:
        r315.n(r316, r318);
        goto L451
    L449:
        r318 = "7 6 28 45 32 30";
    L451:
        r153 = 0;
    L453:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & DownloadConstants.TB) != 0) goto L463;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | DownloadConstants.TB));
        if (this.__node_19 == 0) goto L461;
        h r319 = r310.e();
        long r320 = this.__node_19;
        ProfileEditData r321 = this.__cardData;
        Intrinsics.checkNotNull(r321);
        if (r321.isDarkMode() == false) goto L459;
        String r322 = "58 12 28 11 19 64";
    L460:
        r319.n(r320, r322);
        goto L461
    L459:
        r322 = "58 12 28 11 19 32";
    L461:
        r153 = 0;
    L463:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 4398046511104L) != 0) goto L473;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 4398046511104L));
        if (this.__node_20 == 0) goto L471;
        h r323 = r310.e();
        long r324 = this.__node_20;
        ProfileEditData r325 = this.__cardData;
        Intrinsics.checkNotNull(r325);
        if (r325.isDarkMode() == false) goto L469;
        String r326 = "18 43 8 57 7 50 40 20 59";
    L470:
        r323.n(r324, r326);
        goto L471
    L469:
        r326 = "18 43 8 57 7 50 40 20 41";
    L471:
        r153 = 0;
    L473:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 281474976710656L) != 0) goto L479;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 281474976710656L));
        if (this.__node_21 == 0) goto L477;
        h r327 = r310.e();
        long r328 = this.__node_21;
        ProfileEditData r329 = this.__cardData;
        Intrinsics.checkNotNull(r329);
        r327.l(r328, "placeholder-color", Long.valueOf(__helper_neutral50ArgbColor(r329.isDarkMode())));
    L477:
        r153 = 0;
    L479:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 562949953421312L) != 0) goto L489;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 562949953421312L));
        if (this.__node_21 == 0) goto L487;
        h r330 = r310.e();
        long r331 = this.__node_21;
        ProfileEditData r332 = this.__cardData;
        Intrinsics.checkNotNull(r332);
        if (r332.isDarkMode() == false) goto L485;
        String r333 = "7 6 28 45 64 2";
    L486:
        r330.n(r331, r333);
        goto L487
    L485:
        r333 = "7 6 28 45 32 30";
    L487:
        r153 = 0;
    L489:
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 4503599627370496L) != 0) goto L498;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 4503599627370496L));
        if (this.__node_23 == 0) goto L498;
        h r334 = r310.e();
        long r335 = this.__node_23;
        ProfileEditData r336 = this.__cardData;
        Intrinsics.checkNotNull(r336);
        if (r336.isDarkMode() == false) goto L495;
        String r337 = "35 17 65 1 37 42 15";
    L496:
        r334.n(r335, r337);
        goto L498
    L495:
        r337 = "35 17 65 1 37 53 15";
    L498:
        if ((((Number) ListProtector.get(r150, 1)).longValue() & 128) != 0) goto L506;
        ListProtector.set(r150, 1, Long.valueOf(((Number) ListProtector.get(r150, 1)).longValue() | 128));
        if (this.__node_33 == 0) goto L506;
        h r338 = r310.e();
        long r339 = this.__node_33;
        ProfileEditData r340 = this.__cardData;
        Intrinsics.checkNotNull(r340);
        if (r340.isDarkMode() == false) goto L504;
        String r341 = "58 44 49 52 29 27 25 21";
    L505:
        r338.n(r339, r341);
        goto L506
    L504:
        r341 = "58 44 49 52 29 27 25 51";
    L506:
        r153 = 0;
    L508:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & 4096) == 0) goto L522;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & PlaybackStateCompat.ACTION_PLAY_FROM_URI) != 0) goto L522;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | PlaybackStateCompat.ACTION_PLAY_FROM_URI));
        if (this.__node_8 == 0) goto L520;
        h r342 = r310.e();
        long r343 = this.__node_8;
        ProfileEditData r344 = this.__cardData;
        Intrinsics.checkNotNull(r344);
        if (r344.getAvatarEditable() == false) goto L518;
        ProfileEditData r345 = this.__cardData;
        Intrinsics.checkNotNull(r345);
        if (r345.isEnterpriseAccount() == true) goto L518;
        boolean r346 = true;
    L519:
        r342.l(r343, "editable", Boolean.valueOf(r346));
    L518:
        r346 = false;
    L520:
        r153 = 0;
    L522:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & PlaybackStateCompat.ACTION_PLAY_FROM_URI) == 0) goto L540;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 512) != 0) goto L540;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 512));
        if (this.__node_7 == 0) goto L538;
        h r347 = r310.e();
        long r1101 = this.__node_7;
        ProfileEditData r348 = this.__cardData;
        Intrinsics.checkNotNull(r348);
        boolean r349 = r348.getDirty();
        ProfileEditData r350 = this.__cardData;
        Intrinsics.checkNotNull(r350);
        String r351 = r350.getNickName();
        ProfileEditData r352 = this.__cardData;
        Intrinsics.checkNotNull(r352);
        boolean r353 = r352.isEnterpriseAccount();
        ProfileEditData r354 = this.__cardData;
        Intrinsics.checkNotNull(r354);
        boolean r355 = r354.getSaving();
        ProfileEditData r356 = this.__cardData;
        Intrinsics.checkNotNull(r356);
        if (__helper_canSubmit(r349, r351, r353, r355, r356.getUserNameStatus()) == false) goto L533;
        ProfileEditData r357 = this.__cardData;
        Intrinsics.checkNotNull(r357);
        if (r357.isDarkMode() == false) goto L532;
        String r358 = "28 11 19 39";
    L537:
        r347.n(r1101, r358);
        goto L538
    L532:
        r358 = "28 11 19 60";
        goto L537
    L533:
        ProfileEditData r359 = this.__cardData;
        Intrinsics.checkNotNull(r359);
        if (r359.isDarkMode() == false) goto L536;
        r358 = "28 11 19 33";
        goto L537
    L536:
        r358 = "28 11 19 55";
    L538:
        r153 = 0;
    L540:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & 16384) == 0) goto L563;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 512) != 0) goto L557;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 512));
        if (this.__node_7 == 0) goto L557;
        h r360 = r310.e();
        long r1102 = this.__node_7;
        ProfileEditData r361 = this.__cardData;
        Intrinsics.checkNotNull(r361);
        boolean r362 = r361.getDirty();
        ProfileEditData r363 = this.__cardData;
        Intrinsics.checkNotNull(r363);
        String r364 = r363.getNickName();
        ProfileEditData r365 = this.__cardData;
        Intrinsics.checkNotNull(r365);
        boolean r366 = r365.isEnterpriseAccount();
        ProfileEditData r367 = this.__cardData;
        Intrinsics.checkNotNull(r367);
        boolean r368 = r367.getSaving();
        ProfileEditData r369 = this.__cardData;
        Intrinsics.checkNotNull(r369);
        if (__helper_canSubmit(r362, r364, r366, r368, r369.getUserNameStatus()) == false) goto L551;
        ProfileEditData r370 = this.__cardData;
        Intrinsics.checkNotNull(r370);
        if (r370.isDarkMode() == false) goto L550;
        String r371 = "28 11 19 39";
    L555:
        r360.n(r1102, r371);
        goto L557
    L550:
        r371 = "28 11 19 60";
        goto L555
    L551:
        ProfileEditData r372 = this.__cardData;
        Intrinsics.checkNotNull(r372);
        if (r372.isDarkMode() == false) goto L554;
        r371 = "28 11 19 33";
        goto L555
    L554:
        r371 = "28 11 19 55";
    L557:
        if ((((Number) ListProtector.get(r150, 1)).longValue() & 64) != 0) goto L561;
        ListProtector.set(r150, 1, Long.valueOf(((Number) ListProtector.get(r150, 1)).longValue() | 64));
        if (this.__node_32 == 0) goto L561;
        h r373 = r310.e();
        long r374 = this.__node_32;
        ProfileEditData r375 = this.__cardData;
        Intrinsics.checkNotNull(r375);
        int r376 = r375.getUserNameStatus();
        ProfileEditData r377 = this.__cardData;
        Intrinsics.checkNotNull(r377);
        String r378 = r377.getUserNameError();
        ProfileEditData r379 = this.__cardData;
        Intrinsics.checkNotNull(r379);
        r373.o(r374, __helper_userNameErrorText(r376, r378, r379.isOversea()));
    L561:
        r153 = 0;
    L563:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) == 0) goto L571;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 8388608) != 0) goto L571;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 8388608));
        if (this.__node_11 == 0) goto L569;
        h r380 = r310.e();
        long r381 = this.__node_11;
        ProfileEditData r382 = this.__cardData;
        Intrinsics.checkNotNull(r382);
        r380.l(r381, ButtonColorBean.StateFocus, Boolean.valueOf(r382.getNickNameFocused()));
    L569:
        r153 = 0;
    L571:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0) goto L579;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 35184372088832L) != 0) goto L579;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 35184372088832L));
        if (this.__node_21 == 0) goto L577;
        h r383 = r310.e();
        long r384 = this.__node_21;
        ProfileEditData r385 = this.__cardData;
        Intrinsics.checkNotNull(r385);
        r383.l(r384, ButtonColorBean.StateFocus, Boolean.valueOf(r385.getUserNameFocused()));
    L577:
        r153 = 0;
    L579:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) == 0) goto L587;
        if ((((Number) ListProtector.get(r150, r153)).longValue() & 549755813888L) != 0) goto L587;
        ListProtector.set(r150, r153, Long.valueOf(((Number) ListProtector.get(r150, r153)).longValue() | 549755813888L));
        if (this.__node_18 == 0) goto L585;
        h r386 = r310.e();
        long r387 = this.__node_18;
        ProfileEditData r388 = this.__cardData;
        Intrinsics.checkNotNull(r388);
        r386.o(r387, r388.getNickNameError());
    L585:
        r153 = 0;
    L587:
        if ((((Number) ListProtector.get(r311, r153)).longValue() & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) goto L589;
    L593:
        int r389 = 0;
        if ((((Number) ListProtector.get(r311, 0)).longValue() & 1048576) == 0) goto L612;
        if ((((Number) ListProtector.get(r150, 0)).longValue() & 512) != 0) goto L612;
        ListProtector.set(r150, 0, Long.valueOf(((Number) ListProtector.get(r150, 0)).longValue() | 512));
        if (this.__node_7 == 0) goto L610;
        h r390 = r310.e();
        long r1103 = this.__node_7;
        ProfileEditData r391 = this.__cardData;
        Intrinsics.checkNotNull(r391);
        boolean r392 = r391.getDirty();
        ProfileEditData r393 = this.__cardData;
        Intrinsics.checkNotNull(r393);
        String r394 = r393.getNickName();
        ProfileEditData r395 = this.__cardData;
        Intrinsics.checkNotNull(r395);
        boolean r396 = r395.isEnterpriseAccount();
        ProfileEditData r397 = this.__cardData;
        Intrinsics.checkNotNull(r397);
        boolean r398 = r397.getSaving();
        ProfileEditData r399 = this.__cardData;
        Intrinsics.checkNotNull(r399);
        if (__helper_canSubmit(r392, r394, r396, r398, r399.getUserNameStatus()) == false) goto L605;
        ProfileEditData r400 = this.__cardData;
        Intrinsics.checkNotNull(r400);
        if (r400.isDarkMode() == true) goto L609;
        r151 = "28 11 19 60";
    L609:
        r390.n(r1103, r151);
        goto L610
    L605:
        ProfileEditData r401 = this.__cardData;
        Intrinsics.checkNotNull(r401);
        if (r401.isDarkMode() == false) goto L608;
        r151 = "28 11 19 33";
        goto L609
    L608:
        r151 = "28 11 19 55";
    L610:
        r389 = 0;
    L612:
        if ((((Number) ListProtector.get(r311, r389)).longValue() & 2097152) != 0) goto L614;
        return;
    L614:
        if ((((Number) ListProtector.get(r150, 1)).longValue() & 2048) != 0) goto L620;
        ListProtector.set(r150, 1, Long.valueOf(((Number) ListProtector.get(r150, 1)).longValue() | 2048));
        if (this.__node_34 == 0) goto L621;
        h r402 = r310.e();
        long r403 = this.__node_34;
        ProfileEditData r404 = this.__cardData;
        Intrinsics.checkNotNull(r404);
        r402.o(r403, r404.getSaveMessage());
        return;
    L621:
        return;
    L620:
        return;
    L589:
        if ((((Number) ListProtector.get(r150, 1)).longValue() & 64) != 0) goto L593;
        ListProtector.set(r150, 1, Long.valueOf(((Number) ListProtector.get(r150, 1)).longValue() | 64));
        if (this.__node_32 == 0) goto L593;
        h r405 = r310.e();
        long r406 = this.__node_32;
        ProfileEditData r407 = this.__cardData;
        Intrinsics.checkNotNull(r407);
        int r408 = r407.getUserNameStatus();
        ProfileEditData r409 = this.__cardData;
        Intrinsics.checkNotNull(r409);
        String r410 = r409.getUserNameError();
        ProfileEditData r411 = this.__cardData;
        Intrinsics.checkNotNull(r411);
        r405.o(r406, __helper_userNameErrorText(r408, r410, r411.isOversea()));
        goto L593
    L193:
        r152 = "null cannot be cast to non-null type kotlin.Any";
        goto L195
    L199:
        r152 = "null cannot be cast to non-null type kotlin.Any";
        goto L200
    L160:
        if (this.__condition_wrapper_4 == 0) goto L174;
        ProfileEditData r412 = this.__cardData;
        Intrinsics.checkNotNull(r412);
        if (m.a(r412.getSaveMessage()) <= 0) goto L164;
        int r413 = 0;
    L165:
        int r414 = this.__condition_branch_4;
        if (r413 == r414) goto L174;
        if (r414 == 0) goto L169;
    L171:
        this.__condition_branch_4 = r413;
        if (r413 != 0) goto L174;
        this.__node_34 = r310.e().d(this.__scopeId);
        r310.e().n(this.__node_34, "58 44 56 52 29 27 25 9");
        r310.e().b(this.__condition_wrapper_4, this.__node_34);
        h r415 = r310.e();
        long r416 = this.__node_34;
        ProfileEditData r417 = this.__cardData;
        Intrinsics.checkNotNull(r417);
        r415.o(r416, r417.getSaveMessage());
        goto L174
    L169:
        if (this.__node_34 == 0) goto L171;
        r310.e().j(this.__condition_wrapper_4, this.__node_34);
        r310.e().i(this.__node_34);
        this.__node_34 = 0;
        goto L171
    L164:
        r413 = -1;
        goto L165
    }

    public final ProfileEditData get__cardData() {
        return this.__cardData;
    }

    public final String get__componentId() {
        return this.__componentId;
    }

    public final int get__condition_branch_0() {
        return this.__condition_branch_0;
    }

    public final int get__condition_branch_1() {
        return this.__condition_branch_1;
    }

    public final int get__condition_branch_2() {
        return this.__condition_branch_2;
    }

    public final int get__condition_branch_3() {
        return this.__condition_branch_3;
    }

    public final int get__condition_branch_4() {
        return this.__condition_branch_4;
    }

    public final long get__condition_wrapper_0() {
        return this.__condition_wrapper_0;
    }

    public final long get__condition_wrapper_1() {
        return this.__condition_wrapper_1;
    }

    public final long get__condition_wrapper_2() {
        return this.__condition_wrapper_2;
    }

    public final long get__condition_wrapper_3() {
        return this.__condition_wrapper_3;
    }

    public final long get__condition_wrapper_4() {
        return this.__condition_wrapper_4;
    }

    public final String get__instance_initialAvatarUrl() {
        return this.__instance_initialAvatarUrl;
    }

    public final String get__instance_initialNickName() {
        return this.__instance_initialNickName;
    }

    public final String get__instance_initialUserName() {
        return this.__instance_initialUserName;
    }

    public final String get__instance_pendingSaveRequest() {
        return this.__instance_pendingSaveRequest;
    }

    public final String get__instance_pendingUserNameRequest() {
        return this.__instance_pendingUserNameRequest;
    }

    public final int get__instance_requestSeq() {
        return this.__instance_requestSeq;
    }

    public final long get__mountedRoot() {
        return this.__mountedRoot;
    }

    public final long get__node_0() {
        return this.__node_0;
    }

    public final long get__node_1() {
        return this.__node_1;
    }

    public final long get__node_10() {
        return this.__node_10;
    }

    public final long get__node_11() {
        return this.__node_11;
    }

    public final long get__node_12() {
        return this.__node_12;
    }

    public final long get__node_13() {
        return this.__node_13;
    }

    public final long get__node_14() {
        return this.__node_14;
    }

    public final long get__node_15() {
        return this.__node_15;
    }

    public final long get__node_16() {
        return this.__node_16;
    }

    public final long get__node_17() {
        return this.__node_17;
    }

    public final long get__node_18() {
        return this.__node_18;
    }

    public final long get__node_19() {
        return this.__node_19;
    }

    public final long get__node_2() {
        return this.__node_2;
    }

    public final long get__node_20() {
        return this.__node_20;
    }

    public final long get__node_21() {
        return this.__node_21;
    }

    public final long get__node_22() {
        return this.__node_22;
    }

    public final long get__node_23() {
        return this.__node_23;
    }

    public final long get__node_24() {
        return this.__node_24;
    }

    public final long get__node_25() {
        return this.__node_25;
    }

    public final long get__node_26() {
        return this.__node_26;
    }

    public final long get__node_27() {
        return this.__node_27;
    }

    public final long get__node_28() {
        return this.__node_28;
    }

    public final long get__node_29() {
        return this.__node_29;
    }

    public final long get__node_3() {
        return this.__node_3;
    }

    public final long get__node_30() {
        return this.__node_30;
    }

    public final long get__node_31() {
        return this.__node_31;
    }

    public final long get__node_32() {
        return this.__node_32;
    }

    public final long get__node_33() {
        return this.__node_33;
    }

    public final long get__node_34() {
        return this.__node_34;
    }

    public final long get__node_4() {
        return this.__node_4;
    }

    public final long get__node_5() {
        return this.__node_5;
    }

    public final long get__node_6() {
        return this.__node_6;
    }

    public final long get__node_7() {
        return this.__node_7;
    }

    public final long get__node_8() {
        return this.__node_8;
    }

    public final long get__node_9() {
        return this.__node_9;
    }

    public final ArrayList<Long> get__pendingDirty() {
        return this.__pendingDirty;
    }

    public final long get__scopeId() {
        return this.__scopeId;
    }

    private static final Unit __action_setInputValue$lambda$21(Object r100) {
        return Unit.INSTANCE;
    }

    public void __action_hideKeyboard(CardSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        CardSession.f(r100, ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, i.b(new Object[0]), null, 24);
    }

    public void __action_onLoad(CardSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        ProfileEditData r101 = this.__cardData;
        Intrinsics.checkNotNull(r101);
        this.__instance_initialNickName = r101.getNickName();
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        this.__instance_initialUserName = r102.getUserName();
        ProfileEditData r103 = this.__cardData;
        Intrinsics.checkNotNull(r103);
        this.__instance_initialAvatarUrl = r103.getAvatarUrl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void __commitPending(CardSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (__hasDirty(this.__pendingDirty) == true) goto L5;
        return;
    L5:
        ArrayList<Long> r101 = i.b(new Long[]{ListProtector.get(this.__pendingDirty, 0)});
        ListProtector.set(this.__pendingDirty, 0, 0L);
        __updateBindings(r100, r101);
    }

    public void __dispose(CardSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        __disposeGeneratedState(r100);
    }

    public void __disposeGeneratedState(CardSession r110) {
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (this.__node_0 != 0) goto L5;
    L139:
        this.__mountedRoot = 0;
        return;
    L5:
        if (this.__node_1 == 0) goto L25;
        long r100 = this.__node_2;
        if (r100 == 0) goto L12;
        long r101 = this.__node_3;
        if (r101 == 0) goto L11;
        r110.f267193a.j(r100, r101);
        r110.f267193a.i(this.__node_3);
        this.__node_3 = 0;
    L11:
        r110.f267193a.j(this.__node_1, this.__node_2);
        r110.f267193a.i(this.__node_2);
        this.__node_2 = 0;
    L12:
        long r102 = this.__node_4;
        if (r102 == 0) goto L18;
        long r103 = this.__node_5;
        if (r103 == 0) goto L17;
        r110.f267193a.j(r102, r103);
        r110.f267193a.i(this.__node_5);
        this.__node_5 = 0;
    L17:
        r110.f267193a.j(this.__node_1, this.__node_4);
        r110.f267193a.i(this.__node_4);
        this.__node_4 = 0;
    L18:
        long r104 = this.__node_6;
        if (r104 == 0) goto L24;
        long r105 = this.__node_7;
        if (r105 == 0) goto L23;
        r110.f267193a.j(r104, r105);
        r110.f267193a.i(this.__node_7);
        this.__node_7 = 0;
    L23:
        r110.f267193a.j(this.__node_1, this.__node_6);
        r110.f267193a.i(this.__node_6);
        this.__node_6 = 0;
    L24:
        r110.f267193a.j(this.__node_0, this.__node_1);
        r110.f267193a.i(this.__node_1);
        this.__node_1 = 0;
    L25:
        long r106 = this.__node_8;
        if (r106 == 0) goto L28;
        r110.f267193a.j(this.__node_0, r106);
        r110.f267193a.i(this.__node_8);
        this.__node_8 = 0;
    L28:
        long r107 = this.__node_9;
        if (r107 == 0) goto L31;
        r110.f267193a.j(this.__node_0, r107);
        r110.f267193a.i(this.__node_9);
        this.__node_9 = 0;
    L31:
        long r108 = this.__node_10;
        if (r108 == 0) goto L53;
        long r109 = this.__node_11;
        if (r109 == 0) goto L36;
        r110.f267193a.j(r108, r109);
        r110.f267193a.i(this.__node_11);
        this.__node_11 = 0;
    L36:
        int r111 = this.__condition_branch_0;
        if (r111 != 0) goto L44;
        long r112 = this.__node_12;
        if (r112 == 0) goto L48;
        long r113 = this.__node_13;
        if (r113 == 0) goto L43;
        r110.f267193a.j(r112, r113);
        r110.f267193a.i(this.__node_13);
        this.__node_13 = 0;
    L43:
        r110.f267193a.j(this.__condition_wrapper_0, this.__node_12);
        r110.f267193a.i(this.__node_12);
        this.__node_12 = 0;
    L48:
        long r114 = this.__condition_wrapper_0;
        if (r114 == 0) goto L51;
        r110.f267193a.j(this.__node_10, r114);
        r110.f267193a.i(this.__condition_wrapper_0);
        this.__condition_wrapper_0 = 0;
    L51:
        this.__condition_branch_0 = -1;
        r110.f267193a.j(this.__node_0, this.__node_10);
        r110.f267193a.i(this.__node_10);
        this.__node_10 = 0;
        goto L53
    L44:
        if (r111 != 1) goto L48;
        long r115 = this.__node_14;
        if (r115 == 0) goto L48;
        r110.f267193a.j(this.__condition_wrapper_0, r115);
        r110.f267193a.i(this.__node_14);
        this.__node_14 = 0;
    L53:
        if (this.__node_15 != 0) goto L55;
    L69:
        long r116 = this.__node_19;
        if (r116 == 0) goto L72;
        r110.f267193a.j(this.__node_0, r116);
        r110.f267193a.i(this.__node_19);
        this.__node_19 = 0;
    L72:
        long r117 = this.__node_20;
        if (r117 == 0) goto L108;
        long r118 = this.__node_21;
        if (r118 == 0) goto L77;
        r110.f267193a.j(r117, r118);
        r110.f267193a.i(this.__node_21);
        this.__node_21 = 0;
    L77:
        int r119 = this.__condition_branch_2;
        if (r119 != 0) goto L85;
        long r120 = this.__node_22;
        if (r120 == 0) goto L104;
        long r121 = this.__node_23;
        if (r121 == 0) goto L84;
        r110.f267193a.j(r120, r121);
        r110.f267193a.i(this.__node_23);
        this.__node_23 = 0;
    L84:
        r110.f267193a.j(this.__condition_wrapper_2, this.__node_22);
        r110.f267193a.i(this.__node_22);
        this.__node_22 = 0;
    L104:
        long r122 = this.__condition_wrapper_2;
        if (r122 == 0) goto L107;
        r110.f267193a.j(this.__node_20, r122);
        r110.f267193a.i(this.__condition_wrapper_2);
        this.__condition_wrapper_2 = 0;
    L107:
        this.__condition_branch_2 = -1;
        r110.f267193a.j(this.__node_0, this.__node_20);
        r110.f267193a.i(this.__node_20);
        this.__node_20 = 0;
        goto L108
    L85:
        if (r119 != 1) goto L92;
        long r123 = this.__node_24;
        if (r123 == 0) goto L104;
        long r124 = this.__node_25;
        if (r124 == 0) goto L91;
        r110.f267193a.j(r123, r124);
        r110.f267193a.i(this.__node_25);
        this.__node_25 = 0;
    L91:
        r110.f267193a.j(this.__condition_wrapper_2, this.__node_24);
        r110.f267193a.i(this.__node_24);
        this.__node_24 = 0;
        goto L104
    L92:
        if (r119 != 2) goto L100;
        long r125 = this.__node_26;
        if (r125 == 0) goto L104;
        long r126 = this.__node_27;
        if (r126 == 0) goto L98;
        r110.f267193a.j(r125, r126);
        r110.f267193a.i(this.__node_27);
        this.__node_27 = 0;
    L98:
        r110.f267193a.j(this.__condition_wrapper_2, this.__node_26);
        r110.f267193a.i(this.__node_26);
        this.__node_26 = 0;
        goto L104
    L100:
        if (r119 != 3) goto L104;
        long r127 = this.__node_28;
        if (r127 == 0) goto L104;
        r110.f267193a.j(this.__condition_wrapper_2, r127);
        r110.f267193a.i(this.__node_28);
        this.__node_28 = 0;
    L108:
        int r128 = this.__condition_branch_3;
        if (r128 != 0) goto L113;
        long r129 = this.__node_29;
        if (r129 == 0) goto L127;
        r110.f267193a.j(this.__condition_wrapper_3, r129);
        r110.f267193a.i(this.__node_29);
        this.__node_29 = 0;
    L127:
        long r130 = this.__condition_wrapper_3;
        if (r130 == 0) goto L130;
        r110.f267193a.j(this.__node_0, r130);
        r110.f267193a.i(this.__condition_wrapper_3);
        this.__condition_wrapper_3 = 0;
    L130:
        this.__condition_branch_3 = -1;
        if (this.__condition_branch_4 != 0) goto L135;
        long r131 = this.__node_34;
        if (r131 == 0) goto L135;
        r110.f267193a.j(this.__condition_wrapper_4, r131);
        r110.f267193a.i(this.__node_34);
        this.__node_34 = 0;
    L135:
        long r132 = this.__condition_wrapper_4;
        if (r132 == 0) goto L138;
        r110.f267193a.j(this.__node_0, r132);
        r110.f267193a.i(this.__condition_wrapper_4);
        this.__condition_wrapper_4 = 0;
    L138:
        this.__condition_branch_4 = -1;
        h r133 = r110.f267193a;
        r133.j(r133.f267237b, this.__node_0);
        r110.f267193a.i(this.__node_0);
        this.__node_0 = 0;
        goto L139
    L113:
        if (r128 != 1) goto L123;
        long r134 = this.__node_30;
        if (r134 == 0) goto L127;
        long r135 = this.__node_31;
        if (r135 == 0) goto L119;
        r110.f267193a.j(r134, r135);
        r110.f267193a.i(this.__node_31);
        this.__node_31 = 0;
    L119:
        long r136 = this.__node_32;
        if (r136 == 0) goto L122;
        r110.f267193a.j(this.__node_30, r136);
        r110.f267193a.i(this.__node_32);
        this.__node_32 = 0;
    L122:
        r110.f267193a.j(this.__condition_wrapper_3, this.__node_30);
        r110.f267193a.i(this.__node_30);
        this.__node_30 = 0;
        goto L127
    L123:
        if (r128 != 2) goto L127;
        long r137 = this.__node_33;
        if (r137 == 0) goto L127;
        r110.f267193a.j(this.__condition_wrapper_3, r137);
        r110.f267193a.i(this.__node_33);
        this.__node_33 = 0;
        goto L127
    L55:
        if (this.__condition_branch_1 != 0) goto L65;
        long r138 = this.__node_16;
        if (r138 == 0) goto L65;
        long r139 = this.__node_17;
        if (r139 == 0) goto L61;
        r110.f267193a.j(r138, r139);
        r110.f267193a.i(this.__node_17);
        this.__node_17 = 0;
    L61:
        long r140 = this.__node_18;
        if (r140 == 0) goto L64;
        r110.f267193a.j(this.__node_16, r140);
        r110.f267193a.i(this.__node_18);
        this.__node_18 = 0;
    L64:
        r110.f267193a.j(this.__condition_wrapper_1, this.__node_16);
        r110.f267193a.i(this.__node_16);
        this.__node_16 = 0;
    L65:
        long r141 = this.__condition_wrapper_1;
        if (r141 == 0) goto L68;
        r110.f267193a.j(this.__node_15, r141);
        r110.f267193a.i(this.__condition_wrapper_1);
        this.__condition_wrapper_1 = 0;
    L68:
        this.__condition_branch_1 = -1;
        r110.f267193a.j(this.__node_0, this.__node_15);
        r110.f267193a.i(this.__node_15);
        this.__node_15 = 0;
        goto L69
    }

    public boolean __hasDirty(ArrayList<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "dirty");
        Long r101 = (Long) ListProtector.get(r100, 0);
        if (r101 != null) goto L6;
    L7:
        return true;
    L6:
        if (r101.longValue() != 0) goto L7;
        return false;
    }

    public ProfileEditData __initialDecode(Object r210) {
        Intrinsics.checkNotNullParameter(r210, "data");
        int r100 = g.f267235a;
        if (g.a.b(r210) == false) goto L104;
        ArrayList r101 = g.a.c(r210);
        ProfileEditData r110 = new ProfileEditData("", "", "", "", true, false, "", "setting", "default", "", false, false, true, false, 0, false, false, false, "", "", false, "");
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        int r103 = r101.size();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r103 != 0) goto L7;
        return r110;
    L7:
        int r104 = 0;
    L8:
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        int r106 = r101.size();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if (r104 >= r106) goto L102;
        String r107 = (String) ListProtector.get(r101, r104);
        int r108 = g.f267235a;
        Object r109 = g.a.a(r210, r107);
        switch(r107.hashCode()) {
            case -1671059855: goto L98;
            case -1666750992: goto L94;
            case -1121153358: goto L90;
            case -909413638: goto L86;
            case -858429790: goto L82;
            case -836030906: goto L78;
            case -519460131: goto L74;
            case -428646058: goto L70;
            case -294225022: goto L66;
            case -266666762: goto L62;
            case -122721527: goto L58;
            case 6137992: goto L54;
            case 69737614: goto L50;
            case 95593426: goto L46;
            case 109254796: goto L42;
            case 316370458: goto L38;
            case 373769757: goto L34;
            case 947558787: goto L30;
            case 1396360609: goto L26;
            case 1645584330: goto L22;
            case 1874684019: goto L18;
            case 2035291212: goto L14;
            default: goto L101;
        };
    L14:
        if (r107.equals("enterpriseDisplayName") == false) goto L101;
        r110.setEnterpriseDisplayName(g.a.f(r109, "$.enterpriseDisplayName"));
        goto L101
    L18:
        if (r107.equals("platform") == false) goto L101;
        r110.setPlatform(g.a.f(r109, "$.platform"));
        goto L101
    L22:
        if (r107.equals("saveMessage") == false) goto L101;
        r110.setSaveMessage(g.a.f(r109, "$.saveMessage"));
        goto L101
    L26:
        if (r107.equals("userNameFocused") == false) goto L101;
        r110.setUserNameFocused(g.a.d(r109, "$.userNameFocused"));
        goto L101
    L30:
        if (r107.equals("isDarkMode") == false) goto L101;
        r110.setDarkMode(g.a.d(r109, "$.isDarkMode"));
        goto L101
    L34:
        if (r107.equals("showNickNameError") == false) goto L101;
        r110.setShowNickNameError(g.a.d(r109, "$.showNickNameError"));
        goto L101
    L38:
        if (r107.equals("nickNameError") == false) goto L101;
        r110.setNickNameError(g.a.f(r109, "$.nickNameError"));
        goto L101
    L42:
        if (r107.equals("scene") == false) goto L101;
        r110.setScene(g.a.f(r109, "$.scene"));
        goto L101
    L46:
        if (r107.equals("dirty") == false) goto L101;
        r110.setDirty(g.a.d(r109, "$.dirty"));
        goto L101
    L50:
        if (r107.equals("nickName") == false) goto L101;
        r110.setNickName(g.a.f(r109, "$.nickName"));
        goto L101
    L54:
        if (r107.equals("userNameStatus") == false) goto L101;
        r110.setUserNameStatus(g.a.e(r109));
        goto L101
    L58:
        if (r107.equals("nickNameFocused") == false) goto L101;
        r110.setNickNameFocused(g.a.d(r109, "$.nickNameFocused"));
        goto L101
    L62:
        if (r107.equals("userName") == false) goto L101;
        r110.setUserName(g.a.f(r109, "$.userName"));
        goto L101
    L66:
        if (r107.equals("isEnterpriseAccount") == false) goto L101;
        r110.setEnterpriseAccount(g.a.d(r109, "$.isEnterpriseAccount"));
        goto L101
    L70:
        if (r107.equals("avatarUrl") == false) goto L101;
        r110.setAvatarUrl(g.a.f(r109, "$.avatarUrl"));
        goto L101
    L74:
        if (r107.equals("avatarEditable") == false) goto L101;
        r110.setAvatarEditable(g.a.d(r109, "$.avatarEditable"));
        goto L101
    L78:
        if (r107.equals("userId") == false) goto L101;
        r110.setUserId(g.a.f(r109, "$.userId"));
        goto L101
    L82:
        if (r107.equals("enterFrom") == false) goto L101;
        r110.setEnterFrom(g.a.f(r109, "$.enterFrom"));
        goto L101
    L86:
        if (r107.equals("saving") == false) goto L101;
        r110.setSaving(g.a.d(r109, "$.saving"));
        goto L101
    L90:
        if (r107.equals("userNameError") == false) goto L101;
        r110.setUserNameError(g.a.f(r109, "$.userNameError"));
        goto L101
    L94:
        if (r107.equals("isDefaultAvatar") == false) goto L101;
        r110.setDefaultAvatar(g.a.d(r109, "$.isDefaultAvatar"));
        goto L101
    L98:
        if (r107.equals("isOversea") == false) goto L101;
        r110.setOversea(g.a.d(r109, "$.isOversea"));
    L101:
        r104 = r104 + 1;
        goto L8
    L102:
        return r110;
    L104:
        throw new Throwable("[TTML Static] Expected Card data object at $.");
    }

    public final void set__cardData(ProfileEditData r100) {
        this.__cardData = r100;
    }

    public final void set__componentId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.__componentId = r100;
    }

    public final void set__condition_branch_0(int r100) {
        this.__condition_branch_0 = r100;
    }

    public final void set__condition_branch_1(int r100) {
        this.__condition_branch_1 = r100;
    }

    public final void set__condition_branch_2(int r100) {
        this.__condition_branch_2 = r100;
    }

    public final void set__condition_branch_3(int r100) {
        this.__condition_branch_3 = r100;
    }

    public final void set__condition_branch_4(int r100) {
        this.__condition_branch_4 = r100;
    }

    public final void set__condition_wrapper_0(long r100) {
        this.__condition_wrapper_0 = r100;
    }

    public final void set__condition_wrapper_1(long r100) {
        this.__condition_wrapper_1 = r100;
    }

    public final void set__condition_wrapper_2(long r100) {
        this.__condition_wrapper_2 = r100;
    }

    public final void set__condition_wrapper_3(long r100) {
        this.__condition_wrapper_3 = r100;
    }

    public final void set__condition_wrapper_4(long r100) {
        this.__condition_wrapper_4 = r100;
    }

    public final void set__instance_initialAvatarUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.__instance_initialAvatarUrl = r100;
    }

    public final void set__instance_initialNickName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.__instance_initialNickName = r100;
    }

    public final void set__instance_initialUserName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.__instance_initialUserName = r100;
    }

    public final void set__instance_pendingSaveRequest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.__instance_pendingSaveRequest = r100;
    }

    public final void set__instance_pendingUserNameRequest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.__instance_pendingUserNameRequest = r100;
    }

    public final void set__instance_requestSeq(int r100) {
        this.__instance_requestSeq = r100;
    }

    public final void set__mountedRoot(long r100) {
        this.__mountedRoot = r100;
    }

    public final void set__node_0(long r100) {
        this.__node_0 = r100;
    }

    public final void set__node_1(long r100) {
        this.__node_1 = r100;
    }

    public final void set__node_10(long r100) {
        this.__node_10 = r100;
    }

    public final void set__node_11(long r100) {
        this.__node_11 = r100;
    }

    public final void set__node_12(long r100) {
        this.__node_12 = r100;
    }

    public final void set__node_13(long r100) {
        this.__node_13 = r100;
    }

    public final void set__node_14(long r100) {
        this.__node_14 = r100;
    }

    public final void set__node_15(long r100) {
        this.__node_15 = r100;
    }

    public final void set__node_16(long r100) {
        this.__node_16 = r100;
    }

    public final void set__node_17(long r100) {
        this.__node_17 = r100;
    }

    public final void set__node_18(long r100) {
        this.__node_18 = r100;
    }

    public final void set__node_19(long r100) {
        this.__node_19 = r100;
    }

    public final void set__node_2(long r100) {
        this.__node_2 = r100;
    }

    public final void set__node_20(long r100) {
        this.__node_20 = r100;
    }

    public final void set__node_21(long r100) {
        this.__node_21 = r100;
    }

    public final void set__node_22(long r100) {
        this.__node_22 = r100;
    }

    public final void set__node_23(long r100) {
        this.__node_23 = r100;
    }

    public final void set__node_24(long r100) {
        this.__node_24 = r100;
    }

    public final void set__node_25(long r100) {
        this.__node_25 = r100;
    }

    public final void set__node_26(long r100) {
        this.__node_26 = r100;
    }

    public final void set__node_27(long r100) {
        this.__node_27 = r100;
    }

    public final void set__node_28(long r100) {
        this.__node_28 = r100;
    }

    public final void set__node_29(long r100) {
        this.__node_29 = r100;
    }

    public final void set__node_3(long r100) {
        this.__node_3 = r100;
    }

    public final void set__node_30(long r100) {
        this.__node_30 = r100;
    }

    public final void set__node_31(long r100) {
        this.__node_31 = r100;
    }

    public final void set__node_32(long r100) {
        this.__node_32 = r100;
    }

    public final void set__node_33(long r100) {
        this.__node_33 = r100;
    }

    public final void set__node_34(long r100) {
        this.__node_34 = r100;
    }

    public final void set__node_4(long r100) {
        this.__node_4 = r100;
    }

    public final void set__node_5(long r100) {
        this.__node_5 = r100;
    }

    public final void set__node_6(long r100) {
        this.__node_6 = r100;
    }

    public final void set__node_7(long r100) {
        this.__node_7 = r100;
    }

    public final void set__node_8(long r100) {
        this.__node_8 = r100;
    }

    public final void set__node_9(long r100) {
        this.__node_9 = r100;
    }

    public final void set__pendingDirty(ArrayList<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.__pendingDirty = r100;
    }

    public final void set__scopeId(long r100) {
        this.__scopeId = r100;
    }

    private static final Unit __setData_10_0$lambda$14(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_11_0$lambda$15(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_12_0$lambda$16(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_13_0$lambda$17(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_13_1$lambda$18(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_15_0$lambda$20(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_17_0$lambda$22(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_17_1$lambda$23(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_17_2$lambda$24(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_18_0$lambda$26(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_18_1$lambda$27(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_19_0$lambda$28(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_3_0$lambda$8(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_5_0$lambda$9(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_6_0$lambda$10(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_7_0$lambda$11(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_8_0$lambda$12(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    private static final Unit __setData_9_0$lambda$13(__TtmlStaticCardController r100, CardSession r101) {
        r100.__commitPending(r101);
        return Unit.INSTANCE;
    }

    public void __action_checkUserNameAfterInput(final CardSession r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "nextUserName");
        if (Intrinsics.areEqual(r101, this.__instance_initialUserName) == false) goto L6;
        this.__instance_pendingUserNameRequest = "";
        __setData_17_0(r100, 0, "");
        return;
    L6:
        String r102 = SrcProfileeditRxPageKt.validateUserName(r101);
        if (m.a(r102) <= 0) goto L10;
        this.__instance_pendingUserNameRequest = "";
        __setData_17_1(r100, 1, r102);
        return;
    L10:
        int r103 = this.__instance_requestSeq + 1;
        final String r104 = "username_" + r103;
        this.__instance_requestSeq = r103;
        this.__instance_pendingUserNameRequest = r104;
        __setData_17_2(r100, 2, "");
        Object r105 = CardSession.f(r100, ProfileEditRelaxPage.METHOD_CHECK_USER_NAME, i.b(new Object[]{r104, r101}), new k(this, r100, r104, r101), 16);
        if (r105 == null) goto L14;
        __action_applyUserNameResult(r100, r105, r104, r101);
        return;
    }

    public void __action_onAvatarChanged(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "event");
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        String r103 = SrcProfileeditRxPageKt.readAvatarUrl(r101, r102.getAvatarUrl());
        __setData_3_0(r100, r103, false, "");
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        String r105 = r104.getNickName();
        ProfileEditData r106 = this.__cardData;
        Intrinsics.checkNotNull(r106);
        __action_reportDirty(r100, r105, r106.getUserName(), r103);
    }

    public void __action_onAvatarTap(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "_event");
        __action_hideKeyboard(r100);
    }

    public void __action_onCancel(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "_event");
        String r102 = this.__instance_initialNickName;
        String r103 = this.__instance_initialUserName;
        String r104 = this.__instance_initialAvatarUrl;
        ProfileEditData r105 = this.__cardData;
        Intrinsics.checkNotNull(r105);
        String r106 = r105.getNickName();
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        String r108 = r107.getUserName();
        ProfileEditData r109 = this.__cardData;
        Intrinsics.checkNotNull(r109);
        boolean r110 = SrcProfileeditRxPageKt.isDirtyValues(r102, r103, r104, r106, r108, r109.getAvatarUrl());
        Intrinsics.checkNotNull(Boolean.valueOf(r110), "null cannot be cast to non-null type kotlin.Any");
        CardSession.f(r100, ProfileEditRelaxPage.METHOD_REQUEST_CLOSE, i.b(new Object[]{Boolean.valueOf(r110)}), null, 24);
    }

    public void __action_onClearNickName(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "_event");
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        if (r102.isEnterpriseAccount() == false) goto L5;
        return;
    L5:
        __setData_11_0(r100, "", true, SrcProfileeditRxPageKt.validateNickName(""));
        __action_setInputValue(r100, "#profile-edit-nickname", "");
        ProfileEditData r103 = this.__cardData;
        Intrinsics.checkNotNull(r103);
        String r104 = r103.getUserName();
        ProfileEditData r105 = this.__cardData;
        Intrinsics.checkNotNull(r105);
        __action_reportDirty(r100, "", r104, r105.getAvatarUrl());
    }

    public void __action_onClearUserName(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "_event");
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        if (r102.isEnterpriseAccount() == false) goto L5;
        return;
    L5:
        __setData_12_0(r100, "", true);
        __action_setInputValue(r100, "#profile-edit-username", "");
        ProfileEditData r103 = this.__cardData;
        Intrinsics.checkNotNull(r103);
        String r104 = r103.getNickName();
        ProfileEditData r105 = this.__cardData;
        Intrinsics.checkNotNull(r105);
        __action_reportDirty(r100, r104, "", r105.getAvatarUrl());
        __action_checkUserNameAfterInput(r100, "");
    }

    public void __action_onEnterpriseFieldTap(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "_event");
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        if (r102.isEnterpriseAccount() == true) goto L5;
        return;
    L5:
        __action_hideKeyboard(r100);
        CardSession.f(r100, ProfileEditRelaxPage.METHOD_SHOW_ENTERPRISE_EDIT_DISABLED_TOAST, i.b(new Object[0]), null, 24);
    }

    public void __action_onNickNameBlur(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "_event");
        __setData_8_0(r100, false);
    }

    public void __action_onNickNameFocus(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "_event");
        __setData_7_0(r100, true);
    }

    public void __action_onNickNameInput(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "event");
        String r102 = SrcProfileeditRxPageKt.readEventString(r101, "value");
        __setData_5_0(r100, r102, false, SrcProfileeditRxPageKt.validateNickName(r102), "");
        ProfileEditData r103 = this.__cardData;
        Intrinsics.checkNotNull(r103);
        String r104 = r103.getUserName();
        ProfileEditData r105 = this.__cardData;
        Intrinsics.checkNotNull(r105);
        __action_reportDirty(r100, r102, r104, r105.getAvatarUrl());
    }

    public void __action_onPageTap(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "event");
        Map r102 = TypeIntrinsics.asMutableMap(com.bytedance.rts.kmp.foundation.h.c(r101, PickerReporterConstants.KEY.TARGET, 0));
        Map r103 = TypeIntrinsics.asMutableMap(com.bytedance.rts.kmp.foundation.h.c(r101, "currentTarget", 0));
        if (r102 == null) goto L9;
        if (r103 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual((Double) com.bytedance.rts.kmp.foundation.h.b(r102), (Double) com.bytedance.rts.kmp.foundation.h.b(r103)) == false) goto L11;
        __action_hideKeyboard(r100);
        return;
    L11:
        return;
    }

    public void __action_onSave(final CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "_event");
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = r102.getDirty();
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        boolean r105 = r104.isEnterpriseAccount();
        ProfileEditData r106 = this.__cardData;
        Intrinsics.checkNotNull(r106);
        String r107 = r106.getNickName();
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        int r109 = r108.getUserNameStatus();
        ProfileEditData r110 = this.__cardData;
        Intrinsics.checkNotNull(r110);
        if (SrcProfileeditRxPageKt.canSubmitValues(r103, r105, r107, r109, r110.getSaving()) == true) goto L5;
        return;
    L5:
        ProfileEditData r111 = this.__cardData;
        Intrinsics.checkNotNull(r111);
        String r112 = SrcProfileeditRxPageKt.validateNickName(r111.getNickName());
        if (m.a(r112) <= 0) goto L9;
        __setData_13_0(r100, true, r112);
        return;
    L9:
        int r113 = this.__instance_requestSeq + 1;
        final String r114 = "save_" + r113;
        this.__instance_requestSeq = r113;
        this.__instance_pendingSaveRequest = r114;
        __setData_13_1(r100, true, "");
        ProfileEditData r115 = this.__cardData;
        Intrinsics.checkNotNull(r115);
        ProfileEditData r116 = this.__cardData;
        Intrinsics.checkNotNull(r116);
        ProfileEditData r117 = this.__cardData;
        Intrinsics.checkNotNull(r117);
        Object r118 = CardSession.f(r100, ProfileEditRelaxPage.METHOD_SAVE_PROFILE, i.b(new Object[]{r114, r115.getUserName(), r116.getNickName(), r117.getAvatarUrl()}), new a1(this, r100, r114), 16);
        if (r118 == null) goto L13;
        __action_applySaveResult(r100, r118, r114);
        return;
    }

    public void __action_onUserNameBlur(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "_event");
        __setData_10_0(r100, false);
    }

    public void __action_onUserNameFocus(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "_event");
        __setData_9_0(r100, true);
    }

    public void __action_onUserNameInput(CardSession r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "event");
        String r102 = SrcProfileeditRxPageKt.readEventString(r101, "value");
        __setData_6_0(r100, r102, "");
        ProfileEditData r103 = this.__cardData;
        Intrinsics.checkNotNull(r103);
        String r104 = r103.getNickName();
        ProfileEditData r105 = this.__cardData;
        Intrinsics.checkNotNull(r105);
        __action_reportDirty(r100, r104, r102, r105.getAvatarUrl());
        __action_checkUserNameAfterInput(r100, r102);
    }

    public boolean __applyPatch(Object r510, ArrayList<Long> r511) {
        Intrinsics.checkNotNullParameter(r510, "patch");
        Intrinsics.checkNotNullParameter(r511, "dirty");
        int r100 = g.f267235a;
        if (g.a.b(r510) == false) goto L193;
        ProfileEditData r101 = this.__cardData;
        Intrinsics.checkNotNull(r101);
        String r102 = r101.getUserId();
        ProfileEditData r103 = this.__cardData;
        Intrinsics.checkNotNull(r103);
        String r104 = r103.getNickName();
        ProfileEditData r105 = this.__cardData;
        Intrinsics.checkNotNull(r105);
        String r106 = r105.getUserName();
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        String r108 = r107.getAvatarUrl();
        ProfileEditData r109 = this.__cardData;
        Intrinsics.checkNotNull(r109);
        boolean r110 = r109.isDefaultAvatar();
        ProfileEditData r111 = this.__cardData;
        Intrinsics.checkNotNull(r111);
        boolean r112 = r111.isEnterpriseAccount();
        ProfileEditData r113 = this.__cardData;
        Intrinsics.checkNotNull(r113);
        String r114 = r113.getEnterpriseDisplayName();
        ProfileEditData r115 = this.__cardData;
        Intrinsics.checkNotNull(r115);
        String r116 = r115.getEnterFrom();
        ProfileEditData r117 = this.__cardData;
        Intrinsics.checkNotNull(r117);
        String r118 = r117.getScene();
        ProfileEditData r119 = this.__cardData;
        Intrinsics.checkNotNull(r119);
        String r120 = r119.getPlatform();
        ProfileEditData r121 = this.__cardData;
        Intrinsics.checkNotNull(r121);
        boolean r122 = r121.isOversea();
        ProfileEditData r123 = this.__cardData;
        Intrinsics.checkNotNull(r123);
        boolean r124 = r123.isDarkMode();
        ProfileEditData r125 = this.__cardData;
        Intrinsics.checkNotNull(r125);
        boolean r126 = r125.getAvatarEditable();
        ProfileEditData r127 = this.__cardData;
        Intrinsics.checkNotNull(r127);
        boolean r128 = r127.getDirty();
        ProfileEditData r129 = this.__cardData;
        Intrinsics.checkNotNull(r129);
        int r130 = r129.getUserNameStatus();
        ProfileEditData r131 = this.__cardData;
        Intrinsics.checkNotNull(r131);
        boolean r132 = r131.getNickNameFocused();
        ProfileEditData r133 = this.__cardData;
        Intrinsics.checkNotNull(r133);
        boolean r134 = r133.getUserNameFocused();
        ProfileEditData r135 = this.__cardData;
        Intrinsics.checkNotNull(r135);
        boolean r136 = r135.getShowNickNameError();
        ProfileEditData r137 = this.__cardData;
        Intrinsics.checkNotNull(r137);
        String r138 = r137.getNickNameError();
        ProfileEditData r139 = this.__cardData;
        Intrinsics.checkNotNull(r139);
        String r140 = r139.getUserNameError();
        ProfileEditData r141 = this.__cardData;
        Intrinsics.checkNotNull(r141);
        boolean r142 = r141.getSaving();
        ProfileEditData r143 = this.__cardData;
        Intrinsics.checkNotNull(r143);
        String r144 = r143.getSaveMessage();
        ArrayList r145 = g.a.c(r510);
        String r310 = r106;
        String r311 = r108;
        boolean r312 = r110;
        boolean r313 = r112;
        String r314 = r114;
        String r315 = r116;
        String r316 = r118;
        String r317 = r120;
        boolean r318 = r122;
        boolean r319 = r124;
        String r146 = r102;
        boolean r147 = r126;
        boolean r148 = r128;
        int r149 = r130;
        boolean r150 = r132;
        boolean r151 = r134;
        boolean r152 = r136;
        String r153 = r138;
        String r154 = r140;
        boolean r512 = r142;
        String r210 = r144;
        String r211 = r104;
        int r155 = 0;
        boolean r156 = false;
        boolean r157 = false;
        boolean r158 = false;
        boolean r212 = false;
        boolean r213 = false;
        boolean r214 = false;
        boolean r215 = false;
        boolean r216 = false;
        boolean r217 = false;
        boolean r218 = false;
        boolean r219 = false;
        boolean r410 = false;
        boolean r411 = false;
        boolean r412 = false;
        boolean r413 = false;
        boolean r414 = false;
        boolean r415 = false;
        boolean r416 = false;
        boolean r417 = false;
        boolean r418 = false;
        boolean r419 = false;
        boolean r513 = false;
    L5:
        IntCompanionObject r159 = IntCompanionObject.INSTANCE;
        String r514 = r154;
        Intrinsics.checkNotNullParameter(r145, "<this>");
        String r515 = r153;
        int r160 = r145.size();
        Intrinsics.checkNotNullParameter(r159, "<this>");
        if (r155 >= r160) goto L100;
        String r161 = (String) ListProtector.get(r145, r155);
        int r162 = g.f267235a;
        Object r163 = g.a.a(r510, r161);
        switch(r161.hashCode()) {
            case -1671059855: goto L95;
            case -1666750992: goto L91;
            case -1121153358: goto L87;
            case -909413638: goto L83;
            case -858429790: goto L79;
            case -836030906: goto L75;
            case -519460131: goto L71;
            case -428646058: goto L67;
            case -294225022: goto L63;
            case -266666762: goto L59;
            case -122721527: goto L55;
            case 6137992: goto L51;
            case 69737614: goto L47;
            case 95593426: goto L43;
            case 109254796: goto L39;
            case 316370458: goto L35;
            case 373769757: goto L31;
            case 947558787: goto L27;
            case 1396360609: goto L23;
            case 1645584330: goto L19;
            case 1874684019: goto L15;
            case 2035291212: goto L11;
            default: goto L98;
        };
    L98:
        r154 = r514;
        r153 = r515;
    L99:
        Unit r164 = Unit.INSTANCE;
        r155 = r155 + 1;
        goto L5
    L11:
        if (r161.equals("enterpriseDisplayName") == false) goto L98;
        r314 = g.a.f(r163, "$.enterpriseDisplayName");
        r154 = r514;
        r153 = r515;
        r215 = true;
        goto L99
    L15:
        if (r161.equals("platform") == false) goto L98;
        r317 = g.a.f(r163, "$.platform");
        r154 = r514;
        r153 = r515;
        r218 = true;
        goto L99
    L19:
        if (r161.equals("saveMessage") == false) goto L98;
        r210 = g.a.f(r163, "$.saveMessage");
        r154 = r514;
        r153 = r515;
        r513 = true;
        goto L99
    L23:
        if (r161.equals("userNameFocused") == false) goto L98;
        r151 = g.a.d(r163, "$.userNameFocused");
        r154 = r514;
        r153 = r515;
        r415 = true;
        goto L99
    L27:
        if (r161.equals("isDarkMode") == false) goto L98;
        r319 = g.a.d(r163, "$.isDarkMode");
        r154 = r514;
        r153 = r515;
        r410 = true;
        goto L99
    L31:
        if (r161.equals("showNickNameError") == false) goto L98;
        r152 = g.a.d(r163, "$.showNickNameError");
        r154 = r514;
        r153 = r515;
        r416 = true;
        goto L99
    L35:
        if (r161.equals("nickNameError") == false) goto L98;
        r153 = g.a.f(r163, "$.nickNameError");
        r154 = r514;
        r417 = true;
        goto L99
    L39:
        if (r161.equals("scene") == false) goto L98;
        r316 = g.a.f(r163, "$.scene");
        r154 = r514;
        r153 = r515;
        r217 = true;
        goto L99
    L43:
        if (r161.equals("dirty") == false) goto L98;
        r148 = g.a.d(r163, "$.dirty");
        r154 = r514;
        r153 = r515;
        r412 = true;
        goto L99
    L47:
        if (r161.equals("nickName") == false) goto L98;
        r211 = g.a.f(r163, "$.nickName");
        r154 = r514;
        r153 = r515;
        r157 = true;
        goto L99
    L51:
        if (r161.equals("userNameStatus") == false) goto L98;
        r149 = g.a.e(r163);
        r154 = r514;
        r153 = r515;
        r413 = true;
        goto L99
    L55:
        if (r161.equals("nickNameFocused") == false) goto L98;
        r150 = g.a.d(r163, "$.nickNameFocused");
        r154 = r514;
        r153 = r515;
        r414 = true;
        goto L99
    L59:
        if (r161.equals("userName") == false) goto L98;
        r310 = g.a.f(r163, "$.userName");
        r154 = r514;
        r153 = r515;
        r158 = true;
        goto L99
    L63:
        if (r161.equals("isEnterpriseAccount") == false) goto L98;
        r313 = g.a.d(r163, "$.isEnterpriseAccount");
        r154 = r514;
        r153 = r515;
        r214 = true;
        goto L99
    L67:
        if (r161.equals("avatarUrl") == false) goto L98;
        r311 = g.a.f(r163, "$.avatarUrl");
        r154 = r514;
        r153 = r515;
        r212 = true;
        goto L99
    L71:
        if (r161.equals("avatarEditable") == false) goto L98;
        r147 = g.a.d(r163, "$.avatarEditable");
        r154 = r514;
        r153 = r515;
        r411 = true;
        goto L99
    L75:
        if (r161.equals("userId") == false) goto L98;
        r146 = g.a.f(r163, "$.userId");
        r154 = r514;
        r153 = r515;
        r156 = true;
        goto L99
    L79:
        if (r161.equals("enterFrom") == false) goto L98;
        r315 = g.a.f(r163, "$.enterFrom");
        r154 = r514;
        r153 = r515;
        r216 = true;
        goto L99
    L83:
        if (r161.equals("saving") == false) goto L98;
        r512 = g.a.d(r163, "$.saving");
        r154 = r514;
        r153 = r515;
        r419 = true;
        goto L99
    L87:
        if (r161.equals("userNameError") == false) goto L98;
        r154 = g.a.f(r163, "$.userNameError");
        r153 = r515;
        r418 = true;
        goto L99
    L91:
        if (r161.equals("isDefaultAvatar") == false) goto L98;
        r312 = g.a.d(r163, "$.isDefaultAvatar");
        r154 = r514;
        r153 = r515;
        r213 = true;
        goto L99
    L95:
        if (r161.equals("isOversea") == false) goto L98;
        r318 = g.a.d(r163, "$.isOversea");
        r154 = r514;
        r153 = r515;
        r219 = true;
        goto L99
    L100:
        Unit r165 = Unit.INSTANCE;
        if (r156 == false) goto L105;
        ProfileEditData r166 = this.__cardData;
        Intrinsics.checkNotNull(r166);
        if (Intrinsics.areEqual(r166.getUserId(), r146) == true) goto L105;
        ProfileEditData r167 = this.__cardData;
        Intrinsics.checkNotNull(r167);
        r167.setUserId(r146);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 1));
        boolean r168 = true;
    L106:
        if (r157 == false) goto L110;
        ProfileEditData r169 = this.__cardData;
        Intrinsics.checkNotNull(r169);
        String r170 = r211;
        if (Intrinsics.areEqual(r169.getNickName(), r170) == true) goto L110;
        ProfileEditData r171 = this.__cardData;
        Intrinsics.checkNotNull(r171);
        r171.setNickName(r170);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 2));
        r168 = true;
    L110:
        if (r158 == false) goto L114;
        ProfileEditData r172 = this.__cardData;
        Intrinsics.checkNotNull(r172);
        String r173 = r310;
        if (Intrinsics.areEqual(r172.getUserName(), r173) == true) goto L114;
        ProfileEditData r174 = this.__cardData;
        Intrinsics.checkNotNull(r174);
        r174.setUserName(r173);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 4));
        r168 = true;
    L114:
        if (r212 == false) goto L118;
        ProfileEditData r175 = this.__cardData;
        Intrinsics.checkNotNull(r175);
        String r176 = r311;
        if (Intrinsics.areEqual(r175.getAvatarUrl(), r176) == true) goto L118;
        ProfileEditData r177 = this.__cardData;
        Intrinsics.checkNotNull(r177);
        r177.setAvatarUrl(r176);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 8));
        r168 = true;
    L118:
        if (r213 == false) goto L122;
        ProfileEditData r178 = this.__cardData;
        Intrinsics.checkNotNull(r178);
        boolean r179 = r312;
        if (r178.isDefaultAvatar() == r179) goto L122;
        ProfileEditData r180 = this.__cardData;
        Intrinsics.checkNotNull(r180);
        r180.setDefaultAvatar(r179);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 16));
        r168 = true;
    L122:
        if (r214 == false) goto L126;
        ProfileEditData r181 = this.__cardData;
        Intrinsics.checkNotNull(r181);
        boolean r182 = r313;
        if (r181.isEnterpriseAccount() == r182) goto L126;
        ProfileEditData r183 = this.__cardData;
        Intrinsics.checkNotNull(r183);
        r183.setEnterpriseAccount(r182);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 32));
        r168 = true;
    L126:
        if (r215 == false) goto L130;
        ProfileEditData r184 = this.__cardData;
        Intrinsics.checkNotNull(r184);
        String r185 = r314;
        if (Intrinsics.areEqual(r184.getEnterpriseDisplayName(), r185) == true) goto L130;
        ProfileEditData r186 = this.__cardData;
        Intrinsics.checkNotNull(r186);
        r186.setEnterpriseDisplayName(r185);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 64));
        r168 = true;
    L130:
        if (r216 == false) goto L134;
        ProfileEditData r187 = this.__cardData;
        Intrinsics.checkNotNull(r187);
        String r188 = r315;
        if (Intrinsics.areEqual(r187.getEnterFrom(), r188) == true) goto L134;
        ProfileEditData r189 = this.__cardData;
        Intrinsics.checkNotNull(r189);
        r189.setEnterFrom(r188);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 128));
        r168 = true;
    L134:
        if (r217 == false) goto L138;
        ProfileEditData r190 = this.__cardData;
        Intrinsics.checkNotNull(r190);
        String r191 = r316;
        if (Intrinsics.areEqual(r190.getScene(), r191) == true) goto L138;
        ProfileEditData r192 = this.__cardData;
        Intrinsics.checkNotNull(r192);
        r192.setScene(r191);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 256));
        r168 = true;
    L138:
        if (r218 == false) goto L142;
        ProfileEditData r193 = this.__cardData;
        Intrinsics.checkNotNull(r193);
        String r194 = r317;
        if (Intrinsics.areEqual(r193.getPlatform(), r194) == true) goto L142;
        ProfileEditData r195 = this.__cardData;
        Intrinsics.checkNotNull(r195);
        r195.setPlatform(r194);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 512));
        r168 = true;
    L142:
        if (r219 == false) goto L146;
        ProfileEditData r196 = this.__cardData;
        Intrinsics.checkNotNull(r196);
        boolean r197 = r318;
        if (r196.isOversea() == r197) goto L146;
        ProfileEditData r198 = this.__cardData;
        Intrinsics.checkNotNull(r198);
        r198.setOversea(r197);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 1024));
        r168 = true;
    L146:
        if (r410 == false) goto L150;
        ProfileEditData r199 = this.__cardData;
        Intrinsics.checkNotNull(r199);
        boolean r1100 = r319;
        if (r199.isDarkMode() == r1100) goto L150;
        ProfileEditData r200 = this.__cardData;
        Intrinsics.checkNotNull(r200);
        r200.setDarkMode(r1100);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 2048));
        r168 = true;
    L150:
        if (r411 == false) goto L154;
        ProfileEditData r201 = this.__cardData;
        Intrinsics.checkNotNull(r201);
        if (r201.getAvatarEditable() == r147) goto L154;
        ProfileEditData r202 = this.__cardData;
        Intrinsics.checkNotNull(r202);
        r202.setAvatarEditable(r147);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 4096));
        r168 = true;
    L154:
        if (r412 == false) goto L158;
        ProfileEditData r203 = this.__cardData;
        Intrinsics.checkNotNull(r203);
        if (r203.getDirty() == r148) goto L158;
        ProfileEditData r204 = this.__cardData;
        Intrinsics.checkNotNull(r204);
        r204.setDirty(r148);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | PlaybackStateCompat.ACTION_PLAY_FROM_URI));
        r168 = true;
    L158:
        if (r413 == false) goto L162;
        ProfileEditData r205 = this.__cardData;
        Intrinsics.checkNotNull(r205);
        if (r205.getUserNameStatus() == r149) goto L162;
        ProfileEditData r206 = this.__cardData;
        Intrinsics.checkNotNull(r206);
        r206.setUserNameStatus(r149);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 16384));
        r168 = true;
    L162:
        if (r414 == false) goto L166;
        ProfileEditData r207 = this.__cardData;
        Intrinsics.checkNotNull(r207);
        if (r207.getNickNameFocused() == r150) goto L166;
        ProfileEditData r208 = this.__cardData;
        Intrinsics.checkNotNull(r208);
        r208.setNickNameFocused(r150);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID));
        r168 = true;
    L166:
        if (r415 == false) goto L170;
        ProfileEditData r209 = this.__cardData;
        Intrinsics.checkNotNull(r209);
        if (r209.getUserNameFocused() == r151) goto L170;
        ProfileEditData r220 = this.__cardData;
        Intrinsics.checkNotNull(r220);
        r220.setUserNameFocused(r151);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH));
        r168 = true;
    L170:
        if (r416 == false) goto L174;
        ProfileEditData r221 = this.__cardData;
        Intrinsics.checkNotNull(r221);
        if (r221.getShowNickNameError() == r152) goto L174;
        ProfileEditData r222 = this.__cardData;
        Intrinsics.checkNotNull(r222);
        r222.setShowNickNameError(r152);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | PlaybackStateCompat.ACTION_PREPARE_FROM_URI));
        r168 = true;
    L174:
        if (r417 == false) goto L178;
        ProfileEditData r223 = this.__cardData;
        Intrinsics.checkNotNull(r223);
        if (Intrinsics.areEqual(r223.getNickNameError(), r515) == true) goto L178;
        ProfileEditData r224 = this.__cardData;
        Intrinsics.checkNotNull(r224);
        r224.setNickNameError(r515);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | PlaybackStateCompat.ACTION_SET_REPEAT_MODE));
        r168 = true;
    L178:
        if (r418 == false) goto L182;
        ProfileEditData r225 = this.__cardData;
        Intrinsics.checkNotNull(r225);
        if (Intrinsics.areEqual(r225.getUserNameError(), r514) == true) goto L182;
        ProfileEditData r226 = this.__cardData;
        Intrinsics.checkNotNull(r226);
        r226.setUserNameError(r514);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED));
        r168 = true;
    L182:
        if (r419 == false) goto L186;
        ProfileEditData r227 = this.__cardData;
        Intrinsics.checkNotNull(r227);
        boolean r228 = r512;
        if (r227.getSaving() == r228) goto L186;
        ProfileEditData r229 = this.__cardData;
        Intrinsics.checkNotNull(r229);
        r229.setSaving(r228);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 1048576));
        r168 = true;
    L186:
        if (r513 == false) goto L191;
        ProfileEditData r230 = this.__cardData;
        Intrinsics.checkNotNull(r230);
        String r231 = r210;
        if (Intrinsics.areEqual(r230.getSaveMessage(), r231) == true) goto L191;
        ProfileEditData r232 = this.__cardData;
        Intrinsics.checkNotNull(r232);
        r232.setSaveMessage(r231);
        ListProtector.set(r511, 0, Long.valueOf(((Number) ListProtector.get(r511, 0)).longValue() | 2097152));
        return true;
    L191:
        return r168;
    L105:
        r168 = false;
        goto L106
    L193:
        throw new Throwable("[TTML Static] Expected Card patch object at $.");
    }

    public boolean __helper_showNickNameErrorView(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "nickNameError");
        if (r100 == false) goto L7;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101.length() <= 0) goto L7;
        return true;
    L7:
        return false;
    }

    public void __initialRender(final CardSession r210, Object r211) {
        Intrinsics.checkNotNullParameter(r210, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r211, "data");
        this.__scopeId = r210.f267193a.f267238c;
        this.__cardData = __initialDecode(r211);
        __action_onLoad(r210);
        long r100 = r210.f267193a.e(this.__scopeId);
        this.__node_0 = r100;
        h r101 = r210.f267193a;
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        if (r102.isDarkMode() == false) goto L5;
        String r103 = "34 4";
    L6:
        r101.n(r100, r103);
        Function1<Object, Unit> r104 = d.d(new j0(r210, this));
        r210.f267193a.a(this.__node_0, "tap", r104);
        h r105 = r210.f267193a;
        r105.b(r105.f267237b, this.__node_0);
        long r106 = r210.f267193a.e(this.__scopeId);
        this.__node_1 = r106;
        r210.f267193a.n(r106, "54 50 40 20");
        r210.f267193a.b(this.__node_0, this.__node_1);
        long r107 = r210.f267193a.e(this.__scopeId);
        this.__node_2 = r107;
        r210.f267193a.n(r107, "5 16 31 47");
        Function1<Object, Unit> r108 = d.d(new q0(r210, this));
        r210.f267193a.a(this.__node_2, "tap", r108);
        r210.f267193a.b(this.__node_1, this.__node_2);
        long r109 = r210.f267193a.d(this.__scopeId);
        this.__node_3 = r109;
        h r110 = r210.f267193a;
        ProfileEditData r111 = this.__cardData;
        Intrinsics.checkNotNull(r111);
        if (r111.isDarkMode() == false) goto L9;
        String r112 = "28 11 19 64";
    L10:
        r110.n(r109, r112);
        r210.f267193a.b(this.__node_2, this.__node_3);
        h r113 = r210.f267193a;
        long r114 = this.__node_3;
        ProfileEditData r115 = this.__cardData;
        Intrinsics.checkNotNull(r115);
        r113.o(r114, __helper_displayCancel(r115.isOversea()));
        long r116 = r210.f267193a.e(this.__scopeId);
        this.__node_4 = r116;
        r210.f267193a.n(r116, "31 47 50 40 6 61");
        r210.f267193a.b(this.__node_1, this.__node_4);
        long r117 = r210.f267193a.d(this.__scopeId);
        this.__node_5 = r117;
        h r118 = r210.f267193a;
        ProfileEditData r119 = this.__cardData;
        Intrinsics.checkNotNull(r119);
        if (Intrinsics.areEqual(r119.getScene(), "account") == false) goto L16;
        ProfileEditData r120 = this.__cardData;
        Intrinsics.checkNotNull(r120);
        if (r120.isDarkMode() == false) goto L15;
        String r121 = "10 11 19 36 64";
    L20:
        r118.n(r117, r121);
        r210.f267193a.b(this.__node_4, this.__node_5);
        h r122 = r210.f267193a;
        long r123 = this.__node_5;
        ProfileEditData r124 = this.__cardData;
        Intrinsics.checkNotNull(r124);
        r122.o(r123, __helper_displayTitle(r124.isOversea()));
        long r125 = r210.f267193a.e(this.__scopeId);
        this.__node_6 = r125;
        r210.f267193a.n(r125, "5 16 31 47");
        Function1<Object, Unit> r126 = d.d(new r0(r210, this));
        r210.f267193a.a(this.__node_6, "tap", r126);
        r210.f267193a.b(this.__node_1, this.__node_6);
        long r127 = r210.f267193a.d(this.__scopeId);
        this.__node_7 = r127;
        h r128 = r210.f267193a;
        ProfileEditData r129 = this.__cardData;
        Intrinsics.checkNotNull(r129);
        boolean r130 = r129.getDirty();
        ProfileEditData r131 = this.__cardData;
        Intrinsics.checkNotNull(r131);
        String r132 = r131.getNickName();
        ProfileEditData r133 = this.__cardData;
        Intrinsics.checkNotNull(r133);
        boolean r134 = r133.isEnterpriseAccount();
        ProfileEditData r135 = this.__cardData;
        Intrinsics.checkNotNull(r135);
        boolean r136 = r135.getSaving();
        ProfileEditData r137 = this.__cardData;
        Intrinsics.checkNotNull(r137);
        if (__helper_canSubmit(r130, r132, r134, r136, r137.getUserNameStatus()) == false) goto L26;
        ProfileEditData r138 = this.__cardData;
        Intrinsics.checkNotNull(r138);
        if (r138.isDarkMode() == false) goto L25;
        String r139 = "28 11 19 39";
    L30:
        r128.n(r127, r139);
        r210.f267193a.b(this.__node_6, this.__node_7);
        h r140 = r210.f267193a;
        long r141 = this.__node_7;
        ProfileEditData r142 = this.__cardData;
        Intrinsics.checkNotNull(r142);
        r140.o(r141, __helper_displayDone(r142.isOversea()));
        long r143 = r210.f267193a.c("profile-avatar", this.__scopeId);
        this.__node_8 = r143;
        h r144 = r210.f267193a;
        ProfileEditData r145 = this.__cardData;
        Intrinsics.checkNotNull(r145);
        String r146 = r145.getAvatarUrl();
        Intrinsics.checkNotNull(r146, "null cannot be cast to non-null type kotlin.Any");
        r144.l(r143, "avatarUrl", r146);
        h r147 = r210.f267193a;
        long r148 = this.__node_8;
        ProfileEditData r149 = this.__cardData;
        Intrinsics.checkNotNull(r149);
        r147.l(r148, "isDefaultAvatar", Boolean.valueOf(r149.isDefaultAvatar()));
        h r150 = r210.f267193a;
        long r151 = this.__node_8;
        ProfileEditData r152 = this.__cardData;
        Intrinsics.checkNotNull(r152);
        if (r152.getAvatarEditable() == false) goto L35;
        ProfileEditData r153 = this.__cardData;
        Intrinsics.checkNotNull(r153);
        if (r153.isEnterpriseAccount() == true) goto L35;
        boolean r154 = true;
    L36:
        r150.l(r151, "editable", Boolean.valueOf(r154));
        h r155 = r210.f267193a;
        long r156 = this.__node_8;
        ProfileEditData r157 = this.__cardData;
        Intrinsics.checkNotNull(r157);
        String r158 = r157.getEnterFrom();
        Intrinsics.checkNotNull(r158, "null cannot be cast to non-null type kotlin.Any");
        r155.l(r156, "enterFrom", r158);
        r210.f267193a.l(this.__node_8, "avatarSize", 110);
        r210.f267193a.l(this.__node_8, "iconSize", 32);
        r210.f267193a.n(this.__node_8, "62 38 48 22");
        Function1<Object, Unit> r159 = d.d(new s0(r210, this));
        r210.f267193a.a(this.__node_8, "tap", r159);
        Function1<Object, Unit> r160 = d.d(new t0(r210, this));
        r210.f267193a.a(this.__node_8, "avatar_changed", r160);
        r210.f267193a.b(this.__node_0, this.__node_8);
        long r161 = r210.f267193a.d(this.__scopeId);
        this.__node_9 = r161;
        h r162 = r210.f267193a;
        ProfileEditData r163 = this.__cardData;
        Intrinsics.checkNotNull(r163);
        if (r163.isDarkMode() == false) goto L39;
        String r164 = "58 46 12 28 11 19 64";
    L40:
        r162.n(r161, r164);
        r210.f267193a.b(this.__node_0, this.__node_9);
        h r165 = r210.f267193a;
        long r166 = this.__node_9;
        ProfileEditData r167 = this.__cardData;
        Intrinsics.checkNotNull(r167);
        r165.o(r166, __helper_displayNickNameLabel(r167.isOversea()));
        long r168 = r210.f267193a.e(this.__scopeId);
        this.__node_10 = r168;
        h r169 = r210.f267193a;
        ProfileEditData r170 = this.__cardData;
        Intrinsics.checkNotNull(r170);
        if (r170.isDarkMode() == false) goto L43;
        String r171 = "18 43 8 57 7 50 40 20 59";
    L44:
        r169.n(r168, r171);
        Function1<Object, Unit> r172 = d.d(new u0(r210, this));
        r210.f267193a.a(this.__node_10, "tap", r172);
        r210.f267193a.b(this.__node_0, this.__node_10);
        long r173 = r210.f267193a.c("x-input-ng", this.__scopeId);
        this.__node_11 = r173;
        r210.f267193a.m(r173, "id", "profile-edit-nickname");
        r210.f267193a.m(this.__node_11, "type", "text");
        r210.f267193a.m(this.__node_11, "confirm-type", TeaEventTrack.ACTION_DRAMA_NEXT);
        r210.f267193a.l(this.__node_11, "maxlength", 40);
        h r174 = r210.f267193a;
        long r175 = this.__node_11;
        ProfileEditData r176 = this.__cardData;
        Intrinsics.checkNotNull(r176);
        r174.l(r175, "disabled", Boolean.valueOf(r176.isEnterpriseAccount()));
        h r177 = r210.f267193a;
        long r178 = this.__node_11;
        ProfileEditData r179 = this.__cardData;
        Intrinsics.checkNotNull(r179);
        r177.l(r178, ButtonColorBean.StateFocus, Boolean.valueOf(r179.getNickNameFocused()));
        h r180 = r210.f267193a;
        long r181 = this.__node_11;
        ProfileEditData r182 = this.__cardData;
        Intrinsics.checkNotNull(r182);
        String r183 = r182.getNickName();
        Intrinsics.checkNotNull(r183, "null cannot be cast to non-null type kotlin.Any");
        r180.l(r181, "default-value", r183);
        r210.f267193a.m(this.__node_11, GXTemplateKey.GAIAX_PLACEHOLDER, "输入昵称，2-40 个字符");
        h r184 = r210.f267193a;
        long r185 = this.__node_11;
        ProfileEditData r186 = this.__cardData;
        Intrinsics.checkNotNull(r186);
        r184.l(r185, "placeholder-color", Long.valueOf(__helper_neutral50ArgbColor(r186.isDarkMode())));
        h r187 = r210.f267193a;
        long r188 = this.__node_11;
        ProfileEditData r189 = this.__cardData;
        Intrinsics.checkNotNull(r189);
        if (r189.isDarkMode() == false) goto L47;
        String r190 = "7 6 28 45 64 2";
    L48:
        r187.n(r188, r190);
        Function1<Object, Unit> r191 = d.d(new v0(r210, this));
        r210.f267193a.a(this.__node_11, "input", r191);
        Function1<Object, Unit> r192 = d.d(new x0(r210, this));
        r210.f267193a.a(this.__node_11, ButtonColorBean.StateFocus, r192);
        Function1<Object, Unit> r193 = d.d(new y0(r210, this));
        r210.f267193a.a(this.__node_11, "blur", r193);
        r210.f267193a.b(this.__node_10, this.__node_11);
        long r194 = r210.f267193a.f(this.__scopeId);
        this.__condition_wrapper_0 = r194;
        r210.f267193a.b(this.__node_10, r194);
        this.__condition_branch_0 = -1;
        ProfileEditData r195 = this.__cardData;
        Intrinsics.checkNotNull(r195);
        String r196 = r195.getNickName();
        ProfileEditData r197 = this.__cardData;
        Intrinsics.checkNotNull(r197);
        boolean r198 = r197.getNickNameFocused();
        ProfileEditData r199 = this.__cardData;
        Intrinsics.checkNotNull(r199);
        if (__helper_showNickNameClear(r196, r198, r199.isEnterpriseAccount()) == false) goto L51;
        this.__condition_branch_0 = 0;
    L52:
        int r200 = this.__condition_branch_0;
        if (r200 != 0) goto L55;
        String r212 = "disabled";
        String r213 = "maxlength";
        long r201 = r210.f267193a.e(this.__scopeId);
        this.__node_12 = r201;
        h r202 = r210.f267193a;
        String r214 = ButtonColorBean.StateFocus;
        String r215 = "confirm-type";
        r202.l(r201, "ignore-focus", Boolean.TRUE);
        String r203 = "text";
        r210.f267193a.n(this.__node_12, "24 7 50 40 61 20");
        Function1<Object, Unit> r204 = d.d(new z0(r210, this));
        r210.f267193a.a(this.__node_12, LynxTouchEvent.EVENT_TOUCH_START, r204);
        String r216 = "24 7 50 40 61 20";
        r210.f267193a.b(this.__condition_wrapper_0, this.__node_12);
        long r205 = r210.f267193a.c("svg", this.__scopeId);
        this.__node_13 = r205;
        r210.f267193a.n(r205, "35 17");
        r210.f267193a.l(this.__node_13, "content", "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"20\" height=\"20\" viewBox=\"0 0 20 20\"><path d=\"M10,0C4.477,0 0,4.477 0,10C0,15.523 4.477,20 10,20C15.523,20 20,15.523 20,10C20,4.477 15.523,0 10,0ZM12.121,6.464C12.512,6.074 13.145,6.074 13.535,6.464C13.926,6.855 13.926,7.488 13.535,7.879L11.414,10L13.535,12.121C13.926,12.512 13.926,13.145 13.535,13.536C13.145,13.926 12.512,13.926 12.121,13.536L10,11.414L7.879,13.536C7.488,13.926 6.855,13.926 6.464,13.536C6.074,13.145 6.074,12.512 6.464,12.121L8.586,10L6.464,7.879C6.074,7.488 6.074,6.855 6.464,6.464C6.855,6.074 7.488,6.074 7.879,6.464L10,8.586L12.121,6.464Z\" fill=\"#CCCCCC\"/></svg>");
        r210.f267193a.b(this.__node_12, this.__node_13);
    L58:
        long r206 = r210.f267193a.e(this.__scopeId);
        this.__node_15 = r206;
        r210.f267193a.n(r206, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        r210.f267193a.b(this.__node_0, this.__node_15);
        long r207 = r210.f267193a.f(this.__scopeId);
        this.__condition_wrapper_1 = r207;
        r210.f267193a.b(this.__node_15, r207);
        this.__condition_branch_1 = -1;
        ProfileEditData r208 = this.__cardData;
        Intrinsics.checkNotNull(r208);
        boolean r209 = r208.getShowNickNameError();
        ProfileEditData r217 = this.__cardData;
        Intrinsics.checkNotNull(r217);
        if (__helper_showNickNameErrorView(r209, r217.getNickNameError()) == false) goto L62;
        this.__condition_branch_1 = 0;
    L62:
        if (this.__condition_branch_1 != 0) goto L64;
        long r218 = r210.f267193a.e(this.__scopeId);
        this.__node_16 = r218;
        r210.f267193a.n(r218, "58 44 14 50 40 20");
        r210.f267193a.b(this.__condition_wrapper_1, this.__node_16);
        long r219 = r210.f267193a.c("svg", this.__scopeId);
        this.__node_17 = r219;
        r210.f267193a.n(r219, "3 63 13");
        r210.f267193a.l(this.__node_17, "content", "<svg height=\"13\" viewBox=\"0 0 14 13\" width=\"14\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M7,12.835C6.154,12.835 5.358,12.672 4.613,12.346C3.873,12.024 3.219,11.58 2.652,11.013C2.085,10.446 1.638,9.792 1.313,9.051C0.991,8.306 0.83,7.511 0.83,6.665C0.83,5.822 0.991,5.029 1.313,4.284C1.634,3.539 2.078,2.883 2.646,2.316C3.217,1.749 3.873,1.305 4.613,0.983C5.358,0.662 6.152,0.501 6.994,0.501C7.836,0.501 8.629,0.662 9.374,0.983C10.119,1.305 10.775,1.749 11.342,2.316C11.909,2.883 12.353,3.539 12.675,4.284C13.001,5.029 13.164,5.822 13.164,6.665C13.164,7.511 13.003,8.306 12.681,9.051C12.359,9.792 11.915,10.446 11.348,11.013C10.781,11.58 10.125,12.024 9.38,12.346C8.636,12.672 7.842,12.835 7,12.835ZM7,11.705C7.698,11.705 8.352,11.573 8.961,11.311C9.571,11.053 10.106,10.693 10.567,10.232C11.029,9.771 11.388,9.235 11.646,8.626C11.905,8.017 12.034,7.363 12.034,6.665C12.034,5.966 11.905,5.313 11.646,4.703C11.388,4.094 11.029,3.558 10.567,3.097C10.106,2.636 9.569,2.276 8.955,2.018C8.346,1.76 7.692,1.631 6.994,1.631C6.295,1.631 5.642,1.76 5.032,2.018C4.427,2.276 3.894,2.636 3.433,3.097C2.971,3.558 2.612,4.094 2.354,4.703C2.095,5.313 1.966,5.966 1.966,6.665C1.966,7.363 2.095,8.017 2.354,8.626C2.612,9.235 2.971,9.771 3.433,10.232C3.894,10.693 4.429,11.053 5.039,11.311C5.648,11.573 6.302,11.705 7,11.705ZM6.994,7.706C6.664,7.706 6.494,7.538 6.486,7.204L6.403,4.164C6.399,3.994 6.452,3.857 6.562,3.751C6.672,3.645 6.814,3.592 6.987,3.592C7.157,3.592 7.298,3.647 7.413,3.757C7.527,3.863 7.582,4.001 7.578,4.17L7.489,7.204C7.48,7.538 7.315,7.706 6.994,7.706ZM6.994,9.673C6.812,9.673 6.653,9.612 6.518,9.489C6.386,9.362 6.321,9.21 6.321,9.032C6.321,8.854 6.386,8.704 6.518,8.582C6.649,8.455 6.807,8.391 6.994,8.391C7.18,8.391 7.339,8.452 7.47,8.575C7.605,8.698 7.673,8.85 7.673,9.032C7.673,9.214 7.605,9.367 7.47,9.489C7.339,9.612 7.18,9.673 6.994,9.673Z\" fill=\"#ff3b30\"/></svg>");
        r210.f267193a.b(this.__node_16, this.__node_17);
        long r220 = r210.f267193a.d(this.__scopeId);
        this.__node_18 = r220;
        r210.f267193a.n(r220, "6 29 0 19 9");
        r210.f267193a.b(this.__node_16, this.__node_18);
        h r221 = r210.f267193a;
        long r222 = this.__node_18;
        ProfileEditData r223 = this.__cardData;
        Intrinsics.checkNotNull(r223);
        r221.o(r222, r223.getNickNameError());
    L64:
        long r224 = r210.f267193a.d(this.__scopeId);
        this.__node_19 = r224;
        h r225 = r210.f267193a;
        ProfileEditData r226 = this.__cardData;
        Intrinsics.checkNotNull(r226);
        if (r226.isDarkMode() == false) goto L67;
        String r227 = "58 12 28 11 19 64";
    L68:
        r225.n(r224, r227);
        r210.f267193a.b(this.__node_0, this.__node_19);
        h r228 = r210.f267193a;
        long r229 = this.__node_19;
        ProfileEditData r230 = this.__cardData;
        Intrinsics.checkNotNull(r230);
        boolean r231 = r230.isOversea();
        ProfileEditData r1100 = this.__cardData;
        Intrinsics.checkNotNull(r1100);
        r228.o(r229, __helper_displayUserNameLabel(r231, r1100.isEnterpriseAccount()));
        long r232 = r210.f267193a.e(this.__scopeId);
        this.__node_20 = r232;
        h r233 = r210.f267193a;
        ProfileEditData r234 = this.__cardData;
        Intrinsics.checkNotNull(r234);
        if (r234.isDarkMode() == false) goto L71;
        String r235 = "18 43 8 57 7 50 40 20 59";
    L72:
        r233.n(r232, r235);
        Function1<Object, Unit> r236 = d.d(new k0(r210, this));
        r210.f267193a.a(this.__node_20, "tap", r236);
        r210.f267193a.b(this.__node_0, this.__node_20);
        long r237 = r210.f267193a.c("x-input-ng", this.__scopeId);
        this.__node_21 = r237;
        r210.f267193a.m(r237, "id", "profile-edit-username");
        r210.f267193a.m(this.__node_21, "type", r203);
        r210.f267193a.m(this.__node_21, r215, "done");
        r210.f267193a.l(this.__node_21, r213, 16);
        h r238 = r210.f267193a;
        long r239 = this.__node_21;
        ProfileEditData r240 = this.__cardData;
        Intrinsics.checkNotNull(r240);
        String r241 = r212;
        r238.l(r239, r241, Boolean.valueOf(r240.isEnterpriseAccount()));
        h r242 = r210.f267193a;
        long r243 = this.__node_21;
        ProfileEditData r244 = this.__cardData;
        Intrinsics.checkNotNull(r244);
        String r245 = r214;
        r242.l(r243, r245, Boolean.valueOf(r244.getUserNameFocused()));
        h r246 = r210.f267193a;
        long r247 = this.__node_21;
        ProfileEditData r248 = this.__cardData;
        Intrinsics.checkNotNull(r248);
        boolean r249 = r248.isEnterpriseAccount();
        ProfileEditData r250 = this.__cardData;
        Intrinsics.checkNotNull(r250);
        String r251 = r250.getEnterpriseDisplayName();
        ProfileEditData r1101 = this.__cardData;
        Intrinsics.checkNotNull(r1101);
        String r252 = __helper_displayUserNameValue(r249, r251, r1101.getUserName());
        Intrinsics.checkNotNull(r252, "null cannot be cast to non-null type kotlin.Any");
        r246.l(r247, "default-value", r252);
        h r253 = r210.f267193a;
        long r254 = this.__node_21;
        ProfileEditData r255 = this.__cardData;
        Intrinsics.checkNotNull(r255);
        String r256 = __helper_displayUserNamePlaceholder(r255.isOversea());
        Intrinsics.checkNotNull(r256, "null cannot be cast to non-null type kotlin.Any");
        r253.l(r254, GXTemplateKey.GAIAX_PLACEHOLDER, r256);
        h r257 = r210.f267193a;
        long r258 = this.__node_21;
        ProfileEditData r259 = this.__cardData;
        Intrinsics.checkNotNull(r259);
        r257.l(r258, "placeholder-color", Long.valueOf(__helper_neutral50ArgbColor(r259.isDarkMode())));
        h r260 = r210.f267193a;
        long r261 = this.__node_21;
        ProfileEditData r262 = this.__cardData;
        Intrinsics.checkNotNull(r262);
        if (r262.isDarkMode() == false) goto L75;
        String r263 = "7 6 28 45 64 2";
    L76:
        r260.n(r261, r263);
        Function1<Object, Unit> r264 = d.d(new m0(r210, this));
        r210.f267193a.a(this.__node_21, "input", r264);
        Function1<Object, Unit> r265 = d.d(new n0(r210, this));
        r210.f267193a.a(this.__node_21, r245, r265);
        Function1<Object, Unit> r266 = d.d(new o0(r210, this));
        r210.f267193a.a(this.__node_21, "blur", r266);
        r210.f267193a.b(this.__node_20, this.__node_21);
        long r267 = r210.f267193a.f(this.__scopeId);
        this.__condition_wrapper_2 = r267;
        r210.f267193a.b(this.__node_20, r267);
        this.__condition_branch_2 = -1;
        ProfileEditData r268 = this.__cardData;
        Intrinsics.checkNotNull(r268);
        if (r268.getUserNameStatus() != 2) goto L79;
        this.__condition_branch_2 = 0;
    L86:
        int r269 = this.__condition_branch_2;
        if (r269 != 0) goto L93;
        long r270 = r210.f267193a.e(this.__scopeId);
        this.__node_22 = r270;
        r210.f267193a.n(r270, r216);
        r210.f267193a.b(this.__condition_wrapper_2, this.__node_22);
        long r271 = r210.f267193a.e(this.__scopeId);
        this.__node_23 = r271;
        h r272 = r210.f267193a;
        ProfileEditData r273 = this.__cardData;
        Intrinsics.checkNotNull(r273);
        if (r273.isDarkMode() == false) goto L91;
        String r274 = "35 17 65 1 37 42 15";
    L92:
        r272.n(r271, r274);
        r210.f267193a.b(this.__node_22, this.__node_23);
    L100:
        long r275 = r210.f267193a.f(this.__scopeId);
        this.__condition_wrapper_3 = r275;
        r210.f267193a.b(this.__node_0, r275);
        this.__condition_branch_3 = -1;
        ProfileEditData r276 = this.__cardData;
        Intrinsics.checkNotNull(r276);
        if (r276.isEnterpriseAccount() == false) goto L103;
        this.__condition_branch_3 = 0;
    L107:
        int r277 = this.__condition_branch_3;
        if (r277 != 0) goto L111;
        long r278 = r210.f267193a.e(this.__scopeId);
        this.__node_29 = r278;
        r210.f267193a.b(this.__condition_wrapper_3, r278);
    L119:
        long r279 = r210.f267193a.f(this.__scopeId);
        this.__condition_wrapper_4 = r279;
        r210.f267193a.b(this.__node_0, r279);
        this.__condition_branch_4 = -1;
        ProfileEditData r280 = this.__cardData;
        Intrinsics.checkNotNull(r280);
        if (m.a(r280.getSaveMessage()) <= 0) goto L123;
        this.__condition_branch_4 = 0;
    L123:
        if (this.__condition_branch_4 != 0) goto L125;
        long r281 = r210.f267193a.d(this.__scopeId);
        this.__node_34 = r281;
        r210.f267193a.n(r281, "58 44 56 52 29 27 25 9");
        r210.f267193a.b(this.__condition_wrapper_4, this.__node_34);
        h r282 = r210.f267193a;
        long r283 = this.__node_34;
        ProfileEditData r284 = this.__cardData;
        Intrinsics.checkNotNull(r284);
        r282.o(r283, r284.getSaveMessage());
    L125:
        this.__mountedRoot = this.__node_0;
        return;
    L111:
        if (r277 != 1) goto L113;
        long r285 = r210.f267193a.e(this.__scopeId);
        this.__node_30 = r285;
        r210.f267193a.n(r285, "58 44 14 50 40 20");
        r210.f267193a.b(this.__condition_wrapper_3, this.__node_30);
        long r286 = r210.f267193a.c("svg", this.__scopeId);
        this.__node_31 = r286;
        r210.f267193a.n(r286, "3 63 13");
        r210.f267193a.l(this.__node_31, "content", "<svg height=\"13\" viewBox=\"0 0 14 13\" width=\"14\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M7,12.835C6.154,12.835 5.358,12.672 4.613,12.346C3.873,12.024 3.219,11.58 2.652,11.013C2.085,10.446 1.638,9.792 1.313,9.051C0.991,8.306 0.83,7.511 0.83,6.665C0.83,5.822 0.991,5.029 1.313,4.284C1.634,3.539 2.078,2.883 2.646,2.316C3.217,1.749 3.873,1.305 4.613,0.983C5.358,0.662 6.152,0.501 6.994,0.501C7.836,0.501 8.629,0.662 9.374,0.983C10.119,1.305 10.775,1.749 11.342,2.316C11.909,2.883 12.353,3.539 12.675,4.284C13.001,5.029 13.164,5.822 13.164,6.665C13.164,7.511 13.003,8.306 12.681,9.051C12.359,9.792 11.915,10.446 11.348,11.013C10.781,11.58 10.125,12.024 9.38,12.346C8.636,12.672 7.842,12.835 7,12.835ZM7,11.705C7.698,11.705 8.352,11.573 8.961,11.311C9.571,11.053 10.106,10.693 10.567,10.232C11.029,9.771 11.388,9.235 11.646,8.626C11.905,8.017 12.034,7.363 12.034,6.665C12.034,5.966 11.905,5.313 11.646,4.703C11.388,4.094 11.029,3.558 10.567,3.097C10.106,2.636 9.569,2.276 8.955,2.018C8.346,1.76 7.692,1.631 6.994,1.631C6.295,1.631 5.642,1.76 5.032,2.018C4.427,2.276 3.894,2.636 3.433,3.097C2.971,3.558 2.612,4.094 2.354,4.703C2.095,5.313 1.966,5.966 1.966,6.665C1.966,7.363 2.095,8.017 2.354,8.626C2.612,9.235 2.971,9.771 3.433,10.232C3.894,10.693 4.429,11.053 5.039,11.311C5.648,11.573 6.302,11.705 7,11.705ZM6.994,7.706C6.664,7.706 6.494,7.538 6.486,7.204L6.403,4.164C6.399,3.994 6.452,3.857 6.562,3.751C6.672,3.645 6.814,3.592 6.987,3.592C7.157,3.592 7.298,3.647 7.413,3.757C7.527,3.863 7.582,4.001 7.578,4.17L7.489,7.204C7.48,7.538 7.315,7.706 6.994,7.706ZM6.994,9.673C6.812,9.673 6.653,9.612 6.518,9.489C6.386,9.362 6.321,9.21 6.321,9.032C6.321,8.854 6.386,8.704 6.518,8.582C6.649,8.455 6.807,8.391 6.994,8.391C7.18,8.391 7.339,8.452 7.47,8.575C7.605,8.698 7.673,8.85 7.673,9.032C7.673,9.214 7.605,9.367 7.47,9.489C7.339,9.612 7.18,9.673 6.994,9.673Z\" fill=\"#ff3b30\"/></svg>");
        r210.f267193a.b(this.__node_30, this.__node_31);
        long r287 = r210.f267193a.d(this.__scopeId);
        this.__node_32 = r287;
        r210.f267193a.n(r287, "6 29 0 19 9");
        r210.f267193a.b(this.__node_30, this.__node_32);
        h r288 = r210.f267193a;
        long r289 = this.__node_32;
        ProfileEditData r290 = this.__cardData;
        Intrinsics.checkNotNull(r290);
        int r291 = r290.getUserNameStatus();
        ProfileEditData r292 = this.__cardData;
        Intrinsics.checkNotNull(r292);
        String r293 = r292.getUserNameError();
        ProfileEditData r294 = this.__cardData;
        Intrinsics.checkNotNull(r294);
        r288.o(r289, __helper_userNameErrorText(r291, r293, r294.isOversea()));
        goto L119
    L113:
        if (r277 != 2) goto L119;
        long r295 = r210.f267193a.d(this.__scopeId);
        this.__node_33 = r295;
        h r296 = r210.f267193a;
        ProfileEditData r297 = this.__cardData;
        Intrinsics.checkNotNull(r297);
        if (r297.isDarkMode() == false) goto L117;
        String r298 = "58 44 49 52 29 27 25 21";
    L118:
        r296.n(r295, r298);
        r210.f267193a.b(this.__condition_wrapper_3, this.__node_33);
        h r299 = r210.f267193a;
        long r300 = this.__node_33;
        ProfileEditData r301 = this.__cardData;
        Intrinsics.checkNotNull(r301);
        r299.o(r300, __helper_userNameTips(r301.isOversea()));
        goto L119
    L117:
        r298 = "58 44 49 52 29 27 25 51";
        goto L118
    L103:
        ProfileEditData r302 = this.__cardData;
        Intrinsics.checkNotNull(r302);
        if (__helper_showUserNameError(r302.getUserNameStatus()) == false) goto L106;
        this.__condition_branch_3 = 1;
        goto L107
    L106:
        this.__condition_branch_3 = 2;
        goto L107
    L91:
        r274 = "35 17 65 1 37 53 15";
        goto L92
    L93:
        String r303 = r216;
        if (r269 != 1) goto L96;
        long r304 = r210.f267193a.e(this.__scopeId);
        this.__node_24 = r304;
        r210.f267193a.n(r304, r303);
        r210.f267193a.b(this.__condition_wrapper_2, this.__node_24);
        long r305 = r210.f267193a.c("svg", this.__scopeId);
        this.__node_25 = r305;
        r210.f267193a.n(r305, "35 17");
        r210.f267193a.l(this.__node_25, "content", "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"22\" height=\"22\" viewBox=\"0 0 22 22\"><path d=\"M10.99,21.037C9.61,21.037 8.311,20.773 7.094,20.246C5.876,19.725 4.802,18.999 3.871,18.068C2.947,17.137 2.221,16.063 1.693,14.846C1.166,13.628 0.902,12.329 0.902,10.949C0.902,9.569 1.166,8.27 1.693,7.053C2.221,5.835 2.947,4.764 3.871,3.84C4.802,2.909 5.873,2.18 7.084,1.652C8.301,1.125 9.6,0.861 10.981,0.861C12.367,0.861 13.669,1.125 14.887,1.652C16.104,2.18 17.178,2.909 18.109,3.84C19.04,4.764 19.77,5.835 20.297,7.053C20.824,8.27 21.088,9.569 21.088,10.949C21.088,12.329 20.824,13.628 20.297,14.846C19.77,16.063 19.04,17.137 18.109,18.068C17.178,18.999 16.104,19.725 14.887,20.246C13.669,20.773 12.37,21.037 10.99,21.037ZM9.906,15.764C10.089,15.764 10.255,15.721 10.404,15.637C10.561,15.552 10.697,15.425 10.814,15.256L15.385,8.127C15.45,8.023 15.509,7.912 15.561,7.795C15.613,7.671 15.639,7.554 15.639,7.443C15.639,7.189 15.541,6.984 15.346,6.828C15.157,6.672 14.942,6.594 14.701,6.594C14.382,6.594 14.118,6.763 13.91,7.102L9.867,13.566L7.992,11.184C7.862,11.021 7.735,10.907 7.611,10.842C7.488,10.777 7.348,10.744 7.191,10.744C6.944,10.744 6.732,10.835 6.557,11.018C6.387,11.193 6.303,11.405 6.303,11.652C6.303,11.776 6.326,11.896 6.371,12.014C6.417,12.131 6.482,12.245 6.566,12.356L8.959,15.266C9.102,15.441 9.249,15.568 9.398,15.646C9.548,15.725 9.717,15.764 9.906,15.764Z\" fill=\"#34C759\"/></svg>");
        r210.f267193a.b(this.__node_24, this.__node_25);
        goto L100
    L96:
        if (r269 != 2) goto L98;
        long r306 = r210.f267193a.e(this.__scopeId);
        this.__node_26 = r306;
        r210.f267193a.l(r306, "ignore-focus", Boolean.TRUE);
        r210.f267193a.n(this.__node_26, r303);
        Function1<Object, Unit> r307 = d.d(new p0(r210, this));
        r210.f267193a.a(this.__node_26, LynxTouchEvent.EVENT_TOUCH_START, r307);
        r210.f267193a.b(this.__condition_wrapper_2, this.__node_26);
        long r308 = r210.f267193a.c("svg", this.__scopeId);
        this.__node_27 = r308;
        r210.f267193a.n(r308, "35 17");
        r210.f267193a.l(this.__node_27, "content", "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"20\" height=\"20\" viewBox=\"0 0 20 20\"><path d=\"M10,0C4.477,0 0,4.477 0,10C0,15.523 4.477,20 10,20C15.523,20 20,15.523 20,10C20,4.477 15.523,0 10,0ZM12.121,6.464C12.512,6.074 13.145,6.074 13.535,6.464C13.926,6.855 13.926,7.488 13.535,7.879L11.414,10L13.535,12.121C13.926,12.512 13.926,13.145 13.535,13.536C13.145,13.926 12.512,13.926 12.121,13.536L10,11.414L7.879,13.536C7.488,13.926 6.855,13.926 6.464,13.536C6.074,13.145 6.074,12.512 6.464,12.121L8.586,10L6.464,7.879C6.074,7.488 6.074,6.855 6.464,6.464C6.855,6.074 7.488,6.074 7.879,6.464L10,8.586L12.121,6.464Z\" fill=\"#CCCCCC\"/></svg>");
        r210.f267193a.b(this.__node_26, this.__node_27);
        goto L100
    L98:
        if (r269 != 3) goto L100;
        long r309 = r210.f267193a.e(this.__scopeId);
        this.__node_28 = r309;
        r210.f267193a.n(r309, "24 7");
        r210.f267193a.b(this.__condition_wrapper_2, this.__node_28);
        goto L100
    L79:
        ProfileEditData r310 = this.__cardData;
        Intrinsics.checkNotNull(r310);
        if (r310.getUserNameStatus() != 3) goto L82;
        this.__condition_branch_2 = 1;
        goto L86
    L82:
        ProfileEditData r311 = this.__cardData;
        Intrinsics.checkNotNull(r311);
        String r312 = r311.getUserName();
        ProfileEditData r313 = this.__cardData;
        Intrinsics.checkNotNull(r313);
        boolean r314 = r313.getUserNameFocused();
        ProfileEditData r315 = this.__cardData;
        Intrinsics.checkNotNull(r315);
        boolean r316 = r315.isEnterpriseAccount();
        ProfileEditData r317 = this.__cardData;
        Intrinsics.checkNotNull(r317);
        if (__helper_showUserNameClear(r312, r314, r316, r317.getUserNameStatus()) == false) goto L85;
        this.__condition_branch_2 = 2;
        goto L86
    L85:
        this.__condition_branch_2 = 3;
        goto L86
    L75:
        r263 = "7 6 28 45 32 30";
        goto L76
    L71:
        r235 = "18 43 8 57 7 50 40 20 41";
        goto L72
    L67:
        r227 = "58 12 28 11 19 32";
        goto L68
    L55:
        r212 = "disabled";
        r213 = "maxlength";
        r215 = "confirm-type";
        r216 = "24 7 50 40 61 20";
        r203 = "text";
        r214 = ButtonColorBean.StateFocus;
        if (r200 != 1) goto L58;
        long r318 = r210.f267193a.e(this.__scopeId);
        this.__node_14 = r318;
        r210.f267193a.n(r318, "24 7");
        r210.f267193a.b(this.__condition_wrapper_0, this.__node_14);
        goto L58
    L51:
        this.__condition_branch_0 = 1;
        goto L52
    L47:
        r190 = "7 6 28 45 32 30";
        goto L48
    L43:
        r171 = "18 43 8 57 7 50 40 20 41";
        goto L44
    L39:
        r164 = "58 46 12 28 11 19 32";
    L35:
        r154 = false;
        goto L36
    L25:
        r139 = "28 11 19 60";
        goto L30
    L26:
        ProfileEditData r319 = this.__cardData;
        Intrinsics.checkNotNull(r319);
        if (r319.isDarkMode() == false) goto L29;
        r139 = "28 11 19 33";
        goto L30
    L29:
        r139 = "28 11 19 55";
        goto L30
    L15:
        r121 = "10 11 19 36 32";
        goto L20
    L16:
        ProfileEditData r320 = this.__cardData;
        Intrinsics.checkNotNull(r320);
        if (r320.isDarkMode() == false) goto L19;
        r121 = "28 11 19 36 64";
        goto L20
    L19:
        r121 = "28 11 19 36 32";
        goto L20
    L9:
        r112 = "28 11 19 32";
        goto L10
    L5:
        r103 = "34 26";
        goto L6
    }

    public void __setData_10_0(final CardSession r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = false;
        if (r102.getUserNameFocused() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setUserNameFocused(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH));
        r103 = true;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        r100.h(new b1(this, r100));
    }

    public void __setData_15_0(final CardSession r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = false;
        if (r102.getDirty() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setDirty(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | PlaybackStateCompat.ACTION_PLAY_FROM_URI));
        r103 = true;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        r100.h(new g1(this, r100));
    }

    public void __setData_18_0(final CardSession r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = false;
        if (r102.getUserNameStatus() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setUserNameStatus(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 16384));
        r103 = true;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        r100.h(new o(this, r100));
    }

    public void __setData_18_1(final CardSession r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = false;
        if (r102.getUserNameStatus() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setUserNameStatus(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 16384));
        r103 = true;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        r100.h(new v(this, r100));
    }

    public void __setData_7_0(final CardSession r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = false;
        if (r102.getNickNameFocused() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setNickNameFocused(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID));
        r103 = true;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        r100.h(new r87.h(this, r100));
    }

    public void __setData_8_0(final CardSession r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = false;
        if (r102.getNickNameFocused() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setNickNameFocused(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID));
        r103 = true;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        r100.h(new s(this, r100));
    }

    public void __setData_9_0(final CardSession r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = false;
        if (r102.getUserNameFocused() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setUserNameFocused(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH));
        r103 = true;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        r100.h(new q(this, r100));
    }

    public String __stringArrayAt(ArrayList<String> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "values");
        if (r101 < 0) goto L9;
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.size();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r101 < r103) goto L8;
        return "";
    L8:
        return (String) ListProtector.get(r100, r101);
    L9:
        return "";
    }

    private static final Unit __initialRender$lambda$31(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new f1(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$31$lambda$30(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 0, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$33(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new x(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$33$lambda$32(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 4, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$35(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new r87.g(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$35$lambda$34(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 13, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$37(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new d1(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$37$lambda$36(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 1, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$39(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new r87.m(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$39$lambda$38(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 3, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$41(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new z(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$41$lambda$40(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 2, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$43(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new d0(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$43$lambda$42(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 5, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$45(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new e(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$45$lambda$44(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 7, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$47(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new n(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$47$lambda$46(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 8, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$49(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new l0(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$49$lambda$48(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 11, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$51(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new u(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$51$lambda$50(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 2, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$53(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new a0(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$53$lambda$52(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 6, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$55(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new r87.i(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$55$lambda$54(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 9, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$57(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new w0(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$57$lambda$56(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 10, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$59(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new l(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __initialRender$lambda$59$lambda$58(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 12, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __updateBindings$lambda$5(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new w(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __updateBindings$lambda$5$lambda$4(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 11, r102);
        return Unit.INSTANCE;
    }

    private static final Unit __updateBindings$lambda$7(final CardSession r100, final __TtmlStaticCardController r101, final Object r102) {
        r100.j(new t(r101, r100, r102));
        return Unit.INSTANCE;
    }

    private static final Unit __updateBindings$lambda$7$lambda$6(__TtmlStaticCardController r100, CardSession r101, Object r102) {
        r100.__dispatchAction(r101, 12, r102);
        return Unit.INSTANCE;
    }

    public void __action_applySaveResult(CardSession r100, Object r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r102, "requestId");
        if (Intrinsics.areEqual(this.__instance_pendingSaveRequest, r102) == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(SrcProfileeditRxPageKt.readPayloadString(r101, "requestId", r102), r102) == true) goto L9;
        return;
    L9:
        if (SrcProfileeditRxPageKt.readPayloadBoolean(r101, "success", false) == false) goto L12;
        this.__instance_pendingSaveRequest = "";
        CardSession.f(r100, ProfileEditRelaxPage.METHOD_REQUEST_CLOSE, i.b(new Object[]{Boolean.FALSE}), null, 24);
        return;
    L12:
        String r103 = SrcProfileeditRxPageKt.readPayloadString(r101, "message", "");
        this.__instance_pendingSaveRequest = "";
        if (m.a(r103) > 0) goto L16;
        r103 = "保存失败，请稍后重试";
    L16:
        __setData_19_0(r100, false, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [r87.c1] */
    public void __action_setInputValue(CardSession r110, String r210, String r211) {
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r210, "selector");
        Intrinsics.checkNotNullParameter(r211, "value");
        h r111 = r110.f267193a;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r210, "selector");
        long r112 = r111.f267237b;
        Intrinsics.checkNotNullParameter(r210, "selector");
        if (r111.f267249n == true) goto L54;
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter("", "delimiters");
        List r100 = StringsKt.split$default(r210, new String[]{""}, false, 0, 4, null);
        if (r100.size() > 1) goto L7;
        ArrayList r101 = new ArrayList(r100);
    L8:
        String r102 = "";
        int r103 = 0;
        boolean r104 = false;
        int r105 = 0;
    L9:
        IntCompanionObject r106 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        int r113 = r101.size();
        Intrinsics.checkNotNullParameter(r106, "<this>");
        if (r103 >= r113) goto L41;
        String r107 = (String) ListProtector.get(r101, r103);
        if (r104 == false) goto L15;
        r103 = r103 + 1;
        r104 = false;
        goto L9
    L15:
        if (Intrinsics.areEqual(r107, "\\") == false) goto L18;
        r103 = r103 + 1;
        r104 = true;
        goto L9
    L18:
        if (Intrinsics.areEqual(r102, "") == false) goto L20;
        if (r105 <= 0) goto L29;
        if (Intrinsics.areEqual(r107, "\"") == false) goto L26;
    L27:
        r103 = r103 + 1;
        r102 = r107;
        goto L9
    L26:
        if (Intrinsics.areEqual(r107, "'") == true) goto L27;
    L29:
        if (Intrinsics.areEqual(r107, "[") == false) goto L32;
        r105 = r105 + 1;
    L39:
        r103 = r103 + 1;
        goto L9
    L32:
        if (Intrinsics.areEqual(r107, "]") == false) goto L36;
        if (r105 <= 0) goto L36;
        r105 = r105 - 1;
    L36:
        if (Intrinsics.areEqual(r107, ".") == false) goto L39;
        if (r105 != 0) goto L39;
        boolean r108 = true;
    L42:
        if (r108 == true) goto L44;
        boolean r109 = true;
    L45:
        if (r109 == false) goto L54;
        j r114 = r111.f267236a;
        if (r114 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r114 = null;
    L50:
        Map<String, Object> r115 = d.f267227a;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r210, "selector");
        Intrinsics.checkNotNullParameter(r115, "options");
        int r116 = s87.e.f540981a;
        s87.i r117 = r114.f540987a;
        Intrinsics.checkNotNullParameter(r117, "renderer");
        Intrinsics.checkNotNullParameter(r210, "selector");
        Intrinsics.checkNotNullParameter(r115, "options");
        long r118 = r117.a().s(r112, r210, r115);
        if (r118 == 0) goto L54;
        b r119 = new b(r118, r111);
    L55:
        if (r119 != 0) goto L57;
        return;
    L57:
        Map r120 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("value", r211)});
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        Map r121 = TypeIntrinsics.asMutableMap(r120);
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type kotlin.Any");
        r119.a(r121, new c1());
        return;
    L44:
        int r122 = r.f267614a;
        r.a.a(new Object[]{"[TTML Static] Class selectors are not supported."});
        r109 = false;
        goto L45
    L20:
        if (Intrinsics.areEqual(r107, r102) == false) goto L39;
        r102 = "";
        goto L39
    L41:
        r108 = false;
        goto L42
    L7:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        r101 = (ArrayList) r100;
    L54:
        r119 = 0;
        goto L55
    }

    public void __dispatchAction(CardSession r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r102, "event");
        switch(r101) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L6;
            case 13: goto L5;
            default: goto L33;
        };
    L5:
        Map<String, Object> r103 = d.b(r102);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onSave(r100, TypeIntrinsics.asMutableMap(r103));
        return;
    L6:
        Map<String, Object> r104 = d.b(r102);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onClearUserName(r100, TypeIntrinsics.asMutableMap(r104));
        return;
    L7:
        Map<String, Object> r105 = d.b(r102);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onClearNickName(r100, TypeIntrinsics.asMutableMap(r105));
        return;
    L8:
        Map<String, Object> r106 = d.b(r102);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onUserNameBlur(r100, TypeIntrinsics.asMutableMap(r106));
        return;
    L9:
        Map<String, Object> r107 = d.b(r102);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onUserNameFocus(r100, TypeIntrinsics.asMutableMap(r107));
        return;
    L10:
        Map<String, Object> r108 = d.b(r102);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onNickNameBlur(r100, TypeIntrinsics.asMutableMap(r108));
        return;
    L11:
        Map<String, Object> r109 = d.b(r102);
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onNickNameFocus(r100, TypeIntrinsics.asMutableMap(r109));
        return;
    L12:
        Map<String, Object> r110 = d.b(r102);
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onUserNameInput(r100, TypeIntrinsics.asMutableMap(r110));
        return;
    L13:
        Map<String, Object> r111 = d.b(r102);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onNickNameInput(r100, TypeIntrinsics.asMutableMap(r111));
        return;
    L14:
        Map<String, Object> r112 = d.b(r102);
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onCancel(r100, TypeIntrinsics.asMutableMap(r112));
        return;
    L15:
        Map<String, Object> r113 = d.b(r102);
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onAvatarChanged(r100, TypeIntrinsics.asMutableMap(r113));
        return;
    L16:
        Map<String, Object> r114 = d.b(r102);
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onEnterpriseFieldTap(r100, TypeIntrinsics.asMutableMap(r114));
        return;
    L17:
        Map<String, Object> r115 = d.b(r102);
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onAvatarTap(r100, TypeIntrinsics.asMutableMap(r115));
        return;
    L18:
        Map<String, Object> r116 = d.b(r102);
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        __action_onPageTap(r100, TypeIntrinsics.asMutableMap(r116));
        return;
    }

    public String __helper_displayUserNameValue(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "enterpriseDisplayName");
        Intrinsics.checkNotNullParameter(r102, "userName");
        if (r100 == false) goto L8;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101.length() <= 0) goto L8;
        return r101;
    L8:
        return r102;
    }

    public boolean __helper_showNickNameClear(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "nickName");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() <= 0) goto L7;
        if (r101 == false) goto L7;
        if (r102 == true) goto L7;
        return true;
    L7:
        return false;
    }

    public String __helper_userNameErrorText(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "validationError");
        if (r100 != 1) goto L15;
        if (Intrinsics.areEqual(r101, "length") == false) goto L10;
        if (r102 == false) goto L8;
        return "用户名长度为 4-16 个字符。";
    L8:
        return "豆包号长度为 4-16 个字符。";
    L10:
        if (r102 == false) goto L12;
        return "用户名只能使用字母、数字以及下划线。";
    L12:
        return "豆包号只能使用字母、数字以及下划线。";
    L15:
        if (r100 != 4) goto L21;
        if (r102 == false) goto L18;
        return "用户名被占用，请尝试其他用户名。";
    L18:
        return "豆包号被占用，请尝试其他用户名。";
    L21:
        if (r100 != 5) goto L24;
        return "校验失败，请稍后重试";
    L24:
        return "";
    }

    public boolean __hostUpdate(CardSession r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "options");
        ArrayList<Long> r103 = i.b(new Long[]{0L});
        if (__applyPatch(r101, r103) == true) goto L5;
        return false;
    L5:
        __updateBindings(r100, r103);
        return true;
    }

    public void __setData_12_0(final CardSession r100, String r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "__set_value_12_0_2");
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (Intrinsics.areEqual(r102.getUserName(), r101) == true) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setUserName(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 4));
        boolean r106 = true;
    L9:
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        if (r107.getUserNameFocused() == r110) goto L12;
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        r108.setUserNameFocused(r110);
        ArrayList<Long> r109 = this.__pendingDirty;
        ListProtector.set(r109, 0, Long.valueOf(((Number) ListProtector.get(r109, 0)).longValue() | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH));
    L13:
        if (r103 == true) goto L15;
        return;
    L15:
        r100.h(new f0(this, r100));
        return;
    L12:
        r103 = r106;
        goto L13
    L8:
        r106 = false;
        goto L9
    }

    public void __setData_13_0(final CardSession r100, boolean r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r110, "__set_value_13_0_18");
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (r102.getShowNickNameError() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setShowNickNameError(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | PlaybackStateCompat.ACTION_PREPARE_FROM_URI));
        boolean r106 = true;
    L9:
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        if (Intrinsics.areEqual(r107.getNickNameError(), r110) == true) goto L12;
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        r108.setNickNameError(r110);
        ArrayList<Long> r109 = this.__pendingDirty;
        ListProtector.set(r109, 0, Long.valueOf(((Number) ListProtector.get(r109, 0)).longValue() | PlaybackStateCompat.ACTION_SET_REPEAT_MODE));
    L13:
        if (r103 == true) goto L15;
        return;
    L15:
        r100.h(new g0(this, r100));
        return;
    L12:
        r103 = r106;
        goto L13
    L8:
        r106 = false;
        goto L9
    }

    public void __setData_13_1(final CardSession r100, boolean r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r110, "__set_value_13_1_21");
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (r102.getSaving() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setSaving(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 1048576));
        boolean r106 = true;
    L9:
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        if (Intrinsics.areEqual(r107.getSaveMessage(), r110) == true) goto L12;
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        r108.setSaveMessage(r110);
        ArrayList<Long> r109 = this.__pendingDirty;
        ListProtector.set(r109, 0, Long.valueOf(((Number) ListProtector.get(r109, 0)).longValue() | 2097152));
    L13:
        if (r103 == true) goto L15;
        return;
    L15:
        r100.h(new c0(this, r100));
        return;
    L12:
        r103 = r106;
        goto L13
    L8:
        r106 = false;
        goto L9
    }

    public void __setData_17_0(final CardSession r100, int r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r110, "__set_value_17_0_19");
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (r102.getUserNameStatus() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setUserNameStatus(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 16384));
        boolean r106 = true;
    L9:
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        if (Intrinsics.areEqual(r107.getUserNameError(), r110) == true) goto L12;
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        r108.setUserNameError(r110);
        ArrayList<Long> r109 = this.__pendingDirty;
        ListProtector.set(r109, 0, Long.valueOf(((Number) ListProtector.get(r109, 0)).longValue() | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED));
    L13:
        if (r103 == true) goto L15;
        return;
    L15:
        r100.h(new r87.r(this, r100));
        return;
    L12:
        r103 = r106;
        goto L13
    L8:
        r106 = false;
        goto L9
    }

    public void __setData_17_1(final CardSession r100, int r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r110, "__set_value_17_1_19");
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (r102.getUserNameStatus() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setUserNameStatus(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 16384));
        boolean r106 = true;
    L9:
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        if (Intrinsics.areEqual(r107.getUserNameError(), r110) == true) goto L12;
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        r108.setUserNameError(r110);
        ArrayList<Long> r109 = this.__pendingDirty;
        ListProtector.set(r109, 0, Long.valueOf(((Number) ListProtector.get(r109, 0)).longValue() | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED));
    L13:
        if (r103 == true) goto L15;
        return;
    L15:
        r100.h(new f(this, r100));
        return;
    L12:
        r103 = r106;
        goto L13
    L8:
        r106 = false;
        goto L9
    }

    public void __setData_17_2(final CardSession r100, int r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r110, "__set_value_17_2_19");
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (r102.getUserNameStatus() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setUserNameStatus(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 16384));
        boolean r106 = true;
    L9:
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        if (Intrinsics.areEqual(r107.getUserNameError(), r110) == true) goto L12;
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        r108.setUserNameError(r110);
        ArrayList<Long> r109 = this.__pendingDirty;
        ListProtector.set(r109, 0, Long.valueOf(((Number) ListProtector.get(r109, 0)).longValue() | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED));
    L13:
        if (r103 == true) goto L15;
        return;
    L15:
        r100.h(new e0(this, r100));
        return;
    L12:
        r103 = r106;
        goto L13
    L8:
        r106 = false;
        goto L9
    }

    public void __setData_19_0(final CardSession r100, boolean r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r110, "__set_value_19_0_21");
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (r102.getSaving() == r101) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setSaving(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 1048576));
        boolean r106 = true;
    L9:
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        if (Intrinsics.areEqual(r107.getSaveMessage(), r110) == true) goto L12;
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        r108.setSaveMessage(r110);
        ArrayList<Long> r109 = this.__pendingDirty;
        ListProtector.set(r109, 0, Long.valueOf(((Number) ListProtector.get(r109, 0)).longValue() | 2097152));
    L13:
        if (r103 == true) goto L15;
        return;
    L15:
        r100.h(new r87.j(this, r100));
        return;
    L12:
        r103 = r106;
        goto L13
    L8:
        r106 = false;
        goto L9
    }

    public void __setData_6_0(final CardSession r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "__set_value_6_0_2");
        Intrinsics.checkNotNullParameter(r110, "__set_value_6_0_21");
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (Intrinsics.areEqual(r102.getUserName(), r101) == true) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setUserName(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 4));
        boolean r106 = true;
    L9:
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        if (Intrinsics.areEqual(r107.getSaveMessage(), r110) == true) goto L12;
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        r108.setSaveMessage(r110);
        ArrayList<Long> r109 = this.__pendingDirty;
        ListProtector.set(r109, 0, Long.valueOf(((Number) ListProtector.get(r109, 0)).longValue() | 2097152));
    L13:
        if (r103 == true) goto L15;
        return;
    L15:
        r100.h(new b0(this, r100));
        return;
    L12:
        r103 = r106;
        goto L13
    L8:
        r106 = false;
        goto L9
    }

    private static final Unit __action_onSave$lambda$19(__TtmlStaticCardController r100, CardSession r101, String r102, Object r103) {
        r100.__action_applySaveResult(r101, r103, r102);
        return Unit.INSTANCE;
    }

    public void __action_applyUserNameResult(CardSession r100, Object r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r102, "requestId");
        Intrinsics.checkNotNullParameter(r103, "userName");
        if (Intrinsics.areEqual(this.__instance_pendingUserNameRequest, r102) == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(SrcProfileeditRxPageKt.readPayloadString(r101, "requestId", r102), r102) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(SrcProfileeditRxPageKt.readPayloadString(r101, "userName", r103), r103) == true) goto L12;
        return;
    L12:
        if (m.a(SrcProfileeditRxPageKt.readPayloadString(r101, "code", "")) <= 0) goto L16;
        __setData_18_0(r100, 5);
        return;
    L16:
        if (SrcProfileeditRxPageKt.readPayloadBoolean(r101, "isUnique", false) == false) goto L18;
        int r104 = 3;
    L19:
        __setData_18_1(r100, r104);
        return;
    L18:
        r104 = 4;
        goto L19
    }

    public void __action_reportDirty(CardSession r100, String r101, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "nextNickName");
        Intrinsics.checkNotNullParameter(r110, "nextUserName");
        Intrinsics.checkNotNullParameter(r111, "nextAvatarUrl");
        boolean r102 = SrcProfileeditRxPageKt.isDirtyValues(this.__instance_initialNickName, this.__instance_initialUserName, this.__instance_initialAvatarUrl, r101, r110, r111);
        ProfileEditData r112 = this.__cardData;
        Intrinsics.checkNotNull(r112);
        if (r102 == r112.getDirty()) goto L5;
        __setData_15_0(r100, r102);
    L5:
        Intrinsics.checkNotNull(Boolean.valueOf(r102), "null cannot be cast to non-null type kotlin.Any");
        CardSession.f(r100, ProfileEditRelaxPage.METHOD_UPDATE_DIRTY_STATE, i.b(new Object[]{Boolean.valueOf(r102)}), null, 24);
    }

    public boolean __helper_showUserNameClear(String r100, boolean r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "userName");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() <= 0) goto L11;
        if (r101 == false) goto L11;
        if (r102 == true) goto L11;
        if (r103 == 2) goto L11;
        if (r103 == 3) goto L11;
        return true;
    L11:
        return false;
    }

    public void __setData_11_0(final CardSession r100, String r101, boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "__set_value_11_0_1");
        Intrinsics.checkNotNullParameter(r111, "__set_value_11_0_18");
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (Intrinsics.areEqual(r102.getNickName(), r101) == true) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setNickName(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 2));
        boolean r106 = true;
    L9:
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        if (r107.getNickNameFocused() == r110) goto L12;
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        r108.setNickNameFocused(r110);
        ArrayList<Long> r109 = this.__pendingDirty;
        ListProtector.set(r109, 0, Long.valueOf(((Number) ListProtector.get(r109, 0)).longValue() | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID));
        r106 = true;
    L12:
        ProfileEditData r112 = this.__cardData;
        Intrinsics.checkNotNull(r112);
        if (Intrinsics.areEqual(r112.getNickNameError(), r111) == true) goto L15;
        ProfileEditData r113 = this.__cardData;
        Intrinsics.checkNotNull(r113);
        r113.setNickNameError(r111);
        ArrayList<Long> r114 = this.__pendingDirty;
        ListProtector.set(r114, 0, Long.valueOf(((Number) ListProtector.get(r114, 0)).longValue() | PlaybackStateCompat.ACTION_SET_REPEAT_MODE));
    L16:
        if (r103 == true) goto L18;
        return;
    L18:
        r100.h(new p(this, r100));
        return;
    L15:
        r103 = r106;
        goto L16
    L8:
        r106 = false;
        goto L9
    }

    public void __setData_3_0(final CardSession r100, String r101, boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "__set_value_3_0_3");
        Intrinsics.checkNotNullParameter(r111, "__set_value_3_0_21");
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (Intrinsics.areEqual(r102.getAvatarUrl(), r101) == true) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setAvatarUrl(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 8));
        boolean r106 = true;
    L9:
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        if (r107.isDefaultAvatar() == r110) goto L12;
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        r108.setDefaultAvatar(r110);
        ArrayList<Long> r109 = this.__pendingDirty;
        ListProtector.set(r109, 0, Long.valueOf(((Number) ListProtector.get(r109, 0)).longValue() | 16));
        r106 = true;
    L12:
        ProfileEditData r112 = this.__cardData;
        Intrinsics.checkNotNull(r112);
        if (Intrinsics.areEqual(r112.getSaveMessage(), r111) == true) goto L15;
        ProfileEditData r113 = this.__cardData;
        Intrinsics.checkNotNull(r113);
        r113.setSaveMessage(r111);
        ArrayList<Long> r114 = this.__pendingDirty;
        ListProtector.set(r114, 0, Long.valueOf(((Number) ListProtector.get(r114, 0)).longValue() | 2097152));
    L16:
        if (r103 == true) goto L18;
        return;
    L18:
        r100.h(new e1(this, r100));
        return;
    L15:
        r103 = r106;
        goto L16
    L8:
        r106 = false;
        goto L9
    }

    private static final Unit __action_checkUserNameAfterInput$lambda$25(__TtmlStaticCardController r100, CardSession r101, String r102, String r103, Object r104) {
        r100.__action_applyUserNameResult(r101, r104, r102, r103);
        return Unit.INSTANCE;
    }

    public boolean __helper_canSubmit(boolean r100, String r101, boolean r102, boolean r103, int r104) {
        Intrinsics.checkNotNullParameter(r101, "nickName");
        if (r100 == false) goto L12;
        if (r102 == true) goto L12;
        if (r103 == true) goto L12;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101.length() <= 0) goto L12;
        if (r104 != 0) goto L10;
    L11:
        return true;
    L10:
        if (r104 == 3) goto L11;
    L12:
        return false;
    }

    public void __setData_5_0(final CardSession r100, String r101, boolean r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "__set_value_5_0_1");
        Intrinsics.checkNotNullParameter(r111, "__set_value_5_0_18");
        Intrinsics.checkNotNullParameter(r112, "__set_value_5_0_21");
        if (r100.g() == true) goto L5;
        return;
    L5:
        ProfileEditData r102 = this.__cardData;
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (Intrinsics.areEqual(r102.getNickName(), r101) == true) goto L8;
        ProfileEditData r104 = this.__cardData;
        Intrinsics.checkNotNull(r104);
        r104.setNickName(r101);
        ArrayList<Long> r105 = this.__pendingDirty;
        ListProtector.set(r105, 0, Long.valueOf(((Number) ListProtector.get(r105, 0)).longValue() | 2));
        boolean r106 = true;
    L9:
        ProfileEditData r107 = this.__cardData;
        Intrinsics.checkNotNull(r107);
        if (r107.getShowNickNameError() == r110) goto L12;
        ProfileEditData r108 = this.__cardData;
        Intrinsics.checkNotNull(r108);
        r108.setShowNickNameError(r110);
        ArrayList<Long> r109 = this.__pendingDirty;
        ListProtector.set(r109, 0, Long.valueOf(((Number) ListProtector.get(r109, 0)).longValue() | PlaybackStateCompat.ACTION_PREPARE_FROM_URI));
        r106 = true;
    L12:
        ProfileEditData r113 = this.__cardData;
        Intrinsics.checkNotNull(r113);
        if (Intrinsics.areEqual(r113.getNickNameError(), r111) == true) goto L15;
        ProfileEditData r114 = this.__cardData;
        Intrinsics.checkNotNull(r114);
        r114.setNickNameError(r111);
        ArrayList<Long> r115 = this.__pendingDirty;
        ListProtector.set(r115, 0, Long.valueOf(((Number) ListProtector.get(r115, 0)).longValue() | PlaybackStateCompat.ACTION_SET_REPEAT_MODE));
        r106 = true;
    L15:
        ProfileEditData r116 = this.__cardData;
        Intrinsics.checkNotNull(r116);
        if (Intrinsics.areEqual(r116.getSaveMessage(), r112) == true) goto L18;
        ProfileEditData r117 = this.__cardData;
        Intrinsics.checkNotNull(r117);
        r117.setSaveMessage(r112);
        ArrayList<Long> r118 = this.__pendingDirty;
        ListProtector.set(r118, 0, Long.valueOf(((Number) ListProtector.get(r118, 0)).longValue() | 2097152));
    L19:
        if (r103 == true) goto L21;
        return;
    L21:
        r100.h(new y(this, r100));
        return;
    L18:
        r103 = r106;
        goto L19
    L8:
        r106 = false;
        goto L9
    }
}
