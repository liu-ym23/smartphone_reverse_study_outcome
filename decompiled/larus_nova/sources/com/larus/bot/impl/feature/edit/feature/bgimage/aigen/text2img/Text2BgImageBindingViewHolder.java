package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import android.animation.ObjectAnimator;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.databinding.LarusLayoutBotEditBgChoosePageBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.utils.e1;
import com.larus.utils.w0;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001(BX\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012-\u0010\u0004\u001a)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002JC\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001d2\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\"J\u0017\u0010#\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u0004\u001a)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/Text2BgImageBindingViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "binding", "Lcom/larus/bot/impl/databinding/LarusLayoutBotEditBgChoosePageBinding;", "onClickImage", "Lkotlin/Function2;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "index", "", "onClickRetry", "Lkotlin/Function1;", "<init>", "(Lcom/larus/bot/impl/databinding/LarusLayoutBotEditBgChoosePageBinding;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "pageIndex", "lightLoadingAnimation", "Landroid/animation/ObjectAnimator;", "getPageIndex", "bindData", "itemData", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/Text2BgImageBindingViewHolder$AIGenBgImageData;", "disableClick", "showError", "showGeneratedImage", "isTwoRow", "", "urlList", "", "Landroid/net/Uri;", "uriList", "", "selectedImageIndex", "(ZLjava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "onImageSelect", "(Ljava/lang/Integer;)V", DyPayConstant.KEY_SHOW_LOADING, "showLoadingAnim", "hideLoadingAnim", "AIGenBgImageData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Text2BgImageBindingViewHolder extends ViewBindingHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f318872f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutBotEditBgChoosePageBinding f318873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Function0<Integer>, Integer, Unit> f318874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Function0<Integer>, Unit> f318875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f318876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObjectAnimator f318877e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.network.http.a<List<BotAvatarIconData>> f318878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f318879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f318880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f318881d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f318878a, r101.f318878a) == true) goto L12;
            return false;
        L12:
            if (this.f318879b == r101.f318879b) goto L15;
            return false;
        L15:
            if (this.f318880c == r101.f318880c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f318881d, r101.f318881d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f318878a.hashCode() * 31;
            if (this.f318879b == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (((r100 + r101) * 31) + this.f318880c) * 31;
            Integer r103 = this.f318881d;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "AIGenBgImageData(state=" + this.f318878a + ", isTwoRow=" + this.f318879b + ", pageIndex=" + this.f318880c + ", selectedImageIndex=" + this.f318881d + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(com.larus.network.http.a<? extends List<BotAvatarIconData>> r100, boolean r101, int r102, Integer r103) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f318878a = r100;
            this.f318879b = r101;
            this.f318880c = r102;
            this.f318881d = r103;
        }

        public static a a(a r100, com.larus.network.http.f r101, Integer r102, int r103) {
            com.larus.network.http.a<List<BotAvatarIconData>> r104 = r101;
            if ((r103 & 1) == 0) goto L5;
            r104 = r100.f318878a;
        L5:
            int r105 = 0;
            if ((r103 & 2) == 0) goto L8;
            boolean r106 = r100.f318879b;
        L10:
            if ((r103 & 4) == 0) goto L13;
            r105 = r100.f318880c;
        L13:
            if ((r103 & 8) == 0) goto L15;
            r102 = r100.f318881d;
        L15:
            r100.getClass();
            Intrinsics.checkNotNullParameter(r104, "state");
            return new a(r104, r106, r105, r102);
        L8:
            r106 = false;
            goto L10
        }
    }

    public final void T3() {
        this.f318873a.f317844f.f317820d.setEnabled(false);
        this.f318873a.f317844f.f317818b.setEnabled(false);
        this.f318873a.f317844f.f317822f.setEnabled(false);
        this.f318873a.f317841c.f317820d.setEnabled(false);
        this.f318873a.f317841c.f317818b.setEnabled(false);
        this.f318873a.f317841c.f317822f.setEnabled(false);
        this.f318873a.f317844f.f317821e.f317813a.setVisibility(8);
        this.f318873a.f317844f.f317819c.f317813a.setVisibility(8);
        this.f318873a.f317844f.f317823g.f317813a.setVisibility(8);
        this.f318873a.f317841c.f317821e.f317813a.setVisibility(8);
        this.f318873a.f317841c.f317819c.f317813a.setVisibility(8);
        this.f318873a.f317841c.f317823g.f317813a.setVisibility(8);
    }

    public Text2BgImageBindingViewHolder(LarusLayoutBotEditBgChoosePageBinding r100, e r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r101, "onClickImage");
        Intrinsics.checkNotNullParameter(r102, "onClickRetry");
        super(r100);
        this.f318873a = r100;
        this.f318874b = r101;
        this.f318875c = r102;
        int r103 = c7.b(12);
        w0.e(r100.f317844f.f317820d, r103);
        w0.e(r100.f317844f.f317818b, r103);
        w0.e(r100.f317844f.f317822f, r103);
        w0.e(r100.f317841c.f317820d, r103);
        w0.e(r100.f317841c.f317818b, r103);
        w0.e(r100.f317841c.f317822f, r103);
        e1.d(r100.f317844f.f317820d, new i(this));
        e1.d(r100.f317844f.f317818b, new j(this));
        e1.d(r100.f317844f.f317822f, new k(this));
        e1.d(r100.f317841c.f317820d, new l(this));
        e1.d(r100.f317841c.f317818b, new m(this));
        e1.d(r100.f317841c.f317822f, new n(this));
        T3();
    }
}
