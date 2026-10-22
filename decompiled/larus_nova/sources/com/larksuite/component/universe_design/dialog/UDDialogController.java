package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u0000 \u008a\u00022\u00020\u0001:\u0004\u008a\u0002\u008b\u0002B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010Ý\u0001\u001a\u00030Þ\u0001\"\u0011\b\u0000\u0010ß\u0001*\n\u0012\u0005\u0012\u0003Hß\u00010à\u00012\u000f\u0010á\u0001\u001a\n\u0012\u0005\u0012\u0003Hß\u00010à\u00012\u0007\u0010â\u0001\u001a\u00020\tH\u0017J\u0013\u0010ã\u0001\u001a\u00030Þ\u00012\u0007\u0010â\u0001\u001a\u00020\tH\u0016J\u001f\u0010ä\u0001\u001a\u00030Þ\u00012\u0007\u0010â\u0001\u001a\u00020\t2\n\u0010å\u0001\u001a\u0005\u0018\u00010æ\u0001H\u0016J\n\u0010ç\u0001\u001a\u00030Þ\u0001H\u0017J\n\u0010è\u0001\u001a\u00030Þ\u0001H\u0016J\t\u0010é\u0001\u001a\u00020\u0015H\u0015J\f\u0010ê\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0014J\t\u0010ë\u0001\u001a\u00020\u0015H\u0015J\f\u0010ì\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0014J\t\u0010í\u0001\u001a\u00020\u0015H\u0015J\f\u0010î\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0014J\u0018\u0010ï\u0001\u001a\u00030Þ\u00012\f\u0010á\u0001\u001a\u0007\u0012\u0002\b\u00030à\u0001H\u0002J\t\u0010ð\u0001\u001a\u00020\u0015H\u0015J\f\u0010ñ\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0014J\n\u0010ò\u0001\u001a\u00030Þ\u0001H\u0002J\n\u0010ó\u0001\u001a\u00030ô\u0001H\u0002J\u000e\u0010õ\u0001\u001a\u00030ö\u0001*\u00020RH\u0002J\n\u0010÷\u0001\u001a\u00030Þ\u0001H\u0002J\r\u0010ø\u0001\u001a\u00020\u0015*\u00020RH\u0002J(\u0010ù\u0001\u001a\u00030Þ\u00012\b\u0010ú\u0001\u001a\u00030û\u00012\u0007\u0010ü\u0001\u001a\u00020\u00152\t\b\u0001\u0010ý\u0001\u001a\u00020\u0015H\u0004J8\u0010þ\u0001\u001a\u00030Þ\u00012\b\u0010ÿ\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0080\u0002\u001a\u00020\u00152\u0007\u0010\u0081\u0002\u001a\u00020\u00152\u0007\u0010\u0082\u0002\u001a\u00020\u00152\u0007\u0010\u0083\u0002\u001a\u00020\u0015H\u0004J.\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0087\u00012\n\u0010ò\u0001\u001a\u0005\u0018\u00010\u0087\u00012\t\b\u0001\u0010\u0085\u0002\u001a\u00020\u00152\t\b\u0001\u0010\u0086\u0002\u001a\u00020\u0015H\u0004J\u001b\u0010\u0087\u0002\u001a\u00020R2\u0007\u0010\u0088\u0002\u001a\u00020R2\u0007\u0010\u0089\u0002\u001a\u00020\u0015H\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u00158\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\u001a\u0010'\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001a\u0010*\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R\u001a\u0010-\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\u001a\u00100\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019R\u001a\u00103\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R\u001c\u00106\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0011\"\u0004\b8\u0010\u0013R\u001a\u00109\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R\u001e\u0010<\u001a\u00020\u00158\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019R\u001a\u0010?\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0017\"\u0004\bA\u0010\u0019R\u001a\u0010B\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0017\"\u0004\bD\u0010\u0019R\u001a\u0010E\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0017\"\u0004\bG\u0010\u0019R\u001a\u0010H\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0017\"\u0004\bJ\u0010\u0019R\u001a\u0010K\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0017\"\u0004\bM\u0010\u0019R\u001a\u0010N\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0017\"\u0004\bP\u0010\u0019R\u001a\u0010Q\u001a\u00020RX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010W\u001a\u00020XX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010]\u001a\u00020RX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010T\"\u0004\b_\u0010VR\u001a\u0010`\u001a\u00020RX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010T\"\u0004\bb\u0010VR\u001a\u0010c\u001a\u00020\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001e\u0010h\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\bi\u0010 \"\u0004\bj\u0010\"R\u001e\u0010k\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\bl\u0010 \"\u0004\bm\u0010\"R\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010z\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0017\"\u0004\b|\u0010\u0019R\u001a\u0010}\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0017\"\u0004\b\u007f\u0010\u0019R\u001d\u0010\u0080\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0017\"\u0005\b\u0082\u0001\u0010\u0019R\u001d\u0010\u0083\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0017\"\u0005\b\u0085\u0001\u0010\u0019R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\"\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u0089\u0001\"\u0006\b\u008e\u0001\u0010\u008b\u0001R\"\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0089\u0001\"\u0006\b\u0091\u0001\u0010\u008b\u0001R\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0089\u0001\"\u0006\b\u0094\u0001\u0010\u008b\u0001R\u001d\u0010\u0095\u0001\u001a\u00020\u001eX\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010e\"\u0005\b\u0097\u0001\u0010gR\u001d\u0010\u0098\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010\u0017\"\u0005\b\u009a\u0001\u0010\u0019R\u001d\u0010\u009b\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010\u0017\"\u0005\b\u009d\u0001\u0010\u0019R\u001d\u0010\u009e\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010\u0017\"\u0005\b \u0001\u0010\u0019R\u001d\u0010¡\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u0017\"\u0005\b£\u0001\u0010\u0019R\u001d\u0010¤\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u0017\"\u0005\b¦\u0001\u0010\u0019R\u001d\u0010§\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010\u0017\"\u0005\b©\u0001\u0010\u0019R\"\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R\u001d\u0010°\u0001\u001a\u00020RX\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010T\"\u0005\b²\u0001\u0010VR\u001d\u0010³\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010\u0017\"\u0005\bµ\u0001\u0010\u0019R \u0010¶\u0001\u001a\u00030·\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R\u001f\u0010¼\u0001\u001a\n\u0012\u0005\u0012\u00030¾\u00010½\u0001X\u0084\u0004¢\u0006\n\n\u0000\u001a\u0006\b¿\u0001\u0010À\u0001R,\u0010Á\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0005\u0012\u00030Ã\u00010Â\u00010½\u0001X\u0084\u0004¢\u0006\n\n\u0000\u001a\u0006\bÄ\u0001\u0010À\u0001R\"\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R\u001d\u0010Ë\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010e\"\u0005\bÍ\u0001\u0010gR\u001d\u0010Î\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010e\"\u0005\bÐ\u0001\u0010gR\u001d\u0010Ñ\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÒ\u0001\u0010e\"\u0005\bÓ\u0001\u0010gR\u001d\u0010Ô\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÕ\u0001\u0010e\"\u0005\bÖ\u0001\u0010gR\u001d\u0010×\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bØ\u0001\u0010e\"\u0005\bÙ\u0001\u0010gR\u001d\u0010Ú\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÛ\u0001\u0010e\"\u0005\bÜ\u0001\u0010g¨\u0006\u008c\u0002"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDDialogController;", "Lcom/larksuite/component/universe_design/dialog/UDDialog$DialogCallback;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mDialog", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", "getMDialog", "()Lcom/larksuite/component/universe_design/dialog/UDDialog;", "setMDialog", "(Lcom/larksuite/component/universe_design/dialog/UDDialog;)V", "mTitle", "", "getMTitle", "()Ljava/lang/CharSequence;", "setMTitle", "(Ljava/lang/CharSequence;)V", "mTitleSize", "", "getMTitleSize", "()I", "setMTitleSize", "(I)V", "mTitleTextColor", "getMTitleTextColor", "setMTitleTextColor", "mTitleTextStyleBold", "", "getMTitleTextStyleBold", "()Ljava/lang/Boolean;", "setMTitleTextStyleBold", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mTitleLineCount", "getMTitleLineCount", "setMTitleLineCount", "mTitleGravity", "getMTitleGravity", "setMTitleGravity", "mTitlePaddingLeft", "getMTitlePaddingLeft", "setMTitlePaddingLeft", "mTitlePaddingTop", "getMTitlePaddingTop", "setMTitlePaddingTop", "mTitlePaddingRight", "getMTitlePaddingRight", "setMTitlePaddingRight", "mTitlePaddingBottom", "getMTitlePaddingBottom", "setMTitlePaddingBottom", "mMessage", "getMMessage", "setMMessage", "mMessageSize", "getMMessageSize", "setMMessageSize", "mMessageTextColor", "getMMessageTextColor", "setMMessageTextColor", "mMessagePaddingLeft", "getMMessagePaddingLeft", "setMMessagePaddingLeft", "mMessagePaddingTop", "getMMessagePaddingTop", "setMMessagePaddingTop", "mMessagePaddingRight", "getMMessagePaddingRight", "setMMessagePaddingRight", "mMessagePaddingBottom", "getMMessagePaddingBottom", "setMMessagePaddingBottom", "mMessageGravity", "getMMessageGravity", "setMMessageGravity", "mGravity", "getMGravity", "setMGravity", "mWidth", "", "getMWidth", "()F", "setMWidth", "(F)V", "mMaxWidth", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "getMMaxWidth", "()Lcom/larksuite/component/universe_design/dimension/UDDimension;", "setMMaxWidth", "(Lcom/larksuite/component/universe_design/dimension/UDDimension;)V", "mHeight", "getMHeight", "setMHeight", "mMaxHeight", "getMMaxHeight", "setMMaxHeight", "mAutoDismiss", "getMAutoDismiss", "()Z", "setMAutoDismiss", "(Z)V", "mCancelable", "getMCancelable", "setMCancelable", "mCanceledOnTouchOutside", "getMCanceledOnTouchOutside", "setMCanceledOnTouchOutside", "mOnCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getMOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setMOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getMOnDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setMOnDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "mHeaderLayoutRes", "getMHeaderLayoutRes", "setMHeaderLayoutRes", "mContentLayoutRes", "getMContentLayoutRes", "setMContentLayoutRes", "mFooterLayoutRes", "getMFooterLayoutRes", "setMFooterLayoutRes", "mRootLayoutRes", "getMRootLayoutRes", "setMRootLayoutRes", "mHeaderLayout", "Landroid/view/View;", "getMHeaderLayout", "()Landroid/view/View;", "setMHeaderLayout", "(Landroid/view/View;)V", "mContentLayout", "getMContentLayout", "setMContentLayout", "mFooterLayout", "getMFooterLayout", "setMFooterLayout", "mRootLayout", "getMRootLayout", "setMRootLayout", "mAllowContentScroll", "getMAllowContentScroll", "setMAllowContentScroll", "mMarginInDp", "getMMarginInDp", "setMMarginInDp", "mTranslationOnY", "getMTranslationOnY", "setMTranslationOnY", "mPaddingLeftInDp", "getMPaddingLeftInDp", "setMPaddingLeftInDp", "mPaddingTopInDp", "getMPaddingTopInDp", "setMPaddingTopInDp", "mPaddingRightInDp", "getMPaddingRightInDp", "setMPaddingRightInDp", "mPaddingBottomInDp", "getMPaddingBottomInDp", "setMPaddingBottomInDp", "mBackground", "Landroid/graphics/drawable/Drawable;", "getMBackground", "()Landroid/graphics/drawable/Drawable;", "setMBackground", "(Landroid/graphics/drawable/Drawable;)V", "mMaskAlpha", "getMMaskAlpha", "setMMaskAlpha", "mAnimStyle", "getMAnimStyle", "setMAnimStyle", "mActionButtonsOrientation", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;", "getMActionButtonsOrientation", "()Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;", "setMActionButtonsOrientation", "(Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;)V", "mActionButtons", "", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionButtonInfo;", "getMActionButtons", "()Ljava/util/List;", "mViewClickInfos", "Landroid/util/Pair;", "Landroid/content/DialogInterface$OnClickListener;", "getMViewClickInfos", "mLifecycleCallback", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$LifecycleCallback;", "getMLifecycleCallback", "()Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$LifecycleCallback;", "setMLifecycleCallback", "(Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$LifecycleCallback;)V", "isHeaderLayoutDefault", "isHeaderLayoutDefault$universe_ui_dialog_release", "setHeaderLayoutDefault$universe_ui_dialog_release", "isContentLayoutDefault", "isContentLayoutDefault$universe_ui_dialog_release", "setContentLayoutDefault$universe_ui_dialog_release", "isFooterLayoutDefault", "isFooterLayoutDefault$universe_ui_dialog_release", "setFooterLayoutDefault$universe_ui_dialog_release", "isHeaderVisible", "isHeaderVisible$universe_ui_dialog_release", "setHeaderVisible$universe_ui_dialog_release", "isContentVisible", "isContentVisible$universe_ui_dialog_release", "setContentVisible$universe_ui_dialog_release", "isFooterVisible", "isFooterVisible$universe_ui_dialog_release", "setFooterVisible$universe_ui_dialog_release", e1.REPLY_ACTION_APPLY, "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "builder", "dialog", "beforeCreate", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", SendEventContainerMethodParamModel.EventKinds.onShow, "onDismiss", "getDefaultHeaderRes", "onCreateHeader", "getDefaultContentRes", "onCreateContent", "getDefaultFooterRes", "onCreateFooter", "applyDialogConfig", "getDefaultRootRes", "createView", "initView", "createDialogFrame", "Landroid/view/ViewGroup;", "toSize", "Lcom/larksuite/component/universe_design/dialog/frame/DialogFrame$Size;", "adjustSize", "toLayoutSize", "setupTextView", "textView", "Landroid/widget/TextView;", "textSize", "textColor", "setupViewPadding", "view", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "getFinalView", "initRes", "defaultRes", "getSize", "dpValue", "fullSize", "Companion", "DialogFooter", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDDialogController implements UDDialog.DialogCallback {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final int DEFAULT_NO_MESSAGE_TITLE_PADDING_BOTTOM = 24;
    private static final int DEFAULT_NO_TITLE_MESSAGE_PADDING_TOP = 24;
    private final Context context;
    private boolean isContentLayoutDefault;
    private boolean isContentVisible;
    private boolean isFooterLayoutDefault;
    private boolean isFooterVisible;
    private boolean isHeaderLayoutDefault;
    private boolean isHeaderVisible;
    private final List<UDBaseDialogBuilder.a> mActionButtons;
    private UDBaseDialogBuilder.ActionBottomOrientation mActionButtonsOrientation;
    private boolean mAllowContentScroll;
    private int mAnimStyle;
    private boolean mAutoDismiss;
    private Drawable mBackground;
    private Boolean mCancelable;
    private Boolean mCanceledOnTouchOutside;
    private View mContentLayout;
    private int mContentLayoutRes;
    private UDDialog mDialog;
    private View mFooterLayout;
    private int mFooterLayoutRes;
    private int mGravity;
    private View mHeaderLayout;
    private int mHeaderLayoutRes;
    private float mHeight;
    private UDBaseDialogBuilder.c mLifecycleCallback;
    private int mMarginInDp;
    private float mMaskAlpha;
    private float mMaxHeight;
    private UDDimension mMaxWidth;
    private CharSequence mMessage;
    private int mMessageGravity;
    private int mMessagePaddingBottom;
    private int mMessagePaddingLeft;
    private int mMessagePaddingRight;
    private int mMessagePaddingTop;
    private int mMessageSize;
    private int mMessageTextColor;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private int mPaddingBottomInDp;
    private int mPaddingLeftInDp;
    private int mPaddingRightInDp;
    private int mPaddingTopInDp;
    private View mRootLayout;
    private int mRootLayoutRes;
    private CharSequence mTitle;
    private int mTitleGravity;
    private int mTitleLineCount;
    private int mTitlePaddingBottom;
    private int mTitlePaddingLeft;
    private int mTitlePaddingRight;
    private int mTitlePaddingTop;
    private int mTitleSize;
    private int mTitleTextColor;
    private Boolean mTitleTextStyleBold;
    private int mTranslationOnY;
    private final List<Pair<Integer, DialogInterface.OnClickListener>> mViewClickInfos;
    private float mWidth;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J(\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J(\u0010$\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J(\u0010%\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010 \u001a\u00020&2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J(\u0010'\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J(\u0010(\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J(\u0010)\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010 \u001a\u00020&2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J\f\u0010*\u001a\u00020\u0016*\u00020\u001fH\u0002R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDDialogController$DialogFooter;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;", "actionButtonOrientation", "getActionButtonOrientation", "()Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;", "setActionButtonOrientation", "(Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;)V", "initActions", "", "completeAutoCalc", "", "lastWidthMeasureSpec", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "changeToHorizontal", "changeToVertical", "ensureHorizontalConstraints", "primaryButton", "Landroid/widget/TextView;", "secondaryButton", ItemStyle.ITEM_STYLE_DIVIDER, "Landroid/view/View;", "topDivider", "ensureHorizontalDividers", "ensureHorizontalRadius", "Lcom/larksuite/component/universe_design/button/UDButton;", "ensureVerticalConstraints", "ensureVerticalDividers", "ensureVerticalRadius", "canNotDisplayAsSingleLine", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DialogFooter extends ConstraintLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UDBaseDialogBuilder.ActionBottomOrientation f284853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f284854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f284855c;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f284856a = null;

            static {
                int[] r100 = new int[UDBaseDialogBuilder.ActionBottomOrientation.values().length];
                r100[UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[UDBaseDialogBuilder.ActionBottomOrientation.AUTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f284856a = r100;
            }
        }

        public final void R5() {
            UDButton r100 = (UDButton) findViewById(R.id.ud_dialog_btn_primary);
            UDButton r101 = (UDButton) findViewById(R.id.ud_dialog_btn_secondary);
            View r102 = findViewById(R.id.ud_dialog_btn_divider);
            View r103 = findViewById(R.id.ud_dialog_footer_divider);
            ViewGroup.LayoutParams r104 = r101.getLayoutParams();
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104;
            r105.startToStart = 0;
            r105.startToEnd = -1;
            r105.endToStart = r102.getId();
            r105.endToEnd = -1;
            r105.topToTop = -1;
            r105.topToBottom = r103.getId();
            r105.bottomToTop = -1;
            r105.bottomToBottom = 0;
            r101.setLayoutParams(r104);
            ViewGroup.LayoutParams r106 = r102.getLayoutParams();
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
            ((ViewGroup.MarginLayoutParams) r107).width = h18.d.d(getContext(), R.dimen.ud_divider_size);
            ((ViewGroup.MarginLayoutParams) r107).height = 0;
            r107.startToStart = -1;
            r107.startToEnd = r101.getId();
            r107.endToStart = r100.getId();
            r107.endToEnd = -1;
            r107.topToTop = -1;
            r107.topToBottom = r103.getId();
            r107.bottomToTop = -1;
            r107.bottomToBottom = 0;
            r102.setLayoutParams(r106);
            ViewGroup.LayoutParams r108 = r100.getLayoutParams();
            Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r109 = (ConstraintLayout.LayoutParams) r108;
            r109.startToStart = -1;
            r109.startToEnd = r102.getId();
            r109.endToStart = -1;
            r109.endToEnd = 0;
            r109.topToTop = -1;
            r109.topToBottom = r103.getId();
            r109.bottomToTop = -1;
            r109.bottomToBottom = 0;
            r100.setLayoutParams(r108);
            if (r100.getVisibility() == 0) goto L5;
        L7:
            r102.setVisibility(8);
        L9:
            if (r100.getVisibility() != 0) goto L11;
        L14:
            r103.setVisibility(0);
        L15:
            float r110 = UDRadius.L.getRadiusSize(getContext());
            if (r100.getVisibility() != 0) goto L21;
            if (r101.getVisibility() != 0) goto L21;
            r100.setCornerRadii(0.0f, 0.0f, 0.0f, r110);
            r101.setCornerRadii(0.0f, 0.0f, r110, 0.0f);
        L21:
            if (r100.getVisibility() != 0) goto L26;
            if (r101.getVisibility() != 8) goto L26;
            r100.setCornerRadii(0.0f, 0.0f, r110, r110);
            r101.setCornerRadii(0.0f, 0.0f, 0.0f, 0.0f);
        L26:
            if (r100.getVisibility() == 8) goto L28;
            return;
        L28:
            if (r101.getVisibility() != 0) goto L32;
            r100.setCornerRadii(0.0f, 0.0f, 0.0f, 0.0f);
            r101.setCornerRadii(0.0f, 0.0f, r110, r110);
            return;
        L32:
            return;
        L11:
            if (r101.getVisibility() == 0) goto L14;
            r103.setVisibility(8);
            goto L15
        L5:
            if (r101.getVisibility() != 0) goto L7;
            r102.setVisibility(0);
            goto L9
        }

        public final void S5() {
            removeAllViews();
            UDBaseDialogBuilder.ActionBottomOrientation r100 = this.f284853a;
            int r101 = a.f284856a[r100.ordinal()];
            if (r101 != 1) goto L5;
        L11:
            LayoutInflater.from(getContext()).inflate(R.layout.ud_dialog_footer_auto_horizontal, this, true);
        L13:
            if (this.f284853a != UDBaseDialogBuilder.ActionBottomOrientation.AUTO) goto L16;
            this.f284854b = false;
            return;
        L16:
            return;
        L5:
            if (r101 == 2) goto L11;
            if (r101 != 3) goto L10;
            LayoutInflater.from(getContext()).inflate(R.layout.ud_dialog_footer_vertical, this, true);
            goto L13
        L10:
            throw new NoWhenBranchMatchedException();
        }

        public final UDBaseDialogBuilder.ActionBottomOrientation getActionButtonOrientation() {
            return this.f284853a;
        }

        public DialogFooter(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f284853a = UDBaseDialogBuilder.ActionBottomOrientation.AUTO;
            S5();
        }

        public final void setActionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            if (this.f284853a == r100) goto L6;
            this.f284853a = r100;
            S5();
            requestLayout();
            return;
        }

        public DialogFooter(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101);
            this.f284853a = UDBaseDialogBuilder.ActionBottomOrientation.AUTO;
            S5();
        }

        @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
        public final void onMeasure(int r110, int r111) {
            UDBaseDialogBuilder.ActionBottomOrientation r100 = this.f284853a;
            UDBaseDialogBuilder.ActionBottomOrientation r101 = UDBaseDialogBuilder.ActionBottomOrientation.AUTO;
            if (r100 == r101) goto L5;
        L7:
            super.onMeasure(r110, r111);
            if (this.f284853a == r101) goto L10;
            return;
        L10:
            if (this.f284854b == true) goto L47;
            TextView r102 = (TextView) findViewById(R.id.ud_dialog_btn_primary);
            TextView r103 = (TextView) findViewById(R.id.ud_dialog_btn_secondary);
            if (r102.getVisibility() != 8) goto L15;
        L17:
            boolean r104 = false;
        L18:
            if (r104 == false) goto L20;
        L29:
            UDButton r105 = (UDButton) findViewById(R.id.ud_dialog_btn_primary);
            UDButton r106 = (UDButton) findViewById(R.id.ud_dialog_btn_secondary);
            View r107 = findViewById(R.id.ud_dialog_btn_divider);
            View r108 = findViewById(R.id.ud_dialog_footer_divider);
            ViewGroup.LayoutParams r109 = r105.getLayoutParams();
            Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r112 = (ConstraintLayout.LayoutParams) r109;
            r112.startToStart = 0;
            r112.startToEnd = -1;
            r112.endToStart = -1;
            r112.endToEnd = 0;
            r112.topToTop = -1;
            r112.topToBottom = r108.getId();
            r112.bottomToTop = r107.getId();
            r112.bottomToBottom = -1;
            r105.setLayoutParams(r109);
            ViewGroup.LayoutParams r113 = r107.getLayoutParams();
            Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r114 = (ConstraintLayout.LayoutParams) r113;
            ((ViewGroup.MarginLayoutParams) r114).width = 0;
            ((ViewGroup.MarginLayoutParams) r114).height = h18.d.d(getContext(), R.dimen.ud_divider_size);
            r114.startToStart = 0;
            r114.startToEnd = -1;
            r114.endToStart = -1;
            r114.endToEnd = 0;
            r114.topToTop = -1;
            r114.topToBottom = r105.getId();
            r114.bottomToTop = r106.getId();
            r114.bottomToBottom = -1;
            r107.setLayoutParams(r113);
            ViewGroup.LayoutParams r115 = r106.getLayoutParams();
            Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r116 = (ConstraintLayout.LayoutParams) r115;
            r116.startToStart = 0;
            r116.startToEnd = -1;
            r116.endToStart = -1;
            r116.endToEnd = 0;
            r116.topToTop = -1;
            r116.topToBottom = r107.getId();
            r116.bottomToTop = -1;
            r116.bottomToBottom = 0;
            r106.setLayoutParams(r115);
            if (r105.getVisibility() != 0) goto L32;
            r108.setVisibility(0);
        L34:
            if (r106.getVisibility() != 0) goto L36;
            r107.setVisibility(0);
        L38:
            if (r105.getVisibility() == 0) goto L40;
            float r117 = UDRadius.L.getRadiusSize(getContext());
            r105.setCornerRadius(0.0f);
            r106.setCornerRadii(0.0f, 0.0f, r117, r117);
        L44:
            this.f284854b = true;
            super.onMeasure(r110, r111);
            return;
        L40:
            if (r106.getVisibility() != 0) goto L42;
            float r118 = UDRadius.L.getRadiusSize(getContext());
            r105.setCornerRadius(0.0f);
            r106.setCornerRadii(0.0f, 0.0f, r118, r118);
            goto L44
        L42:
            float r119 = UDRadius.L.getRadiusSize(getContext());
            r105.setCornerRadii(0.0f, 0.0f, r119, r119);
            r106.setCornerRadius(0.0f);
            goto L44
        L36:
            r107.setVisibility(8);
            goto L38
        L32:
            r108.setVisibility(8);
            goto L34
        L20:
            if (r103.getVisibility() != 8) goto L23;
        L25:
            boolean r120 = false;
        L26:
            if (r120 == true) goto L29;
            R5();
            goto L44
        L23:
            if (r103.getLineCount() <= 1) goto L25;
            r120 = true;
            goto L26
        L15:
            if (r102.getLineCount() <= 1) goto L17;
            r104 = true;
            goto L18
        L47:
            return;
        L5:
            if (this.f284855c == r110) goto L7;
            this.f284855c = r110;
            R5();
            this.f284854b = false;
            goto L7
        }

        public DialogFooter(Context r100, AttributeSet r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101, r102);
            this.f284853a = UDBaseDialogBuilder.ActionBottomOrientation.AUTO;
            S5();
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDDialogController f284857a;

        public b(UDDialogController r100) {
            this.f284857a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (Intrinsics.areEqual(this.f284857a.getMCanceledOnTouchOutside(), Boolean.FALSE) == true) goto L23;
            UDDialog r101 = this.f284857a.getMDialog();
            if (r101 == null) goto L27;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L16:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r103 == null) goto L20;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
            goto L20
        L9:
            if (Looper.myLooper() == r102.getLooper()) goto L11;
            r102.post(DialogLancet.createDismissRunnable(r101));
            return;
        L27:
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair<Integer, DialogInterface.OnClickListener> f284858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UDDialogController f284859b;

        public c(Pair<Integer, DialogInterface.OnClickListener> r100, UDDialogController r101) {
            this.f284858a = r100;
            this.f284859b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ((DialogInterface.OnClickListener) this.f284858a.second).onClick(this.f284859b.getMDialog(), ((Number) this.f284858a.first).intValue());
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDBaseDialogBuilder.a f284860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UDDialogController f284861b;

        public d(UDBaseDialogBuilder.a r100, UDDialogController r101) {
            this.f284860a = r100;
            this.f284861b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DialogInterface.OnClickListener r101 = this.f284860a.f284841i;
            if (r101 == null) goto L6;
            r101.onClick(this.f284861b.getMDialog(), this.f284860a.f284833a);
        L6:
            if (this.f284861b.getMAutoDismiss() == false) goto L26;
            UDDialog r102 = this.f284861b.getMDialog();
            if (r102 == null) goto L30;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r102);
            return;
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r104 == null) goto L23;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
            goto L23
        L12:
            if (Looper.myLooper() == r103.getLooper()) goto L14;
            r103.post(DialogLancet.createDismissRunnable(r102));
            return;
        L30:
            return;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    private final int toLayoutSize(float r100) {
        if (((int) r100) == (-1)) goto L7;
        return -2;
    L7:
        return -1;
    }

    public int getDefaultContentRes() {
        this.isContentLayoutDefault = true;
        return R.layout.ud_dialog_default_content;
    }

    public int getDefaultFooterRes() {
        this.isFooterLayoutDefault = true;
        return R.layout.ud_dialog_default_footer;
    }

    public int getDefaultHeaderRes() {
        this.isHeaderLayoutDefault = true;
        return R.layout.ud_dialog_default_header;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public void onDismiss() {
    }

    private final void adjustSize() {
        UDDialog r100 = this.mDialog;
        if (r100 == null) goto L9;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L10;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = toLayoutSize(this.mWidth);
        r102.height = toLayoutSize(this.mHeight);
        r102.gravity = this.mGravity;
        r102.y = (int) h18.d.b(this.context, this.mTranslationOnY);
        r101.setAttributes(r102);
        return;
    L10:
        return;
    }

    private final ViewGroup createDialogFrame() {
        s08.a r100 = new s08.a(this.context);
        r100.setId(R.id.ud_dialog_frame);
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        r101.gravity = this.mGravity;
        r100.setLayoutParams(r101);
        r100.setOnClickListener(new b(this));
        int r102 = (int) h18.d.b(r100.getContext(), this.mMarginInDp);
        r100.setPadding(r102, r102, r102, r102);
        r100.setDialogWidth(toSize(this.mWidth));
        r100.setDialogHeight(toSize(this.mHeight));
        r100.setMaxWidth(new s08.a.AbstractC7551a.C7552a((int) this.mMaxWidth.toPixels(r100.getContext())));
        r100.setMaxHeight(toSize(this.mMaxHeight));
        return r100;
    }

    public View createView() {
        View r100 = getFinalView(this.mRootLayout, this.mRootLayoutRes, getDefaultRootRes());
        Window r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        setupViewPadding(r100, this.mPaddingLeftInDp, this.mPaddingTopInDp, this.mPaddingRightInDp, this.mPaddingBottomInDp);
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.ud_dialog_header_container);
        ViewGroup r103 = (ViewGroup) r100.findViewById(R.id.ud_dialog_content_container);
        ViewGroup r104 = (ViewGroup) r100.findViewById(R.id.ud_dialog_footer_container);
        View r105 = onCreateHeader();
        if (r105 == null) goto L9;
        if (r102 == null) goto L9;
        r102.addView(r105);
    L9:
        View r106 = onCreateContent();
        if (r106 == null) goto L13;
        if (r103 == null) goto L13;
        r103.addView(r106);
    L13:
        View r107 = onCreateFooter();
        if (r107 == null) goto L17;
        if (r104 == null) goto L17;
        r104.addView(r107);
    L17:
        Iterator<Pair<Integer, DialogInterface.OnClickListener>> r108 = this.mViewClickInfos.iterator();
    L19:
        if (r108.hasNext() == false) goto L24;
        Pair<Integer, DialogInterface.OnClickListener> r109 = r108.next();
        View r110 = r100.findViewById(((Number) r109.first).intValue());
        if (r109.second == null) goto L19;
        if (r110 == null) goto L19;
        r110.setOnClickListener(new c(r109, this));
        goto L19
    L24:
        Drawable r111 = this.mBackground;
        if (r111 == null) goto L27;
        r100.setBackground(r111);
    L27:
        UDDialog r112 = this.mDialog;
        if (r112 == null) goto L30;
        r101 = r112.getWindow();
    L30:
        float r113 = this.mMaskAlpha;
        if (r113 != (-1.0f)) goto L33;
        boolean r114 = true;
    L34:
        if (r114 == true) goto L37;
        if (r101 == null) goto L37;
        r101.setDimAmount(r113);
    L37:
        return r100;
    L33:
        r114 = false;
        goto L34
    }

    public int getDefaultRootRes() {
        if (this.mAllowContentScroll == false) goto L5;
        return R.layout.ud_dialog_default_root;
    L5:
        return R.layout.ud_dialog_default_no_scroll_root;
    }

    public View onCreateContent() {
        View r100 = getFinalView(this.mContentLayout, this.mContentLayoutRes, getDefaultContentRes());
        if (r100 != null) goto L7;
        return null;
    L7:
        if ((!TextUtils.isEmpty(this.mMessage)) == false) goto L21;
        TextView r101 = (TextView) r100.findViewById(R.id.ud_dialog_content_message_tv);
        if (r101 == null) goto L15;
        int r102 = this.mMessageGravity;
        if (r102 < 0) goto L13;
        r101.setGravity(r102);
    L13:
        r101.setText(this.mMessage);
        setupTextView(r101, this.mMessageSize, this.mMessageTextColor);
    L15:
        if (this.isHeaderVisible == false) goto L17;
    L19:
        setupViewPadding(r100, this.mMessagePaddingLeft, this.mMessagePaddingTop, this.mMessagePaddingRight, this.mMessagePaddingBottom);
    L27:
        return r100;
    L17:
        if (this.mMessagePaddingTop >= 0) goto L19;
        Context r103 = this.context;
        setupViewPadding(r100, this.mMessagePaddingLeft, h18.d.e(r103, (int) h18.d.c(r103, R.dimen.ud_dialog_padding_top)), this.mMessagePaddingRight, this.mMessagePaddingBottom);
        goto L27
    L21:
        if (this.mContentLayout != null) goto L27;
        if (this.mContentLayoutRes != 0) goto L27;
        if (this.isContentLayoutDefault == false) goto L27;
        r100.setVisibility(8);
        this.isContentVisible = false;
        goto L27
    }

    public View onCreateFooter() {
        View r100 = getFinalView(this.mFooterLayout, this.mFooterLayoutRes, getDefaultFooterRes());
        if (r100 != null) goto L6;
        return null;
    L6:
        DialogFooter r101 = (DialogFooter) r100.findViewById(R.id.ud_dialog_auto_footer);
        if (r101 == null) goto L9;
        r101.setActionButtonOrientation(this.mActionButtonsOrientation);
    L9:
        Iterator<UDBaseDialogBuilder.a> r102 = this.mActionButtons.iterator();
        int r103 = 0;
    L11:
        if (r102.hasNext() == false) goto L46;
        UDBaseDialogBuilder.a r104 = r102.next();
        TextView r105 = (TextView) r100.findViewById(r104.f284833a);
        if (r105 == null) goto L11;
        r105.setVisibility(0);
        int r106 = r104.f284834b;
        if (r106 == 0) goto L17;
        r105.setText(r106);
    L19:
        if (r104.f284837e == 0) goto L21;
        r105.setTextColor(UDColorUtils.getColor(r105.getContext(), r104.f284837e));
    L24:
        int r107 = r104.f284836d;
        if (r107 == 0) goto L28;
        r105.setTextSize(r107);
    L28:
        if (r104.f284839g == 0) goto L34;
        t08.a r108 = new t08.a();
        r108.setColor(UDColorUtils.getColorStateList(r105.getContext(), r104.f284839g));
        if (r104.f284833a != R.id.ud_dialog_btn_cancel) goto L32;
        UDRadius r110 = UDRadius.XXL;
    L33:
        r108.setCornerRadius(r110.getRadiusSize(r105.getContext()));
        r105.setBackground(r108);
    L37:
        r105.setOnClickListener(new d(r104, this));
        int r109 = r104.f284833a;
        if (r109 == R.id.ud_dialog_btn_secondary2) goto L39;
        if (r109 == R.id.ud_dialog_btn_secondary) goto L41;
        if (r109 == R.id.ud_dialog_btn_primary) goto L43;
        if (r109 != R.id.ud_dialog_btn_cancel) goto L11;
        r103 = r103 | 8;
        goto L11
    L43:
        r103 = r103 | 4;
        goto L11
    L41:
        r103 = r103 | 2;
        goto L11
    L39:
        r103 = r103 | 1;
        goto L11
    L32:
        r110 = UDRadius.L;
        goto L33
    L34:
        int r111 = r104.f284840h;
        if (r111 == 0) goto L37;
        r105.setBackgroundResource(r111);
        goto L37
    L21:
        int r112 = r104.f284838f;
        if (r112 == 0) goto L24;
        r105.setTextColor(r112);
        goto L24
    L17:
        r105.setText(r104.f284835c);
        goto L19
    L46:
        if (r103 <= 0) goto L51;
        View r113 = r100.findViewById(R.id.ud_dialog_footer_divider);
        if (r113 == null) goto L51;
        r113.setVisibility(0);
    L51:
        if (r103 != 6) goto L55;
        View r114 = r100.findViewById(R.id.ud_dialog_btn_divider);
        if (r114 == null) goto L55;
        r114.setVisibility(0);
    L55:
        int r115 = r103 & 1;
        if (r115 == 0) goto L60;
        View r116 = r100.findViewById(R.id.ud_dialog_secondary_btn_divider2);
        if (r116 == null) goto L60;
        r116.setVisibility(0);
    L60:
        int r117 = r103 & 2;
        if (r117 == 0) goto L65;
        View r118 = r100.findViewById(R.id.ud_dialog_secondary_btn_divider);
        if (r118 == null) goto L65;
        r118.setVisibility(0);
    L65:
        int r119 = r103 & 4;
        if (r119 == 0) goto L70;
        View r120 = r100.findViewById(R.id.ud_dialog_primary_btn_divider);
        if (r120 == null) goto L70;
        r120.setVisibility(0);
    L70:
        float r121 = UDRadius.L.getRadiusSize(this.context);
        UDBaseDialogBuilder.ActionBottomOrientation r122 = this.mActionButtonsOrientation;
        if (r122 != UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L83;
        if (r103 != 2) goto L78;
        UDButton r123 = (UDButton) r100.findViewById(R.id.ud_dialog_btn_secondary);
        if (r123 == null) goto L78;
        r123.setCornerRadii(0.0f, 0.0f, r121, r121);
    L78:
        if (r103 != 4) goto L97;
        UDButton r124 = (UDButton) r100.findViewById(R.id.ud_dialog_btn_primary);
        if (r124 == null) goto L97;
        r124.setCornerRadii(0.0f, 0.0f, r121, r121);
    L97:
        if (TextUtils.isEmpty(this.mMessage) == true) goto L99;
    L105:
        return r100;
    L99:
        if (this.mContentLayout != null) goto L105;
        if (this.mContentLayoutRes != 0) goto L105;
        if (this.isContentLayoutDefault == false) goto L105;
        r100.setPadding(0, (int) h18.d.b(this.context, 12), 0, 0);
        goto L105
    L83:
        if (r122 != UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL) goto L97;
        if (r115 <= 0) goto L88;
        UDButton r125 = (UDButton) r100.findViewById(R.id.ud_dialog_btn_secondary2);
        if (r125 == null) goto L97;
        r125.setCornerRadii(0.0f, 0.0f, r121, r121);
        goto L97
    L88:
        if (r117 <= 0) goto L92;
        UDButton r126 = (UDButton) r100.findViewById(R.id.ud_dialog_btn_secondary);
        if (r126 == null) goto L97;
        r126.setCornerRadii(0.0f, 0.0f, r121, r121);
        goto L97
    L92:
        if (r119 <= 0) goto L97;
        UDButton r127 = (UDButton) r100.findViewById(R.id.ud_dialog_btn_primary);
        if (r127 == null) goto L97;
        r127.setCornerRadii(0.0f, 0.0f, r121, r121);
        goto L97
    }

    public View onCreateHeader() {
        View r100 = getFinalView(this.mHeaderLayout, this.mHeaderLayoutRes, getDefaultHeaderRes());
        if (r100 != null) goto L7;
        return null;
    L7:
        if ((!TextUtils.isEmpty(this.mTitle)) == false) goto L19;
        TextView r101 = (TextView) r100.findViewById(R.id.ud_dialog_title_tv);
        if (r101 == null) goto L17;
        r101.setMaxLines(this.mTitleLineCount);
        int r102 = this.mTitleGravity;
        if (r102 < 0) goto L13;
        r101.setGravity(r102);
    L13:
        r101.setText(this.mTitle);
        Boolean r103 = this.mTitleTextStyleBold;
        if (r103 == null) goto L16;
        boolean r104 = Intrinsics.areEqual(r103, Boolean.TRUE);
        int r105 = e.f483540a;
        r101.setTypeface(e.b(r101.getContext(), r104 ? 1 : 0));
    L16:
        setupTextView(r101, this.mTitleSize, this.mTitleTextColor);
    L17:
        setupViewPadding(r100, this.mTitlePaddingLeft, this.mTitlePaddingTop, this.mTitlePaddingRight, this.mTitlePaddingBottom);
    L25:
        return r100;
    L19:
        if (this.mHeaderLayout != null) goto L25;
        if (this.mHeaderLayoutRes != 0) goto L25;
        if (this.isHeaderLayoutDefault == false) goto L25;
        r100.setVisibility(8);
        this.isHeaderVisible = false;
        goto L25
    }

    private final void initView() {
        View r100 = createView();
        ViewGroup r101 = createDialogFrame();
        if (r100 == null) goto L5;
        r101.addView(r100, -2, -2);
    L5:
        UDDialog r102 = this.mDialog;
        if (r102 == null) goto L9;
        r102.setContentView(r101);
        return;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<UDBaseDialogBuilder.a> getMActionButtons() {
        return this.mActionButtons;
    }

    public final UDBaseDialogBuilder.ActionBottomOrientation getMActionButtonsOrientation() {
        return this.mActionButtonsOrientation;
    }

    public final boolean getMAllowContentScroll() {
        return this.mAllowContentScroll;
    }

    public final int getMAnimStyle() {
        return this.mAnimStyle;
    }

    public final boolean getMAutoDismiss() {
        return this.mAutoDismiss;
    }

    public final Drawable getMBackground() {
        return this.mBackground;
    }

    public final Boolean getMCancelable() {
        return this.mCancelable;
    }

    public final Boolean getMCanceledOnTouchOutside() {
        return this.mCanceledOnTouchOutside;
    }

    public final View getMContentLayout() {
        return this.mContentLayout;
    }

    public final int getMContentLayoutRes() {
        return this.mContentLayoutRes;
    }

    public final UDDialog getMDialog() {
        return this.mDialog;
    }

    public final View getMFooterLayout() {
        return this.mFooterLayout;
    }

    public final int getMFooterLayoutRes() {
        return this.mFooterLayoutRes;
    }

    public final int getMGravity() {
        return this.mGravity;
    }

    public final View getMHeaderLayout() {
        return this.mHeaderLayout;
    }

    public final int getMHeaderLayoutRes() {
        return this.mHeaderLayoutRes;
    }

    public final float getMHeight() {
        return this.mHeight;
    }

    public final UDBaseDialogBuilder.c getMLifecycleCallback() {
        return this.mLifecycleCallback;
    }

    public final int getMMarginInDp() {
        return this.mMarginInDp;
    }

    public final float getMMaskAlpha() {
        return this.mMaskAlpha;
    }

    public final float getMMaxHeight() {
        return this.mMaxHeight;
    }

    public final UDDimension getMMaxWidth() {
        return this.mMaxWidth;
    }

    public final CharSequence getMMessage() {
        return this.mMessage;
    }

    public final int getMMessageGravity() {
        return this.mMessageGravity;
    }

    public final int getMMessagePaddingBottom() {
        return this.mMessagePaddingBottom;
    }

    public final int getMMessagePaddingLeft() {
        return this.mMessagePaddingLeft;
    }

    public final int getMMessagePaddingRight() {
        return this.mMessagePaddingRight;
    }

    public final int getMMessagePaddingTop() {
        return this.mMessagePaddingTop;
    }

    public final int getMMessageSize() {
        return this.mMessageSize;
    }

    public final int getMMessageTextColor() {
        return this.mMessageTextColor;
    }

    public final DialogInterface.OnCancelListener getMOnCancelListener() {
        return this.mOnCancelListener;
    }

    public final DialogInterface.OnDismissListener getMOnDismissListener() {
        return this.mOnDismissListener;
    }

    public final int getMPaddingBottomInDp() {
        return this.mPaddingBottomInDp;
    }

    public final int getMPaddingLeftInDp() {
        return this.mPaddingLeftInDp;
    }

    public final int getMPaddingRightInDp() {
        return this.mPaddingRightInDp;
    }

    public final int getMPaddingTopInDp() {
        return this.mPaddingTopInDp;
    }

    public final View getMRootLayout() {
        return this.mRootLayout;
    }

    public final int getMRootLayoutRes() {
        return this.mRootLayoutRes;
    }

    public final CharSequence getMTitle() {
        return this.mTitle;
    }

    public final int getMTitleGravity() {
        return this.mTitleGravity;
    }

    public final int getMTitleLineCount() {
        return this.mTitleLineCount;
    }

    public final int getMTitlePaddingBottom() {
        return this.mTitlePaddingBottom;
    }

    public final int getMTitlePaddingLeft() {
        return this.mTitlePaddingLeft;
    }

    public final int getMTitlePaddingRight() {
        return this.mTitlePaddingRight;
    }

    public final int getMTitlePaddingTop() {
        return this.mTitlePaddingTop;
    }

    public final int getMTitleSize() {
        return this.mTitleSize;
    }

    public final int getMTitleTextColor() {
        return this.mTitleTextColor;
    }

    public final Boolean getMTitleTextStyleBold() {
        return this.mTitleTextStyleBold;
    }

    public final int getMTranslationOnY() {
        return this.mTranslationOnY;
    }

    public final List<Pair<Integer, DialogInterface.OnClickListener>> getMViewClickInfos() {
        return this.mViewClickInfos;
    }

    public final float getMWidth() {
        return this.mWidth;
    }

    public final boolean isContentLayoutDefault$universe_ui_dialog_release() {
        return this.isContentLayoutDefault;
    }

    public final boolean isContentVisible$universe_ui_dialog_release() {
        return this.isContentVisible;
    }

    public final boolean isFooterLayoutDefault$universe_ui_dialog_release() {
        return this.isFooterLayoutDefault;
    }

    public final boolean isFooterVisible$universe_ui_dialog_release() {
        return this.isFooterVisible;
    }

    public final boolean isHeaderLayoutDefault$universe_ui_dialog_release() {
        return this.isHeaderLayoutDefault;
    }

    public final boolean isHeaderVisible$universe_ui_dialog_release() {
        return this.isHeaderVisible;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public void onShow() {
        adjustSize();
    }

    public UDDialogController(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.mTitleSize = -1;
        this.mTitleTextColor = -1;
        this.mTitleLineCount = 2;
        this.mTitleGravity = -1;
        this.mTitlePaddingLeft = -1;
        this.mTitlePaddingTop = -1;
        this.mTitlePaddingRight = -1;
        this.mTitlePaddingBottom = -1;
        this.mMessageSize = -1;
        this.mMessageTextColor = -1;
        this.mMessagePaddingLeft = -1;
        this.mMessagePaddingTop = -1;
        this.mMessagePaddingRight = -1;
        this.mMessagePaddingBottom = -1;
        this.mMessageGravity = -1;
        this.mGravity = 17;
        this.mWidth = 1.0f;
        this.mMaxWidth = new UDDimension.a(Integer.MAX_VALUE);
        this.mHeight = -2.0f;
        this.mMaxHeight = 1.0f;
        this.mAutoDismiss = true;
        this.mAllowContentScroll = true;
        this.mMaskAlpha = -1.0f;
        this.mActionButtonsOrientation = UDBaseDialogBuilder.ActionBottomOrientation.AUTO;
        this.mActionButtons = new ArrayList();
        this.mViewClickInfos = new ArrayList();
        this.isHeaderVisible = true;
        this.isContentVisible = true;
        this.isFooterVisible = true;
    }

    private final void applyDialogConfig(UDBaseDialogBuilder<?> r100) {
        if ((r100.getMGravity$universe_ui_dialog_release() & 80) == 80) goto L5;
        return;
    L5:
        if (this.mAnimStyle != 0) goto L9;
        UDDialog.Companion.getClass();
        UDDialog.access$getConfig$cp().getClass();
        this.mAnimStyle = R.style.UD_BottomDialogAnim;
        return;
    }

    private final s08.a.AbstractC7551a toSize(float r100) {
        if (r100 <= 0.0f) goto L8;
        if (r100 > 1.0f) goto L8;
        return new s08.a.AbstractC7551a.b(r100);
    L8:
        if (r100 <= 1.0f) goto L11;
        return new s08.a.AbstractC7551a.C7552a((int) h18.d.a(this.context, r100));
    L11:
        return new s08.a.AbstractC7551a.C7552a((int) r100);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public void beforeCreate(UDDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        UDBaseDialogBuilder.c r101 = this.mLifecycleCallback;
        if (r101 == null) goto L6;
        r101.beforeCreate(r100);
        return;
    }

    public final void setContentLayoutDefault$universe_ui_dialog_release(boolean r100) {
        this.isContentLayoutDefault = r100;
    }

    public final void setContentVisible$universe_ui_dialog_release(boolean r100) {
        this.isContentVisible = r100;
    }

    public final void setFooterLayoutDefault$universe_ui_dialog_release(boolean r100) {
        this.isFooterLayoutDefault = r100;
    }

    public final void setFooterVisible$universe_ui_dialog_release(boolean r100) {
        this.isFooterVisible = r100;
    }

    public final void setHeaderLayoutDefault$universe_ui_dialog_release(boolean r100) {
        this.isHeaderLayoutDefault = r100;
    }

    public final void setHeaderVisible$universe_ui_dialog_release(boolean r100) {
        this.isHeaderVisible = r100;
    }

    public final void setMActionButtonsOrientation(UDBaseDialogBuilder.ActionBottomOrientation r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mActionButtonsOrientation = r100;
    }

    public final void setMAllowContentScroll(boolean r100) {
        this.mAllowContentScroll = r100;
    }

    public final void setMAnimStyle(int r100) {
        this.mAnimStyle = r100;
    }

    public final void setMAutoDismiss(boolean r100) {
        this.mAutoDismiss = r100;
    }

    public final void setMBackground(Drawable r100) {
        this.mBackground = r100;
    }

    public final void setMCancelable(Boolean r100) {
        this.mCancelable = r100;
    }

    public final void setMCanceledOnTouchOutside(Boolean r100) {
        this.mCanceledOnTouchOutside = r100;
    }

    public final void setMContentLayout(View r100) {
        this.mContentLayout = r100;
    }

    public final void setMContentLayoutRes(int r100) {
        this.mContentLayoutRes = r100;
    }

    public final void setMDialog(UDDialog r100) {
        this.mDialog = r100;
    }

    public final void setMFooterLayout(View r100) {
        this.mFooterLayout = r100;
    }

    public final void setMFooterLayoutRes(int r100) {
        this.mFooterLayoutRes = r100;
    }

    public final void setMGravity(int r100) {
        this.mGravity = r100;
    }

    public final void setMHeaderLayout(View r100) {
        this.mHeaderLayout = r100;
    }

    public final void setMHeaderLayoutRes(int r100) {
        this.mHeaderLayoutRes = r100;
    }

    public final void setMHeight(float r100) {
        this.mHeight = r100;
    }

    public final void setMLifecycleCallback(UDBaseDialogBuilder.c r100) {
        this.mLifecycleCallback = r100;
    }

    public final void setMMarginInDp(int r100) {
        this.mMarginInDp = r100;
    }

    public final void setMMaskAlpha(float r100) {
        this.mMaskAlpha = r100;
    }

    public final void setMMaxHeight(float r100) {
        this.mMaxHeight = r100;
    }

    public final void setMMaxWidth(UDDimension r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mMaxWidth = r100;
    }

    public final void setMMessage(CharSequence r100) {
        this.mMessage = r100;
    }

    public final void setMMessageGravity(int r100) {
        this.mMessageGravity = r100;
    }

    public final void setMMessagePaddingBottom(int r100) {
        this.mMessagePaddingBottom = r100;
    }

    public final void setMMessagePaddingLeft(int r100) {
        this.mMessagePaddingLeft = r100;
    }

    public final void setMMessagePaddingRight(int r100) {
        this.mMessagePaddingRight = r100;
    }

    public final void setMMessagePaddingTop(int r100) {
        this.mMessagePaddingTop = r100;
    }

    public final void setMMessageSize(int r100) {
        this.mMessageSize = r100;
    }

    public final void setMMessageTextColor(int r100) {
        this.mMessageTextColor = r100;
    }

    public final void setMOnCancelListener(DialogInterface.OnCancelListener r100) {
        this.mOnCancelListener = r100;
    }

    public final void setMOnDismissListener(DialogInterface.OnDismissListener r100) {
        this.mOnDismissListener = r100;
    }

    public final void setMPaddingBottomInDp(int r100) {
        this.mPaddingBottomInDp = r100;
    }

    public final void setMPaddingLeftInDp(int r100) {
        this.mPaddingLeftInDp = r100;
    }

    public final void setMPaddingRightInDp(int r100) {
        this.mPaddingRightInDp = r100;
    }

    public final void setMPaddingTopInDp(int r100) {
        this.mPaddingTopInDp = r100;
    }

    public final void setMRootLayout(View r100) {
        this.mRootLayout = r100;
    }

    public final void setMRootLayoutRes(int r100) {
        this.mRootLayoutRes = r100;
    }

    public final void setMTitle(CharSequence r100) {
        this.mTitle = r100;
    }

    public final void setMTitleGravity(int r100) {
        this.mTitleGravity = r100;
    }

    public final void setMTitleLineCount(int r100) {
        this.mTitleLineCount = r100;
    }

    public final void setMTitlePaddingBottom(int r100) {
        this.mTitlePaddingBottom = r100;
    }

    public final void setMTitlePaddingLeft(int r100) {
        this.mTitlePaddingLeft = r100;
    }

    public final void setMTitlePaddingRight(int r100) {
        this.mTitlePaddingRight = r100;
    }

    public final void setMTitlePaddingTop(int r100) {
        this.mTitlePaddingTop = r100;
    }

    public final void setMTitleSize(int r100) {
        this.mTitleSize = r100;
    }

    public final void setMTitleTextColor(int r100) {
        this.mTitleTextColor = r100;
    }

    public final void setMTitleTextStyleBold(Boolean r100) {
        this.mTitleTextStyleBold = r100;
    }

    public final void setMTranslationOnY(int r100) {
        this.mTranslationOnY = r100;
    }

    public final void setMWidth(float r100) {
        this.mWidth = r100;
    }

    public <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        this.mDialog = r101;
        r101.setCallback$universe_ui_dialog_release(this);
        this.mTitle = r100.getMTitle$universe_ui_dialog_release();
        this.mTitleSize = r100.getMTitleSize$universe_ui_dialog_release();
        this.mTitleTextColor = r100.getMTitleTextColor$universe_ui_dialog_release();
        this.mTitleTextStyleBold = r100.getMTitleTextStyleBold$universe_ui_dialog_release();
        this.mTitleLineCount = r100.getMTitleLineCount$universe_ui_dialog_release();
        this.mTitleGravity = r100.getMTitleGravity$universe_ui_dialog_release();
        this.mTitlePaddingLeft = r100.getMTitlePaddingLeft$universe_ui_dialog_release();
        this.mTitlePaddingTop = r100.getMTitlePaddingTop$universe_ui_dialog_release();
        this.mTitlePaddingRight = r100.getMTitlePaddingRight$universe_ui_dialog_release();
        this.mTitlePaddingBottom = r100.getMTitlePaddingBottom$universe_ui_dialog_release();
        this.mMessage = r100.getMMessage$universe_ui_dialog_release();
        this.mMessageSize = r100.getMMessageSize$universe_ui_dialog_release();
        this.mMessageTextColor = r100.getMMessageTextColor$universe_ui_dialog_release();
        this.mMessagePaddingLeft = r100.getMMessagePaddingLeft$universe_ui_dialog_release();
        this.mMessagePaddingTop = r100.getMMessagePaddingTop$universe_ui_dialog_release();
        this.mMessagePaddingRight = r100.getMMessagePaddingRight$universe_ui_dialog_release();
        this.mMessagePaddingBottom = r100.getMMessagePaddingBottom$universe_ui_dialog_release();
        this.mMessageGravity = r100.getMMessageGravity$universe_ui_dialog_release();
        this.mGravity = r100.getMGravity$universe_ui_dialog_release();
        this.mWidth = r100.getMWidth$universe_ui_dialog_release();
        this.mMaxWidth = r100.getMMaxWidth$universe_ui_dialog_release();
        this.mHeight = r100.getMHeight$universe_ui_dialog_release();
        this.mMaxHeight = r100.getMMaxHeight$universe_ui_dialog_release();
        this.mAutoDismiss = r100.getMAutoDismiss$universe_ui_dialog_release();
        this.mCancelable = r100.getMCancelable$universe_ui_dialog_release();
        this.mCanceledOnTouchOutside = r100.getMCanceledOnTouchOutside$universe_ui_dialog_release();
        this.mOnCancelListener = r100.getMOnCancelListener$universe_ui_dialog_release();
        this.mOnDismissListener = r100.getMOnDismissListener$universe_ui_dialog_release();
        this.mHeaderLayoutRes = r100.getMHeaderLayoutRes$universe_ui_dialog_release();
        this.mContentLayoutRes = r100.getMContentLayoutRes$universe_ui_dialog_release();
        this.mFooterLayoutRes = r100.getMFooterLayoutRes$universe_ui_dialog_release();
        this.mRootLayoutRes = r100.getMRootLayoutRes$universe_ui_dialog_release();
        this.mHeaderLayout = r100.getMHeaderLayout$universe_ui_dialog_release();
        this.mContentLayout = r100.getMContentLayout$universe_ui_dialog_release();
        this.mFooterLayout = r100.getMFooterLayout$universe_ui_dialog_release();
        this.mRootLayout = r100.getMRootLayout$universe_ui_dialog_release();
        this.mAllowContentScroll = r100.getMAllowContentScroll$universe_ui_dialog_release();
        this.mMarginInDp = r100.getMMarginInDp$universe_ui_dialog_release();
        this.mTranslationOnY = r100.getMTranslationOnY$universe_ui_dialog_release();
        this.mPaddingLeftInDp = r100.getMPaddingLeftInDp$universe_ui_dialog_release();
        this.mPaddingTopInDp = r100.getMPaddingTopInDp$universe_ui_dialog_release();
        this.mPaddingRightInDp = r100.getMPaddingRightInDp$universe_ui_dialog_release();
        this.mPaddingBottomInDp = r100.getMPaddingBottomInDp$universe_ui_dialog_release();
        this.mBackground = r100.getMBackground$universe_ui_dialog_release();
        this.mMaskAlpha = r100.getMMaskAlpha$universe_ui_dialog_release();
        this.mAnimStyle = r100.getMAnimStyle$universe_ui_dialog_release();
        this.mActionButtonsOrientation = r100.getMActionButtonsOrientation$universe_ui_dialog_release();
        this.mActionButtons.addAll(r100.getMActionButtons$universe_ui_dialog_release());
        this.mViewClickInfos.addAll(r100.getMViewClickInfos$universe_ui_dialog_release());
        this.mLifecycleCallback = r100.getMLifecycleCallback$universe_ui_dialog_release();
        if (this.mWidth != 1.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L10:
        applyDialogConfig(r100);
        return;
    L8:
        if (this.mMarginInDp != 0) goto L10;
        this.mWidth = -1.0f;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public final float getSize(float r100, int r101) {
        if (r100 > 0.0f) goto L5;
        return 0.0f;
    L5:
        if (r100 > 1.0f) goto L8;
        return r101 * r100;
    L8:
        return h18.d.a(this.context, r100);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public void onCreate(UDDialog r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Boolean r102 = this.mCancelable;
        if (r102 == null) goto L5;
        r100.setCancelable(r102.booleanValue());
    L5:
        Boolean r103 = this.mCanceledOnTouchOutside;
        if (r103 == null) goto L8;
        r100.setCanceledOnTouchOutside(r103.booleanValue());
    L8:
        DialogInterface.OnCancelListener r104 = this.mOnCancelListener;
        if (r104 == null) goto L11;
        r100.setOnCancelListener(r104);
    L11:
        DialogInterface.OnDismissListener r105 = this.mOnDismissListener;
        if (r105 == null) goto L14;
        r100.setOnDismissListener(r105);
    L14:
        Window r106 = r100.getWindow();
        int r107 = this.mAnimStyle;
        if (r107 == 0) goto L18;
        if (r106 == null) goto L18;
        r106.setWindowAnimations(r107);
    L18:
        initView();
        UDBaseDialogBuilder.c r108 = this.mLifecycleCallback;
        if (r108 == null) goto L22;
        r108.a(r100);
        return;
    }

    public final View getFinalView(View r100, int r101, int r102) {
        if (r100 != null) goto L12;
        if (r101 != 0) goto L8;
        r101 = r102;
    L8:
        if (r101 != 0) goto L10;
        return null;
    L10:
        return LayoutInflater.from(this.context).inflate(r101, null);
    L12:
        return r100;
    }

    public final void setupTextView(TextView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (r101 <= 0) goto L6;
        r100.setTextSize(2, r101);
    L6:
        if (r102 == (-1)) goto L9;
        r100.setTextColor(UDColorUtils.getColor(this.context, r102));
        return;
    }

    public final void setupViewPadding(View r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r105 = (int) h18.d.b(this.context, r101);
        int r106 = (int) h18.d.b(this.context, r102);
        int r107 = (int) h18.d.b(this.context, r103);
        int r108 = (int) h18.d.b(this.context, r104);
        if (r101 >= 0) goto L5;
        r105 = r100.getPaddingLeft();
    L5:
        if (r102 >= 0) goto L7;
        r106 = r100.getPaddingTop();
    L7:
        if (r103 >= 0) goto L9;
        r107 = r100.getPaddingRight();
    L9:
        if (r104 >= 0) goto L11;
        r108 = r100.getPaddingBottom();
    L11:
        r100.setPadding(r105, r106, r107, r108);
    }
}
