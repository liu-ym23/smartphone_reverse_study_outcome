package com.bytedance.ee.bear.edit.component.richtexteditor;

import androidx.lifecycle.LifecycleObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseEditor implements LifecycleObserver {
    public at5.a a;
    public RichTextEditorWebView b;

    public interface a {
    }

    public abstract RichTextEditorWebView a();

    public abstract com.bytedance.ee.bear.edit.component.richtexteditor.a b();
}
