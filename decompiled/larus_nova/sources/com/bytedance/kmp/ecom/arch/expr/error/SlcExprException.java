package com.bytedance.kmp.ecom.arch.expr.error;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000b2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/kmp/ecom/arch/expr/error/SlcExprException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "code", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "slice-expr-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class SlcExprException extends RuntimeException {
    public static final a Companion = null;
    public static final String EVAL_INVALID_OPCODE = "eval_invalid_opcode";
    public static final String EVAL_INVALID_STACK = "eval_invalid_stack";
    public static final String EVAL_UNKNOWN_FUNCTION = "eval_unknown_function";
    public static final String LEXER_INVALID_NUMBER = "lexer_invalid_number";
    public static final String LEXER_INVALID_OPERATOR = "lexer_invalid_operator";
    public static final String LEXER_INVALID_STRING = "lexer_invalid_string";
    public static final String LEXER_INVALID_TOKEN = "lexer_invalid_token";
    public static final String PARSER_ERROR_PARAM_COUNT = "parser_error_param_count";
    public static final String PARSER_INTERNAL_ERROR = "parser_internal_error";
    public static final String PARSER_INVALID_ARRAY = "parser_invalid_array";
    public static final String PARSER_NEEDLESS_TOKEN = "parser_needless_token";
    public static final String PARSER_SYNTAX_ERROR = "parser_syntax_error";
    private final String code;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getCode() {
        return this.code;
    }

    public SlcExprException(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        super(r100 + ':' + r101);
        this.code = r100;
    }
}
