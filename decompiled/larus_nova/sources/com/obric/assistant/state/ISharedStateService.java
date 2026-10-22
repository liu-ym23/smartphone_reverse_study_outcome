package com.obric.assistant.state;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import yga.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H&J\u001f\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000fH&J\u001f\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH&¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH&J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/state/ISharedStateService;", "", "init", "", "prepareDoubaoData", "getSharedStateInt", "", "key", "", "defaultValue", "(Ljava/lang/String;I)Ljava/lang/Integer;", "putSharedStateInt", "", "value", "getSharedStateLong", "", "(Ljava/lang/String;J)Ljava/lang/Long;", "putSharedStateLong", "getSharedStateBoolean", "(Ljava/lang/String;Z)Ljava/lang/Boolean;", "putSharedStateBoolean", "getSharedStateString", "putSharedStateString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISharedStateService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f392930a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f392931a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<ISharedStateService> f392932b = null;

        public a() {
        }

        static {
            f392931a = new a();
            f392932b = LazyKt.lazy(new b());
        }

        public static ISharedStateService a() {
            return f392932b.getValue();
        }
    }

    static {
        f392930a = a.f392931a;
    }

    boolean a(String r100, String r101);

    Integer b(String r100);

    void c();

    boolean d(String r100, int r101);

    Boolean e(String r100);

    boolean f(String r100, long r101);

    void init();
}
