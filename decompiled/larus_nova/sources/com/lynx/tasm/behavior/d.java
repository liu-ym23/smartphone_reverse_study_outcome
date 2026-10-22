package com.lynx.tasm.behavior;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTruncationShadowNode;
import com.lynx.tasm.behavior.shadow.text.RawTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.frame.FrameShadowNode;
import com.lynx.tasm.behavior.ui.frame.UIFrame;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.UIListItem;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.scroll.UIBounceView;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.ui.view.UIView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements com.lynx.tasm.behavior.b {

    public class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("list-item", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r100, Object r101) {
            return new UIListItem(r100, r101);
        }
    }

    public class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("list-container", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r100, Object r101) {
            return new UIListContainer(r100, r101);
        }
    }

    public class c extends com.lynx.tasm.behavior.a {
        public c() {
            super("frame", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new FrameShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r100, Object r101) {
            return new UIFrame(r100, r101);
        }
    }

    /* JADX INFO: renamed from: com.lynx.tasm.behavior.d$d, reason: collision with other inner class name */
    public class C4562d extends com.lynx.tasm.behavior.a {
        public C4562d() {
            super("view", true, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxFlattenUI createFlattenUIWithParams(LynxContext r100, Object r101) {
            return new LynxFlattenUI(r100, r101);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r100, Object r101) {
            return new UIView(r100, r101);
        }
    }

    public class e extends com.lynx.tasm.behavior.a {
        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new TextShadowNode();
        }

        public e() {
            super("text", true, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxFlattenUI createFlattenUIWithParams(LynxContext r100, Object r101) {
            return new FlattenUIText(r100, r101);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r100, Object r101) {
            return new UIText(r100, r101);
        }
    }

    public class f extends com.lynx.tasm.behavior.a {
        public f() {
            super("raw-text", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new RawTextShadowNode();
        }
    }

    public class g extends com.lynx.tasm.behavior.a {
        public g() {
            super("inline-text", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new InlineTextShadowNode();
        }
    }

    public class h extends com.lynx.tasm.behavior.a {
        public h() {
            super("inline-truncation", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new InlineTruncationShadowNode();
        }
    }

    public class i extends com.lynx.tasm.behavior.a {
        public i() {
            super("scroll-view", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r100, Object r101) {
            return new UIScrollView(r100, r101);
        }
    }

    public class j extends com.lynx.tasm.behavior.a {
        public j() {
            super("bounce-view", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r100, Object r101) {
            return new UIBounceView(r100, r101);
        }
    }

    public class k extends com.lynx.tasm.behavior.a {
        public k() {
            super("component", true, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxFlattenUI createFlattenUIWithParams(LynxContext r100, Object r101) {
            return new LynxFlattenUI(r100, r101);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r100, Object r101) {
            return new UIComponent(r100, r101);
        }
    }

    public class l extends com.lynx.tasm.behavior.a {
        public l() {
            super("list", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r100, Object r101) {
            return new UIList(r100, r101);
        }
    }

    public d() {
    }

    @Override // com.lynx.tasm.behavior.b
    public final List<com.lynx.tasm.behavior.a> create() {
        ArrayList r100 = new ArrayList();
        r100.add(new C4562d());
        r100.add(new e());
        r100.add(new f());
        r100.add(new g());
        r100.add(new h());
        r100.add(new i());
        r100.add(new j());
        r100.add(new k());
        r100.add(new l());
        r100.add(new a());
        r100.add(new b());
        r100.add(new c());
        return r100;
    }
}
