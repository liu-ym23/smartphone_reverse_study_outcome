package com.bytedance.applet.debug.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfo;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersion;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersionPage;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.applet.databinding.LarusItemAppletDebugPreviewAppBinding;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u0000 32\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005/0123B/\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nJ*\u0010\u0010\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0015J*\u0010\u0016\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0015J.\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0005J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0012J\u001c\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u001c\u0010&\u001a\u00020\u00062\n\u0010'\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020%H\u0016J\b\u0010)\u001a\u00020%H\u0016J\u0016\u0010*\u001a\u00020\r*\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012*\b\u0012\u0004\u0012\u00020\u001a0\u00122\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050.H\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/applet/debug/view/AppletDebugVersionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/applet/debug/view/AppletDebugVersionAdapter$AppViewHolder;", "onLoadMoreVersions", "Lkotlin/Function2;", "", "", "onChanged", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "appItems", "", "Lcom/bytedance/applet/debug/view/AppletDebugVersionAdapter$PreviewAppUiState;", "dateFormatter", "Ljava/text/SimpleDateFormat;", "setItems", "apps", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfo;", "selectedVersions", "", "appendItems", "appendFormalVersions", "appKey", "versions", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersion;", "nextCursor", "hasMore", "", "markFormalVersionsLoadFinished", "getChangedItems", "Lcom/bytedance/applet/debug/view/AppletDebugVersionAdapter$PreviewDebugConfigChange;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "toUiState", "selectedVersionTag", "filterNotPreviewVersions", "previewVersionTags", "", "AppViewHolder", "PreviewDebugConfigChange", "PreviewAppUiState", "PreviewVersionType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebugVersionAdapter extends RecyclerView.Adapter<AppViewHolder> {
    public final Function2<String, String, Unit> a;
    public final Function0<Unit> b;
    public final List<b> c;
    public final SimpleDateFormat d;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\"\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/applet/debug/view/AppletDebugVersionAdapter$AppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bytedance/applet/databinding/LarusItemAppletDebugPreviewAppBinding;", "<init>", "(Lcom/bytedance/applet/debug/view/AppletDebugVersionAdapter;Lcom/bytedance/applet/databinding/LarusItemAppletDebugPreviewAppBinding;)V", "bind", "", "item", "Lcom/bytedance/applet/debug/view/AppletDebugVersionAdapter$PreviewAppUiState;", "bindCollapsedStatus", "bindVersions", "addEnabledRow", "addVersionRow", "version", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersion;", "type", "Lcom/bytedance/applet/debug/view/AppletDebugVersionAdapter$PreviewVersionType;", "buildVersionTitle", "", "buildVersionDescription", "formatTime", "timestamp", "", "dp", "", "value", "notifyCurrentItemChanged", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AppViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final LarusItemAppletDebugPreviewAppBinding a;
        public final /* synthetic */ AppletDebugVersionAdapter b;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[PreviewVersionType.values().length];
                r0[PreviewVersionType.TEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[PreviewVersionType.AUDIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[PreviewVersionType.FORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final void V3() {
            int r0 = getAdapterPosition();
            if (r0 == (-1)) goto L6;
            this.b.notifyItemChanged(r0);
            return;
        }

        public final int U3(int r3) {
            Resources r0 = this.a.a.getResources();
            return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
        }

        public AppViewHolder(AppletDebugVersionAdapter r2, LarusItemAppletDebugPreviewAppBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.b = r2;
            super(r3.a);
            this.a = r3;
        }

        public final void T3(final b r32, OpenPlatformPreviewVersion r33, PreviewVersionType r34) {
            if (r33 != null) goto L5;
            return;
        L5:
            final String r3 = r33.getVersionTag();
            String r4 = "";
            if (r3 != null) goto L9;
            r3 = "";
        L9:
            if (StringsKt.isBlank(r3) == false) goto L11;
            return;
        L11:
            Context r5 = this.a.a.getContext();
            boolean r6 = Intrinsics.areEqual(r3, r32.g);
            LinearLayout r7 = new LinearLayout(r5);
            r7.setOrientation(0);
            r7.setGravity(16);
            r7.setBackground(ContextCompat.getDrawable(r5, 2131238484));
            r7.setSelected(r6);
            r7.setPadding(U3(12), U3(16), U3(12), U3(16));
            r7.setMinimumHeight(U3(76));
            LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-1, -2);
            r9.topMargin = U3(12);
            r7.setLayoutParams(r9);
            LinearLayout r10 = new LinearLayout(r5);
            r10.setOrientation(1);
            r10.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView r12 = new TextView(r5);
            Context r13 = this.a.a.getContext();
            int r14 = a.a[r34.ordinal()];
            if (r14 == 1) goto L23;
            if (r14 != 2) goto L15;
        L19:
            Object[] r11 = new Object[1];
            String r15 = r33.getVersionTag();
            if (r15 != null) goto L22;
            r15 = "";
        L22:
            r11[0] = r15;
            String r16 = r13.getString(2131894368, r11);
        L24:
            r12.setText(r16);
            r12.setTextColor(ContextCompat.getColor(r5, 2131100424));
            if (r6 == false) goto L27;
            float r17 = 16.0f;
        L28:
            r12.setTextSize(r17);
            r12.setTypeface(Typeface.create("sans-serif-medium", 0));
            r12.setMaxLines(1);
            r12.setEllipsize(TextUtils.TruncateAt.END);
            r10.addView(r12);
            TextView r18 = new TextView(r5);
            Context r19 = this.a.a.getContext();
            Long r110 = r33.getUpdatedAt();
            if (r110 != null) goto L31;
            r110 = r33.getCreatedAt();
        L31:
            Long r111 = null;
            if (r110 != null) goto L34;
        L45:
            String r112 = null;
        L47:
            if (r34 != PreviewVersionType.TEST) goto L51;
            if (r112 == null) goto L51;
        L86:
            r18.setText(r112);
            r18.setTextColor(ContextCompat.getColor(r5, 2131100425));
            r18.setTextSize(13.0f);
            r18.setMaxLines(2);
            r18.setEllipsize(TextUtils.TruncateAt.END);
            r10.addView(r18);
            CheckBox r2 = new CheckBox(r5);
            r2.setButtonDrawable(ContextCompat.getDrawable(r5, 2131238482));
            r2.setChecked(r6);
            r2.setClickable(false);
            r2.setMinWidth(0);
            r2.setMinHeight(0);
            r2.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(U3(24), U3(24));
            r8.setMarginStart(U3(12));
            r2.setLayoutParams(r8);
            r7.addView(r10);
            r7.addView(r2);
            final AppletDebugVersionAdapter r20 = this.b;
            r7.setOnClickListener(new n(r32, r3, this, r20));
            this.a.l.addView(r7);
            return;
        L51:
            if (r34 != PreviewVersionType.AUDIT) goto L54;
            r112 = r19.getString(2131894361);
            goto L86
        L54:
            if (r34 == PreviewVersionType.FORMAL) goto L56;
            boolean r113 = true;
            ArrayList r21 = new ArrayList();
            String r114 = r33.getVersionTag();
            if (r114 == null) goto L67;
            r4 = r114;
        L67:
            r21.add(r4);
            if (Intrinsics.areEqual(r33.isDefault(), Boolean.TRUE) == false) goto L70;
            r21.add(this.a.a.getContext().getString(2131894342));
        L70:
            Long r22 = r33.getUpdatedAt();
            if (r22 != null) goto L73;
            r22 = r33.getCreatedAt();
        L73:
            if (r22 != null) goto L75;
        L85:
            r112 = CollectionsKt.joinToString$default(r21, " · ", null, null, 0, null, null, 62, null);
            goto L86
        L75:
            if (r22.longValue() > 0) goto L78;
            r113 = false;
        L78:
            if (r113 == false) goto L80;
            r111 = r22;
        L80:
            if (r111 == null) goto L85;
            long r115 = r111.longValue();
            if (r115 >= 10000000000L) goto L84;
            r115 = r115 * ((long) ECDraweeView.SQUARE);
        L84:
            r21.add(this.b.d.format(new Date(r115)));
            goto L85
        L56:
            if (StringsKt.equals(r33.getStatus(), "PUBLISHED", true) == false) goto L60;
            String r23 = r19.getString(2131894349);
        L58:
            r112 = r23;
            goto L86
        L60:
            if (StringsKt.equals(r33.getStatus(), "HISTORY", true) == false) goto L62;
            r23 = r19.getString(2131894350);
            goto L58
        L62:
            r23 = r19.getString(2131894350);
            Intrinsics.checkNotNull(r23);
            goto L58
        L34:
            if (r110.longValue() <= 0) goto L36;
            boolean r24 = true;
        L37:
            if (r24 == true) goto L40;
            r110 = null;
        L40:
            if (r110 == null) goto L45;
            long r25 = r110.longValue();
            Object[] r116 = new Object[1];
            if (r25 >= 10000000000L) goto L44;
            r25 = r25 * ((long) ECDraweeView.SQUARE);
        L44:
            r116[0] = this.b.d.format(new Date(r25));
            r19 = r19;
            r112 = r19.getString(2131894366, r116);
            goto L47
        L36:
            r24 = false;
            goto L37
        L27:
            r17 = 15.0f;
            goto L28
        L15:
            if (r14 == 3) goto L19;
            throw new NoWhenBranchMatchedException();
        L23:
            r16 = r13.getString(2131894367);
            goto L24
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applet/debug/view/AppletDebugVersionAdapter$PreviewVersionType;", "", "<init>", "(Ljava/lang/String;I)V", "TEST", "AUDIT", "FORMAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PreviewVersionType extends Enum<PreviewVersionType> {
        public static final PreviewVersionType AUDIT = null;
        public static final PreviewVersionType FORMAL = null;
        public static final PreviewVersionType TEST = null;
        public static final /* synthetic */ PreviewVersionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PreviewVersionType> getEntries() {
            return b;
        }

        static {
            PreviewVersionType r0 = new PreviewVersionType("TEST", 0);
            TEST = r0;
            PreviewVersionType r1 = new PreviewVersionType("AUDIT", 1);
            AUDIT = r1;
            PreviewVersionType r3 = new PreviewVersionType("FORMAL", 2);
            FORMAL = r3;
            PreviewVersionType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static PreviewVersionType[] values() {
            return (PreviewVersionType[]) a.clone();
        }

        public static PreviewVersionType valueOf(String r1) {
            return (PreviewVersionType) r27.a.a(PreviewVersionType.class, r1);
        }

        public PreviewVersionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final boolean d;
        public boolean e;
        public final String f;
        public String g;
        public final OpenPlatformPreviewVersion h;
        public final OpenPlatformPreviewVersion i;
        public final Set<String> j;
        public List<OpenPlatformPreviewVersion> k;
        public String l;
        public boolean m;
        public boolean n;
        public boolean o;

        public b() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L51;
            return false;
        L51:
            if (this.o == r6.o) goto L53;
            return false;
        L53:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            int r2 = 1231;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.e == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r3 + r4) * 31;
            String r6 = this.f;
            int r7 = 0;
            if (r6 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r5 + r8) * 31;
            String r10 = this.g;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            OpenPlatformPreviewVersion r13 = this.h;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            OpenPlatformPreviewVersion r16 = this.i;
            if (r16 == null) goto L26;
            r7 = r16.hashCode();
        L26:
            int r17 = (((((((r15 + r7) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
            if (this.m == false) goto L29;
            int r18 = 1231;
        L30:
            int r19 = (r17 + r18) * 31;
            if (this.n == false) goto L33;
            int r20 = 1231;
        L34:
            int r21 = (r19 + r20) * 31;
            if (this.o == true) goto L39;
            r2 = 1237;
        L39:
            return r21 + r2;
        L33:
            r20 = 1237;
            goto L34
        L29:
            r18 = 1237;
            goto L30
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r6.hashCode();
            goto L14
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "PreviewAppUiState(appKey=" + this.a + ", appName=" + this.b + ", iconUrl=" + this.c + ", originalEnabled=" + this.d + ", currentEnabled=" + this.e + ", originalVersionTag=" + this.f + ", selectedVersionTag=" + this.g + ", testVersion=" + this.h + ", auditVersion=" + this.i + ", previewVersionTags=" + this.j + ", formalVersions=" + this.k + ", formalNextCursor=" + this.l + ", formalHasMore=" + this.m + ", expanded=" + this.n + ", loadingMoreVersions=" + this.o + ')';
        }

        public b(String r2, String r3, String r4, boolean r5, boolean r6, String r7, String r8, OpenPlatformPreviewVersion r9, OpenPlatformPreviewVersion r10, Set r11, List r12, String r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r2, "appKey");
            Intrinsics.checkNotNullParameter(r3, "appName");
            Intrinsics.checkNotNullParameter(r4, "iconUrl");
            Intrinsics.checkNotNullParameter(r11, "previewVersionTags");
            Intrinsics.checkNotNullParameter(r12, "formalVersions");
            Intrinsics.checkNotNullParameter(r13, "formalNextCursor");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            this.n = false;
            this.o = false;
        }
    }

    public static final class c {
        public final String a;
        public final boolean b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (r0 + r1) * 31;
            String r3 = this.c;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "PreviewDebugConfigChange(appKey=" + this.a + ", enabled=" + this.b + ", versionTag=" + this.c + ')';
        }

        public c(String r2, boolean r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "appKey");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public final List<c> z2() {
        List<b> r0 = this.c;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L3:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L13;
        Object r4 = r2.next();
        b r5 = (b) r4;
        if (r5.e == r5.d) goto L8;
    L11:
        if (r3 == false) goto L3;
        r1.add(r4);
        goto L3
    L8:
        if (Intrinsics.areEqual(r5.g, r5.f) == false) goto L11;
        r3 = false;
        goto L11
    L13:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r1.iterator();
    L15:
        if (r7.hasNext() == false) goto L19;
        Object r8 = r7.next();
        if ((!StringsKt.isBlank(((b) r8).a)) == false) goto L15;
        r6.add(r8);
        goto L15
    L19:
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r10 = r6.iterator();
    L21:
        if (r10.hasNext() == false) goto L27;
        b r11 = (b) r10.next();
        String r12 = r11.a;
        boolean r13 = r11.e;
        if (r13 == false) goto L25;
        String r14 = r11.g;
    L26:
        r9.add(new c(r12, r13, r14));
        goto L21
    L25:
        r14 = null;
        goto L26
    L27:
        return r9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppletDebugVersionAdapter(Function2<? super String, ? super String, Unit> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "onLoadMoreVersions");
        Intrinsics.checkNotNullParameter(r3, "onChanged");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
        this.d = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    }

    public static b A2(OpenPlatformPreviewAppInfo r18, String r19) {
        OpenPlatformPreviewVersionPage r0 = r18.getFormalVersions();
        List r1 = r18.getTestVersions();
        String r2 = null;
        if (r1 == null) goto L5;
        OpenPlatformPreviewVersion r11 = (OpenPlatformPreviewVersion) CollectionsKt.firstOrNull(r1);
    L6:
        List r3 = r18.getAuditVersions();
        if (r3 == null) goto L9;
        OpenPlatformPreviewVersion r12 = (OpenPlatformPreviewVersion) CollectionsKt.firstOrNull(r3);
    L10:
        List r4 = r18.getTestVersions();
        if (r4 != null) goto L13;
        r4 = CollectionsKt.emptyList();
    L13:
        List r5 = r4;
        List r6 = r18.getAuditVersions();
        if (r6 != null) goto L16;
        r6 = CollectionsKt.emptyList();
    L16:
        List r7 = CollectionsKt.plus(r5, r6);
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L18:
        if (r9.hasNext() == false) goto L27;
        String r10 = ((OpenPlatformPreviewVersion) r9.next()).getVersionTag();
        if (r10 != null) goto L22;
    L24:
        r10 = null;
    L25:
        if (r10 == null) goto L18;
        r8.add(r10);
        goto L18
    L22:
        if ((true ^ StringsKt.isBlank(r10)) == false) goto L24;
    L27:
        Set r13 = CollectionsKt.toSet(r8);
        if (r0 == null) goto L30;
        List r14 = r0.getItems();
    L31:
        if (r14 != null) goto L33;
        r14 = CollectionsKt.emptyList();
    L33:
        List r15 = y2(r14, r13);
        if (r19 != null) goto L46;
        Iterator r16 = CollectionsKt.plus(CollectionsKt.listOfNotNull(new OpenPlatformPreviewVersion[]{r11, r12}), r15).iterator();
    L37:
        if (r16.hasNext() == false) goto L41;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((OpenPlatformPreviewVersion) r17).isDefault(), Boolean.TRUE) == false) goto L37;
    L42:
        OpenPlatformPreviewVersion r20 = (OpenPlatformPreviewVersion) r17;
        if (r20 == null) goto L45;
        String r110 = r20.getVersionTag();
    L47:
        String r21 = r18.getAppKey();
        if (r21 != null) goto L50;
        String r22 = "";
    L51:
        String r23 = r18.getAppName();
        if (r23 != null) goto L54;
        String r24 = "";
    L55:
        String r25 = r18.getIconUrl();
        if (r25 != null) goto L58;
        String r26 = "";
    L59:
        Boolean r27 = r18.getDefaultEnabled();
        Boolean r28 = Boolean.TRUE;
        boolean r111 = Intrinsics.areEqual(r27, r28);
        boolean r29 = Intrinsics.areEqual(r18.getDefaultEnabled(), r28);
        if (r0 == null) goto L62;
        r2 = r0.getNextCursor();
    L62:
        if (r2 != null) goto L64;
        r2 = "";
    L64:
        if (r0 != null) goto L66;
    L68:
        boolean r112 = false;
    L70:
        return new b(r22, r24, r26, r111, r29, r110, r110, r11, r12, r13, r15, r2, r112);
    L66:
        if (r0.getHasMore() != true) goto L68;
        r112 = true;
        goto L70
    L58:
        r26 = r25;
        goto L59
    L54:
        r24 = r23;
        goto L55
    L50:
        r22 = r21;
        goto L51
    L45:
        r110 = null;
        goto L47
    L41:
        r17 = null;
        goto L42
    L46:
        r110 = r19;
        goto L47
    L30:
        r14 = null;
        goto L31
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static List y2(List r3, Set r4) {
        if (r4.isEmpty() == false) goto L5;
        return r3;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L14;
        Object r1 = r5.next();
        String r2 = ((OpenPlatformPreviewVersion) r1).getVersionTag();
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        if (r4.contains(r2) == true) goto L7;
        r0.add(r1);
        goto L7
    L14:
        return r0;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        final AppViewHolder r14 = (AppViewHolder) r12;
        Intrinsics.checkNotNullParameter(r14, "holder");
        final b r15 = (b) ListProtector.get(this.c, r13);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "item");
        TextView r0 = r14.a.c;
        String r1 = r15.b;
        if (StringsKt.isBlank(r1) == false) goto L5;
        r1 = r15.a;
    L5:
        r0.setText(r1);
        int r2 = 0;
        r14.a.c.setTypeface(Typeface.create("sans-serif-medium", 0));
        LinearLayout r3 = r14.a.e;
        if ((!r15.n) == false) goto L8;
        int r4 = 0;
    L9:
        r3.setVisibility(r4);
        if (r15.n == true) goto L31;
        String r5 = r15.f;
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        boolean r6 = r15.d;
        View r7 = r14.a.f;
        if (r6 == false) goto L18;
        int r8 = 2131238488;
    L19:
        r7.setBackgroundResource(r8);
        LarusItemAppletDebugPreviewAppBinding r9 = r14.a;
        TextView r10 = r9.d;
        Context r11 = r9.a.getContext();
        if (r6 == false) goto L22;
        int r16 = 2131100428;
    L23:
        r10.setTextColor(ContextCompat.getColor(r11, r16));
        LarusItemAppletDebugPreviewAppBinding r17 = r14.a;
        TextView r18 = r17.d;
        if (r6 == true) goto L26;
        String r19 = r17.a.getContext().getString(2131894343);
    L30:
        r18.setText(r19);
        goto L31
    L26:
        if (StringsKt.isBlank(r5) == false) goto L28;
        r19 = r14.a.a.getContext().getString(2131894345);
        goto L30
    L28:
        r19 = r14.a.a.getContext().getString(2131894346, new Object[]{r5});
        goto L30
    L22:
        r16 = 2131100431;
        goto L23
    L18:
        r8 = 2131238489;
    L31:
        ImageLoaderKt.u(r14.a.b, r15.c, "change_app_icon");
        ImageView r20 = r14.a.g;
        if (r15.n == false) goto L34;
        float r21 = 180.0f;
    L35:
        r20.setRotation(r21);
        LinearLayout r22 = r14.a.l;
        if (r15.n == false) goto L38;
        int r23 = 0;
    L39:
        r22.setVisibility(r23);
        r14.a.h.setOnClickListener(new j(r15, r14));
        r14.a.g.setOnClickListener(new k(r15, r14));
        r14.a.l.removeAllViews();
        Context r24 = r14.a.a.getContext();
        LinearLayout r25 = new LinearLayout(r24);
        r25.setOrientation(0);
        r25.setGravity(16);
        r25.setBackground(ContextCompat.getDrawable(r24, 2131238484));
        r25.setPadding(r14.U3(12), r14.U3(16), r14.U3(12), r14.U3(16));
        r25.setMinimumHeight(r14.U3(54));
        r25.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView r26 = new TextView(r24);
        r26.setText(r24.getString(2131894347));
        r26.setTextColor(ContextCompat.getColor(r24, 2131100424));
        r26.setTextSize(15.0f);
        r26.setTypeface(Typeface.create("sans-serif-medium", 0));
        r26.setMaxLines(1);
        r26.setEllipsize(TextUtils.TruncateAt.END);
        r26.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        r25.addView(r26);
        SwitchCompat r27 = new SwitchCompat(r24);
        final AppletDebugVersionAdapter r28 = r14.b;
        r27.setChecked(r15.e);
        r27.setMinWidth(0);
        r27.setMinHeight(0);
        r27.setPadding(0, 0, 0, 0);
        LinearLayout.LayoutParams r29 = new LinearLayout.LayoutParams(r14.U3(51), r14.U3(31));
        r29.setMarginStart(r14.U3(12));
        r27.setLayoutParams(r29);
        r27.setOnCheckedChangeListener(new m(r15, r14, r28));
        r25.addView(r27);
        r14.a.l.addView(r25);
        r14.T3(r15, r15.h, PreviewVersionType.TEST);
        r14.T3(r15, r15.i, PreviewVersionType.AUDIT);
        Iterator<T> r30 = r15.k.iterator();
    L41:
        if (r30.hasNext() == false) goto L44;
        r14.T3(r15, (OpenPlatformPreviewVersion) r30.next(), PreviewVersionType.FORMAL);
        goto L41
    L44:
        if (r15.m == true) goto L46;
    L48:
        final boolean r31 = false;
    L49:
        LinearLayout r32 = r14.a.i;
        if (r31 == false) goto L52;
    L55:
        boolean r33 = true;
    L56:
        if (r33 == false) goto L58;
        int r34 = 0;
    L59:
        r32.setVisibility(r34);
        r14.a.i.setEnabled(!r15.o);
        LarusItemAppletDebugPreviewAppBinding r35 = r14.a;
        TextView r36 = r35.k;
        if (r15.o == false) goto L62;
        String r37 = r35.a.getContext().getString(2131894355);
    L63:
        r36.setText(r37);
        LarusItemAppletDebugPreviewAppBinding r38 = r14.a;
        r38.k.setTextColor(ContextCompat.getColor(r38.a.getContext(), 2131100422));
        ImageView r39 = r14.a.j;
        if ((!r15.o) == true) goto L67;
        r2 = 8;
    L67:
        r39.setVisibility(r2);
        LinearLayout r40 = r14.a.i;
        final AppletDebugVersionAdapter r41 = r14.b;
        r40.setOnClickListener(new l(r15, r31, r14, r41));
        LarusItemAppletDebugPreviewAppBinding r110 = r14.a;
        r110.l.addView(r110.i);
        return;
    L62:
        r37 = r35.a.getContext().getString(2131894352);
        goto L63
    L58:
        r34 = 8;
        goto L59
    L52:
        if (r15.o == true) goto L55;
        r33 = false;
        goto L56
    L46:
        if ((!StringsKt.isBlank(r15.l)) == false) goto L48;
        r31 = true;
        goto L49
    L38:
        r23 = 8;
        goto L39
    L34:
        r21 = 0.0f;
        goto L35
    L8:
        r4 = 8;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r17, int r18) {
        Intrinsics.checkNotNullParameter(r17, "parent");
        View r0 = LayoutInflater.from(r17.getContext()).inflate(2131562492, r17, false);
        int r1 = 2131363092;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r0, 2131363092);
        if (r5 == null) goto L29;
        r1 = 2131363102;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r0, 2131363102);
        if (r6 == null) goto L29;
        r1 = 2131363107;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r0, 2131363107);
        if (r7 == null) goto L29;
        r1 = 2131363108;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131363108);
        if (r8 == null) goto L29;
        r1 = 2131363109;
        View r9 = ViewBindings.findChildViewById(r0, 2131363109);
        if (r9 == null) goto L29;
        r1 = 2131363110;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131363110)) == null) goto L29;
        r1 = 2131371884;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r0, 2131371884);
        if (r10 == null) goto L29;
        r1 = 2131374285;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131374285);
        if (r11 == null) goto L29;
        r1 = 2131378959;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131378959);
        if (r12 == null) goto L29;
        r1 = 2131378960;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r0, 2131378960);
        if (r13 == null) goto L29;
        r1 = 2131378961;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r0, 2131378961);
        if (r14 == null) goto L29;
        r1 = 2131392208;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131392208);
        if (r15 == null) goto L29;
        return new AppViewHolder(this, new LarusItemAppletDebugPreviewAppBinding((LinearLayout) r0, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15));
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
