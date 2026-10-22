package trb;

import com.ss.android.lark.message.vote.message.VoteMessageCell;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RichText f547320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qrb.a f547321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final irb.b f547322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f547323d;

    public class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f547324a;

        @Override // com.ss.android.lark.widget.richtext.b
        public final void J(RichTextElement.MediaProperty r100) {
        }

        public a(c r100) {
            this.f547324a = r100;
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void H(RichTextElement.ProgressSelectOptionProperty r100) {
            irb.a r101 = new irb.a();
            r101.f495548a = r100.getActionId();
            r101.f495549b = r100.getActionParamName();
            r101.f495550c = r100.getActionParamValue();
            r101.f495551d = r100.isDisable();
            r101.f495552e = r100.isSelected();
            r101.f495553f = r100.getOptionCase();
            r101.f495554g = r100.getContent();
            r101.f495555h = r100.getNumberOfSelected();
            r101.f495556i = r100.getNumberOfTotal();
            ((ArrayList) this.f547324a.f547322c.f495559c).add(r101);
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void a(RichText r100) {
            c r101 = this.f547324a;
            qrb.a r102 = r101.f547321b;
            if (r102 == null) goto L6;
            VoteMessageCell.a r103 = (VoteMessageCell.a) r102;
            r103.a(r101.f547322c);
            return;
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void b(RichText r100) {
            qrb.a r101 = this.f547324a.f547321b;
            if (r101 == null) goto L6;
            r101.getClass();
            return;
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void e(RichTextElement.SelectProperty r100) {
            irb.b r101 = this.f547324a.f547322c;
            r101.f495558b = r100.getMaxPickNum();
            irb.b r102 = this.f547324a.f547322c;
            r100.getMinPickNum();
            r102.getClass();
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void y(RichTextElement.ButtonProperty r100) {
            irb.b r101 = this.f547324a.f547322c;
            r101.f495560d = r100.getActionId();
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void N(RichTextElement.TextProperty r100, Map<String, String> r101) {
            irb.b r102 = this.f547324a.f547322c;
            String r103 = r100.getContent();
            ((ArrayList) r102.f495557a).add(r103);
        }
    }

    public c(RichText r100, VoteMessageCell.a r101) {
        this.f547322c = new irb.b();
        this.f547323d = new a(this);
        this.f547320a = r100;
        this.f547321b = r101;
    }
}
