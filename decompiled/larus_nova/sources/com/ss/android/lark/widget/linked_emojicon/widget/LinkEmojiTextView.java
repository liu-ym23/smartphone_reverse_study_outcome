package com.ss.android.lark.widget.linked_emojicon.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.collection.ArrayMap;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.Reflect;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.card.view.richtext.h0;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.linked_emojicon.TextViewFixTouchConsume;
import com.ss.android.lark.widget.span.AbbreviationInfo;
import com.ss.android.lark.widget.span.AtInfo;
import com.ss.android.lark.widget.span.EmojiconInfo;
import com.ss.android.lark.widget.span.ImageInfo;
import com.ss.android.lark.widget.span.KeyIconUrlInfo;
import com.ss.android.lark.widget.span.MentionInfo;
import com.ss.android.lark.widget.span.PhoneInfo;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.RichUrlInfo;
import com.ss.android.lark.widget.span.SpacingInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.TextStyleInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import com.ss.android.lark.widget.span.e0;
import com.ss.android.lark.widget.span.f0;
import com.ss.android.lark.widget.span.g0;
import com.ss.android.lark.widget.span.u;
import com.ss.android.lark.widget.span.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import sz7.q;

/* JADX INFO: loaded from: classes38.dex */
public class LinkEmojiTextView extends TextViewFixTouchConsume {

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final /* synthetic */ int f446391v1 = 0;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean H0;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f446392J;
    public String K;
    public String L;
    public final TextViewFixTouchConsume.a L0;
    public h M;
    public i N;
    public f O;
    public mcc.i P;
    public int P0;
    public mcc.j Q;
    public e R;
    public final Context S;
    public String T;
    public int U;
    public int V;
    public float V0;
    public int W;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public float f446393b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public v.a f446394g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f446395h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f446396k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public u f446397k1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f446398p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f446399p1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f446400s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f446401t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f446402u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f446403v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f446404w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f446405x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.ss.android.lark.widget.linked_emojicon.widget.c f446406y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f446407z;

    public static class RecogniseCallback implements IGetDataCallback<RecogniseSpansResult> {
        private WeakReference<LinkEmojiTextView> emojiTextView;
        private boolean isMine;
        private String signCacheKey;
        private String text;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r100) {
            Log.e("LinkEmojiTextview preload failed: " + r100.toString());
        }

        public void onSuccess(RecogniseSpansResult r100) {
            LinkEmojiTextView r101 = this.emojiTextView.get();
            List<SpanInfo> r102 = r100.getAllSpanInfos();
            if (r101 != null) goto L5;
            return;
        L5:
            if (CollectionUtils.isNotEmpty(r102) == false) goto L9;
            r101.Q(r100, this.text, this.signCacheKey);
            return;
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
            onError(r100);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
            onSuccess((RecogniseSpansResult) r100);
        }

        public RecogniseCallback(LinkEmojiTextView r100, String r101, boolean r102, String r103) {
            this.emojiTextView = new WeakReference(r100);
            this.text = r101;
            this.isMine = r102;
            this.signCacheKey = r103;
        }
    }

    public static class UrlImageInfo extends SpanInfo {
        public String imageUrl;

        public UrlImageInfo() {
        }
    }

    public class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f446409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f446410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LinkEmojiTextView f446411d;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            if (this.f446411d.O != null) goto L5;
            return;
        L5:
            if (r100.getTag(R.id.tag_long_press) == null) goto L9;
            r100.setTag(R.id.tag_long_press, null);
            if (this.f446411d.O.c(r100, this.f446408a, this.f446409b) == false) goto L12;
            this.f446411d.performHapticFeedback(0);
            return;
        L12:
            return;
        L9:
            this.f446411d.O.d(r100, this.f446408a, this.f446409b);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            super.updateDrawState(r100);
            int r101 = this.f446410c;
            if (r101 == 0) goto L5;
            r100.setColor(r101);
        L9:
            r100.setUnderlineText(false);
            return;
        L5:
            LinkEmojiTextView r102 = this.f446411d;
            if (r102.B == 0) goto L8;
            r100.setColor(r102.getResources().getColor(this.f446411d.B));
            goto L9
        L8:
            r100.setColor(r102.getResources().getColor(R.color.imtoken_message_text_bubbles_blue));
            goto L9
        }

        public a(LinkEmojiTextView r100, String r101, String r102, int r103) {
            this.f446411d = r100;
            this.f446408a = r101;
            this.f446409b = r102;
            this.f446410c = r103;
        }
    }

    public class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkEmojiTextView f446412a;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
        }

        public b(LinkEmojiTextView r100) {
            this.f446412a = r100;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            super.updateDrawState(r100);
            LinkEmojiTextView r101 = this.f446412a;
            int r102 = r101.D;
            if (r102 != 0) goto L5;
            r100.setColor(r101.getResources().getColor(R.color.primary_fill_default));
        L6:
            r100.setUnderlineText(false);
            return;
        L5:
            r100.setColor(r102);
            goto L6
        }
    }

    public class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkEmojiTextView f446413a;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            if (this.f446413a.R != null) goto L5;
            return;
        L5:
            if (r100.getTag(R.id.tag_long_press) != null) goto L9;
            LinkEmojiTextView r101 = this.f446413a;
            e r102 = r101.R;
            int r103 = r101.L0.f446352b;
            ((h0) r102).f432042a.getClass();
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            super.updateDrawState(r100);
        }

        public c(LinkEmojiTextView r100, AbbreviationInfo r101) {
            this.f446413a = r100;
        }
    }

    public class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f446415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinkEmojiTextView f446416c;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            mcc.j r101 = this.f446416c.Q;
            if (r101 == null) goto L6;
            r101.k(r100, this.f446414a, this.f446415b);
        L6:
            if ((r100 instanceof TextView) == false) goto L9;
            ((TextView) r100).setHighlightColor(0);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            r100.setColor(this.f446416c.getResources().getColor(R.color.text_link_normal));
            r100.setUnderlineText(false);
            r100.clearShadowLayer();
        }

        public d(LinkEmojiTextView r100, String r101, String r102) {
            this.f446416c = r100;
            this.f446414a = r101;
            this.f446415b = r102;
        }
    }

    public interface e {
    }

    public interface f {
        boolean c(View r100, String r101, String r102);

        void d(View r100, String r101, String r102);
    }

    public interface g {
    }

    public interface h {
        void a(View r100, String r101);

        void b(View r100, String r101);
    }

    public interface i {
        void a(View r100, String r101);

        boolean b(View r100, String r101);
    }

    public class j extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkEmojiTextView f446417a;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            LinkEmojiTextView r101 = this.f446417a;
            int r102 = LinkEmojiTextView.f446391v1;
            r101.getClass();
        }

        public j(LinkEmojiTextView r100, ImageInfo r101) {
            this.f446417a = r100;
        }
    }

    public class k extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f446419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f446420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f446421d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ LinkEmojiTextView f446422e;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            mcc.i r101 = this.f446422e.P;
            if (r101 == null) goto L6;
            r101.p(r100, this.f446418a, this.f446419b, this.f446420c, this.f446421d);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            super.updateDrawState(r100);
            if (this.f446420c == false) goto L5;
            r100.setColor(this.f446422e.getResources().getColor(R.color.primary_fill_default));
        L6:
            r100.setUnderlineText(false);
            return;
        L5:
            r100.setColor(this.f446422e.getResources().getColor(R.color.ud_N650));
            goto L6
        }

        public k(LinkEmojiTextView r100, String r101, String r102, boolean r103, String r104) {
            this.f446422e = r100;
            this.f446418a = r101;
            this.f446419b = r102;
            this.f446420c = r103;
            this.f446421d = r104;
        }
    }

    public interface l {
    }

    public interface m {
    }

    public class n extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f446424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinkEmojiTextView f446425c;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            if (this.f446425c.M != null) goto L5;
            return;
        L5:
            if (r100.getTag(R.id.tag_long_press) == null) goto L7;
            r100.setTag(R.id.tag_long_press, null);
            this.f446425c.M.b(r100, this.f446423a);
            return;
        L7:
            this.f446425c.M.a(r100, this.f446423a);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            super.updateDrawState(r100);
            LinkEmojiTextView r101 = this.f446425c;
            int r102 = r101.A;
            if (r102 != 0) goto L5;
            r100.setColor(r101.getResources().getColor(R.color.text_link_normal));
        L6:
            r100.setUnderlineText(this.f446424b);
            return;
        L5:
            r100.setColor(r102);
            goto L6
        }

        public n(LinkEmojiTextView r100, String r101, boolean r102) {
            this.f446425c = r100;
            this.f446424b = false;
            this.f446423a = r101;
            this.f446424b = r102;
        }
    }

    public class o extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f446427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinkEmojiTextView f446428c;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            if (this.f446428c.N != null) goto L5;
            return;
        L5:
            if (r100.getTag(R.id.tag_long_press) == null) goto L9;
            r100.setTag(R.id.tag_long_press, null);
            if (this.f446428c.N.b(r100, this.f446426a) == false) goto L12;
            this.f446428c.performHapticFeedback(0);
            return;
        L12:
            return;
        L9:
            this.f446428c.N.a(r100, this.f446426a);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            super.updateDrawState(r100);
            LinkEmojiTextView r101 = this.f446428c;
            int r102 = r101.f446407z;
            if (r102 != 0) goto L5;
            r100.setColor(r101.getResources().getColor(R.color.text_link_normal));
        L6:
            r100.setUnderlineText(this.f446427b);
            r100.setFakeBoldText(this.f446428c.f446398p0);
            return;
        L5:
            r100.setColor(r102);
            goto L6
        }

        public o(LinkEmojiTextView r100, String r101, boolean r102) {
            this.f446428c = r100;
            this.f446427b = false;
            this.f446426a = r101;
            this.f446427b = r102;
        }
    }

    public float[] getFirstSpanDotLocation() {
        return new float[]{this.V0, this.f446393b1};
    }

    public l getOnEllipsizeListener() {
        return null;
    }

    public void setAtOtherChatUserBgColor(int r100) {
    }

    public void setImageClickListener(g r100) {
    }

    public void setOnEllipsizeListener(l r100) {
    }

    public void setOnSetTailSpanListener(m r100) {
    }

    public void setShowUrlUnderLine(boolean r100) {
    }

    public void setUrlBackGroundColor(int r100) {
    }

    public void setUseNewAtStyle(boolean r100) {
    }

    static {
        PatternProtector.compile("<figure>[\\s]*?<img[\\s]*?src=\\\"(.*?)\"[\\s]*?origin-width=\\\"(\\d+)\"[\\s]*?origin-height=\\\"(\\d+)\"[\\s]*?/>[\\s]*?</figure>");
    }

    public final void N() {
        u r100 = this.f446397k1;
        if (r100 == null) goto L5;
        r100.f448782a = null;
        this.f446397k1 = null;
    L5:
        this.f446397k1 = new u(this);
    }

    public String getCurrentUserId() {
        return this.K;
    }

    public com.ss.android.lark.widget.linked_emojicon.widget.c getHelper() {
        return this.f446406y;
    }

    public LinkEmojiTextView(Context r100) {
        this(r100, null);
    }

    public static int M(RecogniseSpansResult r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        List<ImageInfo> r101 = r100.getImageSpanInfos();
        if (CollectionUtils.isEmpty(r101) == false) goto L9;
        return 0;
    L9:
        return r101.size();
    }

    public void setAbbreviationClickListener(e r100) {
        this.R = r100;
    }

    public void setAtAnonymousUserTextColor(int r100) {
        this.H = r100;
    }

    public void setAtOtherChatUserTextColor(int r100) {
        this.G = r100;
    }

    public void setAtSelfBgColor(int r100) {
        this.E = r100;
    }

    public void setAtSelfTextColor(int r100) {
        this.F = r100;
    }

    public void setAtStringClickListner(f r100) {
        this.O = r100;
    }

    public void setAtTextColor(int r100) {
        this.B = r100;
    }

    public void setChatTextColor(int r100) {
        this.D = r100;
    }

    public void setCurrentUserId(String r100) {
        this.K = r100;
    }

    public void setDefaultAtUserColor(int r100) {
        this.C = r100;
    }

    public void setDotReadColor(int r100) {
        this.W = r100;
    }

    public void setDotUnreadColor(int r100) {
        this.f446396k0 = r100;
    }

    public void setHashTagSpanClickListener(mcc.j r100) {
        this.Q = r100;
    }

    public void setImageFetcher(v.a r100) {
        this.f446394g1 = r100;
    }

    public void setIsUrlShowUnderLine(boolean r100) {
        this.f446399p1 = r100;
    }

    public void setLinkClickable(boolean r100) {
        this.f446395h1 = r100;
    }

    public void setMentionSpanClickListener(mcc.i r100) {
        this.P = r100;
    }

    public void setNeedToRecognize(boolean r100) {
        this.f446404w = r100;
    }

    public void setNeedToRecognizePhone(boolean r100) {
        this.f446405x = r100;
    }

    public void setPhoneStringClickListener(h r100) {
        this.M = r100;
    }

    public void setPhoneTextColor(int r100) {
        this.A = r100;
    }

    public void setShowShortTailText(boolean r100) {
        this.H0 = r100;
        if (r100 == false) goto L5;
        this.T = UIUtils.getString(getContext(), R.string.Lark_Legacy_EllipseShortText);
        return;
    L5:
        this.T = UIUtils.getString(getContext(), R.string.Lark_Legacy_EllipseViewFullTextTip);
    }

    public void setShowTail(boolean r100) {
        this.f446402u = r100;
    }

    public void setTailColor(int r100) {
        this.f446400s = r100;
    }

    public void setTailContent(String r100) {
        this.T = r100;
    }

    @Override // android.widget.TextView
    public void setTextIsSelectable(boolean r100) {
        super.setTextIsSelectable(r100);
        this.L0.f446351a = !r100;
    }

    public void setUnClickGroupBgColor(int r100) {
        this.f446392J = r100;
    }

    public void setUnClickGroupTextColor(int r100) {
        this.I = r100;
    }

    public void setUnclickGroupId(String r100) {
        this.L = r100;
    }

    public void setUrlBoldText(boolean r100) {
        this.f446398p0 = r100;
    }

    public void setUrlStringClickListner(i r100) {
        this.N = r100;
    }

    public void setUrlTextColor(int r100) {
        this.f446407z = r100;
    }

    public LinkEmojiTextView(Context r100, AttributeSet r101) {
        this(r100, r101, android.R.attr.textViewStyle);
    }

    public final void B(ncc.g r310, KeyIconUrlInfo r311) {
        int r100 = r310.length();
        int r101 = this.f446407z;
        if (r101 != 0) goto L7;
        r101 = getResources().getColor(R.color.text_link_normal);
    L7:
        if (r311.isColorIcon == true) goto L12;
        int r102 = r311.iconColor;
        if (r102 != 0) goto L13;
        r102 = r101;
    L13:
        int r103 = r311.placeHolderRes;
        if (r103 == 0) goto L16;
        Drawable r104 = AppCompatResources.getDrawable(this.S, r103);
    L17:
        Drawable r110 = r104;
        q r111 = new q(this.S, !idb.f.a().isEnable("lark.avatar.icon.key.drawable.draw.lock.disable"));
        r111.c(r311.iconKey, null, UIHelper.dp2px(14.0f), UIHelper.dp2px(14.0f), r110, !r311.isUrlPreview, Integer.valueOf(r102), false, null);
        Context r105 = getContext();
        String r106 = r311.href;
        ncc.e.a r107 = new ncc.e.a(r106);
        r106.toString();
        int r210 = UIUtils.dp2px(r105, 3.0f);
        int r211 = UIUtils.dp2px(r105, 3.0f);
        ncc.e r108 = new ncc.e(r105, r107, "", null, r111, (int) getTextSize(), false, 0, r105.getResources().getColor(R.color.text_link_hover), r105.getResources().getColor(R.color.text_link_hover), r210, r211);
        r108.a(new ncc.d(this));
        r310.b(r311.text.substring(0, 1), r108, this.f446403v);
        r310.b(r311.text.substring(1), new ForegroundColorSpan(r101), this.f446403v);
        r310.setSpan(new o(this, r311.href, this.f446399p1), r100, r311.text.length() + r100, this.f446403v);
        return;
    L16:
        r104 = null;
        goto L17
    L12:
        r102 = r311.iconColor;
        goto L13
    }

    public final void D(ncc.g r210, RichUrlInfo r211) {
        int r100 = r210.length();
        int r101 = this.f446407z;
        if (r101 != 0) goto L7;
        r101 = getResources().getColor(R.color.text_link_normal);
    L7:
        if (r211.isColorIcon == true) goto L12;
        int r102 = r211.iconColor;
        if (r102 != 0) goto L13;
        r102 = r101;
    L13:
        String r103 = r211.unicode;
        if (r103 != null) goto L16;
    L19:
        Drawable r104 = AppCompatResources.getDrawable(this.S, r211.mLocalImageResId);
    L20:
        Drawable r110 = r104;
        String r105 = r211.unicode;
        if (r105 != null) goto L23;
    L25:
        r110.mutate();
        r110.setTint(r102);
    L26:
        Context r106 = getContext();
        String r107 = r211.href;
        ncc.e.a r108 = new ncc.e.a(r107);
        r107.toString();
        int r111 = UIUtils.dp2px(r106, 3.0f);
        int r112 = UIUtils.dp2px(r106, 3.0f);
        int r113 = r106.getResources().getColor(R.color.text_link_hover);
        int r114 = r106.getResources().getColor(R.color.text_link_hover);
        ncc.e r109 = new ncc.e(r106, r108, "", null, r110, (int) getTextSize(), false, 0, r113, r114, r111, r112);
        r210.b(r211.text.substring(0, 1), r109, this.f446403v);
        ForegroundColorSpan r115 = new ForegroundColorSpan(r101);
        r210.b(r211.text.substring(1), r115, this.f446403v);
        r210.setSpan(new o(this, r211.href, this.f446399p1), r100, r211.text.length() + r100, this.f446403v);
        return;
    L23:
        if (TextUtils.isEmpty(r105) == false) goto L26;
        if (r102 == 0) goto L26;
    L16:
        if (TextUtils.isEmpty(r103) == true) goto L19;
        Integer[] r116 = sbb.d.f541292a;
        r104 = new BitmapDrawable(sbb.d.a(r211.unicode));
        goto L20
    L12:
        r102 = r211.iconColor;
        goto L13
    }

    public final void G(String r100, RecogniseSpansResult r101) {
        H(r100, r101, true, null);
    }

    public void I(int r110, int r111) {
        if (this.U == r110) goto L5;
    L7:
        boolean r100 = false;
    L9:
        if (this.f446402u == true) goto L11;
        return;
    L11:
        if (this.f446401t == false) goto L14;
        if (r100 == false) goto L14;
        return;
    L14:
        this.U = r110;
        this.V = r111;
        int r101 = getLineCount();
        Layout r102 = getLayout();
        int r103 = getMaxLines();
        if (r103 == 0) goto L43;
        if (r101 >= r103) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(getText()) == true) goto L46;
        int r104 = r103 - 1;
        int r105 = r102.getLineEnd(r104);
        int r106 = r102.getLineStart(r104);
        if (r105 < getText().length()) goto L24;
        return;
    L24:
        if (this.H0 == true) goto L26;
    L28:
        CharSequence r107 = getText().subSequence(0, r106);
        String r108 = this.T;
        float r109 = getPaint().measureText(r108);
        int r112 = UIHelper.getWindowWidth(getContext());
        int r113 = r105 - 1;
        if ("\n".equals(String.valueOf(getText().charAt(r113))) == false) goto L31;
        CharSequence r114 = getText().subSequence(r106, r113);
    L32:
        CharSequence r115 = TextUtils.ellipsize(r114, getPaint(), Math.max(r112 * 0.6f, getMeasuredWidth()) - r109, TextUtils.TruncateAt.END);
        if (r115.length() <= 2) goto L36;
        if (r115 == r114) goto L36;
        r114 = r115.subSequence(0, r115.length() - 1);
    L36:
        SpannableStringBuilder r116 = new SpannableStringBuilder(r107);
        r116.append(r114);
        int r117 = r116.length();
        r116.append(r108);
        if (this.H0 == true) goto L39;
        r116.setSpan(new ForegroundColorSpan(this.f446400s), r117 + 1, r117 + r108.length(), 18);
    L39:
        setText(r116);
    L40:
        this.f446401t = true;
        measure(r110, r111);
        return;
    L31:
        r114 = getText().subSequence(r106, r105);
        goto L32
    L26:
        if (TextUtils.equals(this.T, UIUtils.getString(getContext(), R.string.Lark_Legacy_EllipseShortText)) == false) goto L28;
        setText(new SpannableStringBuilder(getText().subSequence(0, r105 - 1)).append(this.T));
        goto L40
    L46:
        return;
    L43:
        return;
    L5:
        if (this.V != r111) goto L7;
        r100 = true;
        goto L9
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        I(r100, r101);
    }

    @Override // com.ss.android.lark.widget.EllipsizedEmojiconTextView, com.ss.android.lark.widget.linked_emojicon.base.EmojiconTextView, android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        int r102 = getMaxLines();
        if (this.f446402u == true) goto L5;
    L7:
        super.setText(r100, r101);
        return;
    L5:
        if (r102 < 1) goto L7;
        r100 = TextUtils.ellipsize(r100, getPaint(), UIHelper.getWindowWidth(getContext()) * r102, TextUtils.TruncateAt.END);
        goto L7
    }

    public LinkEmojiTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f446401t = false;
        this.f446402u = false;
        this.f446403v = 33;
        this.f446404w = true;
        this.f446405x = true;
        this.W = R.color.imtoken_message_icon_read_dot;
        this.f446396k0 = R.color.imtoken_message_icon_unread_dot;
        this.f446398p0 = false;
        this.H0 = false;
        if (TextViewFixTouchConsume.a.f446350c != null) goto L5;
        TextViewFixTouchConsume.a.f446350c = new TextViewFixTouchConsume.a();
    L5:
        this.L0 = TextViewFixTouchConsume.a.f446350c;
        this.f446395h1 = true;
        this.f446399p1 = false;
        this.S = r100;
        this.f446406y = new com.ss.android.lark.widget.linked_emojicon.widget.c(this);
        this.f446400s = UIUtils.getColor(r100, R.color.text_link_normal);
        this.T = getResources().getString(R.string.Lark_Legacy_EllipseViewFullTextTip);
        setShouldEllipsized(false);
    }

    public final void A(ncc.g r100, SpanInfo r101, String r102) {
        if ((r101 instanceof ImageInfo) == false) goto L13;
        ImageInfo r103 = (ImageInfo) r101;
        String r104 = r103.key;
        String r105 = r103.url;
        v.c r106 = new v.c();
        r106.f448804a = r103.width;
        r106.f448805b = r103.height;
        r106.f448806c = r103.viewWidth;
        r106.f448807d = r103.viewHeight;
        r106.f448808e = r103.isLargeImage;
        r106.f448809f = r103.bgColor;
        r106.f448812i = this.f446397k1;
        if (TextUtils.isEmpty(r104) == true) goto L10;
        v.a r107 = this.f446394g1;
        if (r107 == null) goto L9;
        r106.f448813j = r107;
    L9:
        v r108 = r106.a(getContext(), r104);
    L11:
        r100.b(r102, r108, this.f446403v);
        int r109 = r100.length();
        int r110 = r109 - r102.length();
        r100.setSpan(new j(this, r103), r110, r109, this.f446403v);
        return;
    L10:
        r108 = r106.a(getContext(), r105);
        goto L11
    }

    public final void C(ncc.g r100, String r110, SpanInfo r111) {
        String r101 = r111.text;
        int r102 = r111.type;
        if (r102 != 1) goto L12;
        if ((r111 instanceof KeyIconUrlInfo) == false) goto L8;
        B(r100, (KeyIconUrlInfo) r111);
    L56:
        String r103 = null;
    L58:
        if (r103 != null) goto L60;
        r103 = r110.substring(Math.min(r111.end, r110.length()));
    L60:
        r100.a(r103);
        return;
    L8:
        if ((r111 instanceof RichUrlInfo) == false) goto L10;
        D(r100, (RichUrlInfo) r111);
        goto L56
    L10:
        r100.b(r101, new o(this, ((UrlInfo) r111).href, this.f446399p1), this.f446403v);
        F(r100, r111, r101);
        goto L56
    L12:
        if (r102 != 0) goto L22;
        if ((r111 instanceof AtInfo) == false) goto L20;
        AtInfo r104 = (AtInfo) r111;
        String r105 = r104.userId;
        r100.c(r101, J(this.S, r101, r104), this.f446403v);
        F(r100, r111, r101);
        if (this.P0 != (-1)) goto L56;
        if (getHelper().a(r105) == false) goto L56;
        this.P0 = r100.toString().length();
        goto L56
    L20:
        Log.e("LinkEmojiTextView", "Span info error:" + r111);
        r100.a(r101);
        goto L56
    L22:
        if (r102 != 8) goto L28;
        if ((r111 instanceof MentionInfo) == false) goto L26;
        MentionInfo r106 = (MentionInfo) r111;
        r100.b(r101, new k(this, r106.f448580id, r101, r106.isAuthorized, r106.url), this.f446403v);
        goto L56
    L26:
        Log.e("LinkEmojiTextView", "Span info error:" + r111);
        r100.a(r101);
        goto L56
    L28:
        if (r102 != 11) goto L34;
        if ((r111 instanceof MentionInfo) == false) goto L32;
        r100.b(r101, new d(this, ((MentionInfo) r111).f448580id, r101), this.f446403v);
        goto L56
    L32:
        Log.e("LinkEmojiTextView", "Span info error:" + r111);
        r100.a(r101);
        goto L56
    L34:
        if (r102 != 3) goto L37;
        r100.b(r101, new b(this), this.f446403v);
        goto L56
    L37:
        if (r102 != 2) goto L40;
        r100.b(r101, new n(this, r101, this.f446399p1), this.f446403v);
        goto L56
    L40:
        if (r102 != 4) goto L43;
        F(r100, r111, r101);
        goto L56
    L43:
        if (r102 != 5) goto L46;
        y(r100, r111, r101);
        goto L56
    L46:
        if (r102 != 6) goto L49;
        A(r100, r111, r101);
        goto L56
    L49:
        if (r102 != 7) goto L54;
        if ((r111 instanceof SpacingInfo) == false) goto L56;
        e0.a r107 = new e0.a();
        r107.f448672a = ((SpacingInfo) r111).spacingHeight;
        r100.b(r101, new e0(r107), this.f446403v);
        goto L56
    L54:
        if (r102 != 10) goto L57;
        z(r100, r111, r101);
        goto L56
    L57:
        r103 = "";
        goto L58
    }

    public final void F(ncc.g r100, SpanInfo r101, String r102) {
        TextStyleInfo r103 = (TextStyleInfo) r101;
        if ((getPaintFlags() & 16) != 16) goto L6;
        r103.isStrikeThruText = true;
    L6:
        if (r103.isIndependent == false) goto L8;
        r100.b(r102, new ncc.h(r103), this.f446403v);
        return;
    L8:
        int r104 = r100.length();
        if (r102 != null) goto L11;
    L19:
        Log.e("LinkEmojiTextView", "Span info error:" + r101);
        return;
    L11:
        if (r104 < r102.length()) goto L19;
        int r105 = r104 - r102.length();
        if (r105 < r100.length()) goto L16;
        return;
    L16:
        if (r104 > r100.length()) goto L23;
        r100.setSpan(new ncc.h(r103), r105, r104, this.f446403v);
        return;
    }

    public Map<String, Object> J(Context r110, String r111, AtInfo r112) {
        String r100 = r112.userId;
        boolean r101 = r112.isAnonymous;
        ArrayMap r102 = new ArrayMap();
        int r103 = R.color.text_title;
        if (r101 == true) goto L5;
        boolean r104 = r112.isOutChatUser;
        int r105 = R.color.text_caption;
        if (r104 == true) goto L13;
    L15:
        if (r104 == false) goto L17;
        int r106 = r110.getResources().getColor(R.color.text_caption);
    L18:
        a r107 = new a(this, r111, r100, r106);
        r102.put("AtClick", r107);
        if (r104 == false) goto L26;
        int r113 = this.G;
        if (r113 == 0) goto L24;
        r105 = r113;
    L24:
        r102.put("ForegroundColorSpan", new ForegroundColorSpan(r110.getResources().getColor(r105)));
    L69:
        return r102;
    L26:
        if (TextUtils.isEmpty(this.K) == false) goto L28;
    L37:
        boolean r114 = getHelper().a(r100);
        int r108 = R.color.imtoken_message_text_bubbles_blue;
        if (r114 == false) goto L51;
        int r115 = this.B;
        if (r115 == 0) goto L43;
        r108 = r115;
    L43:
        boolean r116 = ((ArrayList) getHelper().f446443b).contains(r100);
        if (r116 == false) goto L46;
        int r117 = this.W;
    L47:
        if (r116 == false) goto L49;
        Paint.Style r118 = Paint.Style.FILL;
    L50:
        r102.put("ReadStatusSpan", new ncc.f(UIUtils.getColor(r110, r117), UIUtils.getColor(r110, r108), r118));
        r102.put("ForegroundColorSpan", new ForegroundColorSpan(r110.getResources().getColor(r108)));
        goto L69
    L49:
        r118 = Paint.Style.STROKE;
        goto L50
    L46:
        r117 = this.f446396k0;
        goto L47
    L51:
        String r119 = this.L;
        if (r119 != null) goto L54;
    L64:
        int r120 = this.C;
        if (r120 != 0) goto L68;
        r120 = r110.getResources().getColor(R.color.imtoken_message_text_bubbles_blue);
    L68:
        r102.put("ForegroundColorSpan", new ForegroundColorSpan(r120));
        r107.f446410c = r120;
        goto L69
    L54:
        if (r119.equals(r100) == false) goto L64;
        int r121 = this.I;
        if (r121 == 0) goto L59;
        r103 = r121;
    L59:
        int r122 = this.f446392J;
        if (r122 != 0) goto L62;
        int r123 = UIUtils.getColor(r110, R.color.lkui_transparent);
    L63:
        int r109 = r123;
        r102.put("RoundedTagSpan", occ.b.a(r110, Math.round(getTextSize()), r112.textStyle, Math.round(getTextSize()), UIUtils.getColor(r110, r103), r109));
        goto L69
    L62:
        r123 = UIUtils.getColor(r110, r122);
        goto L63
    L28:
        if (this.K.equals(r100) == false) goto L37;
        int r124 = this.F;
        if (r124 != 0) goto L32;
        r124 = R.color.static_white;
    L32:
        int r125 = this.E;
        if (r125 != 0) goto L35;
        int r126 = UIUtils.getColor(r110, R.color.primary_fill_default);
    L36:
        int r127 = r126;
        r102.put("RoundedTagSpan", occ.b.a(r110, Math.round(getTextSize()), r112.textStyle, Math.round(getTextSize()), UIUtils.getColor(r110, r124), r127));
        goto L69
    L35:
        r126 = UIUtils.getColor(r110, r125);
        goto L36
    L17:
        r106 = 0;
        goto L18
    L13:
        if (this.G == 0) goto L15;
        r106 = r110.getResources().getColor(this.G);
        goto L18
    L5:
        if (this.H == 0) goto L8;
        r103 = this.G;
    L8:
        r102.put("ForegroundColorSpan", new ForegroundColorSpan(r110.getResources().getColor(r103)));
        return r102;
    }

    public final ncc.g O(List<SpanInfo> r100, CharSequence r101, String r110) {
        if (r101 == null) goto L4;
        getContext();
        ncc.g r102 = new ncc.g(r101);
    L6:
        if (CollectionUtils.isEmpty(r100) == false) goto L10;
        r102.a(r110);
        return r102;
    L10:
        if (r100.size() != 1) goto L13;
        SpanInfo r103 = (SpanInfo) ListProtector.get(r100, 0);
        r102.a(r110.substring(0, Math.min(((SpanInfo) ListProtector.get(r100, 0)).start, r110.length())));
        C(r102, r110, r103);
        return r102;
    L13:
        r102.a(r110.substring(0, Math.min(((SpanInfo) ListProtector.get(r100, 0)).start, r110.length())));
        int r104 = 0;
    L15:
        if (r104 >= (r100.size() - 1)) goto L28;
        SpanInfo r105 = (SpanInfo) ListProtector.get(r100, r104);
        r104 = r104 + 1;
        SpanInfo r106 = (SpanInfo) ListProtector.get(r100, r104);
        int r107 = r105.end;
        int r108 = r106.start;
        if (r107 <= r108) goto L18;
        if ((r106 instanceof TextStyleInfo) == false) goto L24;
        if (((TextStyleInfo) r106).isIndependent == true) goto L24;
        E(r110, r102, r105, r106);
    L24:
        r105.end = r108;
        int r109 = r108 - r105.start;
        if (r109 > r105.text.length()) goto L15;
        r105.text = r105.text.substring(0, r109);
        E(r110, r102, r105, r106);
        goto L15
    L18:
        E(r110, r102, r105, r106);
        goto L15
    L28:
        C(r102, r110, (SpanInfo) ListProtector.get(r100, r100.size() - 1));
        return r102;
    L4:
        getContext();
        r102 = new ncc.g();
        goto L6
    }

    public final ncc.g P(List<SpanInfo> r100, CharSequence r101, String r102) {
        return O(r100, r101, r102);
    L4:
        e = move-exception;
        Log.e("LinkEmojiTextView", e.getCause(), true);
        getContext();
        ncc.g r103 = new ncc.g();
        r103.a(r102);
        return r103;
    }

    public final void Q(RecogniseSpansResult r100, String r101, String r102) {
        this.P0 = -1;
        this.f446393b1 = -1.0f;
        this.V0 = -1.0f;
        int r103 = 0;
        CharSequence r104 = null;
        if (r100 != null) goto L5;
    L14:
        this.P0 = -1;
        this.f446393b1 = -1.0f;
        this.V0 = -1.0f;
        this.f446401t = false;
        if (this.f446404w == false) goto L29;
        Pattern r105 = g0.f448681d;
        g0 r106 = g0.a.f448687a;
        boolean r107 = this.f446405x;
        r106.getClass();
        RecogniseSpansResult r108 = r106.g(r101, new ArrayList(), r107, null);
        getContext();
        ncc.g r109 = new ncc.g(r101);
        ClickableSpan[] r110 = (ClickableSpan[]) r109.getSpans(0, r101.length(), ClickableSpan.class);
        if (r110.length <= 0) goto L22;
        int r111 = r109.getSpanStart(r110[0]);
        int r112 = r110.length;
        int r113 = 0;
    L19:
        if (r103 >= r112) goto L21;
        r113 = r109.getSpanEnd(r110[r103]);
        r103 = r103 + 1;
        goto L19
    L21:
        r104 = r101.subSequence(r111, r113);
    L22:
        if (r108 != null) goto L24;
        List<SpanInfo> r114 = new ArrayList();
    L25:
        M(r108);
        N();
        super.setText(P(r114, r104, r101));
        if (TextViewFixTouchConsume.a.f446350c != null) goto L28;
        TextViewFixTouchConsume.a.f446350c = new TextViewFixTouchConsume.a();
    L28:
        setMovementMethod(TextViewFixTouchConsume.a.f446350c);
        return;
    L24:
        r114 = r108.getAllSpanInfos();
        goto L25
    L29:
        super.setText(r101);
        return;
    L5:
        if (this.f446404w == false) goto L14;
        this.f446401t = false;
        M(r100);
        N();
        f0 r115 = f0.a.f448675a;
        if (r115.a(r102) == null) goto L9;
        super.setText(P(r115.a(r102).getAllSpanInfos(), null, r101));
    L11:
        if (this.f446395h1 == false) goto L13;
        setMovementMethod(this.L0);
        return;
    L13:
        setMovementMethod(null);
        return;
    L9:
        super.setText(P(r100.getAllSpanInfos(), null, r101));
        goto L11
    }

    public final void T(RecogniseSpansResult r100, String r101, boolean r102) {
        Q(r100, r101, "");
    }

    public final void y(ncc.g r100, SpanInfo r101, String r102) {
        if ((r101 instanceof AbbreviationInfo) == false) goto L6;
        AbbreviationInfo r103 = (AbbreviationInfo) r101;
        r100.b(r102, new com.ss.android.lark.widget.linked_emojicon.widget.a(r102, getContext(), r103.intervalOff, r103.intervalOn), this.f446403v);
        int r104 = r100.length();
        int r105 = r104 - r102.length();
        r100.setSpan(new c(this, r103), r105, r104, this.f446403v);
        return;
    }

    public final void z(ncc.g r100, SpanInfo r110, String r111) {
        if ((r110 instanceof EmojiconInfo) == false) goto L6;
        EmojiconInfo r112 = (EmojiconInfo) r110;
        r100.b(r111, new com.ss.android.lark.widget.linked_emojicon.base.a(this.S, r112.drawable, r112.key, getEmojiconSize(), getEmojiconAlignment(), getEmojiconTextSize()), this.f446403v);
        return;
    }

    public final void E(String r110, ncc.g r111, SpanInfo r112, SpanInfo r113) {
        String r100 = r112.text;
        int r101 = r112.type;
        if (r101 != 1) goto L12;
        if ((r112 instanceof KeyIconUrlInfo) == false) goto L8;
        B(r111, (KeyIconUrlInfo) r112);
    L55:
        if ((r113 instanceof AtInfo) == false) goto L57;
    L67:
        String r114 = r110.substring(r112.end, r113.start);
        int r115 = r112.type;
        if (r115 == 1) goto L70;
        if (r115 == 2) goto L70;
    L75:
        r111.a(r114);
        return;
    L70:
        char[] r116 = r114.toCharArray();
        if (r116.length <= 0) goto L75;
        if (r116[0] != '\n') goto L75;
        r114 = UIUtils.getString(getContext(), R.string.Lark_Legacy_PlaceHolderChar) + r114;
        goto L75
    L57:
        if ((r113 instanceof UrlInfo) == true) goto L67;
        if ((r113 instanceof TextStyleInfo) == false) goto L67;
        if (((TextStyleInfo) r113).isIndependent == true) goto L67;
        if ((r113 instanceof AbbreviationInfo) == true) goto L67;
        if ((r113 instanceof MentionInfo) == true) goto L67;
        return;
    L8:
        if ((r112 instanceof RichUrlInfo) == false) goto L10;
        D(r111, (RichUrlInfo) r112);
        goto L55
    L10:
        r111.b(r100, new o(this, ((UrlInfo) r112).href, this.f446399p1), this.f446403v);
        F(r111, r112, r100);
        goto L55
    L12:
        if (r101 != 0) goto L22;
        if ((r112 instanceof AtInfo) == false) goto L20;
        AtInfo r102 = (AtInfo) r112;
        String r103 = r102.userId;
        r111.c(r100, J(this.S, r100, r102), this.f446403v);
        F(r111, r112, r100);
        if (this.P0 != (-1)) goto L55;
        if (getHelper().a(r103) == false) goto L55;
        this.P0 = r111.toString().length();
        goto L55
    L20:
        Log.e("LinkEmojiTextView", "Span info error:" + r112);
        r111.a(r100);
        goto L55
    L22:
        if (r101 != 3) goto L24;
        r111.b(r100, new b(this), this.f446403v);
        goto L55
    L24:
        if (r101 != 2) goto L27;
        r111.b(r100, new n(this, r100, this.f446399p1), this.f446403v);
        goto L55
    L27:
        if (r101 != 4) goto L30;
        F(r111, r112, r100);
        goto L55
    L30:
        if (r101 != 5) goto L33;
        y(r111, r112, r100);
        goto L55
    L33:
        if (r101 != 6) goto L36;
        A(r111, r112, r100);
        goto L55
    L36:
        if (r101 != 7) goto L41;
        if ((r112 instanceof SpacingInfo) == false) goto L55;
        e0.a r104 = new e0.a();
        r104.f448672a = ((SpacingInfo) r112).spacingHeight;
        r111.b(r100, new e0(r104), this.f446403v);
        goto L55
    L41:
        if (r101 != 8) goto L47;
        if ((r112 instanceof MentionInfo) == false) goto L45;
        MentionInfo r105 = (MentionInfo) r112;
        r111.b(r100, new k(this, r105.f448580id, r100, r105.isAuthorized, r105.url), this.f446403v);
        goto L55
    L45:
        Log.e("LinkEmojiTextView", "mention Span info error:" + r112);
        r111.a(r100);
        goto L55
    L47:
        if (r101 == 11) goto L49;
        if (r101 != 10) goto L55;
        z(r111, r112, r100);
        goto L55
    L49:
        if ((r112 instanceof MentionInfo) == false) goto L51;
        r111.b(r100, new d(this, ((MentionInfo) r112).f448580id, r100), this.f446403v);
        goto L55
    L51:
        Log.e("LinkEmojiTextView", "moments hashtag Span info error:" + r112);
        r111.a(r100);
        goto L55
    }

    public final void H(final String r100, final RecogniseSpansResult r101, boolean r102, String r103) {
        this.P0 = -1;
        this.f446393b1 = -1.0f;
        this.V0 = -1.0f;
        final boolean r104 = false;
        this.f446401t = false;
        this.f446395h1 = r102;
        if (this.f446404w == true) goto L5;
        super.setText(r100);
        return;
    L5:
        if (r101 == null) goto L19;
        M(r101);
        N();
        super.setText(P(r101.getAllSpanInfos(), null, r100));
        if (r102 == true) goto L9;
        setMovementMethod(null);
    L14:
        if (this.f446405x == false) goto L39;
        com.ss.android.lark.widget.linked_emojicon.widget.f r105 = com.ss.android.lark.widget.linked_emojicon.widget.f.a();
        List<SpanInfo> r106 = r101.getAllSpanInfos();
        IGetDataCallback<List<PhoneInfo>> r107 = new AnonymousClass1(this, r101, r100, r104);
        r105.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L18;
        r107.onError(new ErrorResult("text is empty"));
        return;
    L18:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.widget.linked_emojicon.widget.e(r100, r106, r107));
        return;
    L39:
        return;
    L9:
        if (TextViewFixTouchConsume.a.f446350c != null) goto L11;
        TextViewFixTouchConsume.a.f446350c = new TextViewFixTouchConsume.a();
    L11:
        setMovementMethod(TextViewFixTouchConsume.a.f446350c);
        goto L14
    L19:
        super.setText(r100);
        if (com.ss.android.lark.widget.linked_emojicon.widget.f.f446457a == null) goto L22;
    L31:
        com.ss.android.lark.widget.linked_emojicon.widget.f r108 = com.ss.android.lark.widget.linked_emojicon.widget.f.f446457a;
        RecogniseCallback r109 = new RecogniseCallback(this, r100, false, r103);
        boolean r110 = this.f446405x;
        r108.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L34;
        r109.onError(new ErrorResult("text is empty"));
        return;
    L34:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.widget.linked_emojicon.widget.d(r100, r110, r103, r109));
        return;
    L22:
        monitor-enter(com.ss.android.lark.widget.linked_emojicon.widget.f.class);
    L28:
        th = move-exception;
        throw th;
    L24:
        if (com.ss.android.lark.widget.linked_emojicon.widget.f.f446457a != null) goto L26;
        com.ss.android.lark.widget.linked_emojicon.widget.f.f446457a = new com.ss.android.lark.widget.linked_emojicon.widget.f();     // Catch: Throwable -> L28
    L26:
        monitor-exit(com.ss.android.lark.widget.linked_emojicon.widget.f.class);     // Catch: Throwable -> L28
        goto L31
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        Layout r105 = getLayout();
        if (Build.VERSION.SDK_INT == 26) goto L5;
    L11:
        Rect r106 = new Rect();
        if (r105 == null) goto L27;
        int r107 = this.P0;
        if (r107 == (-1)) goto L27;
        int r108 = r105.getLineForOffset(r107);
        r105.getLineBounds(r108, r106);     // Catch: IndexOutOfBoundsException -> L25
        if (getMaxLines() != (-1)) goto L20;
    L23:
        this.f446393b1 = r106.top;     // Catch: IndexOutOfBoundsException -> L25
        this.V0 = r105.getSecondaryHorizontal(this.P0);     // Catch: IndexOutOfBoundsException -> L25
    L29:
        return;
    L20:
        if (r108 < (getMaxLines() - 1)) goto L23;
        this.f446393b1 = -1.0f;     // Catch: IndexOutOfBoundsException -> L25
        this.V0 = -1.0f;     // Catch: IndexOutOfBoundsException -> L25
    L25:
        this.f446393b1 = -1.0f;
        this.V0 = -1.0f;
        return;
    L27:
        this.f446393b1 = -1.0f;
        this.V0 = -1.0f;
        return;
    L5:
        if ((r105 instanceof DynamicLayout) == false) goto L11;
        new Reflect((DynamicLayout) r105).i("sStaticLayout", null);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
