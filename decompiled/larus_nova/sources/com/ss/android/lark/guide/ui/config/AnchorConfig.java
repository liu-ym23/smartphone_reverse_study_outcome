package com.ss.android.lark.guide.ui.config;

import android.graphics.Point;
import android.view.View;
import androidx.core.view.GravityCompat;
import com.alibaba.gaiax.model.GXAnimation;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final class AnchorConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<? extends View> f425786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnchorGravity f425787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Point f425788c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/guide/ui/config/AnchorConfig$AnchorGravity;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", GXAnimation.STATE_START, GXAnimation.STATE_END, "TOP", "BOTTOM", "guide-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnchorGravity extends Enum<AnchorGravity> {
        public static final AnchorGravity BOTTOM = null;
        public static final AnchorGravity END = null;
        public static final AnchorGravity START = null;
        public static final AnchorGravity TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnchorGravity[] f425789a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f425790b = null;
        private final int value;

        public static EnumEntries<AnchorGravity> getEntries() {
            return f425790b;
        }

        static {
            AnchorGravity r100 = new AnchorGravity(GXAnimation.STATE_START, 0, GravityCompat.START);
            START = r100;
            AnchorGravity r101 = new AnchorGravity(GXAnimation.STATE_END, 1, GravityCompat.END);
            END = r101;
            AnchorGravity r102 = new AnchorGravity("TOP", 2, 48);
            TOP = r102;
            AnchorGravity r103 = new AnchorGravity("BOTTOM", 3, 80);
            BOTTOM = r103;
            AnchorGravity[] r104 = {r100, r101, r102, r103};
            f425789a = r104;
            f425790b = EnumEntriesKt.enumEntries(r104);
        }

        public static AnchorGravity[] values() {
            return (AnchorGravity[]) f425789a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AnchorGravity valueOf(String r100) {
            return (AnchorGravity) a.a(AnchorGravity.class, r100);
        }

        public AnchorGravity(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public /* synthetic */ AnchorConfig(View r100, AnchorGravity r101) {
        this(r100, r101, new Point());
    }

    public AnchorConfig(View r100, AnchorGravity r101, Point r102) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        Intrinsics.checkNotNullParameter(r101, "anchorDirect");
        Intrinsics.checkNotNullParameter(r102, "anchorOffset");
        this.f425786a = new WeakReference(r100);
        this.f425787b = r101;
        this.f425788c = r102;
    }
}
